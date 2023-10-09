package tiny.connector.http;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:
 *
 * @author hassan
 * @since 2023/10/7 17:09
 */
public class HttpConnector implements Runnable{

    boolean stopped;
    private String schema = "http";

    public String getSchema() {
        return schema;
    }

    @Override
    public void run() {
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.0.1"));
        }catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        while (!stopped) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
            }catch (Exception e) {
                e.printStackTrace();
            }
            HttpProcessor httpProcessor = new HttpProcessor();
            httpProcessor.process(socket);
        }
    }

    public void start() {
        new Thread(this).start();
    }
}

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Description:
 *
 * @author hassan
 * @since 2023/10/5 14:31
 */
public class HttpServer2 {
    /**
     * WEB_ROOT is the directory where our HTML and other files reside.
     * For this package, WEB_ROOT is the "webroot" directory under the
     * working directory.
     * The working directory is the location in the file system
     * from where the java command was invoked.
     */
    // shutdown command
    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";
    // the shutdown command received
    private boolean shutdown = false;

    public static void main(String[] args) {
        HttpServer2 server1 = new HttpServer2();
        server1.await();
    }

    private void await() {
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            serverSocket = new ServerSocket(port, 1, InetAddress.getByName("127.0.01"));
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }

        while (!shutdown) {
            Socket socket;
            InputStream input;
            OutputStream output;
            try {
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();

                Request request = new Request(input);
                request.parse();

                Response response = new Response(output);
                response.setRequest(request);

                if (request.getUri().startsWith("/servlet/")) {
                    ServletProcessor2 processor = new ServletProcessor2();
                    processor.process(request, response);
                } else {
                    StaticResourceProcessor processor = new StaticResourceProcessor();
                    processor.process(request, response);
                }

                socket.close();

                shutdown = request.getUri().equals((SHUTDOWN_COMMAND));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

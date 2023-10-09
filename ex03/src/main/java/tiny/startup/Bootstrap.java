package tiny.startup;

import tiny.connector.http.HttpConnector;

/**
 * Description:
 *
 * @author hassan
 * @since 2023/10/7 17:18
 */
public class Bootstrap {
    public static void main(String[] args) {
        HttpConnector connector = new HttpConnector();
        connector.start();
    }
}

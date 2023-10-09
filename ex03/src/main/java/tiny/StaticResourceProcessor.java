package tiny;

import tiny.connector.http.HttpRequest;
import tiny.connector.http.HttpResponse;

/**
 * Description:
 *
 * @author hassan
 * @since 2023/10/5 14:45
 */
public class StaticResourceProcessor {
    public void process(HttpRequest request, HttpResponse response) {
        try {
            response.sendStaticResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

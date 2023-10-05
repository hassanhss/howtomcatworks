import java.io.IOException;

/**
 * Description:
 *
 * @author hassan
 * @since 2023/10/5 14:45
 */
public class StaticResourceProcessor {
    public void process(Request request, Response response) {
        try {
            response.sendStaticResource();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

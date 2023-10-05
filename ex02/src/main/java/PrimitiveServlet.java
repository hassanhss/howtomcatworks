import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Description:
 *
 * @author hassan
 * @since 2023/10/3 17:50
 */
public class PrimitiveServlet implements Servlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("from service");
        String header = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: application/json\r\n" +
                "\r\n";
        PrintWriter out = res.getWriter();
        out.println(header);
        out.println("Hello. Roses are red.");
        out.print("Violets are blue.");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}

package edu.wctc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "SearchServlet", urlPatterns = "/Search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rset = null;

        //add genera and do it by this instead (look back at search and do it)
        String title = request.getParameter("Title");
        try {
            //create connections
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            String absPath = getServletContext().getRealPath("/") + "../../db";

            absPath ="jdbc:derby:" + absPath;

            conn = DriverManager.getConnection(absPath, "jessie", "jessie");

            String sql = "select Title, Publisher, Developer from Games where Title = ?";

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, title);

            //execute statements

            /* rset = stmt.executeQuery(
                    "select Title, Publisher.name, Developer " +
                            "from Games " +
                            "inner join Publisher" +
                            "on Publisher.Publisher_ID = Game.Publisher" +
                            "");
                            */
            rset = stmt.executeQuery();

            StringBuilder sb = new StringBuilder("<html><body><table><tr><th>Title</th><th>Publisher</th><th>Developer</th></tr>");

            while (rset.next()){
                String Title = rset.getString("Title");
                int Publisher = rset.getInt("Publisher");
                int Developer = rset.getInt("Developer");

                sb.append("<tr>");

                sb.append("<td>");
                sb.append(Title);
                sb.append("</td>");

                sb.append("<td>");
                sb.append(Publisher);
                sb.append("</td>");

                sb.append("<td>");
                sb.append(Developer);
                sb.append("</td>");

                sb.append("</tr>");
            }
            sb.append("</table></body></html>");

            response.setContentType("text/html");

            response.getWriter().print(sb.toString());

            //close the connection: see the finally

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally{
            closeAll(conn, stmt, rset);
        }
    }

    public static void closeAll(Connection conn, Statement stmt, ResultSet rset) {
        if (rset != null) {
            try {
                rset.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}

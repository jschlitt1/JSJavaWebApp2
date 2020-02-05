package edu.wctc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "ListServlet", urlPatterns = "/ClassList")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;
        try {
            //create connections
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            String absPath = getServletContext().getRealPath("/") + "../../db";

            absPath ="jdbc:derby:" + absPath;

            conn = DriverManager.getConnection(absPath, "jessie", "jessie");

            stmt = conn.createStatement();

            //execute statements

             rset = stmt.executeQuery("select Title as Game, P.name as Publisher, D.name as Developer" +
                     " from Games G" +
                     " inner join PUBLISHERS P on P.Publisher_ID = G.Publisher" +
                     " inner join DEVELOPERS D on D.DEVELOPER_ID = G.Developer"
             );

            //rset = stmt.executeQuery("select Title, Publisher, Developer from Games ");

            StringBuilder sb = new StringBuilder("<html><body><table><tr><th>Title</th><th>Publisher</th><th>Developer</th></tr>");

            while (rset.next()){
                String Title = rset.getString("Game");
                String Publisher = rset.getString("Publisher");
                String Developer = rset.getString("Developer");

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

package edu.wctc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MainServlet", urlPatterns="/controller")
public class MainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String page = request.getParameter("page");
         switch(page){
            case "detail":
                request.getRequestDispatcher("/view/detail.jsp").forward(request, response);
                break;
            case "index":
                request.getRequestDispatcher("/view/index.jsp").forward(request, response);
                break;
            case "list" :
                List<GameList> gameList = new ArrayList<>();

                //loop while the result has more rows (do query here)
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

                    rset = stmt.executeQuery("select Title as Game, P.name as Publisher, D.name as Developer" +
                            " from Games G" +
                            " inner join PUBLISHERS P on P.Publisher_ID = G.Publisher" +
                            " inner join DEVELOPERS D on D.DEVELOPER_ID = G.Developer"
                    );

                    while (rset.next()) {
                        GameList aGame = new GameList();
                        aGame.setId(rset.getInt("ID"));
                        aGame.setDeveloper(rset.getString("Developer"));
                        aGame.setPublisher(rset.getString("Publisher"));
                        //add the rest

                        gameList.add(aGame);
                    }
                }catch(ClassNotFoundException | SQLException e){
                    e.printStackTrace();
                }
                finally{
                    closeAll(conn, stmt, rset);
                }
                request.setAttribute("games", gameList);
                request.getRequestDispatcher("/view/list.jsp").forward(request, response);
                break;
            case "login":
                request.getRequestDispatcher("/view/login.jsp").forward(request, response);
                break;
            default:
                request.getRequestDispatcher("/view/notfound.jsp").forward(request, response);
                break;
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

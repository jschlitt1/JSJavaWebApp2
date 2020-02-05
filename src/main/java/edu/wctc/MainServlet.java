package edu.wctc;

import edu.Game;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
                List<Game> gameList = new ArrayList<>();

                //loop while the result has more rows (do query here)
                while(rset.next()){
                    Game aGame = new Game();
                    aGame.setId(rset.getInt("ID"));
                    //add the rest

                    gameList.add(aGame);
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
}

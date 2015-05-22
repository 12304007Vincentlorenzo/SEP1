package servlet;



import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginServlet extends HttpServlet {

    /**
     * Constructor of the object.
     */
    public LoginServlet() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }

    /**
     * The doGet method of the servlet. <br>
     * <p>
     * This method is called when a form has its tag value method equals to get.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws javax.servlet.ServletException if an error occurred
     * @throws java.io.IOException      if an error occurred
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.doPost(request, response);
    }

    /**
     * The doPost method of the servlet. <br>
     * <p>
     * This method is called when a form has its tag value method equals to post.
     *
     * @param request  the request send by the client to the server
     * @param response the response send by the server to the client
     * @throws javax.servlet.ServletException if an error occurred
     * @throws java.io.IOException      if an error occurred
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {



        String username = request.getParameter("userid");
        String password = request.getParameter("password");

        UserService us = new UserService();

        UserInterface ui = us.getUserPort();

        User user = ui.checkLogin(username, password);


        if (user == null) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("userid", user.getUserID());
            if (user instanceof Provider) {
                request.getRequestDispatcher("/provider.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/customer.jsp").forward(request, response);
            }
        }
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws javax.servlet.ServletException if an error occurs
     */
    public void init() throws ServletException {
        // Put your code here
    }

}

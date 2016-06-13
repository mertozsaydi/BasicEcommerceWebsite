/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "User", urlPatterns = {"/User"})
public class User extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /*
             * TODO output your page here. You may use following sample code.
             */
            out.println("<style type=\"text/css\">\n" +
            "      body { font-size: 85%; font-family: 'Segoe Print', Segoe Print; color:#005200; }\n" +
            "      ul#tabs { list-style-type: none; margin: 30px 0 0 0; padding: 0 0 0.3em 0; }\n" +
            "      ul#tabs li { display: inline; }\n" +
            "      ul#tabs li a { color: #005200;  border: 1px solid #0489B1; border-bottom: none; padding: 0.3em; text-decoration: none; }\n" +
            "      ul#tabs li a:hover { background-color: #FAFAFA; }\n" +
            "      div.tabContent { border: 1px solid #0489B1; padding: 0.5em; background-color: #EFF8FB; }\n" +
            "      div.tabContent.hide { display: none; }\n" +
            "      .frm1 { text-align: right; }\n" +
            "      .bck1 { background-color: #EFF8FB; }\n" +
            "      a:link, a:visited {  color:#005200;  text-decoration: none; }" +
            "      table { width:100%; }\n" +
            "      table, th, td { border: 1px solid black; border-collapse: collapse; }\n" +
            "      th, td { padding: 5px;}\n" +
            "      table#t01 tr:nth-child(even) { background-color: #eee; }\n" +
            "      table#t01 tr:nth-child(odd) { background-color:#fff; }\n" +
            "      table#t01 th	{ background-color: #0489B1; color: white; }"+
            "    </style>\n" +
            "  </head>\n" + 
            "  <body >\n" +
            "   <div style=\"text-align:center;font-size:100%;border-radius:20px;border:15px solid #0489B1; background-color:#EFF8FB\">\n" +
            "     <h1>\n" +
            "       <b>MEGA.com</b>\n" +
            "     </h1>\n" +
            "   </div>");
            HttpSession session = request.getSession(true);
            
            if(request.getParameter("signout")!=null)
            {
                session.setAttribute("UserName", "Signed Out");
                session.setAttribute("UserId", 0);
                session.setAttribute("cartNum",0);
                session.setAttribute("productIDs",null);
            }
            if(request.getParameter("delete")!=null)
            {
                
                try {
                    Connection con = DriverManager.getConnection( "jdbc:derby://localhost:1527/webdatabaseproje", "proje", "proje" );
                    Statement stat = con.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs;
               
                    String sql= "SELECT * FROM Users " +
                            "                   WHERE Users.id = " +  session.getAttribute("UserId");
                    rs = stat.executeQuery(sql);
                    
                    rs.first();
                    if(rs.getString("PASSWORD").equals(Integer.toString(request.getParameter("delete").hashCode())))
                    {
                        rs.deleteRow();
                        session.setAttribute("UserName", "User Deleted");
                        session.setAttribute("UserId", 0);
                    }
                    
                    else
                        session.setAttribute("UserName", "Wrong Password");
                    rs.close();
                    stat.close();
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
                
            if(session.getAttribute("UserId").equals(0))
            {
                out.println("<form class=frm1 method='POST' action='Home'>" +
                "E-mail: <input name='uname' type='text'>" +
                "&nbspPassword: <input name='pass' type='password'>" +
                "<input type='submit' value='Sign In'></form>");
            }
            else
            {
                  out.println("<p class=frm1 ><a class=frm1 href=\"http://localhost:8080/WebApplication2/Cart?id=0\"><b>Cart(" + session.getAttribute("cartNum") + ")</b></a>&nbsp&nbsp Signed in as: <b><a class=frm1 href=\"http://localhost:8080/WebApplication2/User\"> " + session.getAttribute("UserName") +  "</b></a></p>");
            }
            
            out.println("    <ul id=\"tabs\">\n" +
            "      <li><a class=\"bck1\" href=\"/WebApplication2/Home\">Home</a></li>\n" +
            "      <li><a class=\"bck1\" href=\"http://localhost:8080/WebApplication2/Battery\">Battery</a></li>\n" +
            "      <li><a class=\"bck1\" href=\"http://localhost:8080/WebApplication2/PhoneCover\">Phone Covers</a></li>\n" +
            "      <li><a class=\"bck1\" href=\"http://localhost:8080/WebApplication2/CCCable\">Charging-Connection Cables</a></li>\n" +
            "      <li><a class=\"bck1\" href=\"http://localhost:8080/WebApplication2/Headphone\">Headphones</a></li>\n" +
            "      <li><a class=\"bck1\" href=\"http://localhost:8080/WebApplication2/CarAcc\">Car Accesories</a></li>\n" +
            "      <li><a class=\"bck1\" href=\"http://localhost:8080/WebApplication2/ScreenProt\">Screen Protectors</a></li>\n" +
            "      <li><a class=\"bck1\" href=\"http://localhost:8080/WebApplication2/PhoneStand\">Phone Stands</a></li>\n" +
            "      <li><a class=\"bck1\" href=\"http://localhost:8080/WebApplication2/PortSpeaker\">Portable Speakers</a></li>\n" +
            "      <li><a class=\"bck1\" href=\"http://localhost:8080/WebApplication2/ArmBand\">Armbands</a></li>\n" +
            "      <li><a class=\"bck1\" href=\"http://localhost:8080/WebApplication2/SignUp\"><b>Sign Up</b></a></li>\n" +
            "      <li><a class=\"bck1\" href=\"http://localhost:8080/WebApplication2/AboutUs\">About Us</a></li>\n" +
            "    </ul>\n");
            
            out.println("<div class=\"tabContent\" >\n" +
            "      <h2>User: "+ session.getAttribute("UserName") + "</h2>\n");
            
            if(request.getParameter("deleteuser")!=null && request.getParameter("delete")==null )
            {
                out.println("<p> Enter password to delete user! </p>");
                out.println("<form method='POST' action='User'>" +
                "<input name='delete' type='password'>" +
                "<input type='submit' value=' Delete '></form>");
            }
            else if(!session.getAttribute("UserName").toString().equals("Signed Out"))
            {
            try {
                Connection con = DriverManager.getConnection( "jdbc:derby://localhost:1527/webdatabaseproje", "proje", "proje" );
                Statement stat = con.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                ResultSet rs;
                
                List<String> list = new ArrayList<>();
                rs = stat.executeQuery("SELECT city FROM City");
                rs.first();
                do{
                    list.add(rs.getString("CITY"));
                }while(rs.next());
                rs.close();
                
                String sql= "SELECT nameof, surname, city, address FROM Users " +
                        "                         JOIN City ON City.id=Users.cityid" +
                        "                   WHERE Users.id = " +  session.getAttribute("UserId");
                rs = stat.executeQuery(sql);
                                    
                rs.first();
                out.println("<p> User Info: </p>" +
                "<p> Name: " + rs.getString("NAMEOF") +  "</p>" +
                "<p> Surname: " + rs.getString("SURNAME") + "</p>" +
                "<p> City: " + rs.getString("CITY") + "</p>" +
                "<p> Address: " + rs.getString("ADDRESS") + "</p>");
                rs.close();
                
                out.println("<form method='POST' action='Edit'>" +
                "<input type='submit' value='          Edit          '></form>");
                
                out.println("<form method='POST' action='User'>" +
                "<input name='signout' type='hidden'>" +
                "<input type='submit' value='      Sign Out      '></form>");
                
                out.println("<form method='POST' action='User'>" +
                "<input name='deleteuser' type='hidden'>" +
                "<input type='submit' value='    Delete User    '></form>");
                try
                {
                    out.println("<p> Orders: </p>" );
                    sql= "SELECT  Orders.id AS ordid, nameof,odate FROM Orders JOIN Product ON Orders.pid=Product.id" +
                        "                   WHERE Orders.userid = " +  session.getAttribute("UserId");
                    rs = stat.executeQuery(sql);
                    rs.first();
                    do{
                        out.println("<p>" + rs.getInt("ordid") + ": " + rs.getString("NAMEOF") + ":&nbsp&nbsp" + rs.getString("ODATE")+"</p>" );
                    }while(rs.next());
                }
                catch(Exception ex){ }
                rs.close();
                stat.close();
                con.close();
                
            } catch (SQLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            out.println("</div>\n" + 
            "           </body>\n" + 
            "           </html>");
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.sql.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "BuyResult", urlPatterns = {"/BuyResult"})
public class BuyResult extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
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
            "      th, td { padding: 5px; text-align: left; }\n" +
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
             out.println("<p class=frm1 ><a class=frm1 href=\"http://localhost:8080/WebApplication2/Cart?id=0\"><b>Cart(" + session.getAttribute("cartNum") + ")</b></a>&nbsp&nbsp Signed in as: <b><a class=frm1 href=\"http://localhost:8080/WebApplication2/User\"> " + session.getAttribute("UserName") +  "</b></a></p>");
            
            out.println("    <ul id=\"tabs\">\n" +
            "      <li><a class=\"bck1\" href=\"http://localhost:8080/WebApplication2/Home\">Home</a></li>\n" +
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
            "      <h2>Buy product:</h2>\n");
            
            ArrayList<String> CartProducts = new ArrayList<String>();
            
            if(request.getParameter("cardnum")!=null && request.getParameter("cardnum").length()==16 && request.getParameter("cvc2")!=null && request.getParameter("cvc2").length()==3)
            {
                out.println("<p> Buy Succesfull: </p>");
                session.setAttribute("cartNum",0);
                
                try {
                    Connection con = DriverManager.getConnection( "jdbc:derby://localhost:1527/webdatabaseproje", "proje", "proje" );
                    Statement stat = con.createStatement( ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                    ResultSet rs;
                    CartProducts = (ArrayList<String>)session.getAttribute("productIDs");
                    
                    for (String pid : CartProducts) {
                        String sql= "SELECT stock FROM Info" +
                        " WHERE pid = " +  pid;
                        rs = stat.executeQuery(sql);
                        rs.first();
                        do{
                            rs.updateInt("STOCK", rs.getInt("STOCK")-1);
                            rs.updateRow();
                        }while(rs.next());
                        rs.close();
                    }
                    
                    rs = stat.executeQuery("SELECT * FROM Orders");
                    rs.first();
                    int orderid;
                    
                    rs.last();
                    try{
                        orderid=rs.getInt("ID")+1;
                    }
                    catch(Exception e)
                    {
                        orderid=1;
                    }
                    rs.close();
                    
                    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    Date date = new Date();
                    String str1 = date.toString();
                    
                    for (String pid : CartProducts) {
                        rs = stat.executeQuery("SELECT * FROM Orders");
                        rs.moveToInsertRow();
                        rs.updateInt("ID", orderid);
                        rs.updateInt("USERID", Integer.parseInt(session.getAttribute("UserId").toString()));
                        rs.updateInt("PID", Integer.parseInt(pid));
                        rs.updateString("ODATE", str1);
                        rs.insertRow();
                        rs.close();
                    }
                    
                    out.println("<p> --------------- </p>" +
                    "<p>Order number: " + orderid + "</p>" +
                    "<p> Date: " +str1 + "</p>");
                    
                    stat.close();
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(BuyResult.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
                out.println("<h2>Wrong Card Number!</h2>\n");
                
            out.println("<p align=\"center\">© MEGA.com Mert, Efe, Gulce, Alper All Rights Reserved</p>");
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package converter.web;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import converter.ejb.ConverterBean;

@WebServlet(name = "ConverterServlet", urlPatterns
        = {"/ConverterServlet"})
public class ConverterServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private ConverterBean cb = new ConverterBean();

    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Temperature Converter</title>");
        out.println("<style>");
        out.println("body { font-family: Monotype Corsiva; background-color: #eceff8; text-align: center; display: flex; flex-direction: column; align-items: center; height: 100vh; justify-content: center;}");
        out.println(".container { background-color: #9dbed4; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.2); width: 300px; }");
        out.println("h1 { color: #333; }");
        out.println("input[type='text'] { width: 100%; padding: 10px; margin: 10px 0; border: 1px solid #ccc; border-radius: 5px; }");
        out.println("input[type='submit'] {font-family: Monotype Corsiva; width: 100%; padding: 10px; background-color: #eceff8; color: #000; border: none; border-radius: 5px; cursor: pointer; }");
        out.println("input[type='submit']:hover { background-color: #eceff8; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Fahrenheit/Kelvin Converter</h1>");
        out.println("<div class='container'>");
        try {
            String degree = request.getParameter("degree");
            if ((degree != null) && (degree.length() > 0)) {
                double d = Double.parseDouble(degree);
                if (request.getParameter("F TO K") != null) {
                    String kelvin = cb.ftok(d);
                    out.println("<p>" + degree + " Fahrenheit are " + kelvin + " Kelvin.</p>");
                }

                if (request.getParameter("K TO F") != null) {
                    String fahrenheit = cb.ktof(d);
                    out.println("<p>" + degree + " Kelvin are " + fahrenheit + " Fahrenheit.</p>");
                }

            } else {
                out.println("<p>Enter degree to convert:</p>");
                out.println("<form method=\"get\">");
                out.println("<p> <input type=\"text\" name=\"degree\"size=\"25\"></p>");
                out.println("<br/>");
                out.println("<input type='submit' name='F TO K' value='Convert Fahrenheit To Kelvin'></p>");
                out.println("<input type='submit' name='K TO F' value='Convert Kelvin To Fahrenheit'>");
                out.println("</form>");
            }
        } finally {
            out.println("</body>");
            out.println("</html>");
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
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
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
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
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

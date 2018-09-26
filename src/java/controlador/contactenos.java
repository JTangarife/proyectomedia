/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelos.Contactenos;
/**
 *
 * @author Usuario
 */
@WebServlet(name = "contactenos", urlPatterns = {"/contactenos"})
public class contactenos extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("jsp/contactenos.jsp");
        request.setAttribute("ListaDesa", consultarDatos());
        
        String nombre = request.getParameter("nombre");
        
        if(nombre != null && !nombre.equals("")) {
            String telefono = request.getParameter("telefono");
            String direccion = request.getParameter("direccion");
        }
        rd.forward(request, response);
    }
    
    private void guardarDesarrollador (String nombre, String telefono, String direccion){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/contactenos","root", "");
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM desarrolladores");
            ps.setString(1, nombre);
            ps.setString(2, telefono);
            ps.setString(3, direccion);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(contactenos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(contactenos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    List<Contactenos> consultarDatos(){
        List<Contactenos> ListaDesa = new ArrayList<Contactenos>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/contactenos","root", "");
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM desarrolladores");
            ResultSet resultado = ps.executeQuery();
            Contactenos c;
            while(resultado.next()){
                String nombre = resultado.getString("nombre");
                String telefono = resultado.getString("telefono");
                String direccion = resultado.getString("direccion");
                c = new Contactenos(nombre, telefono, direccion);
                ListaDesa.add(c);
            }
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(contactenos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex){
            Logger.getLogger(contactenos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ListaDesa;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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

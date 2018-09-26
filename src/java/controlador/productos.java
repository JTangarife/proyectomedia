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

import modelos.Producto;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "productos", urlPatterns = {"/productos"})
public class productos extends HttpServlet {

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
        RequestDispatcher rd = request.getRequestDispatcher("jsp/productos.jsp");
        request.setAttribute("listaProd", consultarDatos());
        
        String nombre = request.getParameter("nombre");
        
        if(nombre != null && !nombre.equals("")) {
            String precio = request.getParameter("precio");
            String descripcion = request.getParameter("descripcion");
            int tipocomida = Integer.parseInt(request.getParameter("tipocomida"));
            guardarProducto(nombre, precio, descripcion, tipocomida);
        }
        
        rd.forward(request, response);
    }
    private void guardarProducto(String nombre, String precio, String descripcion, int tipocomida) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/productos", "root", "");
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO `productos`.`listado` (`nombre`, `precio`, descripcion, tipocomida) VALUES (?, ?, ?, ?)");
            ps.setString(1, nombre);
            ps.setString(2, precio);
            ps.setString(3, descripcion);
            ps.setInt(4, tipocomida);
            ps.execute();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(productos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(productos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    List<Producto> consultarDatos (){
        List<Producto> listaProd = new ArrayList<Producto>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/productos","root", "");
            PreparedStatement ps = conexion.prepareStatement("SELECT * FROM listado");
            ResultSet resultado = ps.executeQuery();
            Producto p;
            while(resultado.next()) {
                String nombre = resultado.getString("nombre");
                String  precio = resultado.getString("precio");
                String  descripcion = resultado.getString("descripcion");
                p = new Producto(nombre, precio, descripcion);
                listaProd.add(p);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(productos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(productos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaProd;
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

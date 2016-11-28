/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controlador;

import com.udea.dao.CarteleraDAOImpl;
import com.udea.dto.Cartelera;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author NELLY SILGADO
 */
public class Controlador extends HttpServlet {
    String address = "";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private void doAction(HttpServletRequest request, boolean guardar)
    {
        HttpSession session = request.getSession(true);
        
        System.out.println("ContextPath: "+request.getContextPath());
        System.out.println("Local Addr: "+request.getLocalAddr());
        System.out.println("Request URI: "+request.getRequestURI());
        System.out.println("Local Name: "+request.getLocalName());
        
        
 

        
      }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        address = request.getRequestURI().replaceFirst("/cine", "");
        if (address.startsWith("/")){
            address.replaceFirst("/", "");
        }else{
            address="/"+address;
        }
        
        System.out.println("Addres: "+address);
        
        switch(address){
            case "/":
                address="/index";
                break;
            case "/index":
                break;
            case "/cartelera":
                address="/ListaCartelera";
                CarteleraDAOImpl cDAOImpl = new CarteleraDAOImpl();
                List<Cartelera> listC = cDAOImpl.getCartelras();
                request.setAttribute("carteleras", listC);
                break;
            case "/pelicula":
                break;
            default:
                address="/error";
                request.setAttribute("error", "La página no existe");
        }
        
        
        doAction(request, true);
        
        request.setAttribute("ey", "ey msg");
        request.getRequestDispatcher(address+".jsp").forward(request, response);
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

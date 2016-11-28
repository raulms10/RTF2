/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controlador;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import com.udea.dao.CarteleraDAOImpl;
import com.udea.dao.PeliculaDAOImpl;
import com.udea.dao.ReservaDAOImpl;
import com.udea.dao.UsuarioDAOImpl;
import com.udea.dto.Cartelera;
import com.udea.dto.Pelicula;
import com.udea.dto.Reserva;
import com.udea.dto.Usuario;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
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
    public Integer param;
    public String param2;
    static Controlador myIntance;
    
    public static Controlador getInstance(){
        if(myIntance == null){
            return new Controlador();
        }
        return myIntance;
    }

    public Controlador() {
    }
    
    
    
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
        
        
        System.out.println("ContextPath: "+request.getContextPath());
        System.out.println("Local Addr: "+request.getLocalAddr());
        System.out.println("Request URI: "+request.getRequestURI());
        System.out.println("Local Name: "+request.getLocalName());
        
        
 

        
     }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, boolean login)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        
        response.setContentType("text/html;charset=UTF-8");
        address = request.getRequestURI().replaceFirst("/cine", "");
        if (address.startsWith("/")){
            address.replaceFirst("/", "");
        }else{
            address="/cine"+address;
        }
        
        System.out.println("Addres: "+address);
        
        switch(address){
            case "/":
                address="/index";
                break;
            case "/login":
                String email = "";
                String pass = "";
                if(login){
                    UsuarioDAOImpl uDAOImpl = new UsuarioDAOImpl();
                    email = request.getParameter("email");
                    pass = request.getParameter("contrasenia");
                    System.out.println(email+ "p: "+pass);
                    Usuario u =uDAOImpl.getUsuario(email, pass);
                    if (u != null) {
                        address="/index";
                        session.setAttribute("email", email);
                        session.setAttribute("codigo", u.getCodigo());
                    }else{
                        request.setAttribute("error", "El Usuario no existe, verifique");
                    }
                }else{
                    email = (String) session.getAttribute("email");
                    if (email != null) {
                        address="/index";
                    }else{
                        address="/login";
                    }
                }
                break;
            case "/cerrar":
                session.setAttribute("email", null);
                address="/index";
            break;
            case "/reservas":
                ReservaDAOImpl rDAOImpl = new ReservaDAOImpl();
                List<Reserva> listReserva = rDAOImpl.getReservas();
                request.setAttribute("reservas", listReserva);
                address="/mostrarReserva";
                break;
            case "/cine":
                address="/index";
                break;
            case "/index":
                break;
            case "/cartelera":
                CarteleraDAOImpl cDAOImpl = new CarteleraDAOImpl();
                List<Cartelera> listC = cDAOImpl.getCarteleras();
                request.setAttribute("carteleras", listC);
                address="/ListaCartelera";
                break;
            case "/pelicula":
                address="/consultaPelicula";
                break;
            case "/peliculas":
                PeliculaDAOImpl pDAOImpl = new PeliculaDAOImpl();
                String ti = request.getParameter("tit");
                String genero = request.getParameter("generoPk");
                String clasif = request.getParameter("clasificacionPk");
                List<Pelicula> listaPel = (List<Pelicula>)pDAOImpl.getPeliculas(ti, genero, clasif);
                
                request.setAttribute("peliculas", listaPel);
                request.setAttribute("clasif", param);
                request.setAttribute("genero", param2);
                      
                address="/mostrarPelicula";
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
        processRequest(request, response, false);
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
        processRequest(request, response, true);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.dao;

import com.udea.dto.Pelicula;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author estudiantelis
*/
@Local
public interface PeliculaDAO {
    
    List<String> getPeliculas(String t,String g, String c);
    
    Pelicula getPelicula(String cod);
    
    List<Pelicula> getPeliculas();
   
    
    
}

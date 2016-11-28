/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.dao;

import com.udea.dto.Usuario;
import javax.ejb.Local;

/**
 *
 * @author estudiantelis
 */
@Local
public interface UsuarioDAO {
    
    Usuario getUsuarioByID(String userId);
    
    Usuario getUsuario(String email, String pass);
    
}

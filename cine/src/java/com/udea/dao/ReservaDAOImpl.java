/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.dao;

import com.udea.dto.Reserva;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author estudiantelis
 */
public class ReservaDAOImpl implements ReservaDAO{
    Session session = null;
    
    public ReservaDAOImpl() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    

    @Override
    public List<Reserva> getReservas() {
        return null;
    }

    @Override
    public Reserva getReserva(String cod) {
        return null;
    }

    @Override
    public boolean setReserva(String cod, String boleto, String fecha, String hora) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteReserva(String cod) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

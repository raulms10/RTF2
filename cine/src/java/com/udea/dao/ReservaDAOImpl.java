/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.dao;

import com.udea.dto.Reserva;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

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
        List<Reserva> reservaList = null;

        if(!session.isOpen())
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            Query q = session.createQuery ("from Reserva");
            reservaList = (List<Reserva>) q.list();
            tx.commit();
        }
        catch (HibernateException ex) {
            System.out.println("Error ReservaDAOImpl, getReservas(): "+ex.getMessage());
            tx.rollback();
            ex.printStackTrace();
        }
        return reservaList;
    }

    @Override
    public Reserva getReserva(String cod) {
        Reserva p=null;

        if(!session.isOpen())
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            Query q = session.createQuery ("from Reserva r where r.codigo="+cod);
            p = (Reserva) q.uniqueResult();
            tx.commit();
        }
        catch (HibernateException ex) {
            System.out.println("Error ReservaDAOImpl, getReserva(): "+ex.getMessage());
            tx.rollback();
            ex.printStackTrace();
        }
        return p;
    }

    @Override
    public boolean setReserva(String cod, String boleto, String fecha, String hora) {
        int result = 0;

        if(!session.isOpen())
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            
            Query query = session.createQuery("update Reserva r "
                    +"set r.boleto_Fk = "+boleto
                    +" and r.fecha = "+ fecha 
                    +" and r.hora = "+ hora
                    +" where r.codigo = "+cod);
            result = query.executeUpdate();
            tx.commit();
            return result != 0;
        }
        catch (HibernateException ex) {
            System.out.println("Error ReservaDAOImpl, setReserva(): "+ex.getMessage());
            tx.rollback();
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteReserva(String cod) {
        int result = 0;
        
        if(!session.isOpen())
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            
            Query query = session.createQuery("delete Reserva r " +" where r.codigo = "+cod);
            result = query.executeUpdate();
            tx.commit();
            return result != 0;
        }
        catch (HibernateException ex) {
            System.out.println("Error ReservaDAOImpl, setReserva(): "+ex.getMessage());
            tx.rollback();
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insertReserva(String codBol, String estado, String fecha, String hora, String user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

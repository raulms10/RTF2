/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.dao;

import com.udea.dto.Pelicula;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author estudiantelis
 */
public class PeliculaDAOImpl implements PeliculaDAO{
    Session session = null;

    public PeliculaDAOImpl() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    @Override
    public List<Pelicula> getPeliculas() {
        List<Pelicula> peliculaList = null;

        if(!session.isOpen())
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            Query q = session.createQuery ("from Pelicula");
            peliculaList = (List<Pelicula>) q.list();
            tx.commit();
        }
        catch (HibernateException ex) {
            System.out.println("Error PeliculaDAOImpl, getPeliculas(): "+ex.getMessage());
            tx.rollback();
            ex.printStackTrace();
        }
        return peliculaList;
    }

    @Override
    public Pelicula getPelicula(String cod) {
        Pelicula p=null;

        if(!session.isOpen())
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            Query q = session.createQuery ("from Pelicula p where c.codigo="+cod);
            p = (Pelicula) q.uniqueResult();
            tx.commit();
        }
        catch (HibernateException ex) {
            System.out.println("Error PeliculaDAOImpl, getPelicula(): "+ex.getMessage());
            tx.rollback();
            ex.printStackTrace();
        }
        return p; 
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.dao;

import com.udea.dto.Cartelera;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author estudiantelis
 */
public class CarteleraDAOImpl implements CarteleraDAO{
    Session session = null;

    public CarteleraDAOImpl() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    @Override
    public List<Cartelera> getCartelras() {
        List<Cartelera> carteleraList = null;

        if(!session.isOpen())
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            Query q = session.createQuery ("from Cartelera c order by c.codigo");
            carteleraList = (List<Cartelera>) q.list();
            tx.commit();
        }
        catch (HibernateException ex) {
            System.out.println("Error Cartelera getPeliculas(): "+ex.getMessage());
            tx.rollback();
            ex.printStackTrace();
        }
        return carteleraList;
    }
    
}

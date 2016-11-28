/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.dao;

import com.udea.dto.Usuario;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author estudiantelis
 */
public class UsuarioDAOImpl implements UsuarioDAO{
    Session session = null;

    public UsuarioDAOImpl() {
        session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    @Override
    public Usuario getUsuarioByID(String cod) {
        Usuario u=null;

        if(!session.isOpen())
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            Query q = session.createQuery ("from Usuario u where u.codigo="+cod);
            u = (Usuario) q.uniqueResult();
            tx.commit();
        }
        catch (HibernateException ex) {
            System.out.println("Error UsuarioDAOImpl, getUsuarioById: "+ex.getMessage());
            tx.rollback();
            ex.printStackTrace();
        }
        return u;
    }

    @Override
    public Usuario getUsuario(String email, String pass) {
        Usuario u=null;

        if(!session.isOpen())
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            Query q = session.createQuery ("from Usuario u where u.email='"+email+"' and u.contrasenia='"+pass+"'");
            u = (Usuario) q.uniqueResult();
            tx.commit();
        }
        catch (HibernateException ex) {
            System.out.println("Error UsuarioDAOImpl, getUsuario(): "+ex.getMessage());
            tx.rollback();
            ex.printStackTrace();
        }
        return u;
    }
    
}

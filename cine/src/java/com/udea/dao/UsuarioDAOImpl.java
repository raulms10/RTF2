/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.dao;

import com.udea.dto.Usuario;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author estudiantelis
 */
public class UsuarioDAOImpl implements UsuarioDAO{

    @Override
    public Usuario getUsuarioByID(Integer userId) {
        Session session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        String queryString="from "+Usuario.class.getName()+"u where u.userId=:id";
        Query query=session.createQuery(queryString);
        query.setParameter("id",userId);
        Usuario u = (Usuario)query.list().get(0);
        transaction.commit();
        return u;
    }
    
}

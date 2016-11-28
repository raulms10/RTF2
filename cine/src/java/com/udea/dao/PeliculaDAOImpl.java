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
    public List<String> getPeliculas(String t, String g, String c) {
        List<String> peliculaList = null;

        if(!session.isOpen())
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
          //FROM Usuario u inner join u.permisos as p WITH p.estatus = 1
            String tablas= "from Pelicula p";
            String cond=" where p.codigo=p.codigo";
            //String strQuery =  "Clasificacion c, Genero g where p.generoPk = g.codigo and p.clasificacionPk=c.codigo";
            if(t!=null && !t.isEmpty()){
                cond+=" and p.titulo = '"+t+"'";
                //cond+="where p.generoPk = g.codigo";
            }
            /*if(g!=null && !g.isEmpty()){
                tablas+=", Genero g";
                cond+=" and p.generoPk = g.codigo";
                cond+=" and g.nombre = '"+g+"'";
            }
            if(c!=null && !c.isEmpty()){
                tablas+=", Clasificacion c";
                cond+=" and p.clasificacionPk=c.codigo";
                cond+=" and c.edad >="+c;
            }*/
            
            Query q = session.createQuery (tablas+cond);
            
            peliculaList = (List<String>) q.list();
            
            System.out.println("Consulta: "+tablas+cond + " "+peliculaList.size());
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

    @Override
    public List<Pelicula> getPeliculas() {
        List<Pelicula> peliculaList = null;

        if(!session.isOpen())
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
          
                    
            String strQuery = "from Pelicula";
         
            
            Query q = session.createQuery(strQuery);
            
            peliculaList = (List<Pelicula>) q.list();
            
            System.out.println("Consulta: "+strQuery + " "+peliculaList.size());
            tx.commit();
        }
        catch (HibernateException ex) {
            System.out.println("Error PeliculaDAOImpl, getPeliculas(): "+ex.getMessage());
            tx.rollback();
            ex.printStackTrace();
        }
        return peliculaList;
    }
    
    
    
}

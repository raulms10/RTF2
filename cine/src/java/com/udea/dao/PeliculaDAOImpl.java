/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.dao;

import com.udea.controlador.Controlador;
import com.udea.dto.Clasificacion;
import com.udea.dto.Genero;
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
    public List<Pelicula> getPeliculas(String t, String g, String c) {
        List<Pelicula> peliculaList = null;

        if(!session.isOpen())
            this.session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            Controlador contr;
          //FROM Usuario u inner join u.permisos as p WITH p.estatus = 1 
            String cond=" where p.codigo=p.codigo";
            if(t!=null && !t.isEmpty()){
                cond+=" and p.titulo='"+t+"'";
            }
            
         
                
                if(g!=null && !g.isEmpty()){
                    Query qG = session.createQuery ("from Genero g where g.nombre='"+g+"'");
                    Genero genero = (Genero) qG.uniqueResult();
                    if(genero!=null){ 
                        contr = Controlador.getInstance();
                        contr.param2 = genero.getNombre();   
                        cond+=" and p.generoPk='"+genero.getCodigo()+"'";                    
                    }
            }
            
            
            
                
                if(c!=null && !c.isEmpty()){
                    Query qC = session.createQuery ("from Clasificacion c where c.edad>="+c);
                    List<Clasificacion> cla = qC.list();
                    if(cla.size()>0){
                        contr = Controlador.getInstance();
                        contr.param = cla.get(0).getEdad();
                        cond+=" and p.clasificacionPk='"+cla.get(0).getCodigo()+"'";
                    }
                }
            
            
            String tablas= "from Pelicula p";
           
            Query q = session.createQuery (tablas+cond);
            
            peliculaList = (List<Pelicula>) q.list();
            
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

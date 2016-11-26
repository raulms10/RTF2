package com.udea.dto;
// Generated 26/11/2016 02:55:03 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Elenco generated by hbm2java
 */
@Entity
@Table(name="ELENCO"
    ,schema="ROOT"
)
public class Elenco  implements java.io.Serializable {


     private String codigo;
     private String peliculaFk;

    public Elenco() {
    }

    public Elenco(String codigo, String peliculaFk) {
       this.codigo = codigo;
       this.peliculaFk = peliculaFk;
    }
   
     @Id 

    
    @Column(name="CODIGO", unique=true, nullable=false, length=15)
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    @Column(name="PELICULA_FK", nullable=false, length=15)
    public String getPeliculaFk() {
        return this.peliculaFk;
    }
    
    public void setPeliculaFk(String peliculaFk) {
        this.peliculaFk = peliculaFk;
    }




}


package com.udea.dto;
// Generated 26/11/2016 02:55:03 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Genero generated by hbm2java
 */
@Entity
@Table(name="GENERO"
    ,schema="ROOT"
)
public class Genero  implements java.io.Serializable {


     private String codigo;
     private String nombre;

    public Genero() {
    }

    public Genero(String codigo, String nombre) {
       this.codigo = codigo;
       this.nombre = nombre;
    }
   
     @Id 

    
    @Column(name="CODIGO", unique=true, nullable=false, length=15)
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    @Column(name="NOMBRE", nullable=false, length=50)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




}



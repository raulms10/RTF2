package com.udea.dto;
// Generated 26/11/2016 02:55:03 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Boleto generated by hbm2java
 */
@Entity
@Table(name="BOLETO"
    ,schema="ROOT"
)
public class Boleto  implements java.io.Serializable {


     private String codigo;
     private String asientoFk;
     private String funcionFk;

    public Boleto() {
    }

    public Boleto(String codigo, String asientoFk, String funcionFk) {
       this.codigo = codigo;
       this.asientoFk = asientoFk;
       this.funcionFk = funcionFk;
    }
   
     @Id 

    
    @Column(name="CODIGO", unique=true, nullable=false, length=15)
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    
    @Column(name="ASIENTO_FK", nullable=false, length=15)
    public String getAsientoFk() {
        return this.asientoFk;
    }
    
    public void setAsientoFk(String asientoFk) {
        this.asientoFk = asientoFk;
    }

    
    @Column(name="FUNCION_FK", nullable=false, length=15)
    public String getFuncionFk() {
        return this.funcionFk;
    }
    
    public void setFuncionFk(String funcionFk) {
        this.funcionFk = funcionFk;
    }




}



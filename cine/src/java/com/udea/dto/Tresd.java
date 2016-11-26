package com.udea.dto;
// Generated 26/11/2016 02:55:03 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tresd generated by hbm2java
 */
@Entity
@Table(name="TRESD"
    ,schema="ROOT"
)
public class Tresd  implements java.io.Serializable {


     private String salaFk;

    public Tresd() {
    }

    public Tresd(String salaFk) {
       this.salaFk = salaFk;
    }
   
     @Id 

    
    @Column(name="SALA_FK", unique=true, nullable=false, length=15)
    public String getSalaFk() {
        return this.salaFk;
    }
    
    public void setSalaFk(String salaFk) {
        this.salaFk = salaFk;
    }




}



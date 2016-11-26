package com.udea.dto;
// Generated 26/11/2016 02:55:03 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Actor generated by hbm2java
 */
@Entity
@Table(name="ACTOR"
    ,schema="ROOT"
)
public class Actor  implements java.io.Serializable {


     private String integranteFk;

    public Actor() {
    }

    public Actor(String integranteFk) {
       this.integranteFk = integranteFk;
    }
   
     @Id 

    
    @Column(name="INTEGRANTE_FK", unique=true, nullable=false, length=15)
    public String getIntegranteFk() {
        return this.integranteFk;
    }
    
    public void setIntegranteFk(String integranteFk) {
        this.integranteFk = integranteFk;
    }




}


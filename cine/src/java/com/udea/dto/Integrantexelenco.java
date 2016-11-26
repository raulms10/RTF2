package com.udea.dto;
// Generated 26/11/2016 02:55:03 PM by Hibernate Tools 4.3.1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Integrantexelenco generated by hbm2java
 */
@Entity
@Table(name="INTEGRANTEXELENCO"
    ,schema="ROOT"
)
public class Integrantexelenco  implements java.io.Serializable {


     private IntegrantexelencoId id;

    public Integrantexelenco() {
    }

    public Integrantexelenco(IntegrantexelencoId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="elencoFk", column=@Column(name="ELENCO_FK", nullable=false, length=15) ), 
        @AttributeOverride(name="integranteFk", column=@Column(name="INTEGRANTE_FK", nullable=false, length=15) ) } )
    public IntegrantexelencoId getId() {
        return this.id;
    }
    
    public void setId(IntegrantexelencoId id) {
        this.id = id;
    }




}


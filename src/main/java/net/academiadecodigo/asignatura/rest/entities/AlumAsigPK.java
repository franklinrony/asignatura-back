/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.academiadecodigo.asignatura.rest.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigInteger;

/**
 *
 * @author cash america
 */
@Embeddable
public class AlumAsigPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ASIG_ID")
    private BigInteger asigId;
    @Basic(optional = false)
    @Column(name = "ALUM_ID")
    private BigInteger alumId;

    public AlumAsigPK() {
    }

    public AlumAsigPK(BigInteger asigId, BigInteger alumId) {
        this.asigId = asigId;
        this.alumId = alumId;
    }

    public BigInteger getAsigId() {
        return asigId;
    }

    public void setAsigId(BigInteger asigId) {
        this.asigId = asigId;
    }

    public BigInteger getAlumId() {
        return alumId;
    }

    public void setAlumId(BigInteger alumId) {
        this.alumId = alumId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asigId != null ? asigId.hashCode() : 0);
        hash += (alumId != null ? alumId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlumAsigPK)) {
            return false;
        }
        AlumAsigPK other = (AlumAsigPK) object;
        if ((this.asigId == null && other.asigId != null) || (this.asigId != null && !this.asigId.equals(other.asigId))) {
            return false;
        }
        if ((this.alumId == null && other.alumId != null) || (this.alumId != null && !this.alumId.equals(other.alumId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.academiadecodigo.asignatura.rest.entities.AlumAsigPK[ asigId=" + asigId + ", alumId=" + alumId + " ]";
    }
    
}

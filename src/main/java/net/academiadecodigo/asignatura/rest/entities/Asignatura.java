/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.academiadecodigo.asignatura.rest.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author cash america
 */
@Entity
@Table(name = "ASIGNATURA", catalog = "", schema = "ASIGNATURA")
public class Asignatura implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ASIG_ID")
    private BigDecimal asigId;
    @Basic(optional = false)
    @Column(name = "ASIG_DESCRIPCION")
    private String asigDescripcion;
    @JoinTable(name = "PROF_ASIG", joinColumns = {
        @JoinColumn(name = "ASIG_ID", referencedColumnName = "ASIG_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "PROF_ID", referencedColumnName = "PROF_ID")})
    @ManyToMany
    private List<Profesor> profesorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "asignatura")
    private List<AlumAsig> alumAsigList;

    public Asignatura() {
    }

    public Asignatura(BigDecimal asigId) {
        this.asigId = asigId;
    }

    public Asignatura(BigDecimal asigId, String asigDescripcion) {
        this.asigId = asigId;
        this.asigDescripcion = asigDescripcion;
    }

    public BigDecimal getAsigId() {
        return asigId;
    }

    public void setAsigId(BigDecimal asigId) {
        this.asigId = asigId;
    }

    public String getAsigDescripcion() {
        return asigDescripcion;
    }

    public void setAsigDescripcion(String asigDescripcion) {
        this.asigDescripcion = asigDescripcion;
    }

    public List<Profesor> getProfesorList() {
        return profesorList;
    }

    public void setProfesorList(List<Profesor> profesorList) {
        this.profesorList = profesorList;
    }

    public List<AlumAsig> getAlumAsigList() {
        return alumAsigList;
    }

    public void setAlumAsigList(List<AlumAsig> alumAsigList) {
        this.alumAsigList = alumAsigList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (asigId != null ? asigId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.asigId == null && other.asigId != null) || (this.asigId != null && !this.asigId.equals(other.asigId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.academiadecodigo.asignatura.rest.entities.Asignatura[ asigId=" + asigId + " ]";
    }
    
}

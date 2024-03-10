/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.academiadecodigo.asignatura.rest.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author cash america
 */
@Entity
@Table(name = "PROFESOR", catalog = "", schema = "ASIGNATURA")
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "PROF_ID")
    private BigDecimal profId;
    @Basic(optional = false)
    @Column(name = "PROF_NOMBRES")
    private String profNombres;
    @Basic(optional = false)
    @Column(name = "PROF_APELLIDOS")
    private String profApellidos;
    @Basic(optional = false)
    @Column(name = "PROF_FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date profFechaNacimiento;
    @ManyToMany(mappedBy = "profesorList")
    private List<Asignatura> asignaturaList;

    public Profesor() {
    }

    public Profesor(BigDecimal profId) {
        this.profId = profId;
    }

    public Profesor(BigDecimal profId, String profNombres, String profApellidos, Date profFechaNacimiento) {
        this.profId = profId;
        this.profNombres = profNombres;
        this.profApellidos = profApellidos;
        this.profFechaNacimiento = profFechaNacimiento;
    }

    public BigDecimal getProfId() {
        return profId;
    }

    public void setProfId(BigDecimal profId) {
        this.profId = profId;
    }

    public String getProfNombres() {
        return profNombres;
    }

    public void setProfNombres(String profNombres) {
        this.profNombres = profNombres;
    }

    public String getProfApellidos() {
        return profApellidos;
    }

    public void setProfApellidos(String profApellidos) {
        this.profApellidos = profApellidos;
    }

    public Date getProfFechaNacimiento() {
        return profFechaNacimiento;
    }

    public void setProfFechaNacimiento(Date profFechaNacimiento) {
        this.profFechaNacimiento = profFechaNacimiento;
    }

    public List<Asignatura> getAsignaturaList() {
        return asignaturaList;
    }

    public void setAsignaturaList(List<Asignatura> asignaturaList) {
        this.asignaturaList = asignaturaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profId != null ? profId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesor)) {
            return false;
        }
        Profesor other = (Profesor) object;
        if ((this.profId == null && other.profId != null) || (this.profId != null && !this.profId.equals(other.profId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.academiadecodigo.asignatura.rest.entities.Profesor[ profId=" + profId + " ]";
    }
    
}

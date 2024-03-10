/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.academiadecodigo.asignatura.rest.entities;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "MUNICIPIO", catalog = "", schema = "ASIGNATURA")
public class Municipio implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "MUNI_ID")
    private BigDecimal muniId;
    @Basic(optional = false)
    @Column(name = "MUNI_NOMBRE")
    private String muniNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "muniId")
    @JsonbTransient
    private List<Alumno> alumnoList;
    @JoinColumn(name = "DEPT_ID", referencedColumnName = "DEPT_ID")
    @ManyToOne(optional = false)
    private Departamento deptId;

    public Municipio() {
    }

    public Municipio(BigDecimal muniId) {
        this.muniId = muniId;
    }

    public Municipio(BigDecimal muniId, String muniNombre) {
        this.muniId = muniId;
        this.muniNombre = muniNombre;
    }

    public BigDecimal getMuniId() {
        return muniId;
    }

    public void setMuniId(BigDecimal muniId) {
        this.muniId = muniId;
    }

    public String getMuniNombre() {
        return muniNombre;
    }

    public void setMuniNombre(String muniNombre) {
        this.muniNombre = muniNombre;
    }

    public List<Alumno> getAlumnoList() {
        return alumnoList;
    }

    public void setAlumnoList(List<Alumno> alumnoList) {
        this.alumnoList = alumnoList;
    }

    public Departamento getDeptId() {
        return deptId;
    }

    public void setDeptId(Departamento deptId) {
        this.deptId = deptId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (muniId != null ? muniId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipio)) {
            return false;
        }
        Municipio other = (Municipio) object;
        if ((this.muniId == null && other.muniId != null) || (this.muniId != null && !this.muniId.equals(other.muniId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.academiadecodigo.asignatura.rest.entities.Municipio[ muniId=" + muniId + " ]";
    }
    
}

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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
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
@Table(name = "ALUMNO", catalog = "", schema = "ASIGNATURA")
public class Alumno implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ALUM_ID")
    private BigDecimal alumId;
    @Basic(optional = false)
    @Column(name = "ALUM_NOMBRES")
    private String alumNombres;
    @Basic(optional = false)
    @Column(name = "ALUM_APELLIDOS")
    private String alumApellidos;
    @Basic(optional = false)
    @Column(name = "ALUM_FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date alumFechaNacimiento;
    @Basic(optional = false)
    @Column(name = "ALUM_DIRECCION")
    private String alumDireccion;
    @JoinColumn(name = "MUNI_ID", referencedColumnName = "MUNI_ID")
    @ManyToOne(optional = false)
    private Municipio muniId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "alumno")
    private List<AlumAsig> alumAsigList;

    public Alumno() {
    }

    public Alumno(BigDecimal alumId) {
        this.alumId = alumId;
    }

    public Alumno(BigDecimal alumId, String alumNombres, String alumApellidos, Date alumFechaNacimiento, String alumDireccion) {
        this.alumId = alumId;
        this.alumNombres = alumNombres;
        this.alumApellidos = alumApellidos;
        this.alumFechaNacimiento = alumFechaNacimiento;
        this.alumDireccion = alumDireccion;
    }

    public BigDecimal getAlumId() {
        return alumId;
    }

    public void setAlumId(BigDecimal alumId) {
        this.alumId = alumId;
    }

    public String getAlumNombres() {
        return alumNombres;
    }

    public void setAlumNombres(String alumNombres) {
        this.alumNombres = alumNombres;
    }

    public String getAlumApellidos() {
        return alumApellidos;
    }

    public void setAlumApellidos(String alumApellidos) {
        this.alumApellidos = alumApellidos;
    }

    public Date getAlumFechaNacimiento() {
        return alumFechaNacimiento;
    }

    public void setAlumFechaNacimiento(Date alumFechaNacimiento) {
        this.alumFechaNacimiento = alumFechaNacimiento;
    }

    public String getAlumDireccion() {
        return alumDireccion;
    }

    public void setAlumDireccion(String alumDireccion) {
        this.alumDireccion = alumDireccion;
    }

    public Municipio getMuniId() {
        return muniId;
    }

    public void setMuniId(Municipio muniId) {
        this.muniId = muniId;
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
        hash += (alumId != null ? alumId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumno)) {
            return false;
        }
        Alumno other = (Alumno) object;
        if ((this.alumId == null && other.alumId != null) || (this.alumId != null && !this.alumId.equals(other.alumId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "net.academiadecodigo.asignatura.rest.entities.Alumno[ alumId=" + alumId + " ]";
    }
    
}

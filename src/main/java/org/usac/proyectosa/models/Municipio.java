package org.usac.proyectosa.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author esvux
 */
@Entity
@Table(name = "municipio")
public class Municipio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_municipio")
    private Integer idMunicipio;

    @NotNull
    @Size(max = 150)
    @Column(name = "nombre")
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipio", fetch = FetchType.LAZY)
    private Set<CentroVotacion> centrosVotacion;

    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference(value = "municipio")
    private Departamento departamento;

    public Municipio() {
    }

    public Municipio(Integer idMunicipio, String nombre) {
        this.idMunicipio = idMunicipio;
        this.nombre = nombre;
    }
    
    public Municipio(Integer idMunicipio, String nombre, Departamento depto) {
        this.idMunicipio = idMunicipio;
        this.nombre = nombre;
        this.departamento = depto;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<CentroVotacion> getCentrosVotacion() {
        return centrosVotacion;
    }

    public void setCentrosVotacion(Set<CentroVotacion> centrosVotacion) {
        this.centrosVotacion = centrosVotacion;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    
}

package org.usac.proyectosa.models;

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
@Table(name = "centro_votacion")
public class CentroVotacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_centro")
    private Integer idCentro;

    @NotNull
    @Size(max = 150)
    @Column
    private String nombre;
    
    @NotNull
    @Size(max = 150)
    @Column
    private String direccion;
    
    @Size(max = 150)
    @Column(name = "extra_direccion")
    private String extraDireccion;
    
    @JoinColumn(name = "id_municipio", referencedColumnName = "id_municipio")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Municipio municipio;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "centroVotacion", fetch = FetchType.LAZY)
    private Set<MesaVotacion> mesasVotacion;

    public Integer getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(Integer idCentro) {
        this.idCentro = idCentro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getExtraDireccion() {
        return extraDireccion;
    }

    public void setExtraDireccion(String extraDireccion) {
        this.extraDireccion = extraDireccion;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }

    public Set<MesaVotacion> getMesasVotacion() {
        return mesasVotacion;
    }

    public void setMesasVotacion(Set<MesaVotacion> mesasVotacion) {
        this.mesasVotacion = mesasVotacion;
    }
    
}

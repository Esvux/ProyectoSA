package org.usac.proyectosa.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
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
import org.usac.proyectosa.rest.View;

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
    @JsonView(View.Search.class)
    private Integer idMunicipio;

    @NotNull
    @Size(max = 150)
    @Column(name = "nombre")
    @JsonView(View.Search.class)
    private String nombre;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "municipio", fetch = FetchType.LAZY)
    @JsonManagedReference("municipio-centros")
    private Set<CentroVotacion> centrosVotacion;

    @JoinColumn(name = "id_departamento", referencedColumnName = "id_departamento")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference("departamento-municipios")
    private Departamento departamento;

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

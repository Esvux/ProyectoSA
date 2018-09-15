package org.usac.proyectosa.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

/**
 *
 * @author esvux
 */
@Entity
@Table(name = "mesa_votacion")
public class MesaVotacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_mesa")
    private Integer idMesa;
    
    @NotNull
    @Column(name = "num_mesa")
    private int numMesa;
    
    @NotNull
    @Column(name = "cant_nulos")
    private int cantNulos;
    
    @NotNull
    @Column(name = "cant_blancos")
    private int cantBlancos;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mesa", fetch = FetchType.LAZY)
    @JsonManagedReference("mesa-votos")
    private Set<Voto> votos;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mesa", fetch = FetchType.LAZY)
    @JsonManagedReference("mesa-electores")
    private Set<Elector> electores;
    
    @JoinColumn(name = "id_centro", referencedColumnName = "id_centro")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference("centro-mesas")
    private CentroVotacion centroVotacion;

    public Integer getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Integer idMesa) {
        this.idMesa = idMesa;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

    public int getCantNulos() {
        return cantNulos;
    }

    public void setCantNulos(int cantNulos) {
        this.cantNulos = cantNulos;
    }

    public int getCantBlancos() {
        return cantBlancos;
    }

    public void setCantBlancos(int cantBlancos) {
        this.cantBlancos = cantBlancos;
    }

    public Set<Voto> getVotos() {
        return votos;
    }

    public void setVotos(Set<Voto> votos) {
        this.votos = votos;
    }

    public Set<Elector> getElectores() {
        return electores;
    }

    public void setElectores(Set<Elector> electores) {
        this.electores = electores;
    }

    public CentroVotacion getCentroVotacion() {
        return centroVotacion;
    }

    public void setCentroVotacion(CentroVotacion centroVotacion) {
        this.centroVotacion = centroVotacion;
    }

}

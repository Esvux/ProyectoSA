package org.usac.proyectosa.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author esvux
 */
@Entity
@Table(name = "voto")
public class Voto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_voto")
    private Integer idVoto;
    
    @JoinColumn(name = "id_mesa", referencedColumnName = "id_mesa")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference("mesa-votos")
    private MesaVotacion mesa;
    
    @JoinColumn(name = "id_partido", referencedColumnName = "id_partido")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference("partido-votos")
    private Partido partido;

    public Integer getIdVoto() {
        return idVoto;
    }

    public void setIdVoto(Integer idVoto) {
        this.idVoto = idVoto;
    }

    public MesaVotacion getMesa() {
        return mesa;
    }

    public void setMesa(MesaVotacion mesa) {
        this.mesa = mesa;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }
    
}

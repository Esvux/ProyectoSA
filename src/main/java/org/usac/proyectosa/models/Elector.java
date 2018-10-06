package org.usac.proyectosa.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.usac.proyectosa.rest.View;

/**
 *
 * @author esvux
 */
@Entity
@Table(name = "elector")
public class Elector implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_elector")
    @JsonView(View.Search.class)
    private Integer idElector;
    
    @NotNull
    @Size(max = 20)
    @Column
    @JsonView(View.Search.class)
    private String dpi;
    
    @NotNull
    @Column(name = "num_padron")
    @JsonView(View.Search.class)
    private Integer numPadron;
    
    @NotNull
    @Size(max = 150)
    @Column
    @JsonView(View.Search.class)
    private String nombres;

    @NotNull
    @Size(max = 150)
    @Column
    @JsonView(View.Search.class)
    private String apellidos;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento")
    @JsonView(View.Search.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;
    
    @NotNull
    @Size(min = 1, max = 1)
    @Column
    @JsonView(View.Search.class)
    private String genero;
    
    @NotNull
    @Size(max = 150)
    @Column
    @JsonView(View.Search.class)
    private String direccion;
    
    @Size(max = 150)
    @Column(name = "extra_direccion")
    @JsonView(View.Search.class)
    private String extraDireccion;
    
    @Column(name = "voto_emitido")
    @JsonView(View.Search.class)
    private Boolean votoEmitido;
    
    @JoinColumn(name = "id_mesa", referencedColumnName = "id_mesa")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference("mesa-electores")
    private MesaVotacion mesa;

    public Elector() {
        this.votoEmitido = Boolean.FALSE;
    }
    
    public Integer getIdElector() {
        return idElector;
    }

    public void setIdElector(Integer idElector) {
        this.idElector = idElector;
    }

    public String getDpi() {
        return dpi;
    }

    public void setDpi(String dpi) {
        this.dpi = dpi;
    }

    public Integer getNumPadron() {
        return numPadron;
    }

    public void setNumPadron(Integer numPadron) {
        this.numPadron = numPadron;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
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

    public Boolean getVotoEmitido() {
        return votoEmitido;
    }

    public void setVotoEmitido(Boolean votoEmitido) {
        this.votoEmitido = votoEmitido;
    }
    
    public MesaVotacion getMesa() {
        return mesa;
    }

    public void setMesa(MesaVotacion mesa) {
        this.mesa = mesa;
    }

}

package org.usac.proyectosa.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    private Integer idElector;
    
    @NotNull
    @Size(max = 20)
    @Column
    private String dpi;
    
    @NotNull
    @Size(max = 20)
    @Column(name = "num_padron")
    private String numPadron;
    
    @NotNull
    @Size(max = 150)
    @Column
    private String nombres;

    @NotNull
    @Size(max = 150)
    @Column
    private String apellidos;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento")
    private Date fechaNacimiento;
    
    @NotNull
    @Size(min = 1, max = 1)
    @Column
    private String genero;
    
    @NotNull
    @Size(max = 150)
    @Column
    private String direccion;
    
    @Size(max = 150)
    @Column(name = "extra_direccion")
    private String extraDireccion;
    
    @JoinColumn(name = "id_mesa", referencedColumnName = "id_mesa")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference("mesa-electores")
    private MesaVotacion mesa;

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

    public String getNumPadron() {
        return numPadron;
    }

    public void setNumPadron(String numPadron) {
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

    public MesaVotacion getMesa() {
        return mesa;
    }

    public void setMesa(MesaVotacion mesa) {
        this.mesa = mesa;
    }

}

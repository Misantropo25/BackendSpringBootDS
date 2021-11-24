package inpecable.inpecableSpring.modelo;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;


@Entity
@Table(name="detalleServicio")
public class DetalleServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "costoServicio", scale = 2, precision = 7)
    private BigDecimal costoServicio;
    @Column(name = "fechaCreacion")
    private LocalDateTime fechaCreacion;
    @Column(name = "fechaExpiracion")
    private LocalDateTime fechaExpiracion;


    @OneToOne(mappedBy = "tieneDetalle")
    @JsonManagedReference(value = "tieneDetalle")
    private Servicio tieneDetalle;

    public DetalleServicio() {
    }

    public DetalleServicio(String descripcion, BigDecimal costoServicio, LocalDateTime fechaCreacion, LocalDateTime fechaExpiracion, Servicio tieneDetalle) {
        this.descripcion = descripcion;
        this.costoServicio = costoServicio;
        this.fechaCreacion = fechaCreacion;
        this.fechaExpiracion = fechaExpiracion;
        this.tieneDetalle = tieneDetalle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCostoServicio() {
        return costoServicio;
    }

    public void setCostoServicio(BigDecimal costoServicio) {
        this.costoServicio = costoServicio;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(LocalDateTime fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public Servicio getTieneDetalle() {
        return tieneDetalle;
    }

    public void setTieneDetalle(Servicio tieneDetalle) {
        this.tieneDetalle = tieneDetalle;
    }
}

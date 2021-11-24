package inpecable.inpecableSpring.modelo;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="servicio")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nombreServicio")
    private String nombreServicio;
    @Column(name = "estadoServicio")
    private Boolean estadoServicio;

    @OneToMany(mappedBy = "tieneServicio")
    @JsonManagedReference(value = "tieneServicio")
    private List<Contrato> tieneServicio;

    @OneToOne
    @JoinColumn(name="tieneDetalle", referencedColumnName = "id")
    @JsonBackReference(value = "tieneDetalle")
    private DetalleServicio tieneDetalle;


    public Servicio() {
    }


    public Servicio(String nombreServicio, Boolean estadoServicio, List<Contrato> tieneServicio, DetalleServicio tieneDetalle) {
        this.nombreServicio = nombreServicio;
        this.estadoServicio = estadoServicio;
        this.tieneServicio = tieneServicio;
        this.tieneDetalle = tieneDetalle;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreServicio() {
        return nombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        this.nombreServicio = nombreServicio;
    }

    public Boolean getEstadoServicio() {
        return estadoServicio;
    }

    public void setEstadoServicio(Boolean estadoServicio) {
        this.estadoServicio = estadoServicio;
    }

    public List<Contrato> getTieneServicio() {
        if(this.tieneServicio==null){
            this.tieneServicio = new ArrayList<>();
        }
        return tieneServicio;
    }

    public void setTieneServicio(List<Contrato> tieneServicio) {
        this.tieneServicio = tieneServicio;
    }

    public DetalleServicio getTieneDetalle() {
        return tieneDetalle;
    }

    public void setTieneDetalle(DetalleServicio tieneDetalle) {
        this.tieneDetalle = tieneDetalle;
    }
}

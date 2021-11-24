package inpecable.inpecableSpring.modelo;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="contrato")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "estadoContrato")
    private Boolean estadoContrato;
    @Column(name = "direccion")
    private String direccion;


    @OneToMany(mappedBy = "correspondeContrato")
    @JsonManagedReference(value = "correspondeContrato")
    private List<PagoContrato> correspondeContrato;

    @ManyToOne
    @JoinColumn(name="correspondeCliente", referencedColumnName = "id")
    @JsonBackReference(value = "correspondeCliente")
    private Cliente correspondeCliente;


    @ManyToOne
    @JoinColumn(name="tieneServicio", referencedColumnName = "id")
    @JsonBackReference(value = "tieneServicio")
    private Servicio tieneServicio;


    public Contrato() {
    }


    public Contrato(String descripcion, Boolean estadoContrato, String direccion, List<PagoContrato> correspondeContrato, Cliente correspondeCliente, Servicio tieneServicio) {
        this.descripcion = descripcion;
        this.estadoContrato = estadoContrato;
        this.direccion = direccion;
        this.correspondeContrato = correspondeContrato;
        this.correspondeCliente = correspondeCliente;
        this.tieneServicio = tieneServicio;
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

    public Boolean getEstadoContrato() {
        return estadoContrato;
    }

    public void setEstadoContrato(Boolean estadoContrato) {
        this.estadoContrato = estadoContrato;
    }

    public List<PagoContrato> getCorrespondeContrato() {
        if (this.correspondeContrato == null){
            this.correspondeContrato = new ArrayList<>();
        }
        return correspondeContrato;
    }

    public void setCorrespondeContrato(List<PagoContrato> correspondeContrato) {
        this.correspondeContrato = correspondeContrato;
    }

    public Cliente getCorrespondeCliente() {

        return correspondeCliente;
    }

    public void setCorrespondeCliente(Cliente correspondeCliente) {
        this.correspondeCliente = correspondeCliente;
    }

    public Servicio getTieneServicio() {
        return tieneServicio;
    }

    public void setTieneServicio(Servicio tieneServicio) {
        this.tieneServicio = tieneServicio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

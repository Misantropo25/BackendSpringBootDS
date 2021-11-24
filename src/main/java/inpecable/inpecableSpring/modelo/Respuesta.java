package inpecable.inpecableSpring.modelo;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="respuesta")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "contenido")
    private String contenido;

    @ManyToOne
    @JoinColumn(name="empleadoRespondio", referencedColumnName = "id")
    @JsonBackReference(value = "empleadoRespondio")
    private Empleado empleadoRespondio;

    @ManyToOne
    @JoinColumn(name="ticketRespondio", referencedColumnName = "id")
    @JsonBackReference(value = "ticketRespondio")
    private Ticket ticketRespondio;

    public Respuesta() {
    }

    public Respuesta(String contenido, Empleado empleadoRespondio, Ticket ticketRespondio) {
        this.contenido = contenido;
        this.empleadoRespondio = empleadoRespondio;
        this.ticketRespondio = ticketRespondio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Empleado getEmpleadoRespondio() {
        return empleadoRespondio;
    }

    public void setEmpleadoRespondio(Empleado empleadoRespondio) {
        this.empleadoRespondio = empleadoRespondio;
    }

    public Ticket getTicketRespondio() {
        return ticketRespondio;
    }

    public void setTicketRespondio(Ticket ticketRespondio) {
        this.ticketRespondio = ticketRespondio;
    }
}

package inpecable.inpecableSpring.modelo;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "descripcionTicket")
    private String descripcionTicket;
    @Column(name = "estadoTicket")
    private Boolean estadoTicket;
    @Column(name = "fecCreacion")
    private LocalDateTime fecCreacion;

    @OneToMany(mappedBy = "ticketRespondio")
    @JsonManagedReference(value = "ticketRespondio")
    private List<Respuesta> ticketRespondio;

    @ManyToOne
    @JoinColumn(name="clienteSolicito", referencedColumnName = "id")
    @JsonBackReference(value = "clienteSolicito")
    private Cliente clienteSolicito;


    public Ticket() {
    }

    public Ticket(String descripcionTicket, Boolean estadoTicket, LocalDateTime fecCreacion, List<Respuesta> ticketRespondio, Cliente clienteSolicito) {
        this.descripcionTicket = descripcionTicket;
        this.estadoTicket = estadoTicket;
        this.fecCreacion = fecCreacion;
        this.ticketRespondio = ticketRespondio;
        this.clienteSolicito = clienteSolicito;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getFecCreacion() {
        return fecCreacion;
    }

    public void setFecCreacion(LocalDateTime fecCreacion) {
        this.fecCreacion = fecCreacion;
    }

    public Cliente getClienteSolicito() {
        return clienteSolicito;
    }

    public void setClienteSolicito(Cliente clienteSolicito) {
        this.clienteSolicito = clienteSolicito;
    }

    public String getDescripcionTicket() {
        return descripcionTicket;
    }

    public void setDescripcionTicket(String descripcionTicket) {
        this.descripcionTicket = descripcionTicket;
    }

    public Boolean getEstadoTicket() {
        return estadoTicket;
    }

    public void setEstadoTicket(Boolean estadoTicket) {
        this.estadoTicket = estadoTicket;
    }

    public List<Respuesta> getTicketRespondio() {
        if (this.ticketRespondio == null){
            this.ticketRespondio = new ArrayList<>();
        }
        return ticketRespondio;
    }

    public void setTicketRespondio(List<Respuesta> ticketRespondio) {
        this.ticketRespondio = ticketRespondio;
    }
}

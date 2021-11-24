package inpecable.inpecableSpring.control;

import inpecable.inpecableSpring.modelo.Ticket;
import inpecable.inpecableSpring.modelo.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TicketRestController {
    @Autowired
    private ITicketService ticketService;

    @GetMapping("/ticket")
    public List<Ticket> listar(){
        return ticketService.findAll();
    }

    @GetMapping("/ticket/{id}")
    public Ticket mostrar(@PathVariable Long id){
        return ticketService.findById(id);
    }

    @PostMapping("/ticket")
    @ResponseStatus(HttpStatus.CREATED)
    public Ticket crear(@RequestBody Ticket ticket){
        if(ticket.getDescripcionTicket()!=null){
            ticket.setEstadoTicket(true);
            ticket.setFecCreacion(LocalDateTime.now());
            return ticketService.save(ticket);
        }
        return null;
    }

    @PutMapping("/ticket/{id}")
    public Ticket actualizar(@RequestBody Ticket ticket, @PathVariable Long id){
        Ticket ticketOriginal = ticketService.findById(id);
        if(ticket.getDescripcionTicket()!=null){
            ticketOriginal.setDescripcionTicket(ticket.getDescripcionTicket());
        }
        if(ticket.getEstadoTicket()!=null){
            ticketOriginal.setEstadoTicket(ticket.getEstadoTicket());
        }
        if(ticket.getFecCreacion()!=null){
            ticketOriginal.setFecCreacion(ticket.getFecCreacion());
        }
        return ticketService.save(ticketOriginal);
    }

    @DeleteMapping("/ticket/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        ticketService.delete(id);
    }
}
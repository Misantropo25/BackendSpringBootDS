package inpecable.inpecableSpring.modelo.dao;

import inpecable.inpecableSpring.modelo.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface ITicketDao extends CrudRepository<Ticket,Long> {

}

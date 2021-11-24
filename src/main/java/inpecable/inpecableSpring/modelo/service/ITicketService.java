package inpecable.inpecableSpring.modelo.service;

import inpecable.inpecableSpring.modelo.Ticket;

import java.util.List;

public interface ITicketService {
    public List<Ticket> findAll();
    public Ticket findById(Long id);
    public Ticket save(Ticket ticket);
    public void delete(Long id);
}

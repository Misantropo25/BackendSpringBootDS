package inpecable.inpecableSpring.modelo.service;

import inpecable.inpecableSpring.modelo.Ticket;
import inpecable.inpecableSpring.modelo.dao.ITicketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketServiceImpl implements ITicketService{
    @Autowired
    private ITicketDao ticketDao;

    @Override
    @Transactional(readOnly = true)
    public List<Ticket> findAll() {
        return (List<Ticket>) ticketDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Ticket findById(Long id) {
        return ticketDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Ticket save(Ticket ticket) {
        return ticketDao.save(ticket);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        ticketDao.deleteById(id);
    }
}
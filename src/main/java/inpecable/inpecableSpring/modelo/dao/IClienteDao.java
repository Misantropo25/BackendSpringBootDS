package inpecable.inpecableSpring.modelo.dao;

import inpecable.inpecableSpring.modelo.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository<Cliente,Long> {
}

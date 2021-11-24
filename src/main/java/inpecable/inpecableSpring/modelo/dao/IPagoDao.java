package inpecable.inpecableSpring.modelo.dao;

import inpecable.inpecableSpring.modelo.PagoContrato;
import org.springframework.data.repository.CrudRepository;

public interface IPagoDao extends CrudRepository<PagoContrato, Long> {

}
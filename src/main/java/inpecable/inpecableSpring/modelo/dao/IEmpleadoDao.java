package inpecable.inpecableSpring.modelo.dao;

import inpecable.inpecableSpring.modelo.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface IEmpleadoDao extends CrudRepository<Empleado, Long> {
}

package inpecable.inpecableSpring.modelo.dao;

import inpecable.inpecableSpring.modelo.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario,Long> {

}

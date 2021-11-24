package inpecable.inpecableSpring.modelo.service;

import inpecable.inpecableSpring.modelo.Empleado;

import java.util.List;

public interface IEmpleadoService {
    public List<Empleado> findAll();
    public Empleado findById(Long id);
    public Empleado save(Empleado empleado);
    public void delete(Long id);
}

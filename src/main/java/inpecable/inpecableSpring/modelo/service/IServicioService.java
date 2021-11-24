package inpecable.inpecableSpring.modelo.service;

import inpecable.inpecableSpring.modelo.Servicio;

import java.util.List;

public interface IServicioService {
    public List<Servicio> findAll();
    public Servicio findById(Long id);
    public Servicio save(Servicio servicio);
    public void delete(Long id);
}

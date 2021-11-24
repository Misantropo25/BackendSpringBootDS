package inpecable.inpecableSpring.modelo.service;

import inpecable.inpecableSpring.modelo.DetalleServicio;

import java.util.List;

public interface IDetalleService {
    public List<DetalleServicio> findAll();
    public DetalleServicio findById(Long id);
    public DetalleServicio save(DetalleServicio detalleServicio);
    public void delete(Long id);
}

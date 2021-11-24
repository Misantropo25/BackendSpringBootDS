package inpecable.inpecableSpring.modelo.service;

import inpecable.inpecableSpring.modelo.Respuesta;

import java.util.List;

public interface IRespuestaService {
    public List<Respuesta> findAll();
    public Respuesta findById(Long id);
    public Respuesta save(Respuesta respuesta);
    public void delete(Long id);
}

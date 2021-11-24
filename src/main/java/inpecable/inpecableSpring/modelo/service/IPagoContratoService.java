package inpecable.inpecableSpring.modelo.service;

import inpecable.inpecableSpring.modelo.PagoContrato;

import java.util.List;

public interface IPagoContratoService {
    public List<PagoContrato> findAll();
    public PagoContrato findById(Long id);
    public PagoContrato save(PagoContrato pagoContrato);
    public void delete(Long id);
}
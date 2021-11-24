package inpecable.inpecableSpring.modelo.service;

import inpecable.inpecableSpring.modelo.Contrato;


import java.util.List;

public interface IContratoService {
    public List<Contrato> findAll();
    public Contrato findById(Long id);
    public Contrato save(Contrato contrato);
    public void delete(Long id);

}

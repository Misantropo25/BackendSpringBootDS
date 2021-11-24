package inpecable.inpecableSpring.modelo.service;

import inpecable.inpecableSpring.modelo.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> findAll();
    public Usuario findById(Long id);
    public Usuario save(Usuario usuario);
    public void delete(Long id);
}

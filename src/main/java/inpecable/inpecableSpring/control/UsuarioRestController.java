package inpecable.inpecableSpring.control;

import inpecable.inpecableSpring.modelo.Ticket;
import inpecable.inpecableSpring.modelo.Usuario;
import inpecable.inpecableSpring.modelo.service.ITicketService;
import inpecable.inpecableSpring.modelo.service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UsuarioRestController {
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/usuario")
    public List<Usuario> listar(){
        return usuarioService.findAll();
    }

    @GetMapping("/usuario/{id}")
    public Usuario mostrar(@PathVariable Long id){
        return usuarioService.findById(id);
    }

    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario crear(@RequestBody Usuario usuario){
        if(usuario.getContrasenia()!=null&&usuario.getNomUsuario()!=null){
            usuario.setUsuarioValidado(false);
            return usuarioService.save(usuario);
        }
        return null;
    }

    @PutMapping("/usuario/{id}")
    public Usuario actualizar(@RequestBody Usuario usuario, @PathVariable Long id){
        Usuario usuarioOriginal = usuarioService.findById(id);
        if(usuario.getContrasenia()!=null){
            usuarioOriginal.setContrasenia(usuario.getContrasenia());
        }
        if(usuario.getNomUsuario()!=null){
            usuarioOriginal.setNomUsuario(usuario.getNomUsuario());
        }
        if(usuario.getUsuarioValidado()!=null){
            usuarioOriginal.setUsuarioValidado(usuario.getUsuarioValidado());
        }
        return usuarioService.save(usuarioOriginal);
    }

    @DeleteMapping("/usuario/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        usuarioService.delete(id);
    }
}

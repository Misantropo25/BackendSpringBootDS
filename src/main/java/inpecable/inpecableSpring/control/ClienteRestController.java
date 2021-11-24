package inpecable.inpecableSpring.control;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import inpecable.inpecableSpring.modelo.Cliente;
import inpecable.inpecableSpring.modelo.service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/api")
public class ClienteRestController {
    @Autowired
    private IClienteService clienteService;

    @GetMapping("/cliente")
    public List<Cliente> listar(){
        return clienteService.findAll();
    }

    @GetMapping("/cliente/{id}")
    public Cliente mostrar(@PathVariable Long id){
        return clienteService.findById(id);
    }

    @PostMapping("/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente crear(@RequestBody Cliente cliente) {
//        Validaciones para la creacion de un cliente
        if (cliente.getNombre() != null && cliente.getDNI() != null && cliente.getDNI().matches("[+-]?\\d*(\\.\\d+)?") == true && cliente.getApeMaterno() != null && cliente.getApePaterno() != null && cliente.getEmail() != null && cliente.getNumTelefono() != null && cliente.getNumTelefono().matches("[+-]?\\d*(\\.\\d+)?") == true && cliente.getSexo() != null && cliente.getSexo().length() == 1) {
            return clienteService.save(cliente);
        }
        return null;
    }


    @PutMapping("/cliente/{id}")
    public Cliente actualizar(@RequestBody Cliente cliente, @PathVariable Long id){
        Cliente clienteOriginal = clienteService.findById(id);
//        Validaciones para la actualizacion de datos de cliente
        if(cliente.getNombre()!=null){
            clienteOriginal.setNombre(cliente.getNombre());
        }
        if(cliente.getDNI()!=null && cliente.getDNI().matches("[+-]?\\d*(\\.\\d+)?") == true){
            clienteOriginal.setDNI(cliente.getDNI());
        }
        if(cliente.getApeMaterno() != null){
            clienteOriginal.setApeMaterno(cliente.getApeMaterno());
        }
        if(cliente.getApePaterno() != null){
            clienteOriginal.setApePaterno(cliente.getApePaterno());
        }
        if(cliente.getEmail()!=null){
            clienteOriginal.setEmail(cliente.getEmail());
        }
        if(cliente.getNumTelefono()!=null && cliente.getNumTelefono().matches("[+-]?\\d*(\\.\\d+)?") == true){
            clienteOriginal.setNumTelefono(cliente.getNumTelefono());
        }
        if(cliente.getSexo()!=null){
            clienteOriginal.setSexo(cliente.getSexo());
        }
        if(cliente.getTienesUsuario()!=null){
            clienteOriginal.setTienesUsuario(cliente.getTienesUsuario());
        }
        return clienteService.save(clienteOriginal);
    }

    @DeleteMapping("/cliente/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        clienteService.delete(id);
    }
}

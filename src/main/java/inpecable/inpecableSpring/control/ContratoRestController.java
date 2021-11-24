package inpecable.inpecableSpring.control;


import inpecable.inpecableSpring.modelo.Cliente;
import inpecable.inpecableSpring.modelo.Contrato;
import inpecable.inpecableSpring.modelo.service.IClienteService;
import inpecable.inpecableSpring.modelo.service.IContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ContratoRestController  {
    @Autowired
    private IContratoService contratoService;
    private IClienteService clienteService;

    @GetMapping("/contrato")
    public List<Contrato> listar(){
        return contratoService.findAll();
    }

    @GetMapping("/contrato/{id}")
    public Contrato mostrar(@PathVariable Long id){
        return contratoService.findById(id);
    }

    @PostMapping("/contrato")
    @ResponseStatus(HttpStatus.CREATED)
    public Contrato crear(@RequestBody Contrato contrato){
//        Validaciones para crear un contrato
        if(contrato.getDescripcion() != null && contrato.getDireccion()!=null){
            contrato.setEstadoContrato(true);
            return contratoService.save(contrato);
        }
        return null;
    }


    @PutMapping("/contrato/{id}")
    public Contrato actualizar(@RequestBody Contrato contrato, @PathVariable Long id){
        Contrato contratoOriginal = contratoService.findById(id);
        if(contrato.getDescripcion() != null){
            contratoOriginal.setDescripcion(contrato.getDescripcion());
        }
        if(contrato.getDireccion()!=null){
            contratoOriginal.setDireccion((contrato.getDireccion()));
        }
        if(contrato.getEstadoContrato()!=null){
            contratoOriginal.setEstadoContrato(contrato.getEstadoContrato());
        }
        return contratoService.save(contratoOriginal);
    }

    @DeleteMapping("/contrato/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        contratoService.delete(id);
    }
}

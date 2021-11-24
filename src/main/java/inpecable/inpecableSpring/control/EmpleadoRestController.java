package inpecable.inpecableSpring.control;


import inpecable.inpecableSpring.modelo.Cliente;
import inpecable.inpecableSpring.modelo.DetalleServicio;
import inpecable.inpecableSpring.modelo.Empleado;
import inpecable.inpecableSpring.modelo.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmpleadoRestController {
    @Autowired
    private IEmpleadoService empleadoService;

    @GetMapping("/empleado")
    public List<Empleado> listar() {
        return empleadoService.findAll();
    }

    @GetMapping("/empleado/{id}")
    public Empleado mostrar(@PathVariable Long id) {
        return empleadoService.findById(id);
    }

    @PostMapping("/empleado")
    @ResponseStatus(HttpStatus.CREATED)
    public Empleado crear(@RequestBody Empleado empleado) {
        //        Validaciones para la creacion de un empleado
        if (empleado.getNombre() != null && empleado.getDNI() != null && empleado.getDNI().matches("[+-]?\\d*(\\.\\d+)?") == true && empleado.getApeMaterno() != null && empleado.getApePaterno() != null && empleado.getEmail() != null && empleado.getNumTelefono() != null && empleado.getNumTelefono().matches("[+-]?\\d*(\\.\\d+)?") == true && empleado.getSexo() != null && empleado.getSexo().length() == 1 && empleado.getArea()!=null && empleado.getDireccion()!=null){
            return empleadoService.save(empleado);
        }
        return null;
    }

    @PutMapping("/empleado/{id}")
    public Empleado actualizar(@RequestBody Empleado empleado, @PathVariable Long id) {
        Empleado empleadoOriginal = empleadoService.findById(id);
        if(empleado.getNombre()!=null){
            empleadoOriginal.setNombre(empleado.getNombre());
        }
        if(empleado.getDNI()!=null && empleado.getDNI().matches("[+-]?\\d*(\\.\\d+)?") == true){
            empleadoOriginal.setDNI(empleado.getDNI());
        }
        if(empleado.getApeMaterno() != null){
            empleadoOriginal.setApeMaterno(empleado.getApeMaterno());
        }
        if(empleado.getApePaterno() != null){
            empleadoOriginal.setApePaterno(empleado.getApePaterno());
        }
        if(empleado.getDireccion()!=null){
            empleadoOriginal.setDireccion((empleado.getDireccion()));
        }
        if(empleado.getArea()!=null){
            empleadoOriginal.setArea(empleado.getArea());
        }
        if(empleado.getEmail()!=null){
            empleadoOriginal.setEmail(empleado.getEmail());
        }
        if(empleado.getNumTelefono()!=null && empleado.getNumTelefono().matches("[+-]?\\d*(\\.\\d+)?") == true){
            empleadoOriginal.setNumTelefono(empleado.getNumTelefono());
        }
        if(empleado.getSexo()!=null){
            empleadoOriginal.setSexo(empleado.getSexo());
        }
        if(empleado.getTieneUsuario()!=null){
            empleadoOriginal.setTieneUsuario(empleado.getTieneUsuario());
        }
        return empleadoService.save(empleadoOriginal);
    }

    @DeleteMapping("/empleado/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        empleadoService.delete(id);
    }
}
package inpecable.inpecableSpring.control;

import inpecable.inpecableSpring.modelo.DetalleServicio;
import inpecable.inpecableSpring.modelo.service.IDetalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api")
public class DetalleServicioRestController {
    @Autowired
    private IDetalleService detalleService;

    @GetMapping("/detalles")
    public List<DetalleServicio> listar(){
        return detalleService.findAll();
    }

    @GetMapping("/detalles/{id}")
    public DetalleServicio mostrar(@PathVariable Long id){
        return detalleService.findById(id);
    }

    @PostMapping("/detalles")
    @ResponseStatus(HttpStatus.CREATED)
    public DetalleServicio crear(@RequestBody DetalleServicio detalleServicio){
        if(detalleServicio.getCostoServicio() != null && detalleServicio.getDescripcion()!=null){
            detalleServicio.setFechaCreacion(LocalDateTime.now());
            detalleServicio.setFechaExpiracion(null);
            detalleServicio.setCostoServicio(detalleServicio.getCostoServicio().setScale(2, RoundingMode.HALF_UP));
            return detalleService.save(detalleServicio);
        }
        return null;
    }

    @PutMapping("/detalles/{id}")
    public DetalleServicio actualizar(@RequestBody DetalleServicio detalleServicio, @PathVariable Long id){
        DetalleServicio detalleOriginal = detalleService.findById(id);
        if(detalleServicio.getCostoServicio()!=null){
            detalleOriginal.setCostoServicio(detalleServicio.getCostoServicio());
        }
        if(detalleServicio.getDescripcion()!=null){
            detalleOriginal.setDescripcion(detalleServicio.getDescripcion());
        }
        if(detalleServicio.getFechaExpiracion()!=null){
            detalleOriginal.setFechaExpiracion(detalleServicio.getFechaExpiracion());
        }
        return detalleService.save(detalleOriginal);
    }

    @DeleteMapping("/detalles/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        detalleService.delete(id);
    }



}


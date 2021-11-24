package inpecable.inpecableSpring.control;


import inpecable.inpecableSpring.modelo.Respuesta;
import inpecable.inpecableSpring.modelo.service.IRespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RespuestaController {
    @Autowired
    private IRespuestaService respuestaService;

    @GetMapping("/respuesta")
    public List<Respuesta> listar(){
        return respuestaService.findAll();
    }

    @GetMapping("/respuesta/{id}")
    public Respuesta mostrar(@PathVariable Long id){
        return respuestaService.findById(id);
    }

    @PostMapping("/respuesta")
    @ResponseStatus(HttpStatus.CREATED)
    public Respuesta crear(@RequestBody Respuesta respuesta){
        if(respuesta.getContenido()!=null){
            return respuestaService.save(respuesta);
        }
        return null;
    }

    @PutMapping("/respuesta/{id}")
    public Respuesta actualizar(@RequestBody Respuesta respuesta, @PathVariable Long id){
        Respuesta respuestaOriginal = respuestaService.findById(id);
        if(respuesta.getContenido()!=null){
            respuestaOriginal.setContenido(respuesta.getContenido());
        }
        return respuestaService.save(respuestaOriginal);
    }

    @DeleteMapping("/respuesta/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        respuestaService.delete(id);
    }

}

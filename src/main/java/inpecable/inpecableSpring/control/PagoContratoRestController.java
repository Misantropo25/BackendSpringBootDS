package inpecable.inpecableSpring.control;

import inpecable.inpecableSpring.modelo.PagoContrato;
import inpecable.inpecableSpring.modelo.service.IPagoContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/api")
public class PagoContratoRestController {
    @Autowired
    private IPagoContratoService pagoContratoService;

    @GetMapping("/pago")
    public List<PagoContrato> listar(){
        return pagoContratoService.findAll();
    }

    @GetMapping("/pago/{id}")
    public PagoContrato mostrar(@PathVariable Long id){
        return pagoContratoService.findById(id);
    }

    @PostMapping("/pago")
    @ResponseStatus(HttpStatus.CREATED)
    public PagoContrato crear(@RequestBody PagoContrato pagoContrato){
        if(pagoContrato.getMonto()!=null){}
        pagoContrato.setEstadoPago(false);
        pagoContrato.setFechaLimitePago(LocalDateTime.now().plusMonths(1));
        pagoContrato.setFechaPago(null);
        pagoContrato.setMora(null);
        return pagoContratoService.save(pagoContrato);
    }

    @PutMapping("/pago/{id}")
    public PagoContrato actualizar(@RequestBody PagoContrato pagoContrato, @PathVariable Long id){
        PagoContrato pagoContratoOriginal = pagoContratoService.findById(id);
        if(pagoContrato.getEstadoPago() != true||false){
            pagoContratoOriginal.setEstadoPago(pagoContrato.getEstadoPago());
        }
        if(pagoContrato.getFechaLimitePago() != null){
            pagoContratoOriginal.setFechaLimitePago(pagoContrato.getFechaLimitePago());
        }
        if(pagoContrato.getFechaPago() != null){
            pagoContratoOriginal.setFechaPago(pagoContrato.getFechaPago());
        }
        if(pagoContrato.getMonto()!=null){
            pagoContratoOriginal.setMonto(pagoContrato.getMonto());
        }
        if(pagoContrato.getMora()!=null){
            pagoContratoOriginal.setMora(pagoContrato.getMora());
        }
        return pagoContratoService.save(pagoContratoOriginal);
    }

    @DeleteMapping("/pago/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        pagoContratoService.delete(id);
    }


}
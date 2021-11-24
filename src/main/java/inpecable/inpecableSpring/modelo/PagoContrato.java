package inpecable.inpecableSpring.modelo;

import ch.qos.logback.core.net.server.Client;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="pago")
public class PagoContrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "monto", scale = 2, precision = 7)
    private BigDecimal monto; // Ojo como tomaremos el monto como string o decimal
    @Column(name = "fechaPago")
    private LocalDateTime fechaPago;
    @Column(name = "fechaLimitePago")
    private LocalDateTime fechaLimitePago;
    @Column(name = "mora", scale = 2, precision = 7)
    private BigDecimal mora;
    @Column(name = "estadoPago")
    private boolean estadoPago;

    @ManyToOne
    @JoinColumn(name="correspondeContrato", referencedColumnName = "id")
    @JsonBackReference(value = "correspondeContrato")
    private Contrato correspondeContrato;

    public PagoContrato() {
    }

    public PagoContrato(BigDecimal monto, LocalDateTime fechaPago, LocalDateTime fechaLimitePago, BigDecimal mora, boolean estadoPago, Contrato correspondeContrato) {
        this.monto = monto;
        this.fechaPago = fechaPago;
        this.fechaLimitePago = fechaLimitePago;
        this.mora = mora;
        this.estadoPago = estadoPago;
        this.correspondeContrato = correspondeContrato;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public LocalDateTime getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDateTime fechaPago) {
        this.fechaPago = fechaPago;
    }

    public LocalDateTime getFechaLimitePago() {
        return fechaLimitePago;
    }

    public void setFechaLimitePago(LocalDateTime fechaLimitePago) {
        this.fechaLimitePago = fechaLimitePago;
    }

    public BigDecimal getMora() {
        return mora;
    }

    public void setMora(BigDecimal mora) {
        this.mora = mora;
    }

    public boolean getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(boolean estadoPago) {
        this.estadoPago = estadoPago;
    }

    public Contrato getCorrespondeContrato() {
        return correspondeContrato;
    }

    public void setCorrespondeContrato(Contrato correspondeContrato) {
        this.correspondeContrato = correspondeContrato;
    }
}

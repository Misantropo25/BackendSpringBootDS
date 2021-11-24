package inpecable.inpecableSpring.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apePaterno")
    private String apePaterno;
    @Column(name = "apeMaterno")
    private String apeMaterno;
    @Column(name = "DNI")
    private String DNI;
    @Column(name = "sexo")
    private String sexo;
    @Column(name = "numTelefono")
    private String numTelefono;
    @Column(name = "email")
    private String email;



    @OneToOne
    @JoinColumn(name="tienesUsuario", referencedColumnName = "id")
    @JsonManagedReference(value = "usuarioCliente")
    private Usuario tienesUsuario;


    @OneToMany(mappedBy = "clienteSolicito")
    @JsonManagedReference(value = "clienteSolicito")
    private List<Ticket> clienteSolicito;


    @OneToMany(mappedBy = "correspondeCliente")
    @JsonManagedReference(value = "correspondeCliente")
    private List<Contrato> correspondeCliente;


    public Cliente() {
    }

    public Cliente(String nombre, String apePaterno, String apeMaterno, String DNI, String sexo, String numTelefono, String email, Usuario tienesUsuario, List<Ticket> clienteSolicito, List<Contrato> correspondeCliente) {
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.DNI = DNI;
        this.sexo = sexo;
        this.numTelefono = numTelefono;
        this.email = email;
        this.tienesUsuario = tienesUsuario;
        this.clienteSolicito = clienteSolicito;
        this.correspondeCliente = correspondeCliente;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario getTienesUsuario() {
        if (this.tienesUsuario == null){
            this.tienesUsuario = null;
        }
        return tienesUsuario;
    }

    public void setTienesUsuario(Usuario tienesUsuario) {
        this.tienesUsuario = tienesUsuario;
    }

    public List<Ticket> getClienteSolicito() {
        if(this.clienteSolicito == null){
            this.clienteSolicito = new ArrayList<>();
        }
        return clienteSolicito;
    }

    public void setClienteSolicito(List<Ticket> clienteSolicito) {
        this.clienteSolicito = clienteSolicito;
    }

    public List<Contrato> getCorrespondeCliente() {
        if(this.correspondeCliente == null){
            this.correspondeCliente = new ArrayList<>();
        }
        return correspondeCliente;
    }

    public void setCorrespondeCliente(List<Contrato> correspondeCliente) {
        this.correspondeCliente = correspondeCliente;
    }
}

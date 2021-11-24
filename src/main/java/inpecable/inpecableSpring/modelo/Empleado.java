package inpecable.inpecableSpring.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="empleado")
public class Empleado {
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
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "area")
    private String area;

    @OneToOne
    @JoinColumn(name="tieneUsuario", referencedColumnName = "id")
    @JsonManagedReference(value = "usuarioEmpleado")
    private Usuario tieneUsuario;

    @OneToMany(mappedBy = "empleadoRespondio")
    @JsonManagedReference(value = "empleadoRespondio")
    private List<Respuesta> empleadoRespondio;



    public Empleado() {
    }

    public Empleado(String nombre, String apePaterno, String apeMaterno, String DNI, String sexo, String numTelefono, String email, String direccion, String area, Usuario tieneUsuario, List<Respuesta> empleadoRespondio) {
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.DNI = DNI;
        this.sexo = sexo;
        this.numTelefono = numTelefono;
        this.email = email;
        this.direccion = direccion;
        this.area = area;
        this.tieneUsuario = tieneUsuario;
        this.empleadoRespondio = empleadoRespondio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Usuario getTieneUsuario() {
        return tieneUsuario;
    }

    public void setTieneUsuario(Usuario tieneUsuario) {
        this.tieneUsuario = tieneUsuario;
    }

    public List<Respuesta> getEmpleadoRespondio() {
        if(this.empleadoRespondio == null){
            this.empleadoRespondio = new ArrayList<>();
        }
        return empleadoRespondio;
    }

    public void setEmpleadoRespondio(List<Respuesta> empleadoRespondio) {
        this.empleadoRespondio = empleadoRespondio;
    }
}

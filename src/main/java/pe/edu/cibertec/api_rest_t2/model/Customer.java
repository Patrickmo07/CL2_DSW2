package pe.edu.cibertec.api_rest_t2.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="clientes")
public class Customer {

@Id
    private String id_cliente;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;
}

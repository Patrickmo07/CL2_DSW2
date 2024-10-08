package pe.edu.cibertec.api_rest_t2.dto;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerDto {

    private String id_cliente;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String direccion;

}

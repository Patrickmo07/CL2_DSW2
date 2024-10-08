package pe.edu.cibertec.api_rest_t2.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenericResponseDto<T>{

private boolean correcto;
private String mensaje;
private T respuesta;
private String codigoerror;
}

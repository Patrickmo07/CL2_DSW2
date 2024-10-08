package pe.edu.cibertec.api_rest_t2.service;

import pe.edu.cibertec.api_rest_t2.dto.CustomerDto;

import java.util.List;

public interface ICustomerService {
    List<CustomerDto> findByTelefono(String telefono);
    List<CustomerDto> findByDireccion(String direccion);
    List<CustomerDto> buscarClienteXDireccion(String direccion);
}

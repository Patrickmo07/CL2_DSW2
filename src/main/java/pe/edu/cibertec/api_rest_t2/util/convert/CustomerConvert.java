package pe.edu.cibertec.api_rest_t2.util.convert;

import org.springframework.stereotype.Component;
import pe.edu.cibertec.api_rest_t2.dto.CustomerDto;
import pe.edu.cibertec.api_rest_t2.model.Customer;

@Component
public class CustomerConvert {
    public CustomerDto convertirClienteAClienteDto(Customer customer){
        return CustomerDto.builder()
                .nombre(customer.getNombre())
                .apellido(customer.getApellido())
                .email(customer.getEmail())
                .telefono(customer.getTelefono())
                .direccion(customer.getDireccion())
                .build();
    }

    public Customer convertirClienteDtoaCliente(CustomerDto clienteDto){
        Customer customer = new Customer();
        customer.setNombre(clienteDto.getNombre());
        customer.setApellido(clienteDto.getApellido());
        customer.setEmail(clienteDto.getEmail());
        customer.setTelefono(clienteDto.getTelefono());
        customer.setDireccion(clienteDto.getDireccion());
        return customer;
    }

}

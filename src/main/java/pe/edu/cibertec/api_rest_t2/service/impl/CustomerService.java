package pe.edu.cibertec.api_rest_t2.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.api_rest_t2.dto.CustomerDto;
import pe.edu.cibertec.api_rest_t2.model.Customer;
import pe.edu.cibertec.api_rest_t2.repository.CustomerRepository;
import pe.edu.cibertec.api_rest_t2.service.ICustomerService;
import pe.edu.cibertec.api_rest_t2.util.convert.CustomerConvert;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CustomerService implements ICustomerService {

private final CustomerRepository customerRepository;
private final CustomerConvert customerConvert;

    @Override
    public List<CustomerDto> findByTelefono(String telefono) {
        List<CustomerDto>clienteDtos = new ArrayList<>();
        for (Customer customer : customerRepository.findByTelefono(telefono)){
            clienteDtos.add(customerConvert.convertirClienteAClienteDto(customer));
        }
        return clienteDtos;
    }

    @Override
    public List<CustomerDto> findByDireccion(String direccion){
        List<CustomerDto>clienteDtos = new ArrayList<>();
        for (Customer customer : customerRepository.findByDireccion(direccion)){
            clienteDtos.add(customerConvert.convertirClienteAClienteDto(customer));
        }
        return  clienteDtos;
    }

    @Override
    public List<CustomerDto> buscarClienteXDireccion(String direccion) {
        List<CustomerDto>clienteDtos = new ArrayList<>();
        for (Customer customer : customerRepository.buscarClienteXDireccion(direccion)){
            clienteDtos.add(customerConvert.convertirClienteAClienteDto(customer));
        }return clienteDtos;
    }
}

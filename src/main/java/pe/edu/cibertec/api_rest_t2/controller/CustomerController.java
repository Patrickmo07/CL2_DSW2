package pe.edu.cibertec.api_rest_t2.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.api_rest_t2.dto.CustomerDto;
import pe.edu.cibertec.api_rest_t2.dto.GenericResponseDto;
import pe.edu.cibertec.api_rest_t2.service.ICustomerService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping (path = "api/v1/cliente")

public class CustomerController {
    private final ICustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<GenericResponseDto<List<CustomerDto>>> obtenerClientesXTelefono(
            @RequestParam("telefono") String telefono
    ){
        List<CustomerDto> clienteDtoList = customerService.findByTelefono(telefono);
        if (clienteDtoList.isEmpty()){
            return new ResponseEntity<>(GenericResponseDto.<List<CustomerDto>>builder()
                    .correcto(false)
                    .mensaje("NO EXISTE CLIENTE")
                    .build(), HttpStatus.OK);

        }else {
            return new ResponseEntity<>(GenericResponseDto.<List<CustomerDto>>builder()
                    .correcto(true)
                    .mensaje("LISTADO DE CLIENTES POR TELEFONO")
                    .respuesta(clienteDtoList).build(),HttpStatus.OK);
        }
    }

    @GetMapping("/address")
    public ResponseEntity<GenericResponseDto<List<CustomerDto>>> obtenerClienteXDireccion(
            @RequestParam("direccion") String direccion
    ){
        List<CustomerDto> clienteDtoList = customerService.findByDireccion(direccion);
        if (clienteDtoList.isEmpty()){
            return new ResponseEntity<>(GenericResponseDto.<List<CustomerDto>>builder()
                    .correcto(false)
                    .mensaje("NO EXISTE CLIENTE")
                    .build(), HttpStatus.OK);

        }else {
            return new ResponseEntity<>(GenericResponseDto.<List<CustomerDto>>builder()
                    .correcto(true)
                    .mensaje("LISTADO DE CLIENTES POR DIRECCION")
                    .respuesta(clienteDtoList).build(),HttpStatus.OK);
        }
    }

}

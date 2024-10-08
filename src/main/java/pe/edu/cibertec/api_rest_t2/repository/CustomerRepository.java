package pe.edu.cibertec.api_rest_t2.repository;


import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.cibertec.api_rest_t2.model.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, String> {

    List<Customer> findByTelefono(String telefono);
    List<Customer> findByDireccion(String direccion);

    @Query(value = "SELECT c FROM Cliente c Where c.direccion=:direccion")
    List<Customer> buscarClienteXDireccion(
            @Param("direccion") String direccion);

    @Transactional
    @Modifying
    @Query ( value = "UPDATE cliente SET direccion=:direccion WHERE id_cliente=:id_cliente")
    void actualizarDireccionCliente(@Param("direccion") String direccion,
                                       @Param("id_cliente")String id_cliente);

    @Transactional
    @Modifying
    @Query( value = "DELETE cliente SET direccion=:direccion WHERE id_cliente=:id_cliente")
    void eliminarDireccionCliente(@Param("direccion") String direccion,
                                  @Param("id_cliente")String id_cliente);
}

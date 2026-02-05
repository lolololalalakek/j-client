package uz.stajirovka.jclient.repository;

import org.springframework.data.repository.CrudRepository;
import uz.stajirovka.jclient.entity.ClientEntity;

import java.util.List;
import java.util.Optional;


public interface ClientRepository extends CrudRepository<ClientEntity, Long> {

    boolean existsByEmail(String email);
}

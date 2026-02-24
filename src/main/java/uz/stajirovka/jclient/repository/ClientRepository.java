package uz.stajirovka.jclient.repository;

import org.springframework.data.repository.CrudRepository;
import uz.stajirovka.jclient.entity.ClientEntity;

import java.util.Optional;


public interface ClientRepository extends CrudRepository<ClientEntity, Long> {

    Optional<ClientEntity> findByEmail(String email);
}

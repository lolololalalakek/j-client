package uz.stajirovka.jclient.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.stajirovka.jclient.dto.request.ClientRequestDto;
import uz.stajirovka.jclient.dto.response.ClientResponseDto;
import uz.stajirovka.jclient.entity.ClientEntity;
import uz.stajirovka.jclient.exception.Duplicate;
import uz.stajirovka.jclient.mapper.ClientMapper;
import uz.stajirovka.jclient.repository.ClientRepository;
import uz.stajirovka.jclient.service.ClientService;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    @Override
    @Transactional
    public ClientResponseDto createClient(ClientRequestDto dto) {

        if (clientRepository.existsByEmail(dto.email())) {
            throw new Duplicate("Client with this email already exists");
        }

        ClientEntity client = clientRepository.save(
            clientMapper.toEntity(dto)
        );

        return clientMapper.toDto(client);
    }

    @Override
    @Transactional
    public ClientResponseDto updateClient(Long id, ClientRequestDto clientRequestDto) {
        ClientEntity clientEntity = clientRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Client not found: " + id));
        clientMapper.updateClient(clientRequestDto, clientEntity);
        return clientMapper.toDto(clientEntity);
    }

    @Override
    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new EntityNotFoundException("Client not found: " + id);
        }
        clientRepository.deleteById(id);
    }
}

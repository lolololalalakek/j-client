package uz.stajirovka.jclient.service.impl;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.stajirovka.jclient.dto.request.ClientRequestDto;
import uz.stajirovka.jclient.dto.response.ClientResponseDto;
import uz.stajirovka.jclient.entity.ClientEntity;
import uz.stajirovka.jclient.exception.ClientNotFoundException;
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
    public ClientResponseDto findOrCreate(ClientRequestDto dto) {
        return clientRepository.findByEmail(dto.email())
            .map(clientMapper::toDto)
            .orElseGet(() -> create(dto));
    }

    private ClientResponseDto create(ClientRequestDto dto) {
        ClientEntity client = clientRepository.save(clientMapper.toEntity(dto));
        return clientMapper.toDto(client);
    }

    @Override
    @Transactional(readOnly = true)
    public ClientResponseDto getClient(Long id) {
        ClientEntity clientEntity = clientRepository.findById(id)
            .orElseThrow(() -> new ClientNotFoundException(id));
        return clientMapper.toDto(clientEntity);
    }

    @Override
    @Transactional
    public ClientResponseDto updateClient(Long id, ClientRequestDto clientRequestDto) {
        ClientEntity clientEntity = clientRepository.findById(id)
            .orElseThrow(() -> new ClientNotFoundException(id));
        clientMapper.updateClient(clientRequestDto, clientEntity);
        return clientMapper.toDto(clientEntity);
    }

    @Override
    @Transactional
    public void deleteClient(Long id) {
        ClientEntity clientEntity = clientRepository.findById(id)
            .orElseThrow(() -> new ClientNotFoundException(id));
        clientRepository.delete(clientEntity);
    }
}

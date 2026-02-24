package uz.stajirovka.jclient.service;

import uz.stajirovka.jclient.dto.request.ClientRequestDto;
import uz.stajirovka.jclient.dto.response.ClientResponseDto;

public interface ClientService {

    ClientResponseDto findOrCreate(ClientRequestDto clientRequestDto);

    ClientResponseDto getClient(Long id);

    ClientResponseDto updateClient(Long id, ClientRequestDto clientRequestDto);

    void deleteClient(Long id);
}

package uz.stajirovka.jclient.service;

import uz.stajirovka.jclient.dto.request.ClientRequestDto;
import uz.stajirovka.jclient.dto.response.ClientResponseDto;

public interface ClientService {

    ClientResponseDto createClient(ClientRequestDto clientRequestDto);

    ClientResponseDto updateClient(Long id, ClientRequestDto clientRequestDto);

    void deleteClient(Long id);
}

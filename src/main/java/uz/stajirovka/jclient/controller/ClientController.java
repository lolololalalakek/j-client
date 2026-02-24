package uz.stajirovka.jclient.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.stajirovka.jclient.dto.request.ClientRequestDto;
import uz.stajirovka.jclient.dto.response.ClientResponseDto;
import uz.stajirovka.jclient.service.ClientService;



@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
@Validated
public class ClientController {

    private final ClientService clientService;

    @PostMapping("/create-client")
    public ResponseEntity<ClientResponseDto> createClient(@Valid @RequestBody ClientRequestDto clientRequestDto) {
        return ResponseEntity.ok(clientService.findOrCreate(clientRequestDto));
    }

    @GetMapping("/get-by-id/{id}")
    public ResponseEntity<ClientResponseDto> getClientById(@PathVariable Long id) {
        return ResponseEntity.ok(clientService.getClient(id));
    }


    @PutMapping("/update-by-id/{id}")
    public ResponseEntity<ClientResponseDto> updateClient(
        @PathVariable Long id,
        @Valid @RequestBody ClientRequestDto clientRequestDto) {
        return ResponseEntity.ok(clientService.updateClient(id, clientRequestDto));
    }

    @DeleteMapping("/delete-by-id/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }

}

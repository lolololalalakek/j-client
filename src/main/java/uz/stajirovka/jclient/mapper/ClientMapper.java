package uz.stajirovka.jclient.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import uz.stajirovka.jclient.dto.request.ClientRequestDto;
import uz.stajirovka.jclient.dto.response.ClientResponseDto;
import uz.stajirovka.jclient.entity.ClientEntity;

@Mapper(componentModel = "spring")
public interface ClientMapper {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    ClientEntity toEntity(ClientRequestDto clientRequestDto);

    ClientResponseDto toDto(ClientEntity clientEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateClient(ClientRequestDto clientRequestDto, @MappingTarget ClientEntity clientEntity);

}

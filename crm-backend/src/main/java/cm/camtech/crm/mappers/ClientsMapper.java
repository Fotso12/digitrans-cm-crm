package cm.camtech.crm.mappers;

import cm.camtech.crm.dtos.ClientsDto;
import cm.camtech.crm.entities.Clients;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientsMapper {

    ClientsDto toDto(Clients clients);

    Clients toEntity(ClientsDto clientsDto);
}
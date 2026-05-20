package cm.camtech.crm.mappers;

import cm.camtech.crm.dtos.CampagnesClientsDto;
import cm.camtech.crm.entities.CampagnesClients;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CampagnesClientsMapper {

    @Mapping(source = "campagnesClientsPK.campagneId", target = "campagneId")
    @Mapping(source = "campagnesClientsPK.clientId", target = "clientId")
    CampagnesClientsDto toDto(CampagnesClients campagnesClients);

    @Mapping(source = "campagneId", target = "campagnesClientsPK.campagneId")
    @Mapping(source = "clientId", target = "campagnesClientsPK.clientId")
    CampagnesClients toEntity(CampagnesClientsDto campagnesClientsDto);
}
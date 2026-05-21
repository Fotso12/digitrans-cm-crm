package cm.camtech.crm.mappers;

import cm.camtech.crm.dtos.ReclamationsDto;
import cm.camtech.crm.entities.Reclamations;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReclamationsMapper {

    @Mapping(source = "assigneeId.id", target = "assigneeId")
    @Mapping(source = "clientId.id", target = "clientId")
    @Mapping(source = "commandeId.id", target = "commandeId")
    ReclamationsDto toDto(Reclamations reclamations);

    @Mapping(source = "assigneeId", target = "assigneeId.id")
    @Mapping(source = "clientId", target = "clientId.id")
    @Mapping(source = "commandeId", target = "commandeId.id")
    Reclamations toEntity(ReclamationsDto reclamationsDto);
}
package cm.camtech.crm.mappers;

import cm.camtech.crm.dtos.CommandesDto;
import cm.camtech.crm.entities.Commandes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommandesMapper {

    // Entity -> DTO
    @Mapping(source = "clientId.id", target = "clientId")
    @Mapping(source = "restaurantId.id", target = "restaurantId")
    @Mapping(source = "traitePar.id", target = "traiteParId")
    CommandesDto toDto(Commandes commandes);

    // DTO -> Entity
    @Mapping(target = "clientId", ignore = true)
    @Mapping(target = "restaurantId", ignore = true)
    @Mapping(target = "traitePar", ignore = true)
    Commandes toEntity(CommandesDto commandesDto);
}
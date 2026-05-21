package cm.camtech.crm.mappers;

import cm.camtech.crm.dtos.CommandesDto;
import cm.camtech.crm.entities.Commandes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommandesMapper {

    @Mapping(source = "clientId.id", target = "clientId")
    @Mapping(source = "restaurantId.id", target = "restaurantId")
    @Mapping(source = "traitePar.id", target = "traiteParId")
    CommandesDto toDto(Commandes commandes);

    @Mapping(source = "clientId", target = "clientId.id")
    @Mapping(source = "restaurantId", target = "restaurantId.id")
    @Mapping(source = "traiteParId", target = "traitePar.id")
    Commandes toEntity(CommandesDto commandesDto);
}
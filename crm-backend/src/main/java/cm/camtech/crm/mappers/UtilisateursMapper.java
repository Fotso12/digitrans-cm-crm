package cm.camtech.crm.mappers;

import cm.camtech.crm.dtos.UtilisateursDto;
import cm.camtech.crm.entities.Utilisateurs;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UtilisateursMapper {

    UtilisateursDto toDto(Utilisateurs utilisateurs);

    Utilisateurs toEntity(UtilisateursDto utilisateursDto);
}
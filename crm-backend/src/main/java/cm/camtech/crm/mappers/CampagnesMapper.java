package cm.camtech.crm.mappers;

import cm.camtech.crm.dtos.CampagnesDto;
import cm.camtech.crm.entities.Campagnes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CampagnesMapper {

    @Mapping(source = "creePar.id", target = "creeParId")
    CampagnesDto toDto(Campagnes campagnes);

    @Mapping(source = "creeParId", target = "creePar.id")
    Campagnes toEntity(CampagnesDto campagnesDto);
}
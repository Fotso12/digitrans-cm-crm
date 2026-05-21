package cm.camtech.crm.mappers;

import cm.camtech.crm.dtos.ProduitsDto;
import cm.camtech.crm.entities.Produits;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProduitsMapper {

    ProduitsDto toDto(Produits produits);

    Produits toEntity(ProduitsDto produitsDto);
}
package cm.camtech.crm.services.interfaces;

import cm.camtech.crm.dtos.UtilisateursDto;

import java.util.List;

public interface UtilisateursInterface {

    UtilisateursDto save(UtilisateursDto utilisateursDto);

    UtilisateursDto update(Long id, UtilisateursDto utilisateursDto);

    UtilisateursDto findById(Long id);

    List<UtilisateursDto> findAll();

    void delete(Long id);
}
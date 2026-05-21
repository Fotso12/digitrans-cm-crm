package cm.camtech.crm.services.interfaces;

import cm.camtech.crm.dtos.LignesCommandesDto;

import java.util.List;

public interface LignesCommandesInterface {

    LignesCommandesDto save(LignesCommandesDto lignesCommandesDto);

    LignesCommandesDto update(Long id, LignesCommandesDto lignesCommandesDto);

    LignesCommandesDto findById(Long id);

    List<LignesCommandesDto> findAll();

    void delete(Long id);
}
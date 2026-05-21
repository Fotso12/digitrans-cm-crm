package cm.camtech.crm.services.interfaces;

import cm.camtech.crm.dtos.ReclamationsDto;

import java.util.List;

public interface ReclamationsInterface {

    ReclamationsDto save(ReclamationsDto reclamationsDto);

    ReclamationsDto update(Long id, ReclamationsDto reclamationsDto);

    ReclamationsDto findById(Long id);

    List<ReclamationsDto> findAll();

    void delete(Long id);
}
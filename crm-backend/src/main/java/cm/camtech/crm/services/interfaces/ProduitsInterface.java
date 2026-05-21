package cm.camtech.crm.services.interfaces;

import cm.camtech.crm.dtos.ProduitsDto;
import java.util.List;
public interface ProduitsInterface {

    ProduitsDto save(ProduitsDto produitsDto);

    ProduitsDto update(Long id, ProduitsDto produitsDto);

    ProduitsDto findById(Long id);

    List<ProduitsDto> findAll();
    
    void delete(Long id);
}

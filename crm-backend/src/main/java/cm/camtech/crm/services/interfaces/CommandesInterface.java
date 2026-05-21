package cm.camtech.crm.services.interfaces;

import cm.camtech.crm.dtos.CommandesDto;

import java.util.List;

public interface CommandesInterface {

    CommandesDto save(CommandesDto commandesDto);

    CommandesDto update(Long id, CommandesDto commandesDto);

    CommandesDto findById(Long id);

    List<CommandesDto> findAll();

    void delete(Long id);
}
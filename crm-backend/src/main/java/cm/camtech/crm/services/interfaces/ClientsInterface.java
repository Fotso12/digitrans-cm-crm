package cm.camtech.crm.services.interfaces;

import cm.camtech.crm.dtos.ClientsDto;

import java.util.List;

public interface ClientsInterface {

    ClientsDto save(ClientsDto clientsDto);

    ClientsDto update(Long id, ClientsDto clientsDto);

    ClientsDto findById(Long id);

    List<ClientsDto> findAll();

    void delete(Long id);
}
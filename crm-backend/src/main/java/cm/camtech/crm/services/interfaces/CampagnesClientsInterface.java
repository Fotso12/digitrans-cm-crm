package cm.camtech.crm.services.interfaces;

import cm.camtech.crm.dtos.CampagnesClientsDto;

import java.util.List;

public interface CampagnesClientsInterface {

    CampagnesClientsDto save(CampagnesClientsDto campagnesClientsDto);

    CampagnesClientsDto findById(Long campagneId, Long clientId);

    List<CampagnesClientsDto> findAll();

    void delete(Long campagneId, Long clientId);
}
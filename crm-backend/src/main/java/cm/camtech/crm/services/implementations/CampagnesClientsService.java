package cm.camtech.crm.services.implementations;

import cm.camtech.crm.dtos.CampagnesClientsDto;
import cm.camtech.crm.entities.CampagnesClients;
import cm.camtech.crm.entities.CampagnesClientsPK;
import cm.camtech.crm.mappers.CampagnesClientsMapper;
import cm.camtech.crm.repositories.CampagnesClientsRepo;
import cm.camtech.crm.services.interfaces.CampagnesClientsInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampagnesClientsService implements CampagnesClientsInterface {

    private final CampagnesClientsRepo campagnesClientsRepo;
    private final CampagnesClientsMapper campagnesClientsMapper;

    public CampagnesClientsService(CampagnesClientsRepo campagnesClientsRepo,
                                   CampagnesClientsMapper campagnesClientsMapper) {
        this.campagnesClientsRepo = campagnesClientsRepo;
        this.campagnesClientsMapper = campagnesClientsMapper;
    }

    @Override
    public CampagnesClientsDto save(CampagnesClientsDto campagnesClientsDto) {

        CampagnesClients campagnesClients =
                campagnesClientsMapper.toEntity(campagnesClientsDto);

        return campagnesClientsMapper.toDto(
                campagnesClientsRepo.save(campagnesClients)
        );
    }

    @Override
    public CampagnesClientsDto findById(Long campagneId, Long clientId) {

        CampagnesClientsPK pk = new CampagnesClientsPK();
        pk.setCampagneId(campagneId);
        pk.setClientId(clientId);

        return campagnesClientsRepo.findById(pk)
                .map(campagnesClientsMapper::toDto)
                .orElse(null);
    }

    @Override
    public List<CampagnesClientsDto> findAll() {

        return campagnesClientsRepo.findAll()
                .stream()
                .map(campagnesClientsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long campagneId, Long clientId) {

        CampagnesClientsPK pk = new CampagnesClientsPK();
        pk.setCampagneId(campagneId);
        pk.setClientId(clientId);

        campagnesClientsRepo.deleteById(pk);
    }
}
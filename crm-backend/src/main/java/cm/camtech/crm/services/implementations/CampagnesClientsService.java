package cm.camtech.crm.services.implementations;

import cm.camtech.crm.dtos.CampagnesClientsDto;
import cm.camtech.crm.entities.CampagnesClients;
import cm.camtech.crm.entities.CampagnesClientsPK;
import cm.camtech.crm.mappers.CampagnesClientsMapper;
import cm.camtech.crm.repositories.CampagnesClientsRepo;
import cm.camtech.crm.services.interfaces.CampagnesClientsInterface;
import cm.camtech.crm.exceptions.ApiException;
import org.springframework.http.HttpStatus;
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

        if (campagnesClientsDto == null || campagnesClientsDto.getCampagneId() == null || campagnesClientsDto.getClientId() == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Données de campagne-client invalides");
        }

        CampagnesClients campagnesClients =
                campagnesClientsMapper.toEntity(campagnesClientsDto);

        return campagnesClientsMapper.toDto(
                campagnesClientsRepo.save(campagnesClients)
        );
    }

    @Override
    public CampagnesClientsDto findById(Long campagneId, Long clientId) {

        if (campagneId == null || clientId == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiants de campagne-client invalides");
        }

        CampagnesClientsPK pk = new CampagnesClientsPK();
        pk.setCampagneId(campagneId);
        pk.setClientId(clientId);

        return campagnesClientsRepo.findById(pk)
                .map(campagnesClientsMapper::toDto)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Association campagne-client introuvable"));
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

        if (campagneId == null || clientId == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiants de campagne-client invalides");
        }

        CampagnesClientsPK pk = new CampagnesClientsPK();
        pk.setCampagneId(campagneId);
        pk.setClientId(clientId);

        if (!campagnesClientsRepo.existsById(pk)) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Association campagne-client introuvable");
        }

        campagnesClientsRepo.deleteById(pk);
    }
}
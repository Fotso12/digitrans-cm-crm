package cm.camtech.crm.services.implementations;

import cm.camtech.crm.dtos.CampagnesDto;
import cm.camtech.crm.entities.Campagnes;
import cm.camtech.crm.mappers.CampagnesMapper;
import cm.camtech.crm.repositories.CampagnesRepo;
import cm.camtech.crm.services.interfaces.CampagnesInterface;
import cm.camtech.crm.exceptions.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampagnesService implements CampagnesInterface {

    private final CampagnesRepo campagnesRepo;
    private final CampagnesMapper campagnesMapper;

    public CampagnesService(CampagnesRepo campagnesRepo,
                            CampagnesMapper campagnesMapper) {
        this.campagnesRepo = campagnesRepo;
        this.campagnesMapper = campagnesMapper;
    }

    @Override
    public CampagnesDto save(CampagnesDto campagnesDto) {

        if (campagnesDto == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Données de campagne invalides");
        }

        Campagnes campagnes = campagnesMapper.toEntity(campagnesDto);

        return campagnesMapper.toDto(
                campagnesRepo.save(campagnes)
        );
    }

    @Override
    public CampagnesDto update(Long id, CampagnesDto campagnesDto) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant de campagne invalide");
        }
        if (!campagnesRepo.existsById(id)) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Campagne introuvable");
        }

        Campagnes campagnes = campagnesMapper.toEntity(campagnesDto);

        campagnes.setId(id);

        return campagnesMapper.toDto(
                campagnesRepo.save(campagnes)
        );
    }

    @Override
    public CampagnesDto findById(Long id) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant de campagne invalide");
        }

        return campagnesRepo.findById(id)
                .map(campagnesMapper::toDto)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Campagne introuvable"));
    }

    @Override
    public List<CampagnesDto> findAll() {

        return campagnesRepo.findAll()
                .stream()
                .map(campagnesMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant de campagne invalide");
        }
        if (!campagnesRepo.existsById(id)) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Campagne introuvable");
        }

        campagnesRepo.deleteById(id);
    }
}
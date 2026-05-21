package cm.camtech.crm.services.implementations;

import cm.camtech.crm.dtos.LignesCommandesDto;
import cm.camtech.crm.entities.LignesCommandes;
import cm.camtech.crm.mappers.LignesCommandesMapper;
import cm.camtech.crm.repositories.LignesCommandesRepo;
import cm.camtech.crm.services.interfaces.LignesCommandesInterface;
import cm.camtech.crm.exceptions.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LignesCommandesService implements LignesCommandesInterface {

    private final LignesCommandesRepo lignesCommandesRepo;
    private final LignesCommandesMapper lignesCommandesMapper;

    public LignesCommandesService(LignesCommandesRepo lignesCommandesRepo,
                                  LignesCommandesMapper lignesCommandesMapper) {
        this.lignesCommandesRepo = lignesCommandesRepo;
        this.lignesCommandesMapper = lignesCommandesMapper;
    }

    @Override
    public LignesCommandesDto save(LignesCommandesDto lignesCommandesDto) {

        if (lignesCommandesDto == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Données de ligne de commande invalides");
        }

        LignesCommandes lignesCommandes = lignesCommandesMapper.toEntity(lignesCommandesDto);

        return lignesCommandesMapper.toDto(
                lignesCommandesRepo.save(lignesCommandes)
        );
    }

    @Override
    public LignesCommandesDto update(Long id, LignesCommandesDto lignesCommandesDto) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant de ligne de commande invalide");
        }
        if (!lignesCommandesRepo.existsById(id)) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Ligne de commande introuvable");
        }

        LignesCommandes lignesCommandes = lignesCommandesMapper.toEntity(lignesCommandesDto);

        lignesCommandes.setId(id);

        return lignesCommandesMapper.toDto(
                lignesCommandesRepo.save(lignesCommandes)
        );
    }

    @Override
    public LignesCommandesDto findById(Long id) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant de ligne de commande invalide");
        }

        return lignesCommandesRepo.findById(id)
                .map(lignesCommandesMapper::toDto)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Ligne de commande introuvable"));
    }

    @Override
    public List<LignesCommandesDto> findAll() {

        return lignesCommandesRepo.findAll()
                .stream()
                .map(lignesCommandesMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant de ligne de commande invalide");
        }
        if (!lignesCommandesRepo.existsById(id)) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Ligne de commande introuvable");
        }

        lignesCommandesRepo.deleteById(id);
    }
}
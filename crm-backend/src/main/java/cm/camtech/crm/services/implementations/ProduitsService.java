package cm.camtech.crm.services.implementations;

import cm.camtech.crm.dtos.ProduitsDto;
import cm.camtech.crm.entities.Produits;
import cm.camtech.crm.mappers.ProduitsMapper;
import cm.camtech.crm.repositories.ProduitsRepo;
import cm.camtech.crm.services.interfaces.ProduitsInterface;
import cm.camtech.crm.exceptions.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitsService implements ProduitsInterface {

    private final ProduitsRepo produitsRepo;
    private final ProduitsMapper produitsMapper;

    public ProduitsService(ProduitsRepo produitsRepo,
                           ProduitsMapper produitsMapper) {
        this.produitsRepo = produitsRepo;
        this.produitsMapper = produitsMapper;
    }

    @Override
    public ProduitsDto save(ProduitsDto produitsDto) {

        if (produitsDto == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Données de produit invalides");
        }

        Produits produits = produitsMapper.toEntity(produitsDto);

        return produitsMapper.toDto(
                produitsRepo.save(produits)
        );
    }

    @Override
    public ProduitsDto update(Long id, ProduitsDto produitsDto) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant de produit invalide");
        }
        if (!produitsRepo.existsById(id)) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Produit introuvable");
        }

        Produits produits = produitsMapper.toEntity(produitsDto);

        produits.setId(id);

        return produitsMapper.toDto(
                produitsRepo.save(produits)
        );
    }

    @Override
    public ProduitsDto findById(Long id) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant de produit invalide");
        }

        return produitsRepo.findById(id)
                .map(produitsMapper::toDto)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Produit introuvable"));
    }

    @Override
    public List<ProduitsDto> findAll() {

        return produitsRepo.findAll()
                .stream()
                .map(produitsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant de produit invalide");
        }
        if (!produitsRepo.existsById(id)) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Produit introuvable");
        }

        produitsRepo.deleteById(id);
    }
}
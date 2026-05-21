package cm.camtech.crm.services.implementations;

import cm.camtech.crm.dtos.ProduitsDto;
import cm.camtech.crm.entities.Produits;
import cm.camtech.crm.mappers.ProduitsMapper;
import cm.camtech.crm.repositories.ProduitsRepo;
import cm.camtech.crm.services.interfaces.ProduitsInterface;
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

        Produits produits = produitsMapper.toEntity(produitsDto);

        return produitsMapper.toDto(
                produitsRepo.save(produits)
        );
    }

    @Override
    public ProduitsDto update(Long id, ProduitsDto produitsDto) {

        Produits produits = produitsMapper.toEntity(produitsDto);

        produits.setId(id);

        return produitsMapper.toDto(
                produitsRepo.save(produits)
        );
    }

    @Override
    public ProduitsDto findById(Long id) {

        return produitsRepo.findById(id)
                .map(produitsMapper::toDto)
                .orElse(null);
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

        produitsRepo.deleteById(id);
    }
}
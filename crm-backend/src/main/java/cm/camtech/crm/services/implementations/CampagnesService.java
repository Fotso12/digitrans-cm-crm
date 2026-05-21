package cm.camtech.crm.services.implementations;

import cm.camtech.crm.dtos.CampagnesDto;
import cm.camtech.crm.entities.Campagnes;
import cm.camtech.crm.mappers.CampagnesMapper;
import cm.camtech.crm.repositories.CampagnesRepo;
import cm.camtech.crm.services.interfaces.CampagnesInterface;
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

        Campagnes campagnes = campagnesMapper.toEntity(campagnesDto);

        return campagnesMapper.toDto(
                campagnesRepo.save(campagnes)
        );
    }

    @Override
    public CampagnesDto update(Long id, CampagnesDto campagnesDto) {

        Campagnes campagnes = campagnesMapper.toEntity(campagnesDto);

        campagnes.setId(id);

        return campagnesMapper.toDto(
                campagnesRepo.save(campagnes)
        );
    }

    @Override
    public CampagnesDto findById(Long id) {

        return campagnesRepo.findById(id)
                .map(campagnesMapper::toDto)
                .orElse(null);
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

        campagnesRepo.deleteById(id);
    }
}
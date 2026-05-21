package cm.camtech.crm.services.implementations;

import cm.camtech.crm.dtos.LignesCommandesDto;
import cm.camtech.crm.entities.LignesCommandes;
import cm.camtech.crm.mappers.LignesCommandesMapper;
import cm.camtech.crm.repositories.LignesCommandesRepo;
import cm.camtech.crm.services.interfaces.LignesCommandesInterface;
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

        LignesCommandes lignesCommandes = lignesCommandesMapper.toEntity(lignesCommandesDto);

        return lignesCommandesMapper.toDto(
                lignesCommandesRepo.save(lignesCommandes)
        );
    }

    @Override
    public LignesCommandesDto update(Long id, LignesCommandesDto lignesCommandesDto) {

        LignesCommandes lignesCommandes = lignesCommandesMapper.toEntity(lignesCommandesDto);

        lignesCommandes.setId(id);

        return lignesCommandesMapper.toDto(
                lignesCommandesRepo.save(lignesCommandes)
        );
    }

    @Override
    public LignesCommandesDto findById(Long id) {

        return lignesCommandesRepo.findById(id)
                .map(lignesCommandesMapper::toDto)
                .orElse(null);
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

        lignesCommandesRepo.deleteById(id);
    }
}
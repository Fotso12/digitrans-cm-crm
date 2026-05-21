package cm.camtech.crm.services.implementations;

import cm.camtech.crm.dtos.ReclamationsDto;
import cm.camtech.crm.entities.Reclamations;
import cm.camtech.crm.mappers.ReclamationsMapper;
import cm.camtech.crm.repositories.ReclamationsRepo;
import cm.camtech.crm.services.interfaces.ReclamationsInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReclamationsService implements ReclamationsInterface {

    private final ReclamationsRepo reclamationsRepo;
    private final ReclamationsMapper reclamationsMapper;

    public ReclamationsService(ReclamationsRepo reclamationsRepo,
                               ReclamationsMapper reclamationsMapper) {
        this.reclamationsRepo = reclamationsRepo;
        this.reclamationsMapper = reclamationsMapper;
    }

    @Override
    public ReclamationsDto save(ReclamationsDto reclamationsDto) {

        Reclamations reclamations = reclamationsMapper.toEntity(reclamationsDto);

        return reclamationsMapper.toDto(
                reclamationsRepo.save(reclamations)
        );
    }

    @Override
    public ReclamationsDto update(Long id, ReclamationsDto reclamationsDto) {

        Reclamations reclamations = reclamationsMapper.toEntity(reclamationsDto);

        reclamations.setId(id);

        return reclamationsMapper.toDto(
                reclamationsRepo.save(reclamations)
        );
    }

    @Override
    public ReclamationsDto findById(Long id) {

        return reclamationsRepo.findById(id)
                .map(reclamationsMapper::toDto)
                .orElse(null);
    }

    @Override
    public List<ReclamationsDto> findAll() {

        return reclamationsRepo.findAll()
                .stream()
                .map(reclamationsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {

        reclamationsRepo.deleteById(id);
    }
}
package cm.camtech.crm.services.implementations;

import cm.camtech.crm.dtos.UtilisateursDto;
import cm.camtech.crm.entities.Utilisateurs;
import cm.camtech.crm.mappers.UtilisateursMapper;
import cm.camtech.crm.repositories.UtilisateursRepo;
import cm.camtech.crm.services.interfaces.UtilisateursInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateursService implements UtilisateursInterface {

    private final UtilisateursRepo utilisateursRepo;
    private final UtilisateursMapper utilisateursMapper;

    public UtilisateursService(UtilisateursRepo utilisateursRepo,
                               UtilisateursMapper utilisateursMapper) {
        this.utilisateursRepo = utilisateursRepo;
        this.utilisateursMapper = utilisateursMapper;
    }

    @Override
    public UtilisateursDto save(UtilisateursDto utilisateursDto) {

        Utilisateurs utilisateurs = utilisateursMapper.toEntity(utilisateursDto);

        return utilisateursMapper.toDto(
                utilisateursRepo.save(utilisateurs)
        );
    }

    @Override
    public UtilisateursDto update(Long id, UtilisateursDto utilisateursDto) {

        Utilisateurs utilisateurs = utilisateursMapper.toEntity(utilisateursDto);

        utilisateurs.setId(id);

        return utilisateursMapper.toDto(
                utilisateursRepo.save(utilisateurs)
        );
    }

    @Override
    public UtilisateursDto findById(Long id) {

        return utilisateursRepo.findById(id)
                .map(utilisateursMapper::toDto)
                .orElse(null);
    }

    @Override
    public List<UtilisateursDto> findAll() {

        return utilisateursRepo.findAll()
                .stream()
                .map(utilisateursMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {

        utilisateursRepo.deleteById(id);
    }
}
package cm.camtech.crm.services.implementations;

import cm.camtech.crm.dtos.CommandesDto;
import cm.camtech.crm.entities.Commandes;
import cm.camtech.crm.mappers.CommandesMapper;
import cm.camtech.crm.repositories.CommandesRepo;
import cm.camtech.crm.services.interfaces.CommandesInterface;
import cm.camtech.crm.exceptions.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommandesService implements CommandesInterface {

    private final CommandesRepo commandesRepo;
    private final CommandesMapper commandesMapper;

    public CommandesService(CommandesRepo commandesRepo,
                            CommandesMapper commandesMapper) {
        this.commandesRepo = commandesRepo;
        this.commandesMapper = commandesMapper;
    }

    @Override
    public CommandesDto save(CommandesDto commandesDto) {

        if (commandesDto == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Données de commande invalides");
        }

        Commandes commandes = commandesMapper.toEntity(commandesDto);

        return commandesMapper.toDto(
                commandesRepo.save(commandes)
        );
    }

    @Override
    public CommandesDto update(Long id, CommandesDto commandesDto) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant de commande invalide");
        }
        if (!commandesRepo.existsById(id)) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Commande introuvable");
        }

        Commandes commandes = commandesMapper.toEntity(commandesDto);

        commandes.setId(id);

        return commandesMapper.toDto(
                commandesRepo.save(commandes)
        );
    }

    @Override
    public CommandesDto findById(Long id) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant de commande invalide");
        }

        return commandesRepo.findById(id)
                .map(commandesMapper::toDto)
                .orElseThrow(() -> new ApiException(HttpStatus.NOT_FOUND, "Commande introuvable"));
    }

    @Override
    public List<CommandesDto> findAll() {

        return commandesRepo.findAll()
                .stream()
                .map(commandesMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {

        if (id == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "Identifiant de commande invalide");
        }
        if (!commandesRepo.existsById(id)) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Commande introuvable");
        }

        commandesRepo.deleteById(id);
    }
}
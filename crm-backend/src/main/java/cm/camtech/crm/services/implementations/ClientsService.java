package cm.camtech.crm.services.implementations;

import cm.camtech.crm.dtos.ClientsDto;
import cm.camtech.crm.entities.Clients;
import cm.camtech.crm.mappers.ClientsMapper;
import cm.camtech.crm.repositories.ClientsRepo;
import cm.camtech.crm.services.interfaces.ClientsInterface;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientsService implements ClientsInterface {

    private final ClientsRepo clientsRepo;
    private final ClientsMapper clientsMapper;

    public ClientsService(ClientsRepo clientsRepo,
                          ClientsMapper clientsMapper) {
        this.clientsRepo = clientsRepo;
        this.clientsMapper = clientsMapper;
    }

    @Override
    public ClientsDto save(ClientsDto clientsDto) {

        Clients clients = clientsMapper.toEntity(clientsDto);

        return clientsMapper.toDto(
                clientsRepo.save(clients)
        );
    }

    @Override
    public ClientsDto update(Long id, ClientsDto clientsDto) {

        Clients clients = clientsMapper.toEntity(clientsDto);

        clients.setId(id);

        return clientsMapper.toDto(
                clientsRepo.save(clients)
        );
    }

    @Override
    public ClientsDto findById(Long id) {

        return clientsRepo.findById(id)
                .map(clientsMapper::toDto)
                .orElse(null);
    }

    @Override
    public List<ClientsDto> findAll() {

        return clientsRepo.findAll()
                .stream()
                .map(clientsMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {

        clientsRepo.deleteById(id);
    }
}
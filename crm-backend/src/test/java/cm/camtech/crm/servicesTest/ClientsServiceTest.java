package cm.camtech.crm.servicesTest;

import cm.camtech.crm.dtos.ClientsDto;
import cm.camtech.crm.entities.Clients;
import cm.camtech.crm.mappers.ClientsMapper;
import cm.camtech.crm.repositories.ClientsRepo;
import cm.camtech.crm.services.implementations.ClientsService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClientsServiceTest {

    @Mock
    private ClientsRepo clientsRepo;

    @Mock
    private ClientsMapper clientsMapper;

    @InjectMocks
    private ClientsService clientsService;

    private Clients clients;
    private ClientsDto clientsDto;

    @BeforeEach
    void setUp() {
        clients = new Clients();
        clients.setId(1L);

        clientsDto = new ClientsDto();
        clientsDto.setId(1L);
    }

    @Test
    void testGetAllClients() {
        List<Clients> liste = new ArrayList<>();
        liste.add(clients);

        when(clientsRepo.findAll()).thenReturn(liste);
        when(clientsMapper.toDto(any(Clients.class))).thenReturn(clientsDto);

        List<ClientsDto> resultat = clientsService.findAll();

        assertNotNull(resultat);
        assertEquals(1, resultat.size());

        verify(clientsRepo, times(1)).findAll();
    }

    @Test
    void testGetClientById() {
        when(clientsRepo.findById(1L)).thenReturn(Optional.of(clients));
        when(clientsMapper.toDto(clients)).thenReturn(clientsDto);

        ClientsDto resultat = clientsService.findById(1L);

        assertNotNull(resultat);

        verify(clientsRepo, times(1)).findById(1L);
    }

    @Test
    void testSaveClient() {
        when(clientsMapper.toEntity(clientsDto)).thenReturn(clients);
        when(clientsRepo.save(clients)).thenReturn(clients);
        when(clientsMapper.toDto(clients)).thenReturn(clientsDto);

        ClientsDto resultat = clientsService.save(clientsDto);

        assertNotNull(resultat);

        verify(clientsRepo, times(1)).save(clients);
    }

    @Test
    void testUpdateClient() {
        when(clientsRepo.existsById(1L)).thenReturn(true);
        when(clientsMapper.toEntity(clientsDto)).thenReturn(clients);
        when(clientsRepo.save(clients)).thenReturn(clients);
        when(clientsMapper.toDto(clients)).thenReturn(clientsDto);

        ClientsDto resultat = clientsService.update(1L, clientsDto);

        assertNotNull(resultat);

        verify(clientsRepo, times(1)).save(clients);
    }

    @Test
    void testDeleteClient() {
        when(clientsRepo.existsById(1L)).thenReturn(true);
        doNothing().when(clientsRepo).deleteById(1L);

        clientsService.delete(1L);

        verify(clientsRepo, times(1)).deleteById(1L);
    }
}

package cm.camtech.crm.servicesTest;

import cm.camtech.crm.dtos.CampagnesClientsDto;
import cm.camtech.crm.entities.CampagnesClients;
import cm.camtech.crm.entities.CampagnesClientsPK;
import cm.camtech.crm.mappers.CampagnesClientsMapper;
import cm.camtech.crm.repositories.CampagnesClientsRepo;
import cm.camtech.crm.services.implementations.CampagnesClientsService;

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
public class CampagnesClientsServiceTest {

    @Mock
    private CampagnesClientsRepo campagnesClientsRepo;

    @Mock
    private CampagnesClientsMapper campagnesClientsMapper;

    @InjectMocks
    private CampagnesClientsService campagnesClientsService;

    private CampagnesClients campagnesClients;
    private CampagnesClientsDto campagnesClientsDto;
    private CampagnesClientsPK campagnesClientsPK;

    @BeforeEach
    void setUp() {

        campagnesClientsPK = new CampagnesClientsPK();
        campagnesClientsPK.setCampagneId(1L);
        campagnesClientsPK.setClientId(1L);

        campagnesClients = new CampagnesClients();
        campagnesClients.setCampagnesClientsPK(campagnesClientsPK);

        campagnesClientsDto = new CampagnesClientsDto();
        campagnesClientsDto.setCampagneId(1L);
        campagnesClientsDto.setClientId(1L);
    }

    @Test
    void testGetAllCampagnesClients() {

        List<CampagnesClients> liste = new ArrayList<>();
        liste.add(campagnesClients);

        when(campagnesClientsRepo.findAll()).thenReturn(liste);

        List<CampagnesClientsDto> resultat =
                campagnesClientsService.findAll();

        assertNotNull(resultat);
        assertEquals(1, resultat.size());

        verify(campagnesClientsRepo, times(1)).findAll();
    }

    @Test
    void testGetCampagnesClientsById() {

        when(campagnesClientsRepo.findById(campagnesClientsPK))
                .thenReturn(Optional.of(campagnesClients));

        when(campagnesClientsMapper.toDto(campagnesClients))
                .thenReturn(campagnesClientsDto);

        CampagnesClientsDto resultat =
                campagnesClientsService.findById(1L, 1L);

        assertNotNull(resultat);

        verify(campagnesClientsRepo, times(1))
                .findById(campagnesClientsPK);
    }

    @Test
    void testSaveCampagnesClients() {

        when(campagnesClientsMapper.toEntity(campagnesClientsDto))
                .thenReturn(campagnesClients);

        when(campagnesClientsRepo.save(campagnesClients))
                .thenReturn(campagnesClients);

        when(campagnesClientsMapper.toDto(campagnesClients))
                .thenReturn(campagnesClientsDto);

        CampagnesClientsDto resultat =
                campagnesClientsService.save(campagnesClientsDto);

        assertNotNull(resultat);

        verify(campagnesClientsRepo, times(1))
                .save(campagnesClients);
    }

    @Test
    void testDeleteCampagnesClients() {

        doNothing().when(campagnesClientsRepo)
                .deleteById(campagnesClientsPK);

        campagnesClientsService.delete(1L, 1L);

        verify(campagnesClientsRepo, times(1))
                .deleteById(campagnesClientsPK);
    }
}
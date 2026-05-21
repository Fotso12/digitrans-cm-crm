package cm.camtech.crm.servicesTest;

import cm.camtech.crm.dtos.ReclamationsDto;
import cm.camtech.crm.entities.Reclamations;
import cm.camtech.crm.mappers.ReclamationsMapper;
import cm.camtech.crm.repositories.ReclamationsRepo;
import cm.camtech.crm.services.implementations.ReclamationsService;

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
public class ReclamationsServiceTest {

    @Mock
    private ReclamationsRepo reclamationsRepo;

    @Mock
    private ReclamationsMapper reclamationsMapper;

    @InjectMocks
    private ReclamationsService reclamationsService;

    private Reclamations reclamations;
    private ReclamationsDto reclamationsDto;

    @BeforeEach
    void setUp() {
        reclamations = new Reclamations();
        reclamations.setId(1L);

        reclamationsDto = new ReclamationsDto();
        reclamationsDto.setId(1L);
    }

    @Test
    void testGetAllReclamations() {
        List<Reclamations> liste = new ArrayList<>();
        liste.add(reclamations);

        when(reclamationsRepo.findAll()).thenReturn(liste);
        when(reclamationsMapper.toDto(any(Reclamations.class))).thenReturn(reclamationsDto);

        List<ReclamationsDto> resultat = reclamationsService.findAll();

        assertNotNull(resultat);
        assertEquals(1, resultat.size());

        verify(reclamationsRepo, times(1)).findAll();
    }

    @Test
    void testGetReclamationById() {
        when(reclamationsRepo.findById(1L)).thenReturn(Optional.of(reclamations));
        when(reclamationsMapper.toDto(reclamations)).thenReturn(reclamationsDto);

        ReclamationsDto resultat = reclamationsService.findById(1L);

        assertNotNull(resultat);

        verify(reclamationsRepo, times(1)).findById(1L);
    }

    @Test
    void testSaveReclamation() {
        when(reclamationsMapper.toEntity(reclamationsDto)).thenReturn(reclamations);
        when(reclamationsRepo.save(reclamations)).thenReturn(reclamations);
        when(reclamationsMapper.toDto(reclamations)).thenReturn(reclamationsDto);

        ReclamationsDto resultat = reclamationsService.save(reclamationsDto);

        assertNotNull(resultat);

        verify(reclamationsRepo, times(1)).save(reclamations);
    }

    @Test
    void testUpdateReclamation() {
        when(reclamationsRepo.existsById(1L)).thenReturn(true);
        when(reclamationsMapper.toEntity(reclamationsDto)).thenReturn(reclamations);
        when(reclamationsRepo.save(reclamations)).thenReturn(reclamations);
        when(reclamationsMapper.toDto(reclamations)).thenReturn(reclamationsDto);

        ReclamationsDto resultat = reclamationsService.update(1L, reclamationsDto);

        assertNotNull(resultat);

        verify(reclamationsRepo, times(1)).save(reclamations);
    }

    @Test
    void testDeleteReclamation() {
        when(reclamationsRepo.existsById(1L)).thenReturn(true);
        doNothing().when(reclamationsRepo).deleteById(1L);

        reclamationsService.delete(1L);

        verify(reclamationsRepo, times(1)).deleteById(1L);
    }
}

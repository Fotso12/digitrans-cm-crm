package cm.camtech.crm.servicesTest;

import cm.camtech.crm.dtos.CampagnesDto;
import cm.camtech.crm.entities.Campagnes;
import cm.camtech.crm.mappers.CampagnesMapper;
import cm.camtech.crm.repositories.CampagnesRepo;
import cm.camtech.crm.services.implementations.CampagnesService;

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
public class CampagnesServiceTest {

    @Mock
    private CampagnesRepo campagnesRepo;

    @Mock
    private CampagnesMapper campagnesMapper;

    @InjectMocks
    private CampagnesService campagnesService;

    private Campagnes campagnes;
    private CampagnesDto campagnesDto;

    @BeforeEach
    void setUp() {
        campagnes = new Campagnes();
        campagnes.setId(1L);

        campagnesDto = new CampagnesDto();
        campagnesDto.setId(1L);
    }

    @Test
    void testGetAllCampagnes() {
        List<Campagnes> liste = new ArrayList<>();
        liste.add(campagnes);

        when(campagnesRepo.findAll()).thenReturn(liste);
        when(campagnesMapper.toDto(any(Campagnes.class))).thenReturn(campagnesDto);

        List<CampagnesDto> resultat = campagnesService.findAll();

        assertNotNull(resultat);
        assertEquals(1, resultat.size());

        verify(campagnesRepo, times(1)).findAll();
    }

    @Test
    void testGetCampagneById() {
        when(campagnesRepo.findById(1L)).thenReturn(Optional.of(campagnes));
        when(campagnesMapper.toDto(campagnes)).thenReturn(campagnesDto);

        CampagnesDto resultat = campagnesService.findById(1L);

        assertNotNull(resultat);

        verify(campagnesRepo, times(1)).findById(1L);
    }

    @Test
    void testSaveCampagne() {
        when(campagnesMapper.toEntity(campagnesDto)).thenReturn(campagnes);
        when(campagnesRepo.save(campagnes)).thenReturn(campagnes);
        when(campagnesMapper.toDto(campagnes)).thenReturn(campagnesDto);

        CampagnesDto resultat = campagnesService.save(campagnesDto);

        assertNotNull(resultat);

        verify(campagnesRepo, times(1)).save(campagnes);
    }

    @Test
    void testUpdateCampagne() {
        when(campagnesRepo.existsById(1L)).thenReturn(true);
        when(campagnesMapper.toEntity(campagnesDto)).thenReturn(campagnes);
        when(campagnesRepo.save(campagnes)).thenReturn(campagnes);
        when(campagnesMapper.toDto(campagnes)).thenReturn(campagnesDto);

        CampagnesDto resultat = campagnesService.update(1L, campagnesDto);

        assertNotNull(resultat);

        verify(campagnesRepo, times(1)).save(campagnes);
    }

    @Test
    void testDeleteCampagne() {
        when(campagnesRepo.existsById(1L)).thenReturn(true);
        doNothing().when(campagnesRepo).deleteById(1L);

        campagnesService.delete(1L);

        verify(campagnesRepo, times(1)).deleteById(1L);
    }
}

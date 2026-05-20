package cm.camtech.crm.servicesTest;

import cm.camtech.crm.dtos.UtilisateursDto;
import cm.camtech.crm.entities.Utilisateurs;
import cm.camtech.crm.mappers.UtilisateursMapper;
import cm.camtech.crm.repositories.UtilisateursRepo;
import cm.camtech.crm.services.implementations.UtilisateursService;

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
public class UtilisateursServiceTest {

    @Mock
    private UtilisateursRepo utilisateursRepo;

    @Mock
    private UtilisateursMapper utilisateursMapper;

    @InjectMocks
    private UtilisateursService utilisateursService;

    private Utilisateurs utilisateurs;
    private UtilisateursDto utilisateursDto;

    @BeforeEach
    void setUp() {

        utilisateurs = new Utilisateurs();
        utilisateurs.setId(1L);

        utilisateursDto = new UtilisateursDto();
        utilisateursDto.setId(1L);
    }

    @Test
    void testGetAllUtilisateurs() {

        List<Utilisateurs> liste = new ArrayList<>();
        liste.add(utilisateurs);

        when(utilisateursRepo.findAll()).thenReturn(liste);

        List<Utilisateurs> resultat = utilisateursService.getAllUtilisateurs();

        assertNotNull(resultat);
        assertEquals(1, resultat.size());

        verify(utilisateursRepo, times(1)).findAll();
    }

    @Test
    void testGetUtilisateurById() {

        when(utilisateursRepo.findById(1L)).thenReturn(Optional.of(utilisateurs));

        Utilisateurs resultat = utilisateursService.getUtilisateurById(1L);

        assertNotNull(resultat);

        verify(utilisateursRepo, times(1)).findById(1L);
    }

    @Test
    void testSaveUtilisateur() {

        when(utilisateursMapper.toEntity(utilisateursDto)).thenReturn(utilisateurs);
        when(utilisateursRepo.save(utilisateurs)).thenReturn(utilisateurs);
        when(utilisateursMapper.toDto(utilisateurs)).thenReturn(utilisateursDto);

        UtilisateursDto resultat = utilisateursService.saveUtilisateur(utilisateursDto);

        assertNotNull(resultat);

        verify(utilisateursRepo, times(1)).save(utilisateurs);
    }

    @Test
    void testDeleteUtilisateur() {

        doNothing().when(utilisateursRepo).deleteById(1L);

        utilisateursService.deleteUtilisateur(1L);

        verify(utilisateursRepo, times(1)).deleteById(1L);
    }
}
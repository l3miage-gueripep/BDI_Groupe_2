package fr.uga.miage.m1;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import fr.uga.miage.m1.entities.CovoiturageLieu;
import fr.uga.miage.m1.entities.Festival;
import fr.uga.miage.m1.entities.LieuCovoiturage;
import fr.uga.miage.m1.entities.Panier;
import fr.uga.miage.m1.entities.PanierOffre;
import fr.uga.miage.m1.pdf.CreationPdf;

public class CreationPdfTest {

    @Test
    public void testCreatePDF() {
        // Create mock objects
        Panier panier = mock(Panier.class);
        PanierOffre panierOffre = mock(PanierOffre.class);
        Festival festival = mock(Festival.class);
        CovoiturageLieu covoiturageLieu = mock(CovoiturageLieu.class);

        // Define behavior of mock objects
        when(panier.getPanierOffres()).thenReturn(Arrays.asList(panierOffre));
        when(panierOffre.getFestival()).thenReturn(festival);
        when(festival.getNomManifestation()).thenReturn("Test Festival");
        when(panierOffre.getCovoiturageLieu()).thenReturn(covoiturageLieu);
        when(covoiturageLieu.getLieuCovoiturage()).thenReturn(new LieuCovoiturage()); // Fix: Pass a LieuCovoiturage object instead of a String

        // Call the method to test
        byte[] result = CreationPdf.createPDF(panier);

        // Verify the result
        assertNotNull(result);
        assertTrue(result.length > 0);
    }
    
}

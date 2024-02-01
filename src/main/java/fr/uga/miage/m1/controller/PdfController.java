package fr.uga.miage.m1.controller;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.miage.m1.dto.PanierDto;
import fr.uga.miage.m1.entities.Panier;
import fr.uga.miage.m1.mapper.PanierMapper;
import fr.uga.miage.m1.pdf.CreationPdf;
import fr.uga.miage.m1.repos.PanierRepo;
import fr.uga.miage.m1.services.PanierService;
import lombok.RequiredArgsConstructor;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PdfController {

    private final PanierRepo repo;

    @GetMapping("/download-pdf/{idPanier}")
    public ResponseEntity<InputStreamResource> downloadPdf(@PathVariable Long idPanier) throws IOException {
        // Suppose you have a method that generates a PDF as a byte array
        Optional<Panier> optionalPanier = repo.findById(idPanier);
        Panier panier = null;
        if (optionalPanier.isPresent()) {
            panier = optionalPanier.get();
        } else {

            throw new NoSuchElementException("Pas de panier pour cet utilisateur");
        }
        byte[] pdfBytes = CreationPdf.createPDF(panier);

        // Create an InputStreamResource from the byte array
        InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(pdfBytes));

        // Set headers for the response
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=example.pdf");
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE);

        // Return the ResponseEntity with headers and the InputStreamResource
        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
    }
}

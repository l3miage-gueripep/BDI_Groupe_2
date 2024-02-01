package fr.uga.miage.m1;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Collections;

import org.hibernate.mapping.Collection;
import org.hibernate.type.descriptor.java.LocalDateTimeJavaType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.RestController;

import fr.uga.miage.m1.entities.CovoiturageLieu;
import fr.uga.miage.m1.entities.Festival;
import fr.uga.miage.m1.entities.LieuCovoiturage;
import fr.uga.miage.m1.entities.OffreCovoiturage;
import fr.uga.miage.m1.entities.Panier;
import fr.uga.miage.m1.entities.PanierOffre;
import fr.uga.miage.m1.pdf.CreationPdf;

@SpringBootApplication
@RestController
@EntityScan(basePackages = "fr.uga.miage.m1.entities")
public class MyApplication {

    public static void main(String[] args) throws FileNotFoundException {
        String dateString = "2024-02-01T12:30:00";
        LocalDateTime parsedDateTime = LocalDateTime.parse(dateString);
        Panier panier = new Panier();
        PanierOffre panierOffre = new PanierOffre();
        Festival festival = new Festival();
        festival.setNomManifestation("blbla");
        festival.setTarifPass(10.0);
        LieuCovoiturage lieuCovoiturage = new LieuCovoiturage();
        lieuCovoiturage.setNomLieu("krypton");
        OffreCovoiturage offreCovoiturage = new OffreCovoiturage();
        offreCovoiturage.setFestival(festival);
        CovoiturageLieu covoiturageLieu = new CovoiturageLieu();
        covoiturageLieu.setOffreCovoiturage(offreCovoiturage);
        covoiturageLieu.setLieuCovoiturage(lieuCovoiturage);
        covoiturageLieu.setHoraire(parsedDateTime);
        panierOffre.setCovoiturageLieu(covoiturageLieu);
        panierOffre.setQuantite(4);
        panier.setPanierOffres(Collections.singletonList(panierOffre));
        CreationPdf.createPDF(panier);
        SpringApplication.run(MyApplication.class, args);
    }
}

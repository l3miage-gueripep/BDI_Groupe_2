package fr.uga.miage.m1.pdf;

import java.io.ByteArrayOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import fr.uga.miage.m1.entities.Panier;
import fr.uga.miage.m1.entities.PanierOffre;

public class CreationPdf {

    public static byte[] createPDF(Panier panier) {

        try {
            // Création d'un document
            Document document = new Document();

            // Création d'un ByteArrayOutputStream pour stocker les octets du PDF
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            // Création d'un écrivain PDF associé au document
            PdfWriter.getInstance(document, byteArrayOutputStream);

            // Ouverture du document pour écrire
            document.open();

            List<PanierOffre> panierOffres = panier.getPanierOffres();

            // Ajout d'informations au document
            panierOffres.forEach(panierOffre -> {
                try {
                    document.add(new Paragraph("Festival : " + panierOffre.getFestival().getNomManifestation()
                            + "       " + "x " + panierOffre.getQuantite() + "     "
                            + panierOffre.getFestival().getTarifPass() * panierOffre.getQuantite()));
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
                try {
                    document.add(new Paragraph("Covoiturage : \n "
                            + panierOffre.getCovoiturageLieu().getLieuCovoiturage().getNomLieu() + "\n"
                            + panierOffre.getCovoiturageLieu().getHoraire() + "\n" + panierOffre.getQuantite() + "   "
                            + " x " + panierOffre.getCovoiturageLieu().getPrix() * panierOffre.getQuantite()));
                } catch (DocumentException e) {
                    e.printStackTrace();
                }
            });

            // Fermeture du document
            document.close();

            // Récupération des octets du PDF à partir du ByteArrayOutputStream
            return byteArrayOutputStream.toByteArray();

        } catch (DocumentException e) {
            e.printStackTrace();
        }

        // En cas d'erreur, retournez un tableau vide ou gestion de l'erreur appropriée
        // selon votre besoin
        return new byte[0];
    }
}

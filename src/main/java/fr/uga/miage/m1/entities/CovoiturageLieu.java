package fr.uga.miage.m1.entities;

public class CovoiturageLieu {

    private Long idCovoiturage;

    private String idLieu;

    public CovoiturageLieu(OffreCovoiturage offre, LieuCovoiturage lieu) {
        this.idCovoiturage = offre.getIdOffreCovoiturage();
        this.idLieu = lieu.getIdLieu();
    }

}

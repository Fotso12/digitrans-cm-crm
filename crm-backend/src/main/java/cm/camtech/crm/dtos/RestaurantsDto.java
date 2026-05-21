package cm.camtech.crm.dtos;

import java.util.Date;

public class RestaurantsDto {

    private Long id;
    private String nom;
    private String ville;
    private String adresse;
    private String telephone;
    private boolean actif;
    private Date dateCreation;

    public RestaurantsDto() {
    }

    // getters et setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public RestaurantsDto(Long id, String nom, String ville, String adresse, String telephone, boolean actif, Date dateCreation) {
        this.id = id;
        this.nom = nom;
        this.ville = ville;
        this.adresse = adresse;
        this.telephone = telephone;
        this.actif = actif;
        this.dateCreation = dateCreation;
    }
}
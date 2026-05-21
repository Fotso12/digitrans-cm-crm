package cm.camtech.crm.dtos;

import java.util.Date;

public class ClientsDto {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private Date dateNaissance;
    private String adresse;
    private String ville;
    private int pointsFidelite;
    private String niveauFidelite;
    private String statut;
    private Date dateInscription;
    private Date dateModification;
    private Long restaurantHabituelId;
    private Long creeParId;

    public ClientsDto() {
    }

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getPointsFidelite() {
        return pointsFidelite;
    }

    public void setPointsFidelite(int pointsFidelite) {
        this.pointsFidelite = pointsFidelite;
    }

    public String getNiveauFidelite() {
        return niveauFidelite;
    }

    public void setNiveauFidelite(String niveauFidelite) {
        this.niveauFidelite = niveauFidelite;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public Long getRestaurantHabituelId() {
        return restaurantHabituelId;
    }

    public void setRestaurantHabituelId(Long restaurantHabituelId) {
        this.restaurantHabituelId = restaurantHabituelId;
    }

    public Long getCreeParId() {
        return creeParId;
    }

    public void setCreeParId(Long creeParId) {
        this.creeParId = creeParId;
    }
}
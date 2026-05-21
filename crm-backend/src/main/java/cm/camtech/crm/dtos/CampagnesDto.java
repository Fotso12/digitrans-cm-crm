package cm.camtech.crm.dtos;

import java.util.Date;

public class CampagnesDto {

    private Long id;
    private String nom;
    private String description;
    private String statut;
    private Date dateDebut;
    private Date dateFin;
    private String cibleSegment;
    private Date dateCreation;

    // relation simplifiée
    private Long creeParId;

    public CampagnesDto() {
    }

    public CampagnesDto(Long id, String nom, String description,
                        String statut, Date dateDebut,
                        Date dateFin, String cibleSegment,
                        Date dateCreation, Long creeParId) {

        this.id = id;
        this.nom = nom;
        this.description = description;
        this.statut = statut;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.cibleSegment = cibleSegment;
        this.dateCreation = dateCreation;
        this.creeParId = creeParId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getCibleSegment() {
        return cibleSegment;
    }

    public void setCibleSegment(String cibleSegment) {
        this.cibleSegment = cibleSegment;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Long getCreeParId() {
        return creeParId;
    }

    public void setCreeParId(Long creeParId) {
        this.creeParId = creeParId;
    }
}
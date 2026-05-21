package cm.camtech.crm.dtos;

import java.util.Date;

public class ReclamationsDto {

    private Long id;
    private String reference;
    private String sujet;
    private String description;
    private String statut;
    private String priorite;
    private String resolution;
    private Date dateCreation;
    private Date dateResolution;
    private Date dateModification;
    private Long assigneeId;
    private Long clientId;
    private Long commandeId;

    public ReclamationsDto() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getReference() {
        return reference;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }
    public String getSujet() {
        return sujet;
    }
    public void setSujet(String sujet) {
        this.sujet = sujet;
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
    public String getPriorite() {
        return priorite;
    }
    public void setPriorite(String priorite) {
        this.priorite = priorite;
    }
    public String getResolution() {
        return resolution;
    }
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }
    public Date getDateCreation() {
        return dateCreation;
    }
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }
    public Date getDateResolution() {
        return dateResolution;
    }
    public void setDateResolution(Date dateResolution) {
        this.dateResolution = dateResolution;
    }
    public Date getDateModification() {
        return dateModification;
    }
    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }
    public Long getAssigneeId() {
        return assigneeId;
    }
    public void setAssigneeId(Long assigneeId) {
        this.assigneeId = assigneeId;
    }
    public Long getClientId() {
        return clientId;
    }
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
    public Long getCommandeId() {
        return commandeId;
    }
    public void setCommandeId(Long commandeId) {
        this.commandeId = commandeId;
    }
    
}
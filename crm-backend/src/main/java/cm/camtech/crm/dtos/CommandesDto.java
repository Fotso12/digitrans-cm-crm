package cm.camtech.crm.dtos;

import java.math.BigDecimal;
import java.util.Date;

public class CommandesDto {

    private Long id;
    private String reference;
    private String statut;
    private BigDecimal montantTotal;
    private int pointsAttribues;
    private String notes;
    private Date dateCommande;
    private Date dateLivraison;
    private Long traiteParId;
    private Long clientId;
    private Long restaurantId;

    public CommandesDto() {
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
    public String getStatut() {
        return statut;
    }
    public void setStatut(String statut) {
        this.statut = statut;
    }
    public BigDecimal getMontantTotal() {
        return montantTotal;
    }
    public void setMontantTotal(BigDecimal montantTotal) {
        this.montantTotal = montantTotal;
    }
    public int getPointsAttribues() {
        return pointsAttribues;
    }
    public void setPointsAttribues(int pointsAttribues) {
        this.pointsAttribues = pointsAttribues;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public Date getDateCommande() {
        return dateCommande;
    }
    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }
    public Date getDateLivraison() {
        return dateLivraison;
    }
    public void setDateLivraison(Date dateLivraison) {
        this.dateLivraison = dateLivraison;
    }
    public Long getTraiteParId() {
        return traiteParId;
    }
    public void setTraiteParId(Long traiteParId) {
        this.traiteParId = traiteParId;
    }
    public Long getClientId() {
        return clientId;
    }
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
    public Long getRestaurantId() {
        return restaurantId;
    }
    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
    
}
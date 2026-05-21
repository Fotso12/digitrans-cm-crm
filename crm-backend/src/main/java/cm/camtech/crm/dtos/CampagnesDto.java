package cm.camtech.crm.dtos;
import java.util.Date;
public class CampagnesDto {

    private Long id;
    private String nom;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private String statut;
    private Long creeParId;

    public CampagnesDto() {
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

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Long getCreeParId() {
        return creeParId;
    }

    public void setCreeParId(Long creeParId) {
        this.creeParId = creeParId;
    }
}

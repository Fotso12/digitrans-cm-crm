package cm.camtech.crm.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reclamations")
@NamedQueries({
        @NamedQuery(name = "Reclamations.findAll", query = "SELECT r FROM Reclamations r"),
        @NamedQuery(name = "Reclamations.findById", query = "SELECT r FROM Reclamations r WHERE r.id = :id"),
        @NamedQuery(name = "Reclamations.findByReference", query = "SELECT r FROM Reclamations r WHERE r.reference = :reference"),
        @NamedQuery(name = "Reclamations.findBySujet", query = "SELECT r FROM Reclamations r WHERE r.sujet = :sujet"),
        @NamedQuery(name = "Reclamations.findByStatut", query = "SELECT r FROM Reclamations r WHERE r.statut = :statut"),
        @NamedQuery(name = "Reclamations.findByPriorite", query = "SELECT r FROM Reclamations r WHERE r.priorite = :priorite"),
        @NamedQuery(name = "Reclamations.findByDateCreation", query = "SELECT r FROM Reclamations r WHERE r.dateCreation = :dateCreation"),
        @NamedQuery(name = "Reclamations.findByDateResolution", query = "SELECT r FROM Reclamations r WHERE r.dateResolution = :dateResolution"),
        @NamedQuery(name = "Reclamations.findByDateModification", query = "SELECT r FROM Reclamations r WHERE r.dateModification = :dateModification")})
public class Reclamations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "reference")
    private String reference;
    @Basic(optional = false)
    @Column(name = "sujet")
    private String sujet;
    @Basic(optional = false)
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "statut")
    private String statut;
    @Basic(optional = false)
    @Column(name = "priorite")
    private String priorite;
    @Lob
    @Column(name = "resolution")
    private String resolution;
    @Basic(optional = false)
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "date_resolution")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateResolution;
    @Column(name = "date_modification")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @JoinColumn(name = "assignee_id", referencedColumnName = "id")
    @ManyToOne
    private Utilisateurs assigneeId;
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clients clientId;
    @JoinColumn(name = "commande_id", referencedColumnName = "id")
    @ManyToOne
    private Commandes commandeId;

    public Reclamations() {
    }

    public Reclamations(Long id) {
        this.id = id;
    }

    public Reclamations(Long id, String reference, String sujet, String description, String statut, String priorite, Date dateCreation) {
        this.id = id;
        this.reference = reference;
        this.sujet = sujet;
        this.description = description;
        this.statut = statut;
        this.priorite = priorite;
        this.dateCreation = dateCreation;
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

    public Utilisateurs getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(Utilisateurs assigneeId) {
        this.assigneeId = assigneeId;
    }

    public Clients getClientId() {
        return clientId;
    }

    public void setClientId(Clients clientId) {
        this.clientId = clientId;
    }

    public Commandes getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(Commandes commandeId) {
        this.commandeId = commandeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reclamations)) {
            return false;
        }
        Reclamations other = (Reclamations) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cmr_savoirmanger.Reclamations[ id=" + id + " ]";
    }

}

package src.main.java.cm.camtech.crm.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "campagnes")
@NamedQueries({
        @NamedQuery(name = "Campagnes.findAll", query = "SELECT c FROM Campagnes c"),
        @NamedQuery(name = "Campagnes.findById", query = "SELECT c FROM Campagnes c WHERE c.id = :id"),
        @NamedQuery(name = "Campagnes.findByNom", query = "SELECT c FROM Campagnes c WHERE c.nom = :nom"),
        @NamedQuery(name = "Campagnes.findByStatut", query = "SELECT c FROM Campagnes c WHERE c.statut = :statut"),
        @NamedQuery(name = "Campagnes.findByDateDebut", query = "SELECT c FROM Campagnes c WHERE c.dateDebut = :dateDebut"),
        @NamedQuery(name = "Campagnes.findByDateFin", query = "SELECT c FROM Campagnes c WHERE c.dateFin = :dateFin"),
        @NamedQuery(name = "Campagnes.findByCibleSegment", query = "SELECT c FROM Campagnes c WHERE c.cibleSegment = :cibleSegment"),
        @NamedQuery(name = "Campagnes.findByDateCreation", query = "SELECT c FROM Campagnes c WHERE c.dateCreation = :dateCreation")})
public class Campagnes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Lob
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "statut")
    private String statut;
    @Column(name = "date_debut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Column(name = "date_fin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @Column(name = "cible_segment")
    private String cibleSegment;
    @Basic(optional = false)
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @JoinColumn(name = "cree_par", referencedColumnName = "id")
    @ManyToOne
    private Utilisateurs creePar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "campagnes")
    private Collection<CampagnesClients> campagnesClientsCollection;

    public Campagnes() {
    }

    public Campagnes(Long id) {
        this.id = id;
    }

    public Campagnes(Long id, String nom, String statut, Date dateCreation) {
        this.id = id;
        this.nom = nom;
        this.statut = statut;
        this.dateCreation = dateCreation;
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

    public Utilisateurs getCreePar() {
        return creePar;
    }

    public void setCreePar(Utilisateurs creePar) {
        this.creePar = creePar;
    }

    public Collection<CampagnesClients> getCampagnesClientsCollection() {
        return campagnesClientsCollection;
    }

    public void setCampagnesClientsCollection(Collection<CampagnesClients> campagnesClientsCollection) {
        this.campagnesClientsCollection = campagnesClientsCollection;
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
        if (!(object instanceof Campagnes)) {
            return false;
        }
        Campagnes other = (Campagnes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cmr_savoirmanger.Campagnes[ id=" + id + " ]";
    }

}


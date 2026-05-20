package agritrans.demo.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "commandes")
@NamedQueries({
        @NamedQuery(name = "Commandes.findAll", query = "SELECT c FROM Commandes c"),
        @NamedQuery(name = "Commandes.findById", query = "SELECT c FROM Commandes c WHERE c.id = :id"),
        @NamedQuery(name = "Commandes.findByReference", query = "SELECT c FROM Commandes c WHERE c.reference = :reference"),
        @NamedQuery(name = "Commandes.findByStatut", query = "SELECT c FROM Commandes c WHERE c.statut = :statut"),
        @NamedQuery(name = "Commandes.findByMontantTotal", query = "SELECT c FROM Commandes c WHERE c.montantTotal = :montantTotal"),
        @NamedQuery(name = "Commandes.findByPointsAttribues", query = "SELECT c FROM Commandes c WHERE c.pointsAttribues = :pointsAttribues"),
        @NamedQuery(name = "Commandes.findByDateCommande", query = "SELECT c FROM Commandes c WHERE c.dateCommande = :dateCommande"),
        @NamedQuery(name = "Commandes.findByDateLivraison", query = "SELECT c FROM Commandes c WHERE c.dateLivraison = :dateLivraison")})
public class Commandes implements Serializable {

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
    @Column(name = "statut")
    private String statut;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "montant_total")
    private BigDecimal montantTotal;
    @Basic(optional = false)
    @Column(name = "points_attribues")
    private int pointsAttribues;
    @Lob
    @Column(name = "notes")
    private String notes;
    @Basic(optional = false)
    @Column(name = "date_commande")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCommande;
    @Column(name = "date_livraison")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateLivraison;
    @JoinColumn(name = "traite_par", referencedColumnName = "id")
    @ManyToOne
    private Utilisateurs traitePar;
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clients clientId;
    @JoinColumn(name = "restaurant_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Restaurants restaurantId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commandeId")
    private Collection<LignesCommandes> lignesCommandesCollection;
    @OneToMany(mappedBy = "commandeId")
    private Collection<Reclamations> reclamationsCollection;

    public Commandes() {
    }

    public Commandes(Long id) {
        this.id = id;
    }

    public Commandes(Long id, String reference, String statut, BigDecimal montantTotal, int pointsAttribues, Date dateCommande) {
        this.id = id;
        this.reference = reference;
        this.statut = statut;
        this.montantTotal = montantTotal;
        this.pointsAttribues = pointsAttribues;
        this.dateCommande = dateCommande;
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

    public Utilisateurs getTraitePar() {
        return traitePar;
    }

    public void setTraitePar(Utilisateurs traitePar) {
        this.traitePar = traitePar;
    }

    public Clients getClientId() {
        return clientId;
    }

    public void setClientId(Clients clientId) {
        this.clientId = clientId;
    }

    public Restaurants getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Restaurants restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Collection<LignesCommandes> getLignesCommandesCollection() {
        return lignesCommandesCollection;
    }

    public void setLignesCommandesCollection(Collection<LignesCommandes> lignesCommandesCollection) {
        this.lignesCommandesCollection = lignesCommandesCollection;
    }

    public Collection<Reclamations> getReclamationsCollection() {
        return reclamationsCollection;
    }

    public void setReclamationsCollection(Collection<Reclamations> reclamationsCollection) {
        this.reclamationsCollection = reclamationsCollection;
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
        if (!(object instanceof Commandes)) {
            return false;
        }
        Commandes other = (Commandes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cmr_savoirmanger.Commandes[ id=" + id + " ]";
    }

}

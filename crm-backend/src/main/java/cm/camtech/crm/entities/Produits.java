package cm.camtech.crm.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "produits")
@NamedQueries({
        @NamedQuery(name = "Produits.findAll", query = "SELECT p FROM Produits p"),
        @NamedQuery(name = "Produits.findById", query = "SELECT p FROM Produits p WHERE p.id = :id"),
        @NamedQuery(name = "Produits.findByNom", query = "SELECT p FROM Produits p WHERE p.nom = :nom"),
        @NamedQuery(name = "Produits.findByPrixUnitaire", query = "SELECT p FROM Produits p WHERE p.prixUnitaire = :prixUnitaire"),
        @NamedQuery(name = "Produits.findByCategorie", query = "SELECT p FROM Produits p WHERE p.categorie = :categorie"),
        @NamedQuery(name = "Produits.findByDisponible", query = "SELECT p FROM Produits p WHERE p.disponible = :disponible"),
        @NamedQuery(name = "Produits.findByDateCreation", query = "SELECT p FROM Produits p WHERE p.dateCreation = :dateCreation")})
public class Produits implements Serializable {

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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "prix_unitaire")
    private BigDecimal prixUnitaire;
    @Column(name = "categorie")
    private String categorie;
    @Basic(optional = false)
    @Column(name = "disponible")
    private boolean disponible;
    @Basic(optional = false)
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produitId")
    private Collection<LignesCommandes> lignesCommandesCollection;

    public Produits() {
    }

    public Produits(Long id) {
        this.id = id;
    }

    public Produits(Long id, String nom, BigDecimal prixUnitaire, boolean disponible, Date dateCreation) {
        this.id = id;
        this.nom = nom;
        this.prixUnitaire = prixUnitaire;
        this.disponible = disponible;
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

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Collection<LignesCommandes> getLignesCommandesCollection() {
        return lignesCommandesCollection;
    }

    public void setLignesCommandesCollection(Collection<LignesCommandes> lignesCommandesCollection) {
        this.lignesCommandesCollection = lignesCommandesCollection;
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
        if (!(object instanceof Produits)) {
            return false;
        }
        Produits other = (Produits) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cmr_savoirmanger.Produits[ id=" + id + " ]";
    }

}
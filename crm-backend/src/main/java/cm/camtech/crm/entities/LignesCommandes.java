package src.main.java.cm.camtech.crm.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "lignes_commandes")
@NamedQueries({
        @NamedQuery(name = "LignesCommandes.findAll", query = "SELECT l FROM LignesCommandes l"),
        @NamedQuery(name = "LignesCommandes.findById", query = "SELECT l FROM LignesCommandes l WHERE l.id = :id"),
        @NamedQuery(name = "LignesCommandes.findByQuantite", query = "SELECT l FROM LignesCommandes l WHERE l.quantite = :quantite"),
        @NamedQuery(name = "LignesCommandes.findByPrixUnitaire", query = "SELECT l FROM LignesCommandes l WHERE l.prixUnitaire = :prixUnitaire"),
        @NamedQuery(name = "LignesCommandes.findBySousTotal", query = "SELECT l FROM LignesCommandes l WHERE l.sousTotal = :sousTotal")})
public class LignesCommandes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "quantite")
    private int quantite;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "prix_unitaire")
    private BigDecimal prixUnitaire;
    @Column(name = "sous_total")
    private BigDecimal sousTotal;
    @JoinColumn(name = "commande_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Commandes commandeId;
    @JoinColumn(name = "produit_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Produits produitId;

    public LignesCommandes() {
    }

    public LignesCommandes(Long id) {
        this.id = id;
    }

    public LignesCommandes(Long id, int quantite, BigDecimal prixUnitaire) {
        this.id = id;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public BigDecimal getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(BigDecimal prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public BigDecimal getSousTotal() {
        return sousTotal;
    }

    public void setSousTotal(BigDecimal sousTotal) {
        this.sousTotal = sousTotal;
    }

    public Commandes getCommandeId() {
        return commandeId;
    }

    public void setCommandeId(Commandes commandeId) {
        this.commandeId = commandeId;
    }

    public Produits getProduitId() {
        return produitId;
    }

    public void setProduitId(Produits produitId) {
        this.produitId = produitId;
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
        if (!(object instanceof LignesCommandes)) {
            return false;
        }
        LignesCommandes other = (LignesCommandes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cmr_savoirmanger.LignesCommandes[ id=" + id + " ]";
    }

}

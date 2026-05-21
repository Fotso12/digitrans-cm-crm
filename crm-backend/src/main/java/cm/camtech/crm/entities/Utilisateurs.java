package cm.camtech.crm.entities;

import jakarta.persistence.*;
import cm.camtech.crm.entities.Campagnes;



import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;


@Entity
@Table(name = "utilisateurs")
@NamedQueries({
        @NamedQuery(name = "Utilisateurs.findAll", query = "SELECT u FROM Utilisateurs u"),
        @NamedQuery(name = "Utilisateurs.findById", query = "SELECT u FROM Utilisateurs u WHERE u.id = :id"),
        @NamedQuery(name = "Utilisateurs.findByNom", query = "SELECT u FROM Utilisateurs u WHERE u.nom = :nom"),
        @NamedQuery(name = "Utilisateurs.findByPrenom", query = "SELECT u FROM Utilisateurs u WHERE u.prenom = :prenom"),
        @NamedQuery(name = "Utilisateurs.findByEmail", query = "SELECT u FROM Utilisateurs u WHERE u.email = :email"),
        @NamedQuery(name = "Utilisateurs.findByMotDePasse", query = "SELECT u FROM Utilisateurs u WHERE u.motDePasse = :motDePasse"),
        @NamedQuery(name = "Utilisateurs.findByRole", query = "SELECT u FROM Utilisateurs u WHERE u.role = :role"),
        @NamedQuery(name = "Utilisateurs.findByActif", query = "SELECT u FROM Utilisateurs u WHERE u.actif = :actif"),
        @NamedQuery(name = "Utilisateurs.findByDateCreation", query = "SELECT u FROM Utilisateurs u WHERE u.dateCreation = :dateCreation"),
        @NamedQuery(name = "Utilisateurs.findByDateModification", query = "SELECT u FROM Utilisateurs u WHERE u.dateModification = :dateModification")})
public class Utilisateurs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "prenom")
    private String prenom;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "mot_de_passe")
    private String motDePasse;
    @Basic(optional = false)
    @Column(name = "role")
    private String role;
    @Basic(optional = false)
    @Column(name = "actif")
    private boolean actif;
    @Basic(optional = false)
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @Column(name = "date_modification")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @OneToMany(mappedBy = "traitePar")
    private Collection<Commandes> commandesCollection;
    @OneToMany(mappedBy = "creePar")
    private Collection<Campagnes> campagnesCollection;
    @OneToMany(mappedBy = "creePar")
    private Collection<Clients> clientsCollection;
    @OneToMany(mappedBy = "assigneeId")
    private Collection<Reclamations> reclamationsCollection;

    public Utilisateurs() {
    }

    public Utilisateurs(Long id) {
        this.id = id;
    }

    public Utilisateurs(Long id, String nom, String prenom, String email, String motDePasse, String role, boolean actif, Date dateCreation) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.motDePasse = motDePasse;
        this.role = role;
        this.actif = actif;
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

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean getActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public Collection<Commandes> getCommandesCollection() {
        return commandesCollection;
    }

    public void setCommandesCollection(Collection<Commandes> commandesCollection) {
        this.commandesCollection = commandesCollection;
    }

    public Collection<Campagnes> getCampagnesCollection() {
        return campagnesCollection;
    }

    public void setCampagnesCollection(Collection<Campagnes> campagnesCollection) {
        this.campagnesCollection = campagnesCollection;
    }

    public Collection<Clients> getClientsCollection() {
        return clientsCollection;
    }

    public void setClientsCollection(Collection<Clients> clientsCollection) {
        this.clientsCollection = clientsCollection;
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
        if (!(object instanceof Utilisateurs)) {
            return false;
        }
        Utilisateurs other = (Utilisateurs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cmr_savoirmanger.Utilisateurs[ id=" + id + " ]";
    }

}

package cm.camtech.crm.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "clients")
@NamedQueries({
        @NamedQuery(name = "Clients.findAll", query = "SELECT c FROM Clients c"),
        @NamedQuery(name = "Clients.findById", query = "SELECT c FROM Clients c WHERE c.id = :id"),
        @NamedQuery(name = "Clients.findByNom", query = "SELECT c FROM Clients c WHERE c.nom = :nom"),
        @NamedQuery(name = "Clients.findByPrenom", query = "SELECT c FROM Clients c WHERE c.prenom = :prenom"),
        @NamedQuery(name = "Clients.findByEmail", query = "SELECT c FROM Clients c WHERE c.email = :email"),
        @NamedQuery(name = "Clients.findByTelephone", query = "SELECT c FROM Clients c WHERE c.telephone = :telephone"),
        @NamedQuery(name = "Clients.findByDateNaissance", query = "SELECT c FROM Clients c WHERE c.dateNaissance = :dateNaissance"),
        @NamedQuery(name = "Clients.findByAdresse", query = "SELECT c FROM Clients c WHERE c.adresse = :adresse"),
        @NamedQuery(name = "Clients.findByVille", query = "SELECT c FROM Clients c WHERE c.ville = :ville"),
        @NamedQuery(name = "Clients.findByPointsFidelite", query = "SELECT c FROM Clients c WHERE c.pointsFidelite = :pointsFidelite"),
        @NamedQuery(name = "Clients.findByNiveauFidelite", query = "SELECT c FROM Clients c WHERE c.niveauFidelite = :niveauFidelite"),
        @NamedQuery(name = "Clients.findByStatut", query = "SELECT c FROM Clients c WHERE c.statut = :statut"),
        @NamedQuery(name = "Clients.findByDateInscription", query = "SELECT c FROM Clients c WHERE c.dateInscription = :dateInscription"),
        @NamedQuery(name = "Clients.findByDateModification", query = "SELECT c FROM Clients c WHERE c.dateModification = :dateModification")})
public class Clients implements Serializable {

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
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "date_naissance")
    @Temporal(TemporalType.DATE)
    private Date dateNaissance;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "ville")
    private String ville;
    @Basic(optional = false)
    @Column(name = "points_fidelite")
    private int pointsFidelite;
    @Basic(optional = false)
    @Column(name = "niveau_fidelite")
    private String niveauFidelite;
    @Basic(optional = false)
    @Column(name = "statut")
    private String statut;
    @Basic(optional = false)
    @Column(name = "date_inscription")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateInscription;
    @Column(name = "date_modification")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModification;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId")
    private Collection<Commandes> commandesCollection;
    @JoinColumn(name = "restaurant_habituel", referencedColumnName = "id")
    @ManyToOne
    private Restaurants restaurantHabituel;
    @JoinColumn(name = "cree_par", referencedColumnName = "id")
    @ManyToOne
    private Utilisateurs creePar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientId")
    private Collection<Reclamations> reclamationsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clients")
    private Collection<CampagnesClients> campagnesClientsCollection;

    public Clients() {
    }

    public Clients(Long id) {
        this.id = id;
    }

    public Clients(Long id, String nom, String prenom, String telephone, int pointsFidelite, String niveauFidelite, String statut, Date dateInscription) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.pointsFidelite = pointsFidelite;
        this.niveauFidelite = niveauFidelite;
        this.statut = statut;
        this.dateInscription = dateInscription;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getPointsFidelite() {
        return pointsFidelite;
    }

    public void setPointsFidelite(int pointsFidelite) {
        this.pointsFidelite = pointsFidelite;
    }

    public String getNiveauFidelite() {
        return niveauFidelite;
    }

    public void setNiveauFidelite(String niveauFidelite) {
        this.niveauFidelite = niveauFidelite;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
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

    public Restaurants getRestaurantHabituel() {
        return restaurantHabituel;
    }

    public void setRestaurantHabituel(Restaurants restaurantHabituel) {
        this.restaurantHabituel = restaurantHabituel;
    }

    public Utilisateurs getCreePar() {
        return creePar;
    }

    public void setCreePar(Utilisateurs creePar) {
        this.creePar = creePar;
    }

    public Collection<Reclamations> getReclamationsCollection() {
        return reclamationsCollection;
    }

    public void setReclamationsCollection(Collection<Reclamations> reclamationsCollection) {
        this.reclamationsCollection = reclamationsCollection;
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
        if (!(object instanceof Clients)) {
            return false;
        }
        Clients other = (Clients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cmr_savoirmanger.Clients[ id=" + id + " ]";
    }

}

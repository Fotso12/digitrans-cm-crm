package agritrans.demo.entities;

@Entity
@Table(name = "restaurants")
@NamedQueries({
    @NamedQuery(name = "Restaurants.findAll", query = "SELECT r FROM Restaurants r"),
    @NamedQuery(name = "Restaurants.findById", query = "SELECT r FROM Restaurants r WHERE r.id = :id"),
    @NamedQuery(name = "Restaurants.findByNom", query = "SELECT r FROM Restaurants r WHERE r.nom = :nom"),
    @NamedQuery(name = "Restaurants.findByVille", query = "SELECT r FROM Restaurants r WHERE r.ville = :ville"),
    @NamedQuery(name = "Restaurants.findByAdresse", query = "SELECT r FROM Restaurants r WHERE r.adresse = :adresse"),
    @NamedQuery(name = "Restaurants.findByTelephone", query = "SELECT r FROM Restaurants r WHERE r.telephone = :telephone"),
    @NamedQuery(name = "Restaurants.findByActif", query = "SELECT r FROM Restaurants r WHERE r.actif = :actif"),
    @NamedQuery(name = "Restaurants.findByDateCreation", query = "SELECT r FROM Restaurants r WHERE r.dateCreation = :dateCreation")})
public class Restaurants implements Serializable {

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
    @Column(name = "ville")
    private String ville;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "telephone")
    private String telephone;
    @Basic(optional = false)
    @Column(name = "actif")
    private boolean actif;
    @Basic(optional = false)
    @Column(name = "date_creation")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurantId")
    private Collection<Commandes> commandesCollection;
    @OneToMany(mappedBy = "restaurantHabituel")
    private Collection<Clients> clientsCollection;

    public Restaurants() {
    }

    public Restaurants(Long id) {
        this.id = id;
    }

    public Restaurants(Long id, String nom, String ville, boolean actif, Date dateCreation) {
        this.id = id;
        this.nom = nom;
        this.ville = ville;
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

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public Collection<Commandes> getCommandesCollection() {
        return commandesCollection;
    }

    public void setCommandesCollection(Collection<Commandes> commandesCollection) {
        this.commandesCollection = commandesCollection;
    }

    public Collection<Clients> getClientsCollection() {
        return clientsCollection;
    }

    public void setClientsCollection(Collection<Clients> clientsCollection) {
        this.clientsCollection = clientsCollection;
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
        if (!(object instanceof Restaurants)) {
            return false;
        }
        Restaurants other = (Restaurants) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cmr_savoirmanger.Restaurants[ id=" + id + " ]";
    }
    
}

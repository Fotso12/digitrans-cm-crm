package agritrans.demo.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "campagnes_clients")
@NamedQueries({
        @NamedQuery(name = "CampagnesClients.findAll", query = "SELECT c FROM CampagnesClients c"),
        @NamedQuery(name = "CampagnesClients.findByCampagneId", query = "SELECT c FROM CampagnesClients c WHERE c.campagnesClientsPK.campagneId = :campagneId"),
        @NamedQuery(name = "CampagnesClients.findByClientId", query = "SELECT c FROM CampagnesClients c WHERE c.campagnesClientsPK.clientId = :clientId"),
        @NamedQuery(name = "CampagnesClients.findByDateAjout", query = "SELECT c FROM CampagnesClients c WHERE c.dateAjout = :dateAjout")})
public class CampagnesClients implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CampagnesClientsPK campagnesClientsPK;
    @Basic(optional = false)
    @Column(name = "date_ajout")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAjout;
    @JoinColumn(name = "campagne_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Campagnes campagnes;
    @JoinColumn(name = "client_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clients clients;

    public CampagnesClients() {
    }

    public CampagnesClients(CampagnesClientsPK campagnesClientsPK) {
        this.campagnesClientsPK = campagnesClientsPK;
    }

    public CampagnesClients(CampagnesClientsPK campagnesClientsPK, Date dateAjout) {
        this.campagnesClientsPK = campagnesClientsPK;
        this.dateAjout = dateAjout;
    }

    public CampagnesClients(long campagneId, long clientId) {
        this.campagnesClientsPK = new CampagnesClientsPK(campagneId, clientId);
    }

    public CampagnesClientsPK getCampagnesClientsPK() {
        return campagnesClientsPK;
    }

    public void setCampagnesClientsPK(CampagnesClientsPK campagnesClientsPK) {
        this.campagnesClientsPK = campagnesClientsPK;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public Campagnes getCampagnes() {
        return campagnes;
    }

    public void setCampagnes(Campagnes campagnes) {
        this.campagnes = campagnes;
    }

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (campagnesClientsPK != null ? campagnesClientsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CampagnesClients)) {
            return false;
        }
        CampagnesClients other = (CampagnesClients) object;
        if ((this.campagnesClientsPK == null && other.campagnesClientsPK != null) || (this.campagnesClientsPK != null && !this.campagnesClientsPK.equals(other.campagnesClientsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cmr_savoirmanger.CampagnesClients[ campagnesClientsPK=" + campagnesClientsPK + " ]";
    }

}

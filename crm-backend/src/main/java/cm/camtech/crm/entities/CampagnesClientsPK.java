package cm.camtech.crm.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CampagnesClientsPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "campagne_id")
    private long campagneId;
    @Basic(optional = false)
    @Column(name = "client_id")
    private long clientId;

    public CampagnesClientsPK() {
    }

    public CampagnesClientsPK(long campagneId, long clientId) {
        this.campagneId = campagneId;
        this.clientId = clientId;
    }

    public long getCampagneId() {
        return campagneId;
    }

    public void setCampagneId(long campagneId) {
        this.campagneId = campagneId;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) campagneId;
        hash += (int) clientId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CampagnesClientsPK)) {
            return false;
        }
        CampagnesClientsPK other = (CampagnesClientsPK) object;
        if (this.campagneId != other.campagneId) {
            return false;
        }
        if (this.clientId != other.clientId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cmr_savoirmanger.CampagnesClientsPK[ campagneId=" + campagneId + ", clientId=" + clientId + " ]";
    }

}

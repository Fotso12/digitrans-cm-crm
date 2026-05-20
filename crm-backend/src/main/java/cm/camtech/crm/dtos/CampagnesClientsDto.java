package cm.camtech.crm.dtos;

import java.util.Date;

public class CampagnesClientsDto {

    private Long campagneId;
    private Long clientId;
    private Date dateAjout;

    public CampagnesClientsDto() {
    }

    public Long getCampagneId() {
        return campagneId;
    }

    public void setCampagneId(Long campagneId) {
        this.campagneId = campagneId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    // getters et setters


    public CampagnesClientsDto(Long campagneId, Long clientId, Date dateAjout) {
        this.campagneId = campagneId;
        this.clientId = clientId;
        this.dateAjout = dateAjout;
    }
}
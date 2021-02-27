/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.gov.health.drugservice;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import lk.gov.health.drugservice.enums.LogAction;

/**
 *
 * @author user
 */
@Entity
@XmlRootElement
public class DrugLog implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String logEntity;
    @Enumerated(EnumType.STRING)
    private LogAction logAction;
    private String description;
    private Long triggeredBy;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date triggeredAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof DrugLog)) {
            return false;
        }
        DrugLog other = (DrugLog) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lk.gov.health.drugservice.DrugLog[ id=" + id + " ]";
    }

    public String getLogEntity() {
        return logEntity;
    }

    public void setLogEntity(String logEntity) {
        this.logEntity = logEntity;
    }

    public LogAction getLogAction() {
        return logAction;
    }

    public void setLogAction(LogAction logAction) {
        this.logAction = logAction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTriggeredBy() {
        return triggeredBy;
    }

    public void setTriggeredBy(Long triggeredBy) {
        this.triggeredBy = triggeredBy;
    }

    public Date getTriggeredAt() {
        return triggeredAt;
    }

    public void setTriggeredAt(Date triggeredAt) {
        this.triggeredAt = triggeredAt;
    }
    
}

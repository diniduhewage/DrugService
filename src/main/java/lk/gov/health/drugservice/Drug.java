/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.gov.health.drugservice;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;
import lk.gov.health.drugservice.enums.DosageUnit;
import lk.gov.health.drugservice.enums.RouteMethod;

/**
 *
 * @author user
 */
@Entity
@XmlRootElement
public class Drug implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String drugId;
    private String drugName;
    @ManyToOne
    private DrugGroup drugGroup;
    @ManyToOne
    private DrugGroup subGroup;
    @Enumerated(EnumType.STRING)
    private RouteMethod routeMethod;
    private Double defaultDosage;
    @Enumerated(EnumType.STRING)
    private DosageUnit dosageUnit;
    @ManyToOne
    private InventoryUnit inventoryUnit;
    @ManyToOne
    private DrugFrequency defFrequency;
    @ManyToOne
    private UsageDuration defDuration;
    private boolean active;
    private boolean retired;
    
    
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
        if (!(object instanceof Drug)) {
            return false;
        }
        Drug other = (Drug) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lk.gov.health.drugservice.Drug[ id=" + id + " ]";
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }  

    public DosageUnit getDosageUnit() {
        return dosageUnit;
    }

    public void setDosageUnit(DosageUnit dosageUnit) {
        this.dosageUnit = dosageUnit;
    }

    public InventoryUnit getInventoryUnit() {
        return inventoryUnit;
    }

    public void setInventoryUnit(InventoryUnit inventoryUnit) {
        this.inventoryUnit = inventoryUnit;
    }    

    public DrugGroup getDrugGroup() {
        return drugGroup;
    }

    public void setDrugGroup(DrugGroup drugGroup) {
        this.drugGroup = drugGroup;
    }

    public DrugGroup getSubGroup() {
        return subGroup;
    }

    public void setSubGroup(DrugGroup subGroup) {
        this.subGroup = subGroup;
    }

    public RouteMethod getRouteMethod() {
        return routeMethod;
    }

    public void setRouteMethod(RouteMethod routeMethod) {
        this.routeMethod = routeMethod;
    }

    public DrugFrequency getDefFrequency() {
        return defFrequency;
    }

    public void setDefFrequency(DrugFrequency defFrequency) {
        this.defFrequency = defFrequency;
    }

    public UsageDuration getDefDuration() {
        return defDuration;
    }

    public void setDefDuration(UsageDuration defDuration) {
        this.defDuration = defDuration;
    }

    public Double getDefaultDosage() {
        return defaultDosage;
    }

    public void setDefaultDosage(Double defaultDosage) {
        this.defaultDosage = defaultDosage;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isRetired() {
        return retired;
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }
    
}

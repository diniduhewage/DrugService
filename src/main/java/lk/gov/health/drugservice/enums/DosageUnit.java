/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.gov.health.drugservice.enums;

/**
 *
 * @author user
 */
public enum DosageUnit {
    mg("mg"),
    ml("ml");
    
    private final String label;    
    private DosageUnit(String label){
        this.label = label;
    }
    
    public String getLabel(){
        return label;
    }
}

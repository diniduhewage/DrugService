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
public enum RouteMethod {
    ORAL("Oral"),
    IM("IM"),
    SC("SC"),
    RECTALLY("Rectally"),
    LA("LA"),
    NEBULIZE("Nebulize"),
    VAGINALLY("Vaginally"),
    EYE("Eye"),
    EAR("Ear"),
    NOSE("Nose"),
    INHALE("Inhale"),
    SUB_LINGUAL("Sub Lingual");
    
    private final String label;    
    private RouteMethod(String label){
        this.label = label;
    }    
    public String getLabel(){
        return label;
    }
}

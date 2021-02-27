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
public enum LogAction {
    CREATE("Create"),
    EDIT("Edit"),
    ACTIVATE("Activate"),
    DEACTIVATE("Deactivate"),
    RETIRE("Retire");
    
    private final String label;    
    private LogAction(String label){
        this.label = label;
    }
    
    public String getLabel(){
        return label;
    }
}

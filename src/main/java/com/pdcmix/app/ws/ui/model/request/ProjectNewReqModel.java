package com.pdcmix.app.ws.ui.model.request;

public class ProjectNewReqModel {
    private String name;
    private String description;
    private Boolean open;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Boolean getOpen() {
        return open;
    }
    public void setOpen(Boolean open) {
        this.open = open;
    }

}

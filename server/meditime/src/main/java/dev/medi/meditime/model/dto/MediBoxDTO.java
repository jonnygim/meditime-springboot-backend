package dev.medi.meditime.model.dto;

import dev.medi.meditime.model.entity.MediBox;

public class MediBoxDTO {
    private String userId;
    private String itemName;

    public MediBoxDTO(MediBox mediBox) {
        this.userId = mediBox.getUserId();
        this.itemName = mediBox.getItemName();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
       
}

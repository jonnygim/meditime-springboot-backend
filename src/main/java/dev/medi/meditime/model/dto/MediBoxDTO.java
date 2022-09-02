package dev.medi.meditime.model.dto;

import dev.medi.meditime.model.entity.MediBox;

public class MediBoxDTO {
    private Long id;
    private String userId;
    private String itemName;

    public MediBoxDTO(MediBox mediBox) {
        this.id = mediBox.getId();
        this.userId = mediBox.getUserId();
        this.itemName = mediBox.getItemName();
    }

    public MediBoxDTO() {};

    public MediBoxDTO(String itemName, String userId) {
        this.itemName = itemName;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

package com.plus120.meditime.dto;

import com.plus120.meditime.domain.MedicineBox;

public class MediBoxDTO {
    private Long id;
    private String userId;
    private String itemName;

    public MediBoxDTO(MedicineBox medicineBox) {
        this.id = medicineBox.getId();
        this.userId = medicineBox.getUserId();
        this.itemName = medicineBox.getItemName();
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

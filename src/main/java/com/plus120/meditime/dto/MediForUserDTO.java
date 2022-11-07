package com.plus120.meditime.dto;

public class MediForUserDTO {
    private String itemName;
    private String itemImage;

    public MediForUserDTO() {};

    public MediForUserDTO(MediForUser m) {
        this.itemName = m.getItemName();
        this.itemImage = m.getItemImage();
    }

    public MediForUserDTO(String itemName, String itemImage) {
        this.itemName = itemName;
        this.itemImage = itemImage;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getItemImage() {
        return itemImage;
    }
    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

}

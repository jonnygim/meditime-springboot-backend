package dev.medi.meditime.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medicine")
public class MediForUser {

    @Id
    @Column(name="item_name")
    private String itemName;

    @Column(name="item_image")
    private String itemImage;
    
    public MediForUser() {};

    public MediForUser(String itemName, String itemImage) {
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

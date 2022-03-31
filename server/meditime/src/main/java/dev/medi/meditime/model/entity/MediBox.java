package dev.medi.meditime.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="medicinebox")
public class MediBox {

    @Column(name="user_id")
    private String userId;

    @Column(name="item_name")
    private String itemName;

    public MediBox() {}

    public MediBox(String userId, String itemName) {
        this.userId = userId;
        this.itemName = itemName;
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

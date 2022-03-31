package dev.medi.meditime.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MEDICINE")
public class Medi {
    
    @Id
    @Column(name="item_name")
    private String itemName;

    @Column(name="entp_name")
    private String entpName;

    @Column(name="efc_item")
    private String efcItem;
    
    @Column(name="meth_item")
    private String methItem;
    
    @Column(name="warn_item")
    private String warnItem;
    
    @Column(name="atpn_item")
    private String atpnItem;
    
    @Column(name="intr_item")
    private String intrItem;
    
    @Column(name="se_item")
    private String seItem;
   
    @Column(name="depo_item")
    private String depoItem;
    
    @Column(name="item_image")
    private String itemImage;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public String getEfcItem() {
        return efcItem;
    }

    public void setEfcItem(String efcItem) {
        this.efcItem = efcItem;
    }

    public String getMethItem() {
        return methItem;
    }

    public void setMethItem(String methItem) {
        this.methItem = methItem;
    }

    public String getWarnItem() {
        return warnItem;
    }

    public void setWarnItem(String warnItem) {
        this.warnItem = warnItem;
    }

    public String getAtpnItem() {
        return atpnItem;
    }

    public void setAtpnItem(String atpnItem) {
        this.atpnItem = atpnItem;
    }

    public String getIntrItem() {
        return intrItem;
    }

    public void setIntrItem(String intrItem) {
        this.intrItem = intrItem;
    }

    public String getSeItem() {
        return seItem;
    }

    public void setSeItem(String seItem) {
        this.seItem = seItem;
    }

    public String getDepoItem() {
        return depoItem;
    }

    public void setDepoItem(String depoItem) {
        this.depoItem = depoItem;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

}

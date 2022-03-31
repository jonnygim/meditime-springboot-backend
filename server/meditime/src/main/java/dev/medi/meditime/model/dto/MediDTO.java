package dev.medi.meditime.model.dto;

import dev.medi.meditime.model.entity.Medi;

public class MediDTO {

    private String itemName;
    private String entpName;
    private String efcItem;
    private String methItem;
    private String warnItem;
    private String atpnItem;
    private String intrItem;
    private String seItem;
    private String depoItem;
    private String itemImage;
    
    public MediDTO(String itemName, String entpName, String efcItem, String methItem, String warnItem, String atpnItem,
            String intrItem, String seItem, String depoItem, String itemImage) {
        this.itemName = itemName;
        this.entpName = entpName;
        this.efcItem = efcItem;
        this.methItem = methItem;
        this.warnItem = warnItem;
        this.atpnItem = atpnItem;
        this.intrItem = intrItem;
        this.seItem = seItem;
        this.depoItem = depoItem;
        this.itemImage = itemImage;
    }

    public MediDTO(Medi r) {
        this.itemName = r.getItemName();
        this.entpName = r.getEntpName();
        this.efcItem = r.getEfcItem();
        this.methItem = r.getMethItem();
        this.warnItem = r.getWarnItem();
        this.atpnItem = r.getAtpnItem();
        this.intrItem = r.getIntrItem();
        this.seItem = r.getSeItem();
        this.depoItem = r.getDepoItem();
        this.itemImage = r.getItemImage();


        // this.id = book.getId();
        // this.name = book.getName();
        // this.description = book.getDescription();
        // this.author = book.getAuthor();
        // this.price = book.getPrice();
    }

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

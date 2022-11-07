package com.plus120.meditime.dto;

import com.plus120.meditime.domain.Medicine;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MedicineDTO {

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
    
    public MedicineDTO(String itemName, String entpName, String efcItem, String methItem, String warnItem, String atpnItem,
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

    public MedicineDTO(Medicine r) {
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
    }

    public MedicineDTO(String itemName, String itemImage) {
        this.itemName = itemName;
        this.itemImage = itemImage;
    }

}

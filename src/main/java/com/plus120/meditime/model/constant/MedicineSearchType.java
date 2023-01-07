package com.plus120.meditime.model.constant;

import lombok.Getter;

public enum MedicineSearchType {

    ITEMNAME("이름"),
    ITEMEFCY("효능"),
    ITEMUSEMETHOD("사용법"),
    ITEMATPN("주의사항"),
    ITEMATPNWARN("경고"),
    ITEMINTRC("상호작용"),
    ITEMSE("부작용"),
    ITEMIMAGE("사진");

    @Getter private final String description;
    MedicineSearchType(String description) {
        this.description = description;
    }

}

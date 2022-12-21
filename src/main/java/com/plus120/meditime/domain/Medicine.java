package com.plus120.meditime.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "itemName"),
        @Index(columnList = "entpName"),
        @Index(columnList = "itemEfcy"),
        @Index(columnList = "itemUseMethod"),
        @Index(columnList = "itemAtpnWarn"),
        @Index(columnList = "itemAtpn"),
        @Index(columnList = "itemIntrc"),
        @Index(columnList = "itemSe"),
        @Index(columnList = "itemDepositMethod"),
        @Index(columnList = "itemImage")
})
@Entity
public class Medicine {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ToString.Exclude
    @OrderBy("id")
    @OneToMany(mappedBy = "medicine")
    private final Set<MedicineBox> medicineBoxes = new LinkedHashSet<>();

    @Setter @Column(nullable = false) private String itemName;
    @Setter @Column(nullable = false) private String entpName;
    @Setter @Column(nullable = false) private String itemEfcy;
    @Setter @Column(nullable = false) private String itemUseMethod;
    @Setter @Column(nullable = false) private String itemAtpnWarn;
    @Setter @Column(nullable = false) private String itemAtpn;
    @Setter @Column(nullable = false) private String itemIntrc;
    @Setter @Column(nullable = false) private String itemSe;
    @Setter @Column(nullable = false) private String itemDepositMethod;
    @Setter @Column(nullable = false) private String itemImage;

    protected Medicine() {}

    private Medicine(String itemName, String entpName, String itemEfcy, String itemUseMethod, String itemAtpnWarn, String itemAtpn, String itemIntrc, String itemSe, String itemDepositMethod, String itemImage) {
        this.itemName = itemName;
        this.entpName = entpName;
        this.itemEfcy = itemEfcy;
        this.itemUseMethod = itemUseMethod;
        this.itemAtpnWarn = itemAtpnWarn;
        this.itemAtpn = itemAtpn;
        this.itemIntrc = itemIntrc;
        this.itemSe = itemSe;
        this.itemDepositMethod = itemDepositMethod;
        this.itemImage = itemImage;
    }

    public static Medicine of(String itemName, String entpName, String itemEfcy, String itemUseMethod, String itemAtpnWarn, String itemAtpn, String itemIntrc, String itemSe, String itemDepositMethod, String itemImage) {
        return new Medicine(itemName, entpName, itemEfcy, itemUseMethod, itemAtpnWarn, itemAtpn, itemIntrc, itemSe, itemDepositMethod, itemImage);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Medicine medicine)) return false;
        return id !=null && id.equals(medicine.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}

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
        @Index(columnList = "item_name"),
        @Index(columnList = "entp_name"),
        @Index(columnList = "efc_name"),
        @Index(columnList = "meth_name"),
        @Index(columnList = "warn_name"),
        @Index(columnList = "atpn_name"),
        @Index(columnList = "intr_name"),
        @Index(columnList = "se_name"),
        @Index(columnList = "depo_name"),
        @Index(columnList = "item_image")
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
    @Setter @Column(nullable = false) private String efcItem;
    @Setter @Column(nullable = false) private String methItem;
    @Setter @Column(nullable = false) private String warnItem;
    @Setter @Column(nullable = false) private String atpnItem;
    @Setter @Column(nullable = false) private String intrItem;
    @Setter @Column(nullable = false) private String seItem;
    @Setter @Column(nullable = false) private String depoItem;
    @Setter @Column(nullable = false) private String itemImage;

    protected Medicine() {}

    private Medicine(String itemName, String entpName, String efcItem, String methItem, String warnItem, String atpnItem, String intrItem, String seItem, String depoItem, String itemImage) {
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

    public static Medicine of(String itemName, String entpName, String efcItem, String methItem, String warnItem, String atpnItem, String intrItem, String seItem, String depoItem, String itemImage) {
        return new Medicine(itemName, entpName, efcItem, methItem, warnItem, atpnItem, intrItem, seItem, depoItem, itemImage);
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

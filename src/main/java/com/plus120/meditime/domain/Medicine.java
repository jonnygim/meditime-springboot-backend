package com.plus120.meditime.domain;

import javax.persistence.*;

@Entity
@Table(name="medicine")
public class Medicine {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

}

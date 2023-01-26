package com.plus120.meditime.model;

import com.plus120.meditime.model.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@Entity
public class MedicineBox {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;


    @Setter @ManyToOne(optional = false) private Medicine medicine; // 약 정보 (ID)
    @Setter @ManyToOne(optional = false) private UserEntity userEntity; // 유저 정보 (ID)

    @CreatedDate @Column(nullable = false) private LocalDateTime createdAt; // 생성일시
    @CreatedBy @Column(nullable = false, length = 100) private String createdBy; // 생성자
    @LastModifiedDate @Column(nullable = false) private LocalDateTime modifiedAt; // 수정일시
    @LastModifiedBy @Column(nullable = false, length = 100) private String modifiedBy; // 수정자

    protected MedicineBox() {}

    private MedicineBox(Medicine medicine, UserEntity userEntity) {
        this.medicine = medicine;
        this.userEntity = userEntity;
    }

    public static MedicineBox of(Medicine medicine, UserEntity userEntity) {
        return new MedicineBox(medicine, userEntity);
    }

}

package com.plus120.meditime.model;

import com.plus120.meditime.model.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createdAt"),
        @Index(columnList = "createdBy")
})
@EntityListeners(AuditingEntityListener.class)
@Entity
public class ArticleComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Setter @ManyToOne(optional = false) private Article article; // 게시글 (ID)
    @Setter @ManyToOne(optional = false) private UserEntity userEntity; // 유저 정보 (ID)
    @Setter @Column(nullable = false, length = 500) private String content;

    @CreatedDate @Column(nullable = false) private LocalDateTime createdAt; // 생성일시
    @CreatedBy @Column(nullable = false, length = 100) private String createdBy; // 생성자
    @LastModifiedDate @Column(nullable = false) private LocalDateTime modifiedAt; // 수정일시
    @LastModifiedBy @Column(nullable = false, length = 100) private String modifiedBy; // 수정자

    protected ArticleComment() {}

    private ArticleComment(Article article, UserEntity userEntity, String content) {
        this.article = article;
        this.userEntity = userEntity;
        this.content = content;
    }

    public static ArticleComment of(Article article, UserEntity userEntity, String content) {
        return new ArticleComment(article, userEntity, content);
    }

}

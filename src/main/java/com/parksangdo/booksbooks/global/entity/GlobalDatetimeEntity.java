package com.parksangdo.booksbooks.global.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * <b>생성,수정 정보 엔티티 공통부분</b>
 * <p>
 * * @see <a href=
 * *      "https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#auditing.basics">JPA AUDIT</a>
 * </p>
 *
 * @author sangdo.park
 * @since 2023/06/08
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class GlobalDatetimeEntity implements Serializable {

    @JsonIgnore
    private static final long serialVersionUID = 1L;

    /**
     * 생성한 사용자(Actor Id) :
     */
    @CreatedBy
    @Setter
    @Column(updatable = false, length = 36, columnDefinition = "VARCHAR(36) COMMENT '생성자'")
    protected String createdBy;

    /**
     * 생성 년월일시분초
     */
    @CreationTimestamp
    @ApiModelProperty(notes = "생성 일시")
    @Column(nullable = false, updatable = false, columnDefinition = "DATETIME(6) COMMENT '생성 일시'")
    protected ZonedDateTime createdAt;

    /**
     * 갱신한 사용자 :
     */
    @LastModifiedBy
    @Column(length = 36, columnDefinition = "VARCHAR(36) COMMENT '수정자'")
    protected String updatedBy;

    /**
     * 갱신 년월일시분초
     */
    @UpdateTimestamp
    @ApiModelProperty(notes = "수정 일시")
    @Column(nullable = true, columnDefinition = "DATETIME(6) COMMENT '수정 일시'")
    protected ZonedDateTime updatedAt;

}

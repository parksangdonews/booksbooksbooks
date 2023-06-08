package com.parksangdo.booksbooks.global.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

/**
 * <b>삭제처리 관련 엔티티 기본설정</b>
 * <p>
 * isDeleted
 * </p>
 *
 * @author
 * @since 2023/06/08
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class GlobalDeletedDatetimeEntity extends GlobalDatetimeEntity {

    @Column(columnDefinition = "BIT(1) COMMENT '삭제 여부'")
    @ApiModelProperty(notes = "삭제 여부")
    protected Boolean isDeleted = false;

    public void remove() {
        this.isDeleted = true;
    }

    public void restore() {
        this.isDeleted = false;
    }
}

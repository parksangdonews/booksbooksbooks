package com.parksangdo.booksbooks.api.entity;

import com.parksangdo.booksbooks.global.entity.GlobalDeletedDatetimeEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

/**
 * <b>회원 책 엔티티</b>
 * <p>
 * 회원 책 엔티티
 * </p>
 *
 * @author sangdo.park
 * @since 2023/06/08
 */
@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false, of = {"memberId", "bookDetailId"})
@ToString(exclude = {"memberId", "bookDetailId"})
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MemberBooksEntity extends GlobalDeletedDatetimeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 회원 ID <<memberId>> UUID2
     */
    @Id
    @Type(type = "uuid-char")
    @Column(columnDefinition = "CHAR(36) COMMENT '회원 ID'", updatable = false, nullable = false, unique = true, length = 36)
    @ApiModelProperty(notes = "회원 ID")
    @Length(min = 36, max = 36)
    private UUID memberId;

    /**
     * 책정보 ID <<memberId>> UUID2
     */
    @Id
    @Type(type = "uuid-char")
    @Column(columnDefinition = "CHAR(36) COMMENT '책정보 ID'", updatable = true, nullable = false, unique = false, length = 36)
    @ApiModelProperty(notes = "책정보 ID")
    @Length(min = 36, max = 36)
    private UUID bookDetailId;

    /**
     * ISBN <<isbn>>
     */
    @ApiModelProperty(notes = "ISBN")
    @Column(columnDefinition = "VARCHAR(16) COMMENT 'ISBN'", nullable = false, length = 16)
    private String isbn;

    /**
     * 보유갯수 <<bookCount>>
     */
    @ApiModelProperty(notes = "동일 책 보유 갯수")
    @Column(columnDefinition = "INTEGER COMMENT '동일 책 보유 갯수'", nullable = true)
    private Integer bookCount;

    /**
     * 별점 <<point>>
     */
    @ApiModelProperty(notes = "포인트")
    @Column(columnDefinition = "INTEGER COMMENT '포인트'", nullable = true)
    private Integer point;


}

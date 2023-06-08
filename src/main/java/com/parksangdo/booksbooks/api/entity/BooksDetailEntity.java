package com.parksangdo.booksbooks.api.entity;

import com.parksangdo.booksbooks.global.entity.GlobalDeletedDatetimeEntity;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.UUID;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

/**
 * <b>책 엔티티</b>
 * <p>
 * 책 엔티티
 * </p>
 *
 * @author sangdo.park
 * @since 2023/06/08
 */
@Data
@Entity(name = "BOOKS_DETAIL")
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@ToString(exclude = "bookDetailId")
@Cacheable
public class BooksDetailEntity extends GlobalDeletedDatetimeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 책 ID <<booksDetailId>> UUID2
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "CHAR(36) COMMENT '책 ID'", updatable = false, nullable = false, unique = true, length = 36)
    @ApiModelProperty(notes = "책 ID")
    @Length(min = 36, max = 36)
    private UUID booksDetailId;

    /**
     * ISBN <<isbn>>
     */
    @ApiModelProperty(notes = "ISBN")
    @Column(columnDefinition = "VARCHAR(16) COMMENT 'ISBN'", nullable = false, length = 16)
    private String isbn;

    /**
     * 제목 <<title>>
     */
    @ApiModelProperty(notes = "제목")
    @Column(columnDefinition = "VARCHAR(255) COMMENT '제목'", nullable = false, length = 255)
    private String title;

    /**
     * 책정보 URL <<bookUrl>>
     */
    @ApiModelProperty(notes = "책정보 URL")
    @Column(columnDefinition = "VARCHAR(255) COMMENT '책정보 URL'", nullable = true, length = 255)
    private String bookUrl;


    /**
     * 썸네일 URL <<bookImageUrl>>
     */
    @ApiModelProperty(notes = "썸네일 URL")
    @Column(columnDefinition = "VARCHAR(255) COMMENT '썸네일 URL'", nullable = true, length = 255)
    private String bookImageUrl;


    /**
     * 저자 <<author>>
     */
    @ApiModelProperty(notes = "저자")
    @Column(columnDefinition = "VARCHAR(255) COMMENT '저자'", nullable = false, length = 255)
    private String author;


    /**
     * 정가 <<price>>
     */
    @ApiModelProperty(notes = "정가")
    @Column(columnDefinition = "INTEGER COMMENT '정가'", nullable = true)
    private Integer price;

    /**
     * 할인가격 <<discount>>
     */
    @ApiModelProperty(notes = "할인가격")
    @Column(columnDefinition = "INTEGER COMMENT '할인가격'", nullable = true)
    private Integer discount;


    /**
     * 출판사정보 <<publisher>>
     */
    @ApiModelProperty(notes = "출판사정보")
    @Column(columnDefinition = "VARCHAR(255) COMMENT '출판사정보'", nullable = false, length = 255)
    private String publisher;


    /**
     * 책설명 <<description>>
     */
    @ApiModelProperty(notes = "책설명")
    @Column(columnDefinition = "MEDIUMTEXT COMMENT '책설명'", nullable = false)
    private String description;

    /**
     * 출간일 <<pubdate>>
     */
    @ApiModelProperty(notes = "출간일")
    @Column(columnDefinition = "TIMESTAMP COMMENT '출간일'")
    private ZonedDateTime pubdate;

    /**
     * 정보입력일시 <<lastBuildDate>>
     */
    @ApiModelProperty(notes = "정보입력일시")
    @Column(columnDefinition = "TIMESTAMP COMMENT '정보입력일시'")
    private ZonedDateTime lastBuildDate;


}

package com.parksangdo.booksbooks.api.entity;

import com.parksangdo.booksbooks.global.entity.GlobalDeletedDatetimeEntity;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.UUID;

/**
 * <b>회원 엔티티</b>
 * <p>
 * 회원 엔티티
 * </p>
 *
 * @author sangdo.park
 * @since 2023/06/08
 */
@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false, of = "memberId")
@ToString(exclude = {"memberId", "password"})
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class MemberEntity extends GlobalDeletedDatetimeEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 회원 ID <<memberId>> UUID2
     */
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(columnDefinition = "CHAR(36) COMMENT '회원 ID'", updatable = false, nullable = false, unique = true, length = 36)
    @ApiModelProperty(notes = "회원 ID")
    @Length(min = 36, max = 36)
    private UUID memberId;

    /**
     * 이메일 주소 <<emailAddr>>
     */
    @ApiModelProperty(notes = "이메일 주소")
    @Column(columnDefinition = "VARCHAR(50) COMMENT '이메일 주소'", nullable = true, length = 50)
    private String emailAddr;

    /**
     * 회원이름 <<memberName>>
     */
    @ApiModelProperty(notes = "회원 이름")
    @Column(columnDefinition = "VARCHAR(64) COMMENT '회원 이름'", nullable = false, length = 64)
    private String memberName;

    /**
     * 표시이름 <<memberNick>>
     */
    @ApiModelProperty(notes = "표시 이름")
    @Column(columnDefinition = "VARCHAR(64) COMMENT '표시 이름'", nullable = true, length = 64)
    private String memberNick;

    /**
     * 패스워드 <<password>>
     */
    @ApiModelProperty(notes = "패스워드")
    @Column(columnDefinition = "VARCHAR(255) COMMENT '패스워드'", nullable = false, length = 255)
    private String password;

    /**
     * 인증 여부 <<authYn>>
     */
    @ApiModelProperty(notes = "인증 여부")
    @Column(columnDefinition = "BIT(1) COMMENT '인증 여부'", nullable = true)
    @NotNull
    private Boolean authYn;

//    // 멤버 북스 테이블
//    /**
//     * 멤버북스 <<companyId>>
//     */
//    @ManyToOne(targetEntity = MemberBooksEntity.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "memberId", columnDefinition = "VARCHAR(36) COMMENT 'Member's books'", foreignKey = @ForeignKey(name = "FK_MemberBooks_booksDetailId", value = ConstraintMode.NO_CONSTRAINT))
//    @OnDelete(action = OnDeleteAction.NO_ACTION)
//    private MemberBoksEntity board;


}

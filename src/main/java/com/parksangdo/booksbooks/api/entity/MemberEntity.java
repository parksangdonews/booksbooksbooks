package com.parksangdo.booksbooks.api.entity;

import com.parksangdo.booksbooks.global.entity.GlobalDeletedDatetimeEntity;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

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
@Entity(name = "MEMBER")
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@ToString(exclude = {"memberId", "password"})
@Cacheable
public class MemberEntity extends GlobalDeletedDatetimeEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 회원 ID <<memberId>> UUID2
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "CHAR(36) COMMENT '회원 ID'", updatable = false, nullable = false, unique = true, length = 36)
    @ApiModelProperty(notes = "회원 ID")
    @Length(min = 36, max = 36)
    private UUID memberId;
    /**
     * 이메일 주소 <<emailAddr>>
     */
    @Column(name = "email_addr")
    @ApiModelProperty(notes = "이메일 주소")
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
     * 휴대전화번호<<phoneNumber>>
     */
    @ApiModelProperty(notes = "휴대전화번호")
    @Column(columnDefinition = "VARCHAR(13) COMMENT '휴대전화번호'", nullable = true, length = 13)
    private String phoneNumber;
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

    @Builder
    public MemberEntity(String emailAddr, String memberName, String memberNick,
        String password) {

        this.emailAddr = emailAddr;
        this.memberName = memberName;
        this.memberNick = memberNick;
        this.password = password;

    }

    @Builder
    public MemberEntity(String emailAddr, String memberName) {
        this.emailAddr = emailAddr;
        this.memberName = memberName;
    }

//    // 멤버 북스 테이블
//    /**
//     * 멤버북스 <<companyId>>
//     */
//    @ManyToOne(targetEntity = MemberBooksEntity.class, fetch = FetchType.LAZY)
//    @JoinColumn(name = "memberId", columnDefinition = "VARCHAR(36) COMMENT 'Member's books'", foreignKey = @ForeignKey(name = "FK_MemberBooks_booksDetailId", value = ConstraintMode.NO_CONSTRAINT))
//    @OnDelete(action = OnDeleteAction.NO_ACTION)
//    private MemberBoksEntity board;


}

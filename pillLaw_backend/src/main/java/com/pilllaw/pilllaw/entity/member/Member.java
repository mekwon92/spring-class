package com.pilllaw.pilllaw.entity.member;

import com.pilllaw.pilllaw.entity.BaseEntity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_member")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mno;

    @Column(nullable = false, length = 500)
    private String email;

    @Column(nullable = false, length = 500)
    private String password;

    @Column(nullable = false, length = 500)
    private String name;

    @Column(nullable = false, length = 500)
    private String nickname;

    @Column(nullable = false, length = 500)
    private String tel;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MemberRole memberRole;

    @Column(nullable = false)
    private Boolean firstLogin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MemberStatus status;

    public enum AccountType {
        SOCIAL, NORMAL
    }

    public enum MemberRole {
        ADMIN, USER, SUBSCRIBER
    }

    public enum MemberStatus {
        LOCKED, DELETED, VERIFIED, SUSPENDED, INACTIVE
    }
}
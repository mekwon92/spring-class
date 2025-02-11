package com.pilllaw.pilllaw.dto.member;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {

    private Long mno;
    private String email;
    private String password;
    private String name;
    private String nickname;
    private String tel;
    private String accountType;
    private String memberRole;
    private Boolean firstLogin;
    private String status;
}
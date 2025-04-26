package com.grepp.coffee.app.model.member.mapper;

import com.grepp.coffee.app.model.member.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {

    // 회원 조회
    MemberDto selectByEmail(@Param("email") String email);

    // 이메일 중복 확인
    boolean existsByEmail(@Param("email") String email);

    // 회원 등록
    int insertMember(MemberDto memberDto);

    // 회원 정보 수정 (비밀번호, 주소, 우편번호)
    int updateMemberInfo(
        @Param("email") String email,
        @Param("password") String password,
        @Param("address") String address,
        @Param("postNum") Integer postNum
    );

    // 회원 활성화
    int enableMember(@Param("email") String email);

    // 주소 수정
    boolean updateAddressByEmail(@Param("email") String email, @Param("address") String address);
}

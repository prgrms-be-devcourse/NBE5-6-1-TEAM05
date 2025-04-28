package com.grepp.coffee.app.model.member;


import com.grepp.coffee.app.model.member.dto.MemberDto;
import com.grepp.coffee.app.model.member.mapper.MemberMapper;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    private final MemberMapper memberMapper;

    @Autowired
    public MemberRepository(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    // 회원 조회
    public Optional<MemberDto> selectByEmail(String email) {
        return Optional.ofNullable(memberMapper.selectByEmail(email));
    }

    // 중복 확인
    public boolean existsByEmail(String email) {
        return memberMapper.existsByEmail(email);
    }

    // 회원 등록
    public boolean insertMember(MemberDto dto) {
        return memberMapper.insertMember(dto) > 0;
    }

    // 회원 정보 수정 (동적 SQL)
    public boolean updateMemberInfo(MemberDto dto) {
        return memberMapper.updateMemberInfo(dto.getEmail(), dto.getPassword(), dto.getAddress(), dto.getPostNum()) > 0;
    }

    // 계정 활성화
    public boolean enableMember(String email) {
        return memberMapper.enableMember(email) > 0;
    }

    // 회원의 주소를 수정
    public boolean updateAddress(String email, String address, int postNum) {
        return memberMapper.updateAddress(email, address, postNum);
    }
}

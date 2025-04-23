package com.grepp.coffee.app.model.repository;


import com.grepp.coffee.app.model.dto.MemberDto;
import java.util.Optional;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberRepository {

    Optional<MemberDto> selectByEmail(String userEmail);

    @Select("select count(*) from member where EMAIL = #{email}")
    Boolean existsMember(String userId);

    @Insert("insert into member (EMAIL, PASSWORD, ADDRESS, POST_NUM, ROLE, ENABLED) "
        + "values(#{email}, #{password}, #{address}, #{postNum}, #{role}, #{enabled})")
    void insert(MemberDto dto);
}

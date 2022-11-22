package com.ssafy.vue.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.vue.model.MemberDto;
import com.ssafy.vue.model.SecDto;

@Mapper
public interface MemberMapper {

	public MemberDto login(MemberDto memberDto) throws SQLException;
	public MemberDto userInfo(String userid) throws SQLException;
	public void saveRefreshToken(Map<String, String> map) throws SQLException;
	public Object getRefreshToken(String userid) throws SQLException;
	public void deleteRefreshToken(Map<String, String> map) throws SQLException;
	public int join(MemberDto m)throws SQLException;
	public void insertSecurity(SecDto sec) throws SQLException;
	public String isDelUser(String userid) throws SQLException;
	public SecDto selectSecurity(String userid) throws SQLException;

}

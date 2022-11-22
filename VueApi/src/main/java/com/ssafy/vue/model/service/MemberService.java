package com.ssafy.vue.model.service;

import com.ssafy.vue.model.MemberDto;
import com.ssafy.vue.model.SecDto;

public interface MemberService {

	public MemberDto login(MemberDto memberDto) throws Exception;
	public MemberDto userInfo(String userid) throws Exception;
	public void saveRefreshToken(String userid, String refreshToken) throws Exception;
	public Object getRefreshToken(String userid) throws Exception;
	public void deleRefreshToken(String userid) throws Exception;
	public int join(MemberDto m)throws Exception;
	public String isDelUser(String userid) throws Exception;
	public void insertSecurity(SecDto sec) throws Exception;
	public SecDto selectSecurity(String userid) throws Exception;
}

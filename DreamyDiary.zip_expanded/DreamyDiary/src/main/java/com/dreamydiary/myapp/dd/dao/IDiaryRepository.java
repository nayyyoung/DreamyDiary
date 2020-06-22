package com.dreamydiary.myapp.dd.dao;

import java.util.List;

import com.dreamydiary.myapp.dd.model.MemberVO;

public interface IDiaryRepository {
	public MemberVO getMemberInfo(String id);
	public void insertMemberInfo(MemberVO member);
	public List<MemberVO> getMemberList();
}

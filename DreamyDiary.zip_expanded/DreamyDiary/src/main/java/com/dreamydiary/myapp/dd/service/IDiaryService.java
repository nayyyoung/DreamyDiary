package com.dreamydiary.myapp.dd.service;

import java.util.List;

import com.dreamydiary.myapp.dd.model.MemberVO;

public interface IDiaryService {
	public MemberVO getMemberInfo(String id);
	public void insertMemberInfo(MemberVO member);
	public List<MemberVO> getMemberList();
}

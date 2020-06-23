package com.dreamydiary.myapp.dd.service;

import java.util.List;

import com.dreamydiary.myapp.dd.model.EventVO;
import com.dreamydiary.myapp.dd.model.MemberVO;

public interface IDiaryService {
	public MemberVO getMemberInfo(String id);
	public void insertMemberInfo(MemberVO member);
	public List<MemberVO> getTotalMember();
	void updateMemberInfo(MemberVO member);
	void deleteMemberInfo(String id, String password);
	List<EventVO> getEventList(String id);
	void insertEventInfo(EventVO event);
}

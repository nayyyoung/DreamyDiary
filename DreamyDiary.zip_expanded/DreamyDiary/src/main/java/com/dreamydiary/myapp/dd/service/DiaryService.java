package com.dreamydiary.myapp.dd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamydiary.myapp.dd.dao.IDiaryRepository;
import com.dreamydiary.myapp.dd.model.EventVO;
import com.dreamydiary.myapp.dd.model.MemberVO;

@Service
public class DiaryService implements IDiaryService{

	@Autowired
	IDiaryRepository repository;

	@Override
	public MemberVO getMemberInfo(String id) {
		return repository.getMemberInfo(id);
	}

	@Override
	public List<MemberVO> getTotalMember() {
		return repository.getTotalMember();
	}
	
	@Override
	public void insertMemberInfo(MemberVO member) {
		repository.insertMemberInfo(member);
	}
	
	@Override
	public void updateMemberInfo(MemberVO member) {
		repository.updateMemberInfo(member);
	}
	
	@Override
	public void deleteMemberInfo(String id, String password) {
		repository.deleteMemberInfo(id, password);
	}
	
	@Override
	public List<EventVO> getEventList(String id) {	
		return repository.getEventList(id);
	}
	
	@Override
	public void insertEventInfo(EventVO event) {
		repository.insertEventInfo(event);
	}
}

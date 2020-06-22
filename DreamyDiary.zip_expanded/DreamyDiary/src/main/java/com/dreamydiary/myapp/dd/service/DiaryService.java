package com.dreamydiary.myapp.dd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamydiary.myapp.dd.dao.IDiaryRepository;
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
	public List<MemberVO> getMemberList() {
		return repository.getMemberList();
	}
	
	@Override
	public void insertMemberInfo(MemberVO member) {
		repository.insertMemberInfo(member);
	}
	
	
}

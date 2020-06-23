package com.dreamydiary.myapp.dd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dreamydiary.myapp.dd.model.EventVO;
import com.dreamydiary.myapp.dd.model.MemberVO;

@Repository
public class DiaryRepository implements IDiaryRepository{

	@Autowired
	JdbcTemplate jdbcTemplate;

	private class MemberMapper implements RowMapper<MemberVO>{
		@Override
		public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberVO member = new MemberVO();
			member.setUserId(rs.getString("USERID"));
			member.setPassWord(rs.getString("PASSWORD")); 
			member.setName(rs.getString("NAME"));
			member.setPhoneNumber(rs.getString("PHONE")); 
			member.setEmail(rs.getString("EMAIL")); 
			member.setBirthDay(rs.getString("BIRTHDAY")); 
			member.setGender(rs.getString("GENDER")); 
			return member;
		}
	}
	
	private class EventMapper implements RowMapper<EventVO>{
		@Override
		public EventVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EventVO event = new EventVO();
			event.setUserId(rs.getString("USERID"));
			event.setTitle(rs.getString("TITLE")); 
			event.setStart(rs.getString("START_DATE"));
			event.setEnd(rs.getString("END_DATE")); 
			return event;
		}
	}
	
	@Override
	public MemberVO getMemberInfo(String id) {
		String sql = "SELECT USERID, PASSWORD, "
				+ "NAME, PHONE, EMAIL, BIRTHDAY, GENDER "
				+ "FROM MEMBER WHERE USERID=?";		
		return jdbcTemplate.queryForObject(sql, new MemberMapper(), id);
	}
	
	@Override
	public List<MemberVO> getTotalMember() {
		String sql = "SELECT * FROM MEMBER";
//		System.out.println("1");
//		System.out.println(jdbcTemplate.query(sql, new MemberMapper()));
		return jdbcTemplate.query(sql, new MemberMapper());
	}
	

	@Override
	public void insertMemberInfo(MemberVO member) {
		String sql = "INSERT INTO MEMBER (USERID, PASSWORD, "
				+ "NAME, PHONE, EMAIL, BIRTHDAY, GENDER) "
				+ "VALUES (?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql,  
				member.getUserId(), 
				member.getPassWord(), 
				member.getName(), 
				member.getPhoneNumber(), 
				member.getEmail(), 
				member.getBirthDay(), 
				member.getGender() 
		);
	}
	
	@Override
	public void updateMemberInfo(MemberVO member) {
		String sql = "UPDATE MEMBER SET"
				+ "PASSWORD=?, NAME=?, PHONE=?,"
				+ "EMAIL=?, BIRTHDAY=?, GENDER=? WHERE USERID=?";
		jdbcTemplate.update(sql,  
				member.getUserId(), 
				member.getPassWord(), 
				member.getName(), 
				member.getPhoneNumber(), 
				member.getEmail(), 
				member.getBirthDay(), 
				member.getGender() 
		);
	}
	
	@Override
	public void deleteMemberInfo(String id, String password) {
		String sql = "DELETE FROM MEMBER WHERE USERID=? AND PASSWORD=?";
		jdbcTemplate.update(sql, id, password);
	}
	
	@Override
	public List<EventVO> getEventList(String id) {
		String sql = "SELECT USERID, TITLE, "
				+ "START_DATE, END_DATE "
				+ "FROM EVENT WHERE USERID=?";		
		return jdbcTemplate.query(sql, new EventMapper(), id);
	}
	
	@Override
	public void insertEventInfo(EventVO event) {
		String sql = "INSERT INTO EVENT (USERID, TITLE, "
				+ "START_DATE, END_DATE) "
				+ "VALUES (?,?,?,?)";
		jdbcTemplate.update(sql,  
				event.getUserId(), 
				event.getTitle(), 
				event.getStart(), 
				event.getEnd()
		);
		//System.out.println("test2");
	}
}

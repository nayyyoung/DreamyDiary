package com.dreamydiary.myapp.dd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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
	
	@Override
	public MemberVO getMemberInfo(String id) {
		String sql = "SELECT USERID, PASSWORD, "
				+ "NAME, PHONE, EMAIL, BIRTHDAY, GENDER "
				+ "FROM MEMBER WHERE USERID=?";		
		return jdbcTemplate.queryForObject(sql, new MemberMapper(), id);
	}
	
	@Override
	public List<MemberVO> getMemberList() {
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
		System.out.println("test");
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
}

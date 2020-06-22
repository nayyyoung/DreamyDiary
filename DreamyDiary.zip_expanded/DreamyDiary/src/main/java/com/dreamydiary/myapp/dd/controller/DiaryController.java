package com.dreamydiary.myapp.dd.controller;

import java.lang.reflect.Member;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dreamydiary.myapp.dd.model.MemberVO;
import com.dreamydiary.myapp.dd.service.IDiaryService;

@Controller
public class DiaryController {
//	private static final Logger logger = LoggerFactory.getLogger(DiaryController.class);

	@Autowired
	IDiaryService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String goCalendar(MemberVO memberVO, Model model) {
		//System.out.println(memberVO);

		
//		MemberVO member = service.getMemberInfo("abc");
//		System.out.println(member);
		List<MemberVO> memberList = service.getMemberList();
		System.out.println(memberList);
		for (MemberVO member : memberList) {
			if(member.getUserId().equals(memberVO.getUserId())) {
				System.out.println("id confirm");
				if(member.getPassWord().equals(memberVO.getPassWord())) {
					System.out.println("password confirm");
					return "/dd/calendar";
				}
			}
		}
		return "home";
	}

	@RequestMapping(value = "/dd/signup")
	public String signup(Model model) {
		return "/dd/signup";
	}

	@RequestMapping(value = "/dd/signup", method = RequestMethod.POST)
	public String signupToCalendar(MemberVO memberVO, Model model) {
		service.insertMemberInfo(memberVO);
		return "home";
	}

}

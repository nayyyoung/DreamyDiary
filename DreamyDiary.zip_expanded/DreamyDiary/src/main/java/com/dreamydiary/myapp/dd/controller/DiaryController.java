package com.dreamydiary.myapp.dd.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dreamydiary.myapp.dd.model.EventVO;
import com.dreamydiary.myapp.dd.model.MemberVO;
import com.dreamydiary.myapp.dd.service.IDiaryService;

@Controller
public class DiaryController {
//	private static final Logger logger = LoggerFactory.getLogger(DiaryController.class);

	@Autowired
	IDiaryService service;
	
	private static String id;
	private static String password;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "home";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String goCalendar(MemberVO memberVO, Model model) {
		//System.out.println(memberVO);

		
//		MemberVO member = service.getMemberInfo("abc");
		System.out.println(memberVO);
		List<MemberVO> memberList = service.getTotalMember();
		//System.out.println(memberList);
		for (MemberVO member : memberList) {
			if(member.getUserId().equals(memberVO.getUserId())) {
				System.out.println("id confirm");
				if(member.getPassWord().equals(memberVO.getPassWord())) {
					System.out.println("password confirm");
					id = memberVO.getUserId();
					password = memberVO.getPassWord();
					return "/dd/calendar";
				}
			}
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/dd/signup")
	public String signup(Model model) {
		return "/dd/signup";
	}

	@RequestMapping(value = "/dd/signup", method = RequestMethod.POST)
	public String signup2Home(MemberVO memberVO, Model model) {
		System.out.println("insert:" + memberVO);
		service.insertMemberInfo(memberVO);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/dd/resign")
	public String resign(Model model) {
		return "/dd/resign";
	}
	
	@RequestMapping(value = "/dd/resign", method = RequestMethod.POST)
	public String resign2Home(MemberVO memberVO, Model model) {
		service.deleteMemberInfo(memberVO.getUserId(), memberVO.getPassWord());
		return "redirect:/";
	}
	
	@ResponseBody
    @RequestMapping(value = "/events", method = RequestMethod.POST)
    public void getCalendarEvents(@RequestBody EventVO eventVO) {
		//System.out.println(id);
		eventVO.setUserId(id);
		eventVO.setStart(eventVO.getStart().substring(0, 10));
		eventVO.setEnd(eventVO.getEnd().substring(0, 10));
		System.out.println("insert event:" + eventVO);
    	service.insertEventInfo(eventVO);
    }
	
	@ResponseBody
    @RequestMapping(value = "/getevents", method = RequestMethod.POST)
    public List<EventVO> init() {
        
    	//HashMap<String, Object> map = new HashMap<String, Object>();
    	List<EventVO> eventList = service.getEventList(id);
//    	for (EventVO event : eventList) {
//    		map.put("eventVO", event);
//		}
//    	System.out.println(eventList);
        return eventList;
    }

}

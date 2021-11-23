package com.myconpany.myapp09.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myconpany.myapp09.member.model.service.MemberService;
import com.myconpany.myapp09.member.model.vo.Member;



@Controller
@SessionAttributes("msg")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "memberinsert", method= RequestMethod.GET)
	public String memberInsert(ModelAndView mv) {
		return "member/memberinsert";
	}
	
	@RequestMapping(value = "signUp", method=RequestMethod.POST)
	public ModelAndView memberInsert(Member member, @RequestParam("memberId") String id,@RequestParam("memberPwd") String pwd,@RequestParam("memberName") String name,
			HttpServletRequest request,HttpServletResponse response, RedirectAttributes rttr, ModelAndView mv) {
		int result=0;
		
		try {
			
			System.out.println(result);
			
			member.setMember_id(id);
			member.setMember_pwd(pwd);
			member.setMember_nm(name);
			result = memberService.insertMember(member);
			System.out.println(result);
			if(result==1) {
				HttpSession session = request.getSession();
				String msg = "회원가입이 완료되었습니다.";
				rttr.addFlashAttribute("msg", msg);
				mv.setViewName("redirect:/memberinsert");
			}else if (result==0){
				String msg = "회원가입에 실패했습니다.";
				rttr.addFlashAttribute("msg", msg);
				mv.setViewName("redirect:/memberinsert");
			}
			else {
				String msg = "회원가입에 오류가 발생하였습니다.";
				rttr.addFlashAttribute("msg", msg);
				mv.setViewName("redirect:/memberinsert");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mv;
	}
}
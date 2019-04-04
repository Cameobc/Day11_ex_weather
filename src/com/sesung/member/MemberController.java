package com.sesung.member;

import java.util.HashMap;
import java.util.Scanner;

public class MemberController {
	
	private MemberInit mi;
	private MemberView mv;
	private Scanner sc;
	private HashMap <String, Member> map;

	public MemberController() {
		mi = new MemberInit();
		mv = new MemberView();
		sc = new Scanner(System.in);
	}
	
	public void start() {
		map = mi.setMember();
		boolean check = true;
		while(check) {
			System.out.println("번호 선택");
			System.out.println("1.회원가입");
			System.out.println("2.로 그 인");
			System.out.println("3.회원탈퇴");
			System.out.println("4.전체정보출력");
			System.out.println("5.종    료");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				Member m = mi.memberJoin();
				map.put(m.getId(), m);
				break;
			case 2:
				Member m2 = mi.memberLogin(map);
				if(m2 != null) {
					mv.view("로그인 성공");
				}else {
					mv.view("로그인 실패");
				}
				break;
			case 3:
				String st = mi.memberDelete(map);
				mv.view(st);
				break;
			case 4:
				mv.view(map);
				break;
				default:
					mv.view("프로그램 종료");
					check=!check;
			}
		}
	}
}

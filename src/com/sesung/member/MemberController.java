package com.sesung.member;

import java.util.HashMap;
import java.util.Scanner;

public class MemberController {

	private MemberInit mi;
	private MemberView mv;
	private Scanner sc;
	private HashMap<String, Member> map;

	public MemberController() {
		mi = new MemberInit();
		mv = new MemberView();
		sc = new Scanner(System.in);
	}

	public void start() {
		map = mi.setMember();
		boolean check = true;
		while (check) {
			System.out.println("번호 선택");
			System.out.println("1.회원가입");
			System.out.println("2.로 그 인");
//			System.out.println("3.회원탈퇴");
//			System.out.println("4.전체정보출력");
			System.out.println("5.종    료");
			int select = sc.nextInt();

			if (select == 1) {
				Member m = mi.memberJoin();
				map.put(m.getId(), m);
			} else if (select == 2) {
				Member m2 = mi.memberLogin(map);
				if (m2 != null) {
					mv.view("로그인 성공");

					System.out.println(m2.getId()+"님 환영합니다");
					System.out.println("==============");

					while (check) {
						System.out.println("1.회원탈퇴");
						System.out.println("2.전체정보출력");
						System.out.println("3.종    료");
						select = sc.nextInt();

						if (select == 1) {
							String st = mi.memberDelete(map);
							mv.view(st);
						} else if (select == 2) {
							mv.view(map);
						} else if (select == 3) {
							mv.view("프로그램 종료");
							check = !check;
						} else {
							System.out.println("잘못된번호 입니다.");
						}
					}
				} else {
					mv.view("로그인 실패");
				}
//				}else if(select==3){
//				String st = mi.memberDelete(map);
//				mv.view(st);
//				}else if(select==4) {
//				mv.view(map);
			} else {
				mv.view("프로그램 종료");
				check = !check;
			}
		}
	}
}
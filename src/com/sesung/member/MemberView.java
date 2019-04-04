package com.sesung.member;

import java.util.HashMap;
import java.util.Iterator;

public class MemberView {

	public void view(String st) {
		System.out.println(st);
	}

	public void view(Member member) {
		System.out.println("Id : "+member.getId());
		System.out.println("Pw : "+member.getPw());
		System.out.println("Name : "+member.getName());
		System.out.println("Age : "+member.getAge());
		System.out.println("Lv : "+member.getLevel());
		System.out.println("==============");
	}

	public void view(HashMap<String, Member> map) {
		Iterator<String> str = map.keySet().iterator();
		while(str.hasNext()) {
			String key = str.next();
			Member value = map.get(key);
			this.view(value);
//			System.out.println("Id : "+value.getId());
//			System.out.println("Pw : "+value.getPw());
//			System.out.println("Name : "+value.getName());
//			System.out.println("Age : "+value.getAge());
//			System.out.println("Lv : "+value.getLevel());
//			System.out.println("==============");
		}
	}
}

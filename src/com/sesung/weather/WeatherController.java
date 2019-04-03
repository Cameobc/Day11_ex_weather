package com.sesung.weather;

import java.util.ArrayList;
import java.util.Scanner;

public class WeatherController {
	//getWeather실행하고 결과물을 weathers에 대입
	//1.날씨정보추가 - setWeather 호출한 결과물을 weathers 에 추가 /2.날씨정보출력 - weatherView / 3.날씨정보종료
	private Scanner sc; 
	private WeatherInit winit;
	private ArrayList<Weather> weathers;
	private WeatherView view;
	
	public WeatherController() {
		sc = new Scanner(System.in);
		winit = new WeatherInit();
		view = new WeatherView();
	}


	public void start() {

		boolean check = true;
		
		weathers = winit.getWeathers();
	
		System.out.println("번호를 선택하세요.");
		while(check) {
			System.out.println("1.날씨정보추가");
			System.out.println("2.날씨정보검색");
			System.out.println("3.날씨정보삭제");
			System.out.println("4.날씨정보출력");
			System.out.println("5.날씨정보종료");
			int select = sc.nextInt();

			if(select==1) {
				Weather w = winit.setWeather();
				weathers.add(w);
			}else if(select==2) {
				Weather w = winit.findWeather(weathers);
				view.view(w);
				
			}else if(select==3){
				winit.deleteWeather(weathers);
			}else if(select==4){
				view.view(weathers);
			}else {
				System.out.println("프로그램 종료");
				check=!check;
			}
		}
	}

}

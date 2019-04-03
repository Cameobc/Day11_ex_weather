package com.sesung.weather;

import java.util.ArrayList;

public class WeatherView {
	

	public void view(ArrayList<Weather> weathers) {
		for(int i =0; i<weathers.size(); i++) {
			System.out.println("도시이름 : " +weathers.get(i).getCity());
			System.out.println("날     씨 : " +weathers.get(i).getState());
			System.out.println("온     도 : " +weathers.get(i).getTem());
			System.out.println("습     도 : " +weathers.get(i).getHum());
			System.out.println("미세먼지 : " +weathers.get(i).getMise());
			System.out.println("==================================");
		}
	
	}

	
	public void view(Weather weather) {
		System.out.println("도시이름 : " +weather.getCity());
		System.out.println("날     씨 : " +weather.getState());
		System.out.println("온     도 : " +weather.getTem());
		System.out.println("습     도 : " +weather.getHum());
		System.out.println("미세먼지 : " +weather.getMise());
		System.out.println("==================================");
	}
}

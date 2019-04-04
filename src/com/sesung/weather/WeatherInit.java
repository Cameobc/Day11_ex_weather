package com.sesung.weather;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WeatherInit {

	private String info;
	private Scanner sc;

	public WeatherInit() {
		info="seoul, 맑음, 10, 20, 0.3, daejeon, 비, 22, 50, 0.1,"
				+ "incheon, 태풍, 56, 90, 22.2, jeju, 흐림, 15, 10, 1.2";
		sc = new Scanner(System.in);
	}

	public ArrayList<Weather> getWeathers() {
		ArrayList<Weather> weathers = new ArrayList<Weather>();
		StringTokenizer st = new StringTokenizer(info, ",");
		while(st.hasMoreTokens()) {
			Weather weather = new Weather();
			weather.setCity(st.nextToken().trim());
			weather.setState(st.nextToken().trim());
			weather.setTem(Integer.parseInt(st.nextToken().trim()));
			weather.setHum(Integer.parseInt(st.nextToken().trim()));
			weather.setMise(Double.parseDouble(st.nextToken().trim()));
			weathers.add(weather);
		}
		
//		String [] total = info.split(",");
//		for(int i =0; i<total.length; i=i+5) {
//			Weather weather = new Weather();
//			weather.setCity(total[i].trim());
//			weather.setState(total[i+1].trim());
//			weather.setTem(Integer.parseInt(total[i+2].trim()));
//			weather.setHum(Integer.parseInt(total[i+3].trim()));
//			weather.setMise(Double.parseDouble(total[i+4].trim()));
//			weathers.add(weather);
//		}
		
//		for(int i =0; i<total.length;i++) {
//			Weather weather = new Weather();
//			weather.setCity(total[i].trim());
//			weather.setState(total[++i].trim());
//			weather.setTem(Integer.parseInt(total[++i].trim()));
//			weather.setHum(Integer.parseInt(total[++i].trim()));
//			weather.setMise(Double.parseDouble(total[++i].trim()));
//			weathers.add(weather);
//		}
		return weathers;
	}

	public Weather setWeather() {
		Weather weather = new Weather();
		System.out.println("도시이름");
		weather.setCity(sc.next());
		System.out.println("날     씨");
		String state = sc.next();
		weather.setState(state);
		System.out.println("온     도");
		int tem = sc.nextInt();
		weather.setTem(tem);
		System.out.println("습     도");
		int hum= sc.nextInt();
		weather.setHum(hum);
		System.out.println("미세먼지");
		double mise=sc.nextDouble();
		weather.setMise(mise);
		return weather;
	}

	public Weather findWeather(ArrayList<Weather> weathers) {
		Weather weather = null;
		System.out.println("검색할 도시 이름 입력");
		String city = sc.next();
//		boolean check=true;
		for(int i=0; i<weathers.size();i++) {
			if(city.equals(weathers.get(i).getCity())) {
				weather=weathers.get(i);
//				check=!check;
				break;
			}
		}
//		if(check) {
//			System.out.println("없는 도시 입니다.");
//		}
		return weather;
	}

	public String deleteWeather(ArrayList<Weather> weathers) {
		System.out.println("삭제할 도시 이름 입력");
		String city = sc.next();
		String result ="없는 도시입니다.";
//		boolean check=true;
		for(int i =0; i<weathers.size(); i++) {
			if(city.equals(weathers.get(i).getCity())){
				weathers.remove(i);
				result = "삭제가 완료되었습니다.";
//				check=!check;
				break;
			}
		}
		return result;
//		if(check) {
//			System.out.println("잘못 입력했습니다.");   // for문이 끝나고 난뒤 boolean 타입을 이용해 if로 출력문을 돌려야 중복출력이 일어나지 않는다.
//	
//		}
	}

}

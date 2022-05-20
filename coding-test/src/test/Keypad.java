package test;

public class Keypad {
	public String solution(int[] numbers, String hand) {

		String[] strNumber = new String[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			strNumber[i] = String.valueOf(numbers[i]);
		}

		String[] result = new String[numbers.length];

		String nowL = "*";
		String nowR = "#";

		for (int i = 0; i < numbers.length; i++) {
			switch (numbers[i]) {
			case 1, 4, 7: {
				result[i] = "L";
				nowL = strNumber[i];
				break;
			}
			case 3, 6, 9: {
				result[i] = "R";
				nowR = strNumber[i];
				break;
			}

			case 2, 5, 8, 0: {
				String usingHand = calcHand(nowL, nowR, strNumber[i], hand);
				if (usingHand.equals("left")) {
					result[i] = "L";
					nowL = strNumber[i];
				} else {
					result[i] = "R";
					nowR = strNumber[i];
				}
				break;
			}
			}
		}
		String answer = "";
		for (int i = 0; i < result.length; i++) {
			answer += result[i];
		}
		return answer;
	}

	public String calcHand(String nowL, String nowR, String weGo, String hand) {
		int lLength = calcLength(nowL, weGo);
		int rLength = calcLength(nowR, weGo);

		if (lLength == rLength) {
			return hand;
		} else if (lLength > rLength) {
			return "right";
		} else {
			return "left";
		}
	}

	public int calcLength(String now, String weGo) {
		int h = Math.abs(setheight(now) - setheight(weGo));
		int v=1;
		switch (now) {
		case "2","5","8","0":{
			v=0;
			break;
		}
		default :{
			v=1;
			break;
		}
		}
		return v + h;
	}

	public int setheight(String now) {
		int h = 1;
		switch (now) {
		case "1", "2", "3": {
			h = 4;
			break;
		}
		case "4", "5", "6": {
			h = 3;
			break;
		}
		case "7", "8", "9": {
			h = 2;
			break;
		}
		case "*", "#", "0": {
			h = 1;
			break;
		}
		}
		return h;
	}
}

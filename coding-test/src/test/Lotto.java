package test;

import java.util.Arrays;

public class Lotto {
	public int[] solution(int[] lottos, int[] win_nums) {
		int numOfZero=0;
		int numOfWin=0;
		
		Arrays.sort(lottos);
		
		//당첨 개수
		for(int i=0;i<6;i++) {
			if(lottos[i]==0) {
				numOfZero++;
			}
			
			for(int j=0; j<6; j++) {
				if(lottos[i]==win_nums[j]) {
					numOfWin++;
					break;
				}
			}
		}
		int min=price(numOfWin);
		int max=price(numOfWin+numOfZero);
        int[] answer = {max, min};
        return answer;
    }
	
	public int price(int num) {
		switch(num) {
		case 6:
			return 1;
		case 5:
			return 2;
		case 4:
			return 3;
		case 3:
			return 4;
		case 2:
			return 5;
		default:
			return 6;
		}
	}
	
    public long solution(int w, int h) {
        long answer = 1;
        int min=0;
        if(w==h){
            answer=w*h-w;
        }else{
            if(w<h) {
            	min=w;
            }else {
            	min=h;
            }
            answer=w*h-(2*min);
        }
        
        if(answer==0) {
        	answer=2;
        }
        return answer;
    }
    
    //하샤드 수
    public boolean solution(int x) {
        boolean answer = false;
        String str=String.valueOf(x);
        String[] arr=str.split("");
        int total=0;
        for(int i=0; i<arr.length;i++) {
        	total+=Integer.parseInt(arr[i]);
        }
        
        if(x%total==0) {
        	answer=true;
        }
        return answer;
    }
    //없는 숫자 더하기
    public int solution(int[] numbers) {
    	int total=0;
    	for(int i=0;i<numbers.length;i++) {
    		total+=numbers[i];
    	}
        int answer = 45-total;
        return answer;
    }
}

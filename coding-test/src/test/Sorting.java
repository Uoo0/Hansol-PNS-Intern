package test;

import java.util.Arrays;
import java.util.Comparator;

public class Sorting {
	public int[] knumber(int[] array, int[][] commands) {
		int len=commands.length;
		int[] answer = new int[len];
		for(int row=0;row<len;row++) {
			int i=commands[row][0]-1;
			int j=commands[row][1];
			int k=commands[row][2]-1;
			
			int[] array1 = new int[j-i];
			int count=0;
			for(int ln=i; ln<j;ln++) {
				array1[count]=array[ln];
				count++;
			}
			
			Arrays.sort(array1);
			answer[row]=array1[k];
		}
		return answer;
	}
	
	public String biggest(int[] numbers) {
		//문자로 변환
		String[] strArr=new String[numbers.length];
		for(int i=0;i<numbers.length ;i++) {
			strArr[i]=String.valueOf(numbers[i]);
		}
		
		//정렬
		Arrays.sort(strArr, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return ((o2+o1).compareTo(o1+o2));
			}
		});
		
		if(strArr[0].equals("0")) {
			return "0";
		}
		
        String answer = "";
        for(String str : strArr) {
        	answer+=str;
        }
        return answer;
    }
	
	  public int solution(int[] citations) {
		  int answer = 0;
		  Arrays.sort(citations);
		  for(int i=0;i<citations.length;i++) {
			  if(citations[i]>=citations.length-i) {
				  answer=citations.length-i;
				  break;
			  }
		  }
	        return answer;
	    }
}

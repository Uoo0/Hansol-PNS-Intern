package test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HashTest {
	//전화번호 목록
    public boolean phoneBook(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        int length=phone_book.length;
        
        if(length==1) {
        	return answer;
        }
        
        for(int i=0; i<length-1 ; i++) {
        		if(phone_book[i+1].startsWith(phone_book[i])) {
        			return false;
        		}
        }
        return answer;
    }

    //위장
    public int camouflage(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> hash = new HashMap<String,Integer>();
        int len=clothes.length;
        
        for(int i=0;i<len;i++) {
        	String key=clothes[i][1];
        	
        	if( !hash.containsKey(key)) {
        		hash.put(key, 1);
        	}else {
        		hash.put(key, hash.get(key)+1);
        	}
        }
        
        Iterator<Integer> i=hash.values().iterator();
        
        while(i.hasNext()) {
        	answer *= i.next().intValue()+1;
        }
        
        return answer-1;
    }
    
    //베스트 앨범
	public int[] bestAlbum(String[] genres, int[] plays) {
		int len=genres.length;
		int[] answer = new int[len/2*2];
		
		//장르별 재생수 합
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i=0;i<len;i++) {
			String key=genres[i];
			int value=plays[i];
			if(!map.containsKey(key)) {
				map.put(key, value);
			}else {
				map.put(key, map.get(key)+value);
			}
		}
		//장르 정렬
		List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
		entryList.sort(new Comparator<Map.Entry<String, Integer>>(){
			@Override
			public int compare(Map.Entry<String, Integer> s1, Map.Entry<String, Integer> s2) {
				return s2.getValue() - s1.getValue();
			}
		});
		
		// 고유번호를 재생 수 기준으로 정렬
		//장르별 곡 고유번호 가져오기
		ArrayList<song> result = new ArrayList<>();
			for(Map.Entry<String, Integer> entry : entryList) {
				ArrayList<song> list = new ArrayList<>();
				for(int i=0; i<len; i++) {
					if(genres[i].equals(entry.getKey())) {
						list.add(new song(entry.getKey(), plays[i],i));
					}
				}
				Collections.sort(list, (s1, s2) -> s2.plays-s1.plays);
				for(int j=0; j<list.size();j++) {
					result.add(list.get(j));
				}
			}			
		//고유번호 짝지어 끊기
		int count = 1;
		int index = 0;
		while (index < len) {
				answer[index] = result.get(index).i;
			index++;
		}
		return answer;
	}

	static class song {
		String genre;
		int plays;
		int i;

		public song(String genre, int plays, int i) {
			this.genre = genre;
			this.plays = plays;
			this.i = i;
		}
	}
}

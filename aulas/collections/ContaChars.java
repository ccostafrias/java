import java.util.*;

public class ContaChars{

	public static void contaChars(String s){

		Map<Character, Integer> map = new TreeMap<>();

		for(char ch : s.toCharArray()){
	
			if(!map.containsKey(ch)){

				map.put(ch, 0);
			}

			map.put(ch, (map.get(ch) + 1));
		}

		System.out.println(map);
	}

	public static void main(String [] args){
		
		contaChars("casa");
		System.out.println("-------------------------------------------------");
		contaChars("teste um, teste dois, teste três...");
	}
}
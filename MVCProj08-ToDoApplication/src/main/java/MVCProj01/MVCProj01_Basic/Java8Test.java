package MVCProj01.MVCProj01_Basic;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Test {

	public static void main(String[] args) 
	{
//		LocalDate birth=LocalDate.of(2003, 10, 27);
//		LocalDate now=LocalDate.now();
//		System.out.println(ChronoUnit.YEARS.between(birth, now));
		/*List<Integer> list=List.of(2,5,8,12,78,95,45,56);
		Map<Boolean, List<Integer>> collect = list.stream().collect(Collectors.partitioningBy(n->n%2==0));
		
		Set<Entry<Boolean, List<Integer>>> entrySet = collect.entrySet();
		for(Entry<Boolean,List<Integer>> entry:entrySet) 
		{
			System.out.println("______________");
			if(entry.getKey()) {
				System.out.println("Even Numbers");
			}
			else {
				System.out.println("Odd Numbers");
			}
			System.out.println("_________________");
			List<Integer> value = entry.getValue();
			for(Integer num:value) {
				System.out.println(num);
			}
			
			
		}
		
		String str="Welcome To JAVA good morning ";
		Map<Character, Long> collect = str.chars().mapToObj((c)->(char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
				
		
		collect.forEach((c,count)->System.out.println(c+" Presents "+count+" times"));
		
		List<String> list=List.of("Facebook","Apple","Microsoft","IBM","TCS");
		
		String collect = list.stream().collect(Collectors.joining(" ","[","]"));
		System.out.println(collect);*/	
		
		List<Integer> list=List.of(7,4,8,59,8,6,8,9,6,3);
		Optional<Integer> first = list.stream().distinct().sorted(Comparator.reverseOrder()).skip(3).findFirst();
		System.out.println(first.get());
		
		
;		
		
		
		
		
	}

}


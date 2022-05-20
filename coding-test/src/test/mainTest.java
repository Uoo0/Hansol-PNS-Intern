package test;

public class mainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sorting sorting=new Sorting();
		int[] array= {1,5,2,6,3,7,4};
		int[][] commands= {{2,5,3}};
		
		System.out.println(sorting.knumber(array, commands));
	}

}

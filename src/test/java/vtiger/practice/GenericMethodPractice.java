package vtiger.practice;

public class GenericMethodPractice {

	public static void main(String[] args) { //caller function
		int sum = add(11,2);
		System.out.println(sum);
		
	}
	
	public static int add(int a, int b) //called function , it'll not run unless its called
	{
		return a+b;
	}

}

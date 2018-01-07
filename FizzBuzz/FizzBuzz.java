public class FizzBuzz {
	public String printFizzBuzz(int num) {
		boolean fizz = false;
		boolean buzz = false;

		if(num%3 == 0){
			fizz = true;
		}
		if(num%5 == 0){
			buzz = true;
		}

		if( fizz == true && buzz == true){
			System.out.println("FizzBuzz");
			return "Divisible by 3 and 5";
		}else if(fizz == true){
			System.out.println("Fizz");
			return "Divisible by 3";
		}else if (buzz == true){
			System.out.println("Buzz");
			return "divisible by 5";
		}else {
			System.out.println("This isn't divisible by 3 or 5");
			return "Not divisible";
		}

	
	}

}

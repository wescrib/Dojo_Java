import java.util.Scanner;

public class Calculate {
	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter value for leg A: ");
		double legA = keyboard.nextDouble();

		System.out.println("Enter value for leg B: ");
		double legB = keyboard.nextDouble();

		Pythagorean test = new Pythagorean();
			double hypotenuse = test.getHypotenuse(legA,legB);
			System.out.println(hypotenuse);

	}


}

package application;

public class Model {
	
	//----Calculate die Operation----
	public double clculate(double number1,double number2,String operation) {
		switch(operation) {
		case "+":
			return number1 + number2;
		case "-":
			return number1 - number2;
		case "*":
			return number1 * number2;
		case "/":
			if(number2 == 0) {
				System.out.println("Durch 0 kann man nicht teilen");
				return 0;
			}
			else {
				return number1 / number2;
			}
		}
		return 0;
	}
}

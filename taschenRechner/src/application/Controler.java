package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Controler {
	
	//----die Variables----
	@FXML
	Text resultLabel;
	
	boolean isTypingNumber = false;
	double firstNumber = 0;
	double secoundNumber = 0;
	String operation = "";
	
	//----Erstellen eines Modell-Objekts----
	Model model = new Model();
	
	//----Die Nummern Methode----
	public void NumberTapped(ActionEvent event) {
		String valuee = ((Button)event.getSource()).getText();
		
		if(isTypingNumber) {
			resultLabel.setText(resultLabel.getText() + valuee);
		}
		else {
			resultLabel.setText(valuee);
			isTypingNumber = true;
		}
	}
	
	//----Die Calculation Methode----
	public void calculateTapped(ActionEvent event) {
		isTypingNumber = false;
		firstNumber = Double.parseDouble(resultLabel.getText());
		operation = ((Button)event.getSource()).getText();
		
	}
	
	//----Die Equals Methode----
	public void equalsTapped(ActionEvent event) {
		isTypingNumber = false;
		secoundNumber = Double.parseDouble(resultLabel.getText());
		
		double result = model.clculate(firstNumber, secoundNumber, operation);
		
		resultLabel.setText(String.valueOf(result));
	}
	
	
	//----Die Zurücksetzen Methode----
	public void restartTapped(ActionEvent event) {
		resultLabel.setText(null);
		firstNumber = 0;
		secoundNumber = 0;
	}
	
}

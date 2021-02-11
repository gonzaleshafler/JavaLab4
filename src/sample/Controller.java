package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Controller {
    @FXML private TextField firstPointTextField;
    @FXML private TextField lastPointTextField;
    @FXML private TextField deltaPointTextField;
    @FXML private TextField aValue;
    @FXML private TextField bValue;
    @FXML private TextField cValue;

    @FXML private Label countOfSteps;
    @FXML private TextArea textArea;


public void onClick(ActionEvent event)
    {
        CalculateY calculateY=new CalculateY();


        Alert a=new Alert(Alert.AlertType.ERROR);
        try {
            calculateY.a= Double.parseDouble(aValue.getText());
            calculateY.b= Double.parseDouble(bValue.getText());
            calculateY.c= Double.parseDouble(cValue.getText());


            calculateY.x1=Double.parseDouble(firstPointTextField.getText());
            calculateY.x2=Double.parseDouble(lastPointTextField.getText());
            if(calculateY.x1>calculateY.x2)
            {
                a.setContentText("Input Error\nValues entered incorrectly! First point cannot be greater than the last.");
                a.show();
                return;
            }

            calculateY.dx=Double.parseDouble(deltaPointTextField.getText());

        }
        catch (NumberFormatException exception)
        {

            a.setContentText("Input Error\nValues entered incorrectly! Try to enter only numbers.");
            a.show();
            return;
        }
            calculateY.fillX(calculateY.x1, calculateY.x2,calculateY.dx);
            calculateY.fillY(calculateY.x);
            countOfSteps.setText("Count of steps = "+String.valueOf(calculateY.x.length)+
                    "\nMin value = "+String.valueOf(calculateY.y[calculateY.findMin(calculateY.y)])+
                    "\nMax value = "+String.valueOf(calculateY.y[calculateY.findMax(calculateY.y)]) +
                    "\nSum of elements = "+String.valueOf(calculateY.summArray(calculateY.y))+
                    "\nArethmetical mean = "+String.valueOf(calculateY.midSummArray(calculateY.y)));
           StringBuilder sb=new StringBuilder();
           String s;
            for (int i=0;i<calculateY.y.length;i++)
            {
                s=String.format("x=%.5f;  y= %.5f \n",calculateY.x[i],calculateY.y[i]);
                sb.append(s);
            }
            textArea.setText(sb.toString());
    }
}

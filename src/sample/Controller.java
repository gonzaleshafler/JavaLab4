package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField firstPointTextField;
    @FXML
    private TextField lastPointTextField;
    @FXML
    private TextField deltaPointTextField;
    @FXML
    private TextField aValue;
    @FXML
    private TextField bValue;
    @FXML
    private TextField cValue;

    @FXML
    private Label countOfSteps;


public void onClick(ActionEvent event)
    {
        CalculateY calculateY=new CalculateY();
            calculateY.a= Double.parseDouble(aValue.getText());
            calculateY.b= Double.parseDouble(bValue.getText());
            calculateY.c= Double.parseDouble(cValue.getText());
            double fx=Double.parseDouble(firstPointTextField.getText());
            double lx=Double.parseDouble(lastPointTextField.getText());
            double dx=Double.parseDouble(deltaPointTextField.getText());
            calculateY.fillX(fx,lx,dx);
            calculateY.fillY(calculateY.x);
            countOfSteps.setText("Count of steps = "+String.valueOf(calculateY.x.length)+
                    "\nMin value = "+String.valueOf(calculateY.y[calculateY.findMin(calculateY.y)])+
                    "\nMax value = "+String.valueOf(calculateY.y[calculateY.findMax(calculateY.y)]) +
                    "\nSum of elements = "+String.valueOf(calculateY.summArray(calculateY.y))+
                    "\nArethmetical mean = "+String.valueOf(calculateY.midSummArray(calculateY.y)));





    }
}

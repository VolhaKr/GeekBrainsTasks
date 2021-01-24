package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
        @FXML
        public TextArea textArea;
        @FXML
        public TextField textField;

        @FXML
        public void clickBtnAddMsg(ActionEvent actionEvent) {

        }
@FXML
    public void pressEnterAddMsg(ActionEvent actionEvent) {

        System.out.println("test") ;
    textArea.appendText(textField.getText() + "\n");
    //textField.requestFocus();
    }


    }










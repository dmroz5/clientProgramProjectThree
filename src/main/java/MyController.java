

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class MyController implements Initializable {
    private int portNumber;

    @FXML
    private VBox root;
    @FXML
    private TextField portField;
    @FXML
    private GridPane grid;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub

    }
    public void setPort(ActionEvent e) throws IOException {
        portNumber = Integer.parseInt(portField.getText());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/ButtonState.fxml"));
        Parent root2 = loader.load(); //load view into parent
        root2.getStylesheets().add("/styles/ServerStart");//set style
        root.getScene().setRoot(root2);//update scene graph
    }
}

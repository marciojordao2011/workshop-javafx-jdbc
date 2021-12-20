package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepartamentosFormController implements Initializable {
	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtNome;
	
	@FXML
	private Label labelErrorName;
	
	@FXML
	private Button btSalvar;
	
	@FXML
	private Button Cancelar;
	
	@FXML
	private void onBtSalvarAction() {
		System.out.println("botao salvar");
	}
	
	@FXML
	private void onBtCancelarAction() {
		System.out.println("botao cancelar");
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {	
		initializeNodes();
	}
	
	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtId, 30);
		}

}

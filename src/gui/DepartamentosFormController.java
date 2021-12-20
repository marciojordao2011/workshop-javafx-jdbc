package gui;

import java.net.URL;
import java.util.ResourceBundle;

import db.DbException;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Departamentos;
import model.services.DepartamentosService;

public class DepartamentosFormController implements Initializable {
	
	private Departamentos entity;
	
	private DepartamentosService service;
	
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
	
	public void setDepartamentos(Departamentos entity) {
		this.entity = entity;
	}
	
	public void setDepartamentosService(DepartamentosService service) {
		this.service = service;
	}
	
	@FXML
	private void onBtSalvarAction(ActionEvent event) {
		if(entity == null) {
			throw new IllegalStateException("entity was null");
		}
		if (service == null) {
			throw new IllegalStateException("service was null");
		}
		try {
			entity = getFormData();
			service.saveOrUpdate(entity);
			Utils.currentStage(event).close();
		}
		catch(DbException e) {
			Alerts.showAlert("Error Saving Object", null, e.getMessage(), AlertType.ERROR);
		}
	}
	
	private Departamentos getFormData() {
		Departamentos obj = new Departamentos();
		
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		obj.setName(txtNome.getText());
		return obj;
	}

	@FXML
	private void onBtCancelarAction(ActionEvent event) {
		Utils.currentStage(event).close();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {	
		initializeNodes();
	}
	
	private void initializeNodes() {
		Constraints.setTextFieldInteger(txtId);
		Constraints.setTextFieldMaxLength(txtId, 30);
		}
	
	public void updateFormData() {
		if(entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtNome.setText(entity.getNome());
	}

}

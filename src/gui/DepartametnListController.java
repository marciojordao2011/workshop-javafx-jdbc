package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.entities.Departamentos;

import model.services.DepartamentosService;

public class DepartametnListController implements Initializable {
	
	private DepartamentosService service;
	
	@FXML
	private TableView<Departamentos> tableViewDepartament;	
	
	@FXML
	private TableColumn<Departamentos, Integer> tableColumnId;
	
	@FXML
	private TableColumn<Departamentos, String> tableColumnNome;
	
	@FXML
	private Button btNovo;
	
	private ObservableList<Departamentos> obsList;
	
	@FXML
	public void onBtNovoAction() {
		System.out.println("Novo Botão ativado");
	}
	
	public void setDepartamentService(DepartamentosService service) {
		this.service = service;
	}
	
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes();
		
	}

	private void initializeNodes() {
		tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
		
		Stage stage = (Stage) Main.getMainScene().getWindow();
		tableViewDepartament.prefHeightProperty().bind(stage.heightProperty());
	}
	
	public void updateTableView() {
		if (service == null) {
			throw new IllegalStateException("Serviço estava nulo");
		}
		List<Departamentos> list = service.findAll();
		obsList = FXCollections.observableArrayList(list);
		tableViewDepartament.setItems(obsList);
	}

}

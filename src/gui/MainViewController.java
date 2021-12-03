package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable {
	@FXML
	private MenuItem menuItemVendedores;
	
	@FXML	
	private MenuItem menuItemDepartamentos;
	
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemVendedoresAction() {
		System.out.println("onMenuItemVendedoresAction");
		}
	
	@FXML
	public void onMenuItemDepartamentosAction() {
		System.out.println("onMenuItemDepartamentosAction");
		}
	
	@FXML
	public void onMenuItemAboutAction() {
		System.out.println("onMenuItemAboutAction");
		}
	
	
	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}

}

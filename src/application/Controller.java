package application;

import java.util.ArrayList;
import java.util.List;

import US_Airports_Model.Flight;
import US_Airports_Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
	
	private Model model;

    @FXML
    private TextArea TextResult;

    @FXML
    private TextField TextDistance;

    @FXML
    private Button ButtonBestFlights;

    @FXML
    private ComboBox<Integer> BoxAnni;

    @FXML
    private ComboBox<String> OriginCity;

    @FXML
    private ComboBox<String> DestinationCity;

    @FXML
    private Button ConnectivityCheck;

    @FXML
    private Button ShortestPath;

    @FXML
    private Button ButtonLoadFlights;
    
    
    public void setModel(Model model) {
		 this.model=model;	
		 
		 List<Integer>anni=new ArrayList<Integer>();
	    	
	      for(int i=1990;i<=2009;i++) {
	    		anni.add(i);
	    	}
	    	
	   	BoxAnni.getItems().addAll(anni);
	   	
	   	
	   	
	 	 
	}


    @FXML
    void getAllFlights(ActionEvent event) {
    	
    	
    	
    	
    	List<Flight> voli=model.getFlights();
    	
    	//Caricare tutte le città nelle combobox


    }


    @FXML
    void getConnectivity(ActionEvent event) {

    }

    @FXML
    void getShortestPath(ActionEvent event) {

    }


    @FXML
    void getBestFlights(ActionEvent event) {
    	
    	
    	
    	TextResult.clear();
    	
    	
    	model.loadFlights(BoxAnni.getValue());    	
  	
    	List<Flight>bestFlights=model.getBest(Integer.parseInt(TextDistance.getText()));
    	
    	
    	if(bestFlights.isEmpty()) {
    		TextResult.setText("Nessun volo presente con distanza minore o uguale a quella selezionata");
    	}
    	
    	else {
    		
    		TextResult.appendText("I Migliori voli sono i seguenti: ");
    		
    		
    		TextResult.appendText(bestFlights.toString());
    	 		
  	
    	}
    	
    	
    	
    	

    } 

}




















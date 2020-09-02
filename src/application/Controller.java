package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    	
    	
    try {	
    	model.loadFlights(BoxAnni.getValue());
    	List<Flight> voli=model.getFlights();
    	
    	Map<String,Integer> mappa_citta=new HashMap<String,Integer>();
    	
    	List<String> citta=new ArrayList<String>();
    	
    	for(Flight f:voli) {
    	 if(!mappa_citta.containsKey(f.getOrigin())) {
    		 
    		 mappa_citta.put(f.getOrigin(), 1);
    		 
    		 citta.add(f.getOrigin());
    	 }
    	 
    	 if(!mappa_citta.containsKey(f.getDestination())) {
    		 
    		 mappa_citta.put(f.getDestination(), 1);
    		 
    		 citta.add(f.getDestination());
    	 }
    		
    	}
    	
    	
    	model.createGraph();
    	
    	Collections.sort(citta);
    	
    	this.OriginCity.getItems().clear();
    	
    	this.DestinationCity.getItems().clear();
    	
    	this.OriginCity.getItems().addAll(citta);
    	
    	this.DestinationCity.getItems().addAll(citta);
    	
    }catch(Exception e) {
    	TextResult.appendText("Errore nella creazione del grafo");
    }
    	


    }


    @FXML
    void getConnectivity(ActionEvent event) {
    	
    	
    	TextResult.clear();
    	
    	try {
    		
    		String origin=OriginCity.getValue();
    		String destination=DestinationCity.getValue();
    		
    		if(!model.existVertex(origin)) {
    			TextResult.appendText("Le due città selezionate non sono connesse nell'anno di riferimento");
    			
    		}
    		
    		else {
    			
    			if(!model.isConnected(origin,destination)) {
    				TextResult.appendText("Le due città selezionate non sono connesse nell'anno di riferimento");
    				
    			}
    			
    			else {
    				TextResult.appendText("Le due città selezionate sono connesse nell'anno di riferimento");
    			}
    			
    			
    		}
    		
    		
    		
    		
    		
    		
    		
    		
    	}catch(Exception e) {
    		
    		TextResult.appendText("Caricare i voli e successivamente selezionare le città desiderate");
    		
    	}
    	
    	
    	

    }

    @FXML
    void getShortestPath(ActionEvent event) {
    	
    	TextResult.clear();
    	
    	

    	
    	try {
    		
    		String origin=OriginCity.getValue();
    		String destination=DestinationCity.getValue();
    		
    		if(!model.existVertex(origin)) {
    			TextResult.appendText("Le due città selezionate non  sono connesse nell'anno di riferimento");
    			
    		}
    		
    		else {
    			
    			if(!model.isConnected(origin,destination)) {
    				TextResult.appendText("Le due città selezionate non sono connesse nell'anno di riferimento");
    				
    			}
    			
    			else {
    		        
    				Map<Long,List<String>>percorso=model.dijkstraShortestPath(origin, destination);
    				
    				Long min_dist=null;
    				 
    				for(Long chiave:percorso.keySet()) {
    					
    					min_dist=chiave;
    					
    				}
    				
    				
    				
    				
    				
    				TextResult.appendText("Esiste un cammino minimo di lunghezza ");
    				
                    TextResult.appendText(min_dist.toString());
    				
    				TextResult.appendText("\n");
    				
    				List<String>percorso_util=percorso.get(min_dist);
    				
    	    				
    				for(String s:percorso_util) {
    					TextResult.appendText(s);
    					TextResult.appendText("\n");
    				}
    				
    				
    							
    			}
    			
    			
    		}
    		
    		
    		 		
    	}catch(Exception e) {
    		
    		TextResult.appendText("Caricare i voli e successivamente selezionare le città desiderate");
    		
    	}

    	
    	

    }


    @FXML
    void getBestFlights(ActionEvent event) {
    	
    	
    	
    	TextResult.clear();
    	
    	
    	
    	model.loadFlights(BoxAnni.getValue());    
    	
    	if(Integer.parseInt(TextDistance.getText())>300) {
    		TextResult.appendText("La massima distanza deve essere <=300");
    	}
    	else {
  	
    	List<Flight>bestFlights=model.getBest(Integer.parseInt(TextDistance.getText()));
    	
    	
    	if(bestFlights.isEmpty()) {
    		TextResult.setText("Nessun volo presente con distanza minore o uguale a quella selezionata");
    	}
    	
    	else {
    		
    		TextResult.appendText("I Migliori voli sono i seguenti: ");
    		TextResult.appendText("\n");
    		
    		
    		for(Flight f:bestFlights) {
    			TextResult.appendText(f.toString());
    			TextResult.appendText("\n");
    		}
    	 		
  	
    	}
    }
    	
    	
    	

    } 

}




















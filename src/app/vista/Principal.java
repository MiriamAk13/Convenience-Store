package app.vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author wrath
 */
public class Principal {
    private final int INVENTARIO = 0;
    private final int CUENTAS = 1;
    private final int CALCULADORA = 2;
    private final int AGENDA = 3;
    private Stage stage;
    private TabPane tp;
    
    public HBox principalPane(Stage stage){
        Button inventario, cuentas, calculadora, agenda;
        inventario = new Button("Inventario");
        cuentas = new Button("Cuentas");
        calculadora = new Button("Calculadora");
        agenda = new Button("Agenda");
        
        this.stage = stage;
        tp = new TabPane();
        
        Tab tInventario = new Tab(inventario.getText());
        Tab tCuentas = new Tab(cuentas.getText());
        Tab tCalculadora = new Tab(calculadora.getText(),Calculadora.calculadoraPane());
        Tab tAgenda = new Tab(agenda.getText(), Agenda.agendaPane());
                
        tp.getStyleClass().add("tabpane");
        tp.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tp.getTabs().addAll(tInventario,tCuentas,tCalculadora,tAgenda);
        
        inventario.setOnAction(e -> showTabs(INVENTARIO));
        calculadora.setOnAction(e -> showTabs(CALCULADORA));
        cuentas.setOnAction(e -> showTabs(CUENTAS));
        agenda.setOnAction(e -> showTabs(AGENDA));
        
        HBox h = new HBox();
        h.getChildren().addAll(inventario, cuentas, calculadora, agenda);
        h.setAlignment(Pos.CENTER);
        return h;
    }
    
    private void showTabs(int startingTab){
        SingleSelectionModel<Tab> selectionModel = tp.getSelectionModel();
        Scene scene = new Scene(tp,800,500);
        
        selectionModel.select(startingTab);
        
        scene.getStylesheets().add("tabs.css"); 
        stage.setScene(scene);
    }
}

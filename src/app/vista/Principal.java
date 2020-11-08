package app.vista;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
        
        tInventario.setContent(Inventario.inventarioPane(tInventario));
                
        tp.getStyleClass().add("tabpane");
        tp.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tp.setTabMaxWidth(300);
        tp.setTabMaxHeight(300);
        tp.getTabs().addAll(tInventario,tCuentas,tCalculadora,tAgenda);
        
        inventario.setOnAction(e -> showTabs(INVENTARIO));
        cuentas.setOnAction(e -> showTabs(CUENTAS));
        calculadora.setOnAction(e -> showTabs(CALCULADORA));
        agenda.setOnAction(e -> showTabs(AGENDA));
        
        HBox h = new HBox();
        h.getChildren().addAll(inventario, cuentas, calculadora, agenda);
        h.setAlignment(Pos.CENTER);
        return h;
    }
    
    private void showTabs(int startingTab){
        SingleSelectionModel<Tab> selectionModel = tp.getSelectionModel();
        Group g = new Group();
        ImageView logoIV = new ImageView();
        
        selectionModel.select(startingTab);
        try{
            logoIV.setImage(new Image(new FileInputStream(new File("src/images/logo3.png"))));
        }catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
        
        logoIV.setFitHeight(70);
        logoIV.setFitWidth(70);
        logoIV.setPreserveRatio(true);
        logoIV.setX(0);
        logoIV.setY(0);
        logoIV.toFront();
        
        
        g.getChildren().addAll(tp, logoIV);
        Scene scene = new Scene(g,900,600);
        
        scene.getStylesheets().add("tabs.css"); 
        stage.setScene(scene);
    }
}

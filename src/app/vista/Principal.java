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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
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
        Tab tCuentas = new Tab(cuentas.getText(), Cuenta.cuentaPane());
        Tab tCalculadora = new Tab(calculadora.getText(),Calculadora.
                calculadoraPane());
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
        // Selection model to start on the tab of tabpane that the user chose
        SingleSelectionModel<Tab> selectionModel = tp.getSelectionModel();
        
        /* StackPane to add the logo, closeSession and settings
         its not possible to use another Layout because of the TabPane */
        StackPane sp = new StackPane();
        VBox v = new VBox();
        ImageView logoIV = new ImageView();
        Button closeSession = new Button("Cerrar Sesion");
        Button settings = new Button();
        ImageView settingsIV = new ImageView();
        
//        closeSession.setOnAction(e -> );
        try{
            logoIV.setImage(new Image(new FileInputStream(
                    new File("src/images/logo3.png"))));
            settingsIV.setImage(new Image(new FileInputStream(
                    new File("src/images/settings.png"))));
        }catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
        
        logoIV.setFitHeight(80);
        logoIV.setFitWidth(80);
        logoIV.setPreserveRatio(true);
        settingsIV.setFitHeight(40);
        settingsIV.setFitWidth(40);
        settingsIV.setPreserveRatio(true);
        settings.setGraphic(settingsIV);
        settings.setId("settings");
        settings.setTranslateY(20);
        closeSession.setId("closeSession");
        selectionModel.select(startingTab);
        
        
        //v.getChildren().addAll(closeSession, settings);
        sp.getChildren().addAll(tp, logoIV, closeSession, settings);
        sp.setAlignment(logoIV, Pos.TOP_LEFT);
        //sp.setAlignment(v, Pos.TOP_RIGHT);
        sp.setAlignment(closeSession, Pos.TOP_RIGHT);
        sp.setAlignment(settings, Pos.TOP_RIGHT);
        Scene scene = new Scene(sp,800,500);
        
        scene.getStylesheets().add("tabs.css"); 
        stage.setScene(scene);
    }
}

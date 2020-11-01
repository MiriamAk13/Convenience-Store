package app.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

/**
 *
 * @author wrath
 */
public class Principal {
    public HBox principalPane(){
        Button inventario, cuentas, calculadora, agenda;
        inventario = new Button("Inventario");
        cuentas = new Button("Cuentas");
        calculadora = new Button("Calculadora");
        agenda = new Button("Agenda");
        
        TabPane tp = new TabPane();
        
        Tab tInventario = new Tab(inventario.getText());
        Tab tCuentas = new Tab(cuentas.getText());
        Tab tCalculadora = new Tab(calculadora.getText(),Calculadora.calculadoraPane());
        Tab tAgenda = new Tab(agenda.getText());
        
        //inventario.setOnAction(new Inventario());
        
        HBox h = new HBox();
        h.getChildren().addAll(inventario, cuentas, calculadora, agenda);
        h.setAlignment(Pos.CENTER);
        return h;
    }
}

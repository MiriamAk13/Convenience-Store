package app.vista;

import app.modelo.Supply;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author wrath
 */
public class Agenda {
    static TableView<Supply> tv;
    public static TableView agendaPane(){
        tv = new TableView<Supply>();
        
        TableColumn day = new TableColumn("Dia");
        TableColumn provider = new TableColumn("Proveedor");
        TableColumn amount = new TableColumn("Monto");
        TableColumn products = new TableColumn("Productos");
        
        tv.setPrefSize(600, 500);
        insertSupplies();
        
        tv.getColumns().addAll(day, provider, amount, products);
        return tv;
    }
    
    private static void insertSupplies(){
        ObservableList<Supply> data = FXCollections.observableArrayList(
                new Supply(new Date())
        );
    }
}

package app.vista;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author wrath
 */
public class Cuenta {
    public static TableView cuentaPane(){
        TableView tv = new TableView();
        
        TableColumn name = new TableColumn("Nombre"); //Person in debt
        TableColumn amount = new TableColumn("Monto a pagar");
        TableColumn products = new TableColumn("Productos");        
        TableColumn operations = new TableColumn("Operaciones");
        
        amount.setPrefWidth(100);        
        products.setPrefWidth(300);
        tv.setEditable(true);
        //name.setCellValueFactory(new PropertyValueFactory<>("name"));
        
        
        tv.getColumns().addAll(name, amount, products, operations);
        
        return tv;
    }
}

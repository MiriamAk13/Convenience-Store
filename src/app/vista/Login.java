package app.vista;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author wrath
 */
public class Login {
    public VBox loginPane(Stage stage){
        VBox v = new VBox();
        GridPane gp = new GridPane();
        
        ImageView loginIV = new ImageView();
        
        Label lUser = new Label("Usuario");
        Label lPwd = new Label("Contraseña");
        TextField tfUser = new TextField();
        TextField tfPwd = new TextField();
        
        Button bLogin = new Button("Ingresar");
        Principal p = new Principal();
        bLogin.setOnAction(e -> {
            //checkIdentification();
            stage.setScene(new Scene(p.principalPane(),800,500));
                });
        
        try{
            loginIV.setImage(new Image(new FileInputStream("src/images/login.png")));
        }catch(FileNotFoundException fnfe){
            fnfe.printStackTrace();
        }
        loginIV.setFitHeight(70);
        loginIV.setFitWidth(70);
        loginIV.setPreserveRatio(true);
        
        gp.add(lUser, 0, 0);
        gp.add(lPwd, 0, 1);
        gp.add(tfUser, 1, 0);
        gp.add(tfPwd, 1, 1);
        gp.setAlignment(Pos.CENTER);
                
        v.getChildren().addAll(loginIV,gp,bLogin);
        v.setAlignment(Pos.CENTER);
        return v;
    }
}

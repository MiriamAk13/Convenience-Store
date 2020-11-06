package app.modelo;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 *
 * @author wrath
 */
public class Product {
    private int id;
    private String name;
    private int quantity;
    private int price;
    private String imgName;

    public Product(int id, String name, int quantity, int price, String imgName) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.imgName = imgName;
    }
    
    public Product(int id, String name, int quantity, int price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.imgName = "noImageFound.jpg";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }
}

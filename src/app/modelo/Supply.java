package app.modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author wrath
 */
public class Supply {
    private Date day;
    private Provider provider;
    private double amount;
    private ArrayList<Product> products;
    
    public Supply(){
        
    }
    
    public Supply(Date day, Provider provider, double amount, ArrayList<Product> products) {
        this.day = day;
        this.provider = provider;
        this.amount = amount;
        this.products = products;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    
    
}

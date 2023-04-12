package product_manager.model;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String name;
    private double price;
    private String describer;
    private String producer;

    public Product() {
    }

    public Product(int id, String name, double price, String describer, String producer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.describer = describer;
        this.producer = producer;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescriber() {
        return describer;
    }

    public void setDescriber(String describer) {
        this.describer = describer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}

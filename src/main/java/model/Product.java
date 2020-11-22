package model;

public class Product {

    private long id_Product;
    private String name_Product;
    private String description;
    private double unit_Of_Measurement;
    private double sale_Price;

    public Product(long id_Product, String name_Product, String description, double unit_Of_Measurement, double sale_Price) {
        this.id_Product = id_Product;
        this.name_Product = name_Product;
        this.description = description;
        this.unit_Of_Measurement = unit_Of_Measurement;
        this.sale_Price = sale_Price;
    }

    public Product() {
    }

    public long getId_Product() {
        return id_Product;
    }

    public void setId_Product(long id_Product) {
        this.id_Product = id_Product;
    }

    public String getName_Product() {
        return name_Product;
    }

    public void setName_Product(String name_Product) {
        this.name_Product = name_Product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnit_Of_Measurement() {
        return unit_Of_Measurement;
    }

    public void setUnit_Of_Measurement(double unit_Of_Measurement) {
        this.unit_Of_Measurement = unit_Of_Measurement;
    }

    public double getSale_Price() {
        return sale_Price;
    }

    public void setSale_Price(double sale_Price) {
        this.sale_Price = sale_Price;
    }
}

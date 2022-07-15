package edu.school21.models;

public class Product {
    private long identifier;
    private String name;
    private int price;

    public Product(long identifier, String name, int price) {
        this.identifier = identifier;
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        return new org.apache.commons.lang.builder.EqualsBuilder().append(identifier, product.identifier).append(price, product.price).append(name, product.name).isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang.builder.HashCodeBuilder(17, 37).append(identifier).append(name).append(price).toHashCode();
    }

    public long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(long identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "identifier=" + identifier +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

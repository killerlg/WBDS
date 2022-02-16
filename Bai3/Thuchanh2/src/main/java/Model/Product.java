package Model;

public class Product {
    private int id;
    private String name;
    private String provider;

    public Product() {
    }

    public Product(int id, String name, String provider) {
        this.id = id;
        this.name = name;
        this.provider = provider;
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

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return  "id=" + id +
                ", name='" + name + '\'' +
                ", provider='" + provider + '\'' +
                '}';
    }
}

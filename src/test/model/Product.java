public class Product {

    private int id;
    private String name;
    private String description;
    private double price;

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    private String category_name;

    public Product(){}



    //used for post request

    public Product(String name, String description, double price, int category_id){

        setName(name);
        setDescription(description);
        setPrice(price);
        setCategory_id(category_id);
    }

    //used for update or get

    public Product(int id, String name, String description, double price, int category_id, String category_name){

        setId(id);
        setName(name);
        setDescription(description);
        setPrice(price);
        setCategory_id(category_id);
        setCategory_name(category_name);
    }

    public Product(int id){
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getCategory_id() {
        return category_id;
    }

    private int category_id;


}
//end of file.

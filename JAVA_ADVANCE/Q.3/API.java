/*
* 3) Create a Product class having properties like name,category, price .Create a ProductFactory class which gives you the List of products when you pass the number of Products.
   Now use stream Api -
    1) To get the list of products whose price range is between x and y.(You can assume x and y yourself)
    2) To get the total categories in the product list.
    3) To get the maximum and minimum priced product in each category.
* */



import java.util.*;
import java.util.stream.Collectors;

class Product {
    private String name;
    private String category;
    private int price;

    public Product(String name, String category, int price) {
        setName(name);
        setCategory(category);
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

class ProductFactory {
    private List<Product> products;

    public ProductFactory() {
        this.products = new ArrayList<Product>();
    }

    public void productAdd(String name, String category, int price) {
        products.add(new Product(name, category, price));
    }

    public void printProducts() {
        System.out.println("Products:");
        for (Product p : products) {
            System.out.println(p.getName() + "\t" + p.getCategory() + "\t" + p.getPrice());
        }
    }

    public void showPriceBetweenXandY(int x, int y) {
        System.out.println("Products priced range:(" + x + "," + y+")");
        List<Product> ans = products.stream().filter(p -> p.getPrice() >= x && p.getPrice() <= y).collect(Collectors.toList());
        ans.forEach(p -> System.out.print(p.getName()+" "));
        System.out.println();
    }

    private Set<String> getCategories(){
        Set<String> ans = products.stream().map(Product::getCategory).collect(Collectors.toSet());
        return ans;
    }
    public void getTotalCategories() {
        Set<String> ans = getCategories();
        System.out.println("Total categories:"+ans.size());
        for(String itr:ans){
            System.out.print(itr+" ");
        }
        System.out.println();
    }

    public void showMaxMinPricedProduct() {
        Set<String> setcat = getCategories();
        for (String str : setcat) {
            int max = products.stream().filter(p -> p.getCategory().equals(str)).map(Product::getPrice).max(Comparator.comparing(Integer::valueOf)).get();
            int min = products.stream().filter(p -> p.getCategory().equals(str)).map(Product::getPrice).min(Comparator.comparing(Integer::valueOf)).get();
            System.out.println("Category:" + str + "(Minimum:" + min+",Maximum:" + max+")");
        }
    }
}

public class API {
    public static void main(String[] args) {
        ProductFactory factory = new ProductFactory();
        factory.productAdd("Iphone", "phone", 100);
        factory.productAdd("MacBook", "laptop", 200);
        factory.productAdd("Dyson", "vaccuum", 50);
        factory.productAdd("HP", "laptop", 150);
        factory.productAdd("OnePlus", "phone", 10);
        factory.productAdd("Dell", "laptop", 70);
        factory.printProducts();
        factory.showPriceBetweenXandY(50, 100);
        factory.getTotalCategories();
        factory.showMaxMinPricedProduct();
    }
}
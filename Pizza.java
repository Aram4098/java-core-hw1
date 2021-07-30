import java.util.*;
public class Pizza {
    private String name;
    private ArrayList<String> ingredients = new ArrayList<>();
    private String type;
    private int quantity;
    
    public Pizza(String name, ArrayList<String> ingredients, String type, int quantity) {
        this.name = name;
        this.type = type;
        try {
            if(quantity>10) {
                throw new MyException("Exception: Maximum quantity is 10");
            } 
        } catch(MyException exp) {
            System.out.println(exp.getMessage());
            System.exit(0);
        }
        this.quantity = quantity;
        for(int i = 0; i<ingredients.size() ; i++) {
            this.ingredients.add(ingredients.get(i));
        }
    }
    
    public Pizza(String name, String type, int quantity) {
        this.name = name;
        this.name = name;
        this.type = type;
        if(quantity>10) {
            System.out.println("Exception: Maximum quantity is 10");
            this.quantity = 10;
        } else { 
            this.quantity = quantity;
        }
    }
    
    public String getName() {
        return this.name;
    } 
    
    public void setName(String n) {
        this.name = n;
    }
    
    public String getType() {
        return this.type;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    
    public ArrayList<String> getIngredients() {
        return this.ingredients;
    }
    
    public void addIngredient(String ing) {
        try {
            if(ingredients.size()>=10) {
                throw new MyException("Exception: The pizza is already full");
            } else if(ingredients.contains(ing)) {
                throw new MyException("Exception: The ingredient is already there. Check your order");
            }
        }catch(MyException exp) {
            System.out.println(exp.getMessage());
            System.exit(0);
        }
        ingredients.add(ing);
    }
    
    public double typePrice() {
        if(this.type.equals("regular")) {
            return 1;
        } else {
            return 1.5;
        }
    }
    
    public double ingredientPrice(String ingr) {
        switch(ingr) {
            case "Tomato paste":
            return 1;
            case "Cheese":
            return 1;
            case "Salami":
            return 1.5;
            case "Bacon":
            return 1.2;
            case "Garlic":
            return 0.3;
            case "Corn":
            return 0.7;
            case "Pepperoni":
            return 0.6;
            case "Olives":
            return 0.5;
            default:
            return 0;
        }
    }
    
}
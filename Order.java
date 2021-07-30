import java.util.*;
import java.time.LocalTime;
public class Order {
    
    private static int n = 10000;
    private int orderNumber;
    private int customerNumber;
    private String customerName;
    private ArrayList<Pizza> pizzas = new ArrayList<>();
    private LocalTime orderTime;
    
    public Order(int customerNumber, String customerName, ArrayList<Pizza> pizzas) {
        orderTime = LocalTime.now();
        this.orderNumber = n++;
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        for(int i = 0; i<pizzas.size() ; i++) {
            if(pizzas.get(i).getName().length()<4 | pizzas.get(i).getName().length()>20) {
                pizzas.get(i).setName(customerName + customerNumber);
            }
            this.pizzas.add(pizzas.get(i));
        }
    }
    
    public int getOrderNumber() {
        return this.orderNumber;
    }
    
    public int getCustomerNumber() {
        return this.customerNumber;
    }
    
    public String getCustomerName() {
        return this.customerName;
    }
    
    public ArrayList<Pizza> getPizzas() {
        return this.pizzas;
    }
    
    public void Display() {
        for(Pizza p : pizzas) {
            System.out.println("[" + orderNumber + " : " + customerNumber + " : " + p.getName() + " : " + p.getQuantity() + "]");
        }
    }
    
    public void printCheck() {
        System.out.println("*******************************");
        System.out.println("Order: " + orderNumber);
        System.out.println("Client: " + customerNumber);
        double total=0;
        for(Pizza p: pizzas) {
            System.out.println("Name: " + p.getName());
            System.out.println("------------------");
            System.out.println("Pizza Base (Calzone) " + p.typePrice() + "0 \u20AC");
            double count=p.typePrice();
            for(String i: p.getIngredients()) {
                count += p.ingredientPrice(i);
                System.out.println(i + " " + p.ingredientPrice(i) + "0 \u20AC");
            }
            System.out.println("------------------");
            System.out.println("Amount: " + count + "0 \u20AC");
            System.out.println("Quantity: " + p.getQuantity());
            total += p.getQuantity()*count;
            System.out.println("------------------");
        }
        System.out.println("Total amount: " + total + "0 \u20AC");
        System.out.println("*******************************");
    }
    
    public static void main(String[] args) {
        
        Pizza pizza1 = new Pizza("Margarita", "regular", 2);
        pizza1.addIngredient("Tomato paste");
        pizza1.addIngredient("Garlic");
        pizza1.addIngredient("Bacon");
        
        Pizza pizza2 = new Pizza("PepperoniOro", "regular", 3);
        pizza2.addIngredient("Tomato paste");
        pizza2.addIngredient("Cheese");
        pizza2.addIngredient("Pepperoni");
        
        ArrayList<Pizza> pizzas1 = new ArrayList<>();
        pizzas1.add(pizza1);
        pizzas1.add(pizza2);
        Order first = new Order(7717, "Aram", pizzas1);
        first.printCheck();
        
        System.out.println();
        System.out.println();
        
        Pizza pizza3 = new Pizza("Margarita", "regular", 12);
        ArrayList<Pizza> pizzas2 = new ArrayList<>();
        pizzas2.add(pizza3);
        Order second = new Order(4372, "Anna", pizzas2);
    }
}
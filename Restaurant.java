/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

/**
 *
 * @author Students
 */
import java.util.*;
public class Restaurant {

   /*
     * @param args the command line arguments
     */
    private Map<String, Double> menu;
    public Restaurant() {
        menu = new HashMap<>();
        menu.put("Chapo" , 10.00);
        menu.put("Maandazi" ,5.00);
        menu.put("Ugali" , 30.00);
        menu.put("Pilau" , 100.00);
        menu.put("Jollof rice" , 150.00);
        menu.put("Mshikaki", 80.00);
        // TODO code application logic here
    }
    public void displayMenu(){
        System.out.println("Menu:");
        for (String item : menu.keySet()) {
            System.out.println(item + " - " + menu.get(item));
        }
    }
    public void addItem(String item, double price){
        menu.put(item, price);
        System.out.println("Item added to the menu");
    }
    public void removeItem(String item){
        menu.remove(item);
        System.out.println("Item removed from the menu");
    }
    public void takeOrder(){
        Scanner input = new Scanner(System.in);
        List<String> order = new ArrayList<>();
        double bill = 0.0;
        System.out.println("Enter your order for today (type 'done' to finish):");
        String item = input.nextLine();
        while (!item.equalsIgnoreCase("done")){
            if (menu.containsKey(item)){
                order.add(item);
                bill += menu.get(item);
            } else {
                System.out.println("Sorry, we do not have this dish on the menu at the moment.");
            }
            item = input.nextLine();
            System.out.println("Order:");
            for (String i : order) {
                System.out.println(i + " - " + menu.get(i));
            }
            System.out.println("Your total bill: " + bill);
            System.out.println("Please make payment via mobile money.");
        }
 
    public static void main(String[] args){
            Restaurant restaurant = new Restaurant();
            restaurant.displayMenu();
            restaurant.addItem("Fish" , 150.0);
            restaurant.removeItem("Water");
            restaurant.displayMenu();
            restaurant.takeOrder();
        }
    }

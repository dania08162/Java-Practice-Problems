import java.util.Scanner; 

public class JavaDiner{ 

    public static void main(String[] args){ 

        Scanner sc = new Scanner(System.in); //for taking input 

        System.out.println("Welcome to the Java Diner! "); 

        System.out.println("Select your meal type: "); 

        System.out.println("B - Breakfast"); 

        System.out.println("L - Lunch"); 

        System.out.println("D - Dinner"); 

        System.out.println("Enter your choice (B/L/D): "); 

        char selection = sc.nextLine().charAt(0); //reads only the first letter of what the user inputs 

        switch (selection) { 

            case 'B': 

            case 'b': //so that it is not case sensitive 

                breakfast(sc);//if they decide for breakfast 

                break; 

            case 'L': 

            case 'l': //so that it is not case sensitive 

                lunch(sc);//if they decide for lunch 

                break; 

            case 'D': 

            case 'd'://so that it is not case sensitive 

                dinner(sc); //if they decide for dinner 

                break; 

            default:  

                System.out.println("Invalid meal type. Please restart and choose B/L/D."); 

        } 

    } 

    public static void breakfast(Scanner sc){ //making a new section for breakfast 

        System.out.println("--- Breakfast Menu ---"); 

        System.out.println("1. Pancakes - $5.99"); 

        System.out.println("2. Omelette - $4.99"); 

        System.out.println("3. Coffee - $2.49"); 

        System.out.println("Enter your choice (1-3): "); 

        int choice = sc.nextInt(); //taking input of the user/s choice 

        double total = 0; //starting price 

        if (choice == 1) { 

            total = 5.99; 

        } else if (choice == 2) { 

            total = 4.99; 

        } else if (choice == 3 ) {  

            total = 2.49; 

        } else {  

            System.out.println("Invalid choice. No order placed."); 

            System.out.println("Your total bill is: $" + total); 

            System.out.println("Thank you for dining with us!"); 

            return; 

        } 

        System.out.println("Your total bill is: $" + total);//final bill 

        System.out.println("Thank you for dining with us!"); 

    } 

    public static void lunch(Scanner sc){ //making a new section for lunch 

        System.out.println("--- Lunch Menu ---"); 

        System.out.println("1.Burger - $7.49"); 

        System.out.println("2. Salad - $6.99"); 

        System.out.println("3. Soda - $1.99"); 

        System.out.println("Enter your choice (1-3): "); 

        int choice = sc.nextInt();//taking input of the user/s choice 

        double total = 0;//starting price 

        if (choice == 1) { 

            total = 7.49; 

        } else if (choice == 2) { 

            total = 6.99; 

        } else if (choice == 3 ) {  

            total = 1.99; 

        } else {  

            System.out.println("Invalid choice. No order placed."); 

            System.out.println("Your total bill is: $" + total); //final bill 

            System.out.println("Thank you for dining with us!"); 

            return; 

        } 

        System.out.println("Your total bill is: $" + total); 

        System.out.println("Thank you for dining with us!"); 

    } 

    public static void dinner(Scanner sc){ //making a new section for dinner 

        System.out.println("--- Dinner Menu ---"); 

        System.out.println("1.Steak - $12.99"); 

        System.out.println("2. Pasta - $10.99"); 

        System.out.println("3. Wine - $8.49"); 

        System.out.println("Enter your choice (1-3): "); 

        int choice = sc.nextInt();//taking input of the user/s choice 

        double total = 0;//starting price 

        if (choice == 1) { 

            total = 12.99; 

        } else if (choice == 2) { 

            total = 10.99; 

        } else if (choice == 3 ) {  

            total = 8.49; 

        } else {  

            System.out.println("Invalid choice. No order placed."); 

            System.out.println("Your total bill is: $" + total); //final bill 

            System.out.println("Thank you for dining with us!"); 

            return; 

        } 

        System.out.println("Your total bill is: $" + total);//final bill 

        System.out.println("Thank you for dining with us!"); 

    } 

} 

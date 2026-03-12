import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        for(int i = 1; i <= 3; i++){

            System.out.println("Enter Customer Name:");
            String name = input.nextLine();

            System.out.println("Enter Phone Number:");
            String phone = input.nextLine();

            System.out.println("Enter Package Type (A/B/C):");
            char packageType = input.next().charAt(0);

            System.out.println("Enter Minutes Used:");
            int minutes = input.nextInt();
            input.nextLine();

            Customer c = new Customer(name, phone, packageType, minutes);

            double bill = Billing.calculateBill(c);

            System.out.println("Customer: " + c.getName());
            System.out.println("Bill = " + bill);

            System.out.println("-----------------------");

        }

    }

}



public class Customer {

    private String name;
    private String phone;
    private char packageType;
    private int minutesUsed;

    // Constructor
    public Customer(String name, String phone, char packageType, int minutesUsed) {

        if(phone.length() != 11){
            System.out.println("Phone number must be 11 digits");
            phone = "00000000000";
        }

        if(minutesUsed < 0){
            System.out.println("Minutes cannot be negative");
            minutesUsed = 0;
        }

        this.name = name;
        this.phone = phone;
        this.packageType = packageType;
        this.minutesUsed = minutesUsed;
    }

    // Getters
    public String getName(){
        return name;
    }

    public String getPhone(){
        return phone;
    }

    public char getPackageType(){
        return packageType;
    }

    public int getMinutesUsed(){
        return minutesUsed;
    }

}

public class Billing {

    public static double calculateBill(Customer c){

        double bill = 0;

        switch(c.getPackageType()){

            case 'A':
                bill = 300;
                if(c.getMinutesUsed() > 100){
                    bill += (c.getMinutesUsed() - 100) * 2;
                }
                break;

            case 'B':
                bill = 500;
                if(c.getMinutesUsed() > 250){
                    bill += (c.getMinutesUsed() - 250) * 1.5;
                }
                break;

            case 'C':
                bill = 800;
                break;

            default:
                System.out.println("Invalid Package");
        }

        return bill;
    }

}
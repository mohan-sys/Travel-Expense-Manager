import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;



class Travel {
    
    public static HashMap<String,HashMap<String,Integer>> trip = new HashMap<>();
    public static HashMap<String,Integer> users = new HashMap<>();
   




    public static void main(String[] args) {
        


        selection_processes(trip);

    }

    

    static void selection_processes(HashMap<String,HashMap<String,Integer>> trip){
        Scanner sc = new Scanner(System.in);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("---WELCOME TO MONEY SPLIT UP---");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("           TRIP MENU           ");
        System.out.println("           ---------           ");
        System.out.println();
        System.out.println("1. Enter Trip Name");
        System.out.println("2. Display all Trips' name");
        System.out.println("3. Goto a Trip's Detail");
        System.out.println("4. EXIT");

        System.out.println("Enter your option: ");
        int n = sc.nextInt();
        switch(n){
            case 1:
                // Get the trip name
                System.out.println();
                System.out.println("Enter the trip name: ");
                sc.nextLine();
                String tripName = sc.nextLine();
                System.out.println();
                trip.put(tripName,users);
                selection_processes(trip);
                break;

            case 2:
                // Display all trips
                System.out.println();
                System.out.println(trip.keySet());
                System.out.println();
                selection_processes(trip);
                break;

            case 3:
                //Go inside a trip
                sc.nextLine();
                String goto_trip = sc.nextLine();
                System.out.println();
                user_data_manipulation(trip.get(goto_trip)); 
                selection_processes(trip);
                break;

            case 4:
                System.exit(0);
        }
        
    }

    static void user_data_manipulation(HashMap<String,Integer>users){
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("           USER MENU           ");
        System.out.println("           ---------           ");
        System.out.println("Welcome to money split up");
        System.out.println("Please choose any of the following");
        System.out.println("1. Add user to the System");
        System.out.println("2. Add trips to the system");
        System.out.println("3. Expense by a particular user");
        System.out.println("4. Show total expense");
        System.out.println("5. Who owes who what??");
        System.out.println("6. RETURN TO MAIN MENU");
        System.out.println("7. EXIT");
        System.out.println("Enter your option: ");
        int n = sc.nextInt();

        switch (n) {
            case 1:
            //    Storing the user name and money spent by the respective user
                
                System.out.println();
                System.out.println("Enter user name and money spent");
                sc.nextLine();

                String a = sc.nextLine();
                Integer b = sc.nextInt();
                System.out.println();
                users.put(a, b);
                user_data_manipulation(users);
                break;

            case 2:
            //     Goto the trip process

                selection_processes(trip);

                break;

            case 3:
                //  To print the expense by each person.
                System.out.println();
                System.out.println("Enter the user's name of who you want to get the expenditure: ");
                sc.nextLine();
                String userName = sc.nextLine();
                System.out.println();

                single_expenditure(userName, users);

                user_data_manipulation(users);
            
                break;
            

            case 4:
            // To print the total expense occured in that trip.

                total_expense(users);

                user_data_manipulation(users);

                break;

            case 5:
                // who owes what
                money_management(users);

                user_data_manipulation(users);

                break;  

            case 6:
                selection_processes(trip);
                break;

            case 7:
                System.exit(0);
                
        }
    }

    static void money_management(HashMap<String,Integer>x){
        Collection<Integer> money = new ArrayList<>();
        money = x.values();

        int sum=0;
        ArrayList<Integer> money1 = new ArrayList<>(money);
        int n=money1.size();
        for(int i=0 ; i<n;i++){
            sum+=money1.get(i);
        }
        int avg=sum/n;
        x.forEach((k,v)->{
            if(v<avg){
                int debt = avg - v;
                System.out.println(k+" owes "+debt+" to the table");
            }
            if(v>avg){
                int diff = v - avg;
                System.out.println("table owes "+diff+" to "+k);
            }
        });
        System.out.println();

        
    }

    static void total_expense(HashMap<String,Integer>x){
        Collection<Integer> money = new ArrayList<>();
        money = x.values();
        int sum=0;
        ArrayList<Integer> money1 = new ArrayList<>(money);
        int n=money1.size();
        for(int i=0 ; i<n;i++){
            sum+=money1.get(i);
        }
        System.out.println(sum);
    }
    
    static void single_expenditure(String user_name,HashMap<String,Integer>x){
        System.out.println(x.get(user_name));

    }

    
}

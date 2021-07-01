import java.util.Scanner;

public class User {
    int select =0;
    void getUserIdex(){
        Scanner scan = new Scanner(System.in);
        try {
            select = scan.nextInt();

        }catch (Exception e) {
            System.out.println("wrong input");
            System.out.println("Please enter a number");
            getUserIdex();
            System.out.println();

        }

    }
}

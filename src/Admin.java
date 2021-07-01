import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends User{
    int fixedRow = 0;
    int fixedCol = 0;
    int chosedRow = 0;
    int chosedCol = 0;
    int numOfPurchasedTicket = 0;
    double percentageOfNumOfTicket = 0.0;
    int totalIncome;


    double totalRowCol;
    int currentIncome = 0;
    char[][] character;
    Scanner scan = new Scanner(System.in);
    void getAdminIndex() {

        System.out.println("Enter the number of Rows ");

        try {
            fixedRow = scan.nextInt();
        } catch (InputMismatchException IME) {
            System.out.println("wrong input");
            System.out.println("Please enter a number");
            System.out.println();
            scan.next();
            getAdminIndex();
        }

        System.out.println("Enter the number of seats on a row ");

        try {
            fixedCol = scan.nextInt();
        } catch (InputMismatchException IME) {
            System.out.println("wrong input");
            System.out.println("Please enter a number");
            System.out.println();
            getAdminIndex();
        }

        }
    void assignIndex(){
        int totalRowCol = fixedCol * fixedRow;
        //total expected income
        totalIncome = totalRowCol * 10;
        //create an empty character array
        character = new char[fixedRow][fixedCol];
        //assign value of S to all position in the array
        for (int i = 0; i < fixedRow; i++) {
            for (int j = 0; j < fixedCol; j++) {
                character[i][j] = 'S';
            }
        }
    }
    void printIdex(){
        for (int i = 0; i< fixedRow; i++){
            for(int j =0; j< fixedCol; j++){

                System.out.print(character[i][j] + "  ");
            }
            System.out.println();
        }

    }
    void buyTicket(){
        System.out.println("Enter a row number");

        try {
            chosedRow = scan.nextInt();
        }catch (InputMismatchException IME) {
            System.out.println("wrong input");
            System.out.println("Please enter a number");
            buyTicket();
        }

        System.out.println("Enter a seat number on row");
        try {
            chosedCol = scan.nextInt();
        }catch (InputMismatchException IME) {
            System.out.println("wrong input");
            System.out.println("Please enter a number");
            buyTicket();

        }
        //condition to check if selected row is not a valid selection
        if( chosedRow > fixedRow || chosedCol >fixedCol || chosedRow < 0 || chosedCol < 0){
            System.out.println("wrong input");
        }else {
            if(character[chosedRow-1][chosedCol-1] != 'B') {
                character[chosedRow-1][chosedCol-1] = 'B';
                currentIncome += 10;
                numOfPurchasedTicket++;

                System.out.println("you purchased a ticket on row " + chosedRow + " and seat number " + chosedCol + "for $10");
            }else {
                System.out.println("seat has already been taken");
            }
        }

    }
    void showStat(){
        System.out.println("Number of Purchased ticket = " + numOfPurchasedTicket);
        DecimalFormat df = new DecimalFormat("#.##");
        percentageOfNumOfTicket = (numOfPurchasedTicket/totalRowCol)*100;
        System.out.println("The percentage of purchased ticket = " + df.format(percentageOfNumOfTicket) + " %");
        System.out.println("Current income = $" + currentIncome);
        System.out.println("Expected Total income = $" + totalIncome);
    }
}
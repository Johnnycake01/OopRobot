public class OopRobot {
    public static void main(String[] args) {

        Admin admin = new Admin();
        User user = new User();
        admin.getAdminIndex();
        admin.assignIndex();
        do{
            //default output for user to select option
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            System.out.println("Choose 1,2,3 to perform action or chose 0 to exit ");
            System.out.println();
            user.getUserIdex();
            System.out.println();


            if(user.select == 1){
                //show the seats
               admin.printIdex();
                System.out.println();
            }else if(user.select == 2){
                //to buy a ticket

                admin.buyTicket();
                System.out.println();
            }else if(user.select == 3){
                //statistic

               admin.showStat();
                System.out.println();

            }else if (user.select< 0 || user.select > 3){
                System.out.println("Invalid input, please try again");
                System.out.println();
            }
        } while (user.select != 0);

    }
}



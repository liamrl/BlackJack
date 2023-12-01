import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner (System.in);
        System.out.println("Hello welcome to the BlackJack player!\nWould you like to bet the normal amount per game ($500) or choose your own bet amount (1 for normal, 2 for choose your own)? ");
        int a = s.nextInt();

        int quit = 0;

        if (a == 1){
            BlackJack b = new BlackJack();
            while (quit == 0){
                b.firstRound();
                System.out.println("\nWould you like to hit (input 1) or stand (input 2)? ");
                int hit = s.nextInt();
                if (hit == 1){
                    while (hit == 1) {
                        b.userPlay(1);
                        System.out.println("\nWould you like to hit (input 1) or stand (input 2)? ");
                        hit = s.nextInt();
                    }
                } else {
                    b.userPlay(2);
                }

                b.computerPlay();
                b.showCards();

                System.out.println("");

                System.out.println("The computer's count is " + b.getComputerCounter());
                System.out.println("Your count is " + b.getPlayerCounter());

                if (b.winner(b.getComputerCounter(), b.getPlayerCounter())){
                    System.out.println("You win!!!");
                    b.bet(true);
                }
                else{
                    System.out.println("You lose :(");
                    b.bet(false);
                }

                System.out.print("Your purse is now ");
                System.out.println(b.getPlayerPurse());

                b.resetGame();

                System.out.println("Would you like to play another game? Press 0 if yes, press 1 if no. ");
                quit = s.nextInt();

            }



        } else {
            System.out.println("How much would you like to bet per game? ");
            int c = s.nextInt();
            BlackJack b = new BlackJack(c);
            while (quit == 0) {
                b.firstRound();
                System.out.println("\nWould you like to hit (input 1) or stand (input 2)? ");
                int hit = s.nextInt();
                if (hit == 1){
                    while (hit == 1) {
                        b.userPlay(1);
                        System.out.println("\nWould you like to hit (input 1) or stand (input 2)? ");
                        hit = s.nextInt();
                    }
                } else {
                    b.userPlay(2);
                }

                b.computerPlay();
                b.showCards();

                System.out.println("");

                System.out.println("The computer's count is " + b.getComputerCounter());
                System.out.println("Your count is " + b.getPlayerCounter());

                if (b.winner(b.getComputerCounter(), b.getPlayerCounter())){
                    System.out.println("You win!!!");
                    b.bet(true);
                }
                else{
                    System.out.println("You lose :(");
                    b.bet(false);
                }

                System.out.print("Your purse is now ");
                System.out.println(b.getPlayerPurse());

                b.resetGame();

                System.out.println("Would you like to play another game? Press 0 if yes, press 1 if no. ");
                quit = s.nextInt();


            }

        }

    }
}
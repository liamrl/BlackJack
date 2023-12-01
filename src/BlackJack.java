import java.lang.*;
import java.util.*;
import java.util.ArrayList;

public class BlackJack {

    private final ArrayList<Integer> FULL_DECK = new ArrayList<Integer>(Arrays.asList(111, 102, 103, 104, 105, 106, 107,
            108, 109, 110, 112, 113, 114, 211, 202, 203, 204, 205, 206, 207, 208, 209, 210, 212, 213, 214, 311, 302, 303, 304,
            305, 306, 307, 308, 309, 310, 312, 313, 314, 411, 402, 403, 404, 405, 406, 407, 408, 409, 410, 412, 413, 414));
    private ArrayList<Integer> useDeck = new ArrayList<Integer>(FULL_DECK);
    private ArrayList<Integer> playerDeck = new ArrayList<Integer>();
    private ArrayList<Integer> computerDeck = new ArrayList<Integer>();
    private int betAmount;
    private int playerPurse = 0;
    private int numCardsLeft = 52;
    private int playerCounter = 0;
    private int computerCounter = 0;

    public BlackJack() {
        betAmount = 500;
    }

    public BlackJack(int betAmount) {
        this.betAmount = betAmount;
    }

    public int cardInIntForm() {
        int rando = (int) (Math.random() * numCardsLeft);
        int cardInt = useDeck.get(rando);
        useDeck.remove(rando);
        numCardsLeft--;
        return cardInt;

    }

    public void firstRound() {
        System.out.println("Your cards are: ");
        int playerFirstCard = cardInIntForm();
        playerDeck.add(playerFirstCard);
        System.out.println(convertToString(playerFirstCard));

        int playerSecondCard = cardInIntForm();
        playerDeck.add(playerSecondCard);
        System.out.println(convertToString(playerSecondCard));

        System.out.println("\nThe computer's cards are: ");
        int computerFirstCard = cardInIntForm();
        computerDeck.add(computerFirstCard);
        System.out.println(convertToString(computerFirstCard));

        int computerSecondCard = cardInIntForm();
        computerDeck.add(computerSecondCard);
        System.out.println("The computer has gotten the second card");
    }

    public String convertToString(int cardInt) {
        String cardStr = "";
        if (cardInt % 100 == 11) {
            cardStr += "Ace of ";
        } else if (cardInt % 100 == 2) {
            cardStr += "Two of ";
        } else if (cardInt % 100 == 3) {
            cardStr += "Three of ";
        } else if (cardInt % 100 == 4) {
            cardStr += "Four of ";
        } else if (cardInt % 100 == 5) {
            cardStr += "Five of ";
        } else if (cardInt % 100 == 6) {
            cardStr += "Six of ";
        } else if (cardInt % 100 == 7) {
            cardStr += "Seven of ";
        } else if (cardInt % 100 == 8) {
            cardStr += "Eight of ";
        } else if (cardInt % 100 == 9) {
            cardStr += "Nine of ";
        } else if (cardInt % 100 == 10) {
            cardStr += "Ten of ";
        } else if (cardInt % 100 == 12) {
            cardStr += "Jack of ";
        } else if (cardInt % 100 == 13) {
            cardStr += "Queen of ";
        } else {
            cardStr += "King of ";
        }

        if (cardInt / 100 == 1) {
            cardStr += "Diamonds";
        } else if (cardInt / 100 == 2) {
            cardStr += "Clubs";
        } else if (cardInt / 100 == 3) {
            cardStr += "Hearts";
        } else {
            cardStr += "Spades";
        }
        return cardStr;
    }

    public void userPlay(int choice) {
        ArrayList<Integer> playerDeckPlay = new ArrayList<Integer>(playerDeck);
        if (playerDeck.size() == 2){
            if ((playerDeckPlay.get(0) % 100) > 11) {
                playerCounter += 10;
            } else {
                playerCounter += (playerDeckPlay.get(0) % 100);
            }

            if ((playerDeckPlay.get(1) % 100) > 11) {
                playerCounter += 10;
            } else {
                playerCounter += (playerDeckPlay.get(1) % 100);

            }
        }

        if (choice == 1) {
            int newCard = cardInIntForm();
            System.out.println(convertToString(newCard));
            playerDeck.add(newCard);
            playerDeckPlay.add(newCard);
            if (newCard % 100 > 11) {
                playerCounter += 10;
            } else {
                playerCounter += (newCard % 100);
            }

            if (playerCounter > 21) {
                if (playerDeckPlay.contains(111)) {
                    int m = playerDeckPlay.indexOf(111);
                    playerDeckPlay.remove(m);
                    playerCounter -= 10;
                } else if (playerDeckPlay.contains(211)) {
                    int m = playerDeckPlay.indexOf(211);
                    playerDeckPlay.remove(m);
                    playerCounter -= 10;
                } else if (playerDeckPlay.contains(311)) {
                    int m = playerDeckPlay.indexOf(311);
                    playerDeckPlay.remove(m);
                    playerCounter -= 10;
                } else if (playerDeckPlay.contains(411)) {
                    int m = playerDeckPlay.indexOf(411);
                    playerDeckPlay.remove(m);
                    playerCounter -= 10;
                }
            }
        } else {
            playerDeckPlay.clear();
        }

    }


    public void computerPlay () {
        ArrayList<Integer> computerDeckPlay = new ArrayList<Integer>(computerDeck);
        if ((computerDeckPlay.get(0) % 100) > 11) {
            computerCounter += 10;
        } else {
            computerCounter += (computerDeckPlay.get(0) % 100);
        }

        if ((computerDeckPlay.get(1) % 100) > 11) {
            computerCounter += 10;
        } else {
            computerCounter += (computerDeckPlay.get(1) % 100);
        }

        while (computerCounter < 17) {
            int newCard = cardInIntForm();
            System.out.print("\nThe computer got the ");
            System.out.println(convertToString(newCard));
            computerDeckPlay.add(newCard);
            computerDeck.add(newCard);
            if (newCard % 100 > 11) {
                computerCounter += 10;
            } else {
                computerCounter += (newCard % 100);
            }

            if (computerCounter > 21) {
                if (computerDeckPlay.contains(111)) {
                    int m = computerDeckPlay.indexOf(111);
                    computerDeckPlay.remove(m);
                    computerCounter -= 10;
                } else if (computerDeckPlay.contains(211)) {
                    int m = computerDeckPlay.indexOf(211);
                    computerDeckPlay.remove(m);
                    computerCounter -= 10;
                } else if (computerDeckPlay.contains(311)) {
                    int m = computerDeckPlay.indexOf(311);
                    computerDeckPlay.remove(m);
                    computerCounter -= 10;
                } else if (computerDeckPlay.contains(411)) {
                    int m = computerDeckPlay.indexOf(411);
                    computerDeckPlay.remove(m);
                    computerCounter -= 10;
                }
            }
        }
    }

    public boolean winner( int computerCounter, int playerCounter){
        if (playerCounter > 21 || playerCounter <= computerCounter && computerCounter < 22) {
            return false;
        } else {
            return true;
        }
    }

    public int getPlayerPurse () {
        return playerPurse;
    }

    public int getPlayerCounter () {
        return playerCounter;
    }

    public int getComputerCounter () {
        return computerCounter;
    }

    public void bet ( boolean winner){
        if (winner) {
            playerPurse += betAmount;
        } else {
            playerPurse -= betAmount;
        }
    }



    public void resetGame() {
        playerDeck.clear();
        computerDeck.clear();
        useDeck = (ArrayList)FULL_DECK.clone();;
        numCardsLeft = 52;
        playerCounter = 0;
        computerCounter = 0;
    }

    public void showCards () {
        int lenPlay = playerDeck.size();
        int lenComp = computerDeck.size();
        System.out.println("\nYour cards are: ");
        for (int i = 0; i < lenPlay; i++) {
            int e = playerDeck.get((i));
            System.out.println(convertToString(e));
        }
        System.out.println("\nThe computers cards are: ");
        for (int i = 0; i < lenComp; i++) {
            int u = computerDeck.get(i);
            System.out.println(convertToString(u));
        }
    }
}

/* Eduardo Sacristan Beltri
   1st DAM
   Compulsory excercises for units 1 to 4*/


import java.util.Scanner;

class Games {
    public static final int MAXNUMBERS = 6;
    public static void main(String[]args) {
        
       if (args[0].equals("lottery")) {
            playLottery();
        }
        else if (args [0].equals("nim") && Integer.parseInt(args[1]) > 0 && 
          Integer.parseInt(args[1]) <= 30) {
            playNim(Integer.parseInt(args[1]));
        }
        else {
            System.out.println("Wrong Input");
        }
    }

    public static int generateNumber(int min, int max) {
        int randomNumber = min + (int) (Math.random() * max);
        return randomNumber;
    }
    
    public static int[] generateLottery() {
        int [] winnerNumber = new int [6];
        int jokerNumber;
        boolean validNumbers;

        do {
            validNumbers = true;
            for (int i = 0; i < winnerNumber.length; i++) {
                winnerNumber[i] = generateNumber(1, 50);
            }
            
            for (int i = 0; i < winnerNumber.length - 1; i++) {
                for (int j = i + 1; j < winnerNumber.length; j++) {
                    if (winnerNumber[i] == winnerNumber[j])
                        validNumbers = false;
                }
            }
        }
        while(validNumbers == false);

        for (int i = 0; i < winnerNumber.length - 1; i++) {
            for (int j = i + 1; j < winnerNumber.length; j++) {
                if (winnerNumber[i] > winnerNumber[j]) {
                    jokerNumber = winnerNumber[i];
                    winnerNumber[i] = winnerNumber[j];
                    winnerNumber[j] = jokerNumber;
                }
            }
        }
        return winnerNumber;
    }
    public static int checkLottery (int[] user, int[] winner) {
        int winsMeter = 0;

        for (int i = 0; i < MAXNUMBERS; i ++) {
            for (int j = 0; j < MAXNUMBERS; j++) {
                if (user[i] == winner[j]) {
                    winsMeter++;
                }
            }
        }
        return winsMeter;
    }
    public static void playLottery() {
        Scanner sc = new Scanner (System.in);

        int[] lotteryNumbers = new int [MAXNUMBERS];
        int jokerNumber;
        boolean validNumbers;

        System.out.println("Welcome to the lottery game. Good Luck!");
            
        do {
            System.out.println("Enter your combination");
            validNumbers = true;
            for (int i = 0; i < MAXNUMBERS; i++) {
                lotteryNumbers[i] = sc.nextInt();
            }
                
            for (int i = 0; i < MAXNUMBERS - 1; i++) {
                for (int j = i + 1; j < MAXNUMBERS; j++) {
                    if (lotteryNumbers[i] == lotteryNumbers[j])
                        validNumbers = false;
                }
            }
        }
        while (validNumbers == false);
        sc.close();

        for (int i = 0; i < MAXNUMBERS - 1; i++) {
            for (int j = i + 1; j < MAXNUMBERS; j++) {
                if (lotteryNumbers[i] > lotteryNumbers[j]) {
                    jokerNumber = lotteryNumbers[i];
                    lotteryNumbers[i] = lotteryNumbers[j];
                    lotteryNumbers[j] = jokerNumber;
                }
            }
        }
        System.out.println("This is the winner combination:");

        int[] winner = generateLottery();

        for (int i = 0; i < MAXNUMBERS; i++) {
            System.out.print(winner[i] + " ");
        }

        System.out.println();
        System.out.println("You have " + checkLottery(lotteryNumbers, winner) + " hits");
    }
    public static void playNim(int number) {
        Scanner sc = new Scanner (System.in);
        boolean endGame = false;
        int substract;
        int chips = number;

        System.out.println("Welcome to the NIN game!");
        System.out.println("Playing with " + number + " chips");

        do {            
            System.out.println("Your turn. Choose how many chips to substract:");
            substract = sc.nextInt();
            chips = chips - substract;
            System.out.println(chips + " chips pending");
            if (chips >= 0 && chips < 4) {
                 endGame = true;
                 System.out.println("YOU LOOSE");
            }
            if (endGame == false) {
                substract = generateNumber(1, 3);
                System.out.println("Computer substracts " + substract + " chips.");
                chips = chips - substract;
                System.out.println(chips + " chips pending");
                if (chips >= 0 && chips < 4) {
                    endGame = true;
                    System.out.println("YOU WIN");
               }
            }
        }
        while(endGame == false);
        sc.close();
    }
}

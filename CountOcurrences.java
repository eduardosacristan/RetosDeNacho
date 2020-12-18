import java.util.Scanner;

public class CountOcurrences {
    public static void main(String[]args) {
        Scanner sc = new Scanner (System.in);

        System.out.println("Enter first phrase");
        String phraseA = sc.nextLine();

        System.out.println("Enter second phrase");
        String phraseB = sc.nextLine();

        System.out.println("Enter number of ocurrences");
        int ocurrences = sc.nextInt();
        sc.close();
        
        if (countString(phraseA, phraseB, ocurrences) == true)
            System.out.println("Yes, it is");
        else    
            System.out.println("No, it is not");
    }
    public static boolean countString(String phraseA, String phraseB, int ocurrences) {
        boolean yesVeryWell = false;
        int positionsMeter = 0;

        while (phraseA.indexOf(phraseB) >= 0) {
            positionsMeter++;
            phraseA = phraseA.replaceFirst(phraseB, "");
        }

        if (positionsMeter >= ocurrences)
            yesVeryWell = true;

        return yesVeryWell;
    }
}

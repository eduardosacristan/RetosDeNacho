import java.util.Scanner;

public class AntSandwitch {
    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        int result = 0;
        int[]pieces = new int [max];
        boolean found = false;
        int total = 0;

        if (max <= 100000) {
            for (int i = 0; i < max; i++) {
                pieces[i] = sc.nextInt();
                total += pieces[i];
            }
            sc.close();

            if (total < 1000000000) {
                for (int i = 0; i < max - 1; i++) {
                    for (int j = i + 1; j < max; j++) {
                        result += pieces[j];
                        if (pieces[i] == result) {
                            found = true;
                            System.out.println ("SI " + i);
                        }
                    }
                    result = 0;
                }
                if (found == false) {
                    System.out.println("NO");
                }
            }
        }
    }
}

import java.util.Scanner;

public class CaminandoVoy
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner (System.in);
        int level0, topLevel, level;
        boolean good = false;
        
        System.out.println("Enter max ramp");
        topLevel = sc.nextInt();
        System.out.println("Enter levels");
        sc.nextLine();
        while(sc.hasNext())
        {
            level0 = sc.nextInt();
            level = sc.nextInt();

            if (level0 - level < topLevel)
                good = true;

            break;
        }
        if (good == true)   
                System.out.println("SUITABLE");
            else System.out.println("NOT A GOOD IDEA");
    }
}
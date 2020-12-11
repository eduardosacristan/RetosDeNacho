/*Eduardo Sacristán Beltri
  This software asks names and relationships and merges them except if the name is "Luke"
  and the relationship is "father"
*/

import java.util.Scanner;

public class YoSoyTu
{
	public static void main(String[]args)
    {
        Scanner sc = new Scanner (System.in);

        int inputs; 
        int meter = 0;
        inputs = sc.nextInt();
        sc.nextLine();
       
        do
        {
            String name = sc.nextLine();
            String relationship = sc.nextLine();

            if (name.equals("Luke") && relationship.equals("father"))
                System.out.println("TOP SECRET");
            else 
            {
                System.out.printf("%s, yo soy tu %s", name, relationship);
                System.out.println();
            }
            meter++;
        }
        while(meter < inputs);
    }
}
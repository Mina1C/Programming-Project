import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        System.out.println("Enter the name of the 8 Teams:");
        String [] names = new String [8]; //I used an Array because I know the number of elements I want (8)

        for (int i = 0; i < 8; i++){
            int notUnique = 0; //acts as a counter to check for uniqueness
            String str = sc.nextLine();

            for (int j = 0; j < i; j++){
                if (str.equals(names[j])){
                    notUnique++;
                }
            }
            if (notUnique != 0) {
                i--;  //if the name entered already exists, then the user can re-enter
                System.out.println("Not a unique name, enter another name:");
            }
            else
                names[i] = str;
        }
        System.out.println("The 8 teams are: "+Arrays.toString(names)); //confirms and displays the team names




        sc.close();
    }
}
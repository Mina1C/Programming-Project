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


        //Part 2
        ArrayList <String> group1 = new ArrayList <>();
        ArrayList <String> group2 = new ArrayList <>();

        ArrayList <Integer> nums = new ArrayList <> ();

        for (int i = 0; i <= 8; i++){
            if (i == 7)
                i++;
            int counter = 0;

            nums.add(i, (int) (Math.random() * (8) + 0));
            for (int j = 0; j < i; j++){
                if(nums.get(i) == nums.get(j))
                    counter++;
            }
            if (counter == 0){ //to use all number from 0-7 once.
                if (i < 4)
                    group1.add(names[nums.get(i)]); //adds the first 4 teams picked randomly,to team 1.
                else
                    group2.add(names[nums.get(i)]);
            }
            else
                i--;
        }

        System.out.println("Group 1: " +group1 +"\nGroup 2: "+group2);

        //matches

        int[] scores = new int[8];
        int[] goals = new int[8];
        int[] received = new int[8];

        System.out.println("Goals: "+goals);

        for (int i = 0; i < 8; i++){

            for (int j = i+1; j < 4; j++){
                int goal1 = (((int)(Math.random()*10 +0)));
                int goal2 = ((int)(Math.random()*10 +0));
                goals[i] += goal1;
                goals[j] += goal2;

                System.out.println(group1.get(i)+" vs "+group1.get(j)+"\n"+goals[i]+":"+goals[j]);

                if(goal1 > goal2)
                    scores[i] += 3;
                else if (goals[i] == goals[j]){
                    scores[i] += 1;
                    scores[j] += 1;
                }
                else if (goal1 < goal2){
                    scores[j] += 3;
                    received[i] += 1;
                }
            }
            for (int j = i+1; j > 4 && j < 8; j++){
                int goal1 = (((int)(Math.random()*10 +0)));
                int goal2 = ((int)(Math.random()*10 +0));
                goals[i] += goal1;
                goals[j] += goal2;

                System.out.println(group2.get(i-4)+" vs "+group2.get(j-4)+"\n"+goals[i]+":"+goals[j]);

                if(goal1 > goal2)
                    scores[i] += 3;
                else if (goal1 == goal2){
                    scores[i] += 1;
                    scores[j] += 1;
                }
                else if (goal1 < goal2){
                    scores[j] += 3;
                    received[i] += 1;
                }
            }

        }
        for (int i = 0; i < 8; i++){

            System.out.println(names[i]+":\nTotal score: "+scores[i]+"\nGoals scored: "+goals[i]+"\nGoals received: "+received[i]);
        }







        sc.close();
    }
}
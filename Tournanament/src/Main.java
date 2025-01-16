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

            nums.add(i, (int) (Math.random() * (8) +0));

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


        for (int i = 0; i < 8; i++){

            for (int j = i+1; j < 4; j++){
                int goal1 = (int)(Math.random()*10 +0);
                int goal2 = (int)(Math.random()*10 +0);
                goals[i] += goal1;
                goals[j] += goal2;

                System.out.println(group1.get(i)+" vs "+group1.get(j)+"\n"+goal1+":"+goal2);

                System.out.println("Goals: "+Arrays.toString(goals));

                if (goal1 > goal2) {
                    scores[i] += 3;
                    received[i] += goal2;
                    received[j] += goal1;
                }
                else if (goal1 == goal2){
                    scores[i] += 1;
                    scores[j] += 1;
                    received[i] += goal2;
                    received[j] += goal1;
                }
                else if (goal1 < goal2){
                    scores[j] += 3;
                    received[i] += goal2;
                    received[j] += goal1;
                }
            }
            for (int j = i+1; j > 4 && j < 8; j++){

                int goal1 = (int)(Math.random()*10 +0);
                int goal2 = (int)(Math.random()*10 +0);
                goals[i] += goal1;
                goals[j] += goal2;

                System.out.println(group2.get(i-4)+" vs "+group2.get(j-4)+"\n"+goal1+":"+goal2);

                System.out.println("Goals: "+Arrays.toString(goals));

                if (goal1 > goal2) {
                    scores[i] += 3;
                    received[i] += goal2;
                    received[j] += goal1;
                }
                else if (goal1 == goal2){
                    scores[i] += 1;
                    scores[j] += 1;
                    received[i] += goal2;
                    received[j] += goal1;
                }
                else if (goal1 < goal2){
                    scores[j] += 3;
                    received[i] += goal2 - goal1;
                    received[j] += goal1;
                }
            }
        }

        String first = "";
        String second = "";
        String first2 = ""; //first team in group 2
        String second2 = ""; //second team in group 2

        for (int i = 0; i < 4; i++){

            System.out.println(group1.get(i)+":\nTotal score: "+scores[i]+"\nGoals scored: "+goals[i]+"\nGoals received: "+received[i]);
            System.out.println(group2.get(i)+":\nTotal score: "+scores[i+4]+"\nGoals scored: "+goals[i+4]+"\nGoals received: "+received[i+4]);
            for(int j = 1; j+i < 4; j++){

                if (scores[i] > scores[j]) //finding the first scoring team in group 1
                    first = (group1.get(i));
                else
                    first = group1.get(j);

                if (scores[i+4] > scores[j+4]) //finding the first scoring team in group 2
                    first2 = (group2.get(i));
                else
                    first2 = group2.get(j);
            }
        }

        for (int i = 0; i < 4; i++){
            for(int j = 1; j+i < 4; j++){

                if (scores[i] > scores[j] && !group1.get(i).equals(first)) //finding the second scoring team in group 1
                    second = (group1.get(i));
                else if (!group1.get(j).equals(first))
                    second = group1.get(j);
                else
                    second = group1.get(i); //just in case the largest number is compared with a lower one

                if (scores[i+4] > scores[j+4] && !group2.get(i).equals(first2)) //finding the second scoring team in group 2
                    second2 = (group2.get(i));
                else if (!group2.get(j).equals(first2))
                    second2 = group2.get(j);
                else
                    second2 = group2.get(i); //just in case the largest number is compared with a lower one

            }
        }

        System.out.println("\nThe TEAMS Progressing to Playoff!!!\nFirst team in group 1: "+first+"\nThe second team in group 1: "+second+"\nFirst team in group 2: "+first2+"\nThe second team in group 2: "+second2);








        sc.close();
    }
}
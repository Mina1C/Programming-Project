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

        int topScore1 = -1; //-1 to make sure this field isn't left empty, if the team that is being compared has 0 scores.
        int secondTopScore1 = -1; // For Group 1 scores
        int topScore2 = -1;
        int secondTopScore2 = -1; // For Group 2 scores

        for (int i = 0; i < 4; i++){ //to show team standings

            System.out.println(group1.get(i)+":\nTotal score: "+scores[i]+"\nGoals scored: "+goals[i]+"\nGoals received: "+received[i]);
            System.out.println(group2.get(i)+":\nTotal score: "+scores[i+4]+"\nGoals scored: "+goals[i+4]+"\nGoals received: "+received[i+4]);

            // Finding the top two teams in Group 1
            if (scores[i] > topScore1) {
                second = first;       // Move current first to second
                secondTopScore1 = topScore1;
                first = group1.get(i); // Update first team
                topScore1 = scores[i];
            } else if (scores[i] > secondTopScore1) {
                second = group1.get(i); // Update second team
                secondTopScore1 = scores[i];
            }

            // Find the top two teams in Group 2
            if (scores[i + 4] > topScore2) {
                second2 = first2;         // Move current first to second
                secondTopScore2 = topScore2;
                first2 = group2.get(i);   // Update first team
                topScore2 = scores[i + 4];
            } else if (scores[i + 4] > secondTopScore2) {
                second2 = group2.get(i);  // Update second team
                secondTopScore2 = scores[i + 4];
            }
        }

        System.out.println("\nThe TEAMS Progressing to Playoff!!!");
        System.out.println("First team in group 1: " + first+"\nSecond team in group 1: " + second);
        System.out.println("First team in group 2: " + first2+"\nSecond team in group 2: " + second2);






        sc.close();
    }
}
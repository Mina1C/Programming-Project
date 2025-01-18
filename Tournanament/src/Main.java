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

            //if the name entered already exists, then the user can re-enter
            if (notUnique != 0) {
                i--;
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
        String first2 = ""; //top scorer in group 2
        String second2 = ""; //second place in group 2

        //-1 to make sure this field isn't left empty,(e.g. if the team that is being compared has 0 scores.)
        int topScore1 = -1;
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
            }
            else if (scores[i] > secondTopScore1) {
                second = group1.get(i); // Update second team
                secondTopScore1 = scores[i];
            }

            // Find the top two teams in Group 2
            if (scores[i + 4] > topScore2) {
                second2 = first2;         // Move current first to second
                secondTopScore2 = topScore2;
                first2 = group2.get(i);   // Update first team
                topScore2 = scores[i + 4];
            }
            else if (scores[i + 4] > secondTopScore2) {
                second2 = group2.get(i);  // Update second team
                secondTopScore2 = scores[i + 4];
            }
        }


        System.out.println("\nThe TEAMS Progressing to Playoff!!!");
        System.out.println("First team in group 1: " + first+"\nSecond team in group 1: " + second);
        System.out.println("First team in group 2: " + first2+"\nSecond team in group 2: " + second2);



        //semi scores for teams. group number then the rank. group#_rank
        int semi1_1 = (int)(Math.random()*10+0);
        int semi1_2 = (int)(Math.random()*10+0);
        int semi2_1 = (int)(Math.random()*10+0);
        int semi2_2 = (int)(Math.random()*10+0);


        ArrayList <String> order = new ArrayList <>();
        ArrayList <Integer> goalsFinals = new ArrayList <>();


        //Competers and match results shown (goal:goal)
        System.out.println("Semi-Final Results:\n "+first+" vs. "+second2+"\n"+semi1_1+":"+semi2_2);
        System.out.println("Semi-Final Results :\n "+first2+" vs. "+second+"\n"+semi2_1+":"+semi1_2);


        //If the semifinal is tied
        if(semi1_1 == semi2_2){
            System.out.println("The teams are tied, we are proceeding to penalties.\nEnter 3 or 8 to break the tie:");
            int tieBreaker = sc.nextInt();
            if(tieBreaker == 8)
                semi2_2 = 11;
            else
                semi1_1 = 11;
        }
        if(semi2_1 == semi1_2){
            System.out.println("The teams are tied, we are proceeding to penalties.\nEnter 1 or 4 to break the tie:");
            int tieBreaker = sc.nextInt();
            if(tieBreaker == 1)
                semi2_2 = 11;
            else
                semi1_1 = 11;
        }


        //if the top scorers lose
        if (semi1_1 < semi2_2 && semi2_1 < semi1_2){

            int final2_2 = (int)(Math.random()*10+0);
            int final1_2 = (int)(Math.random()*10+0);

            if (final2_2 == final1_2){ //If there is a tie in finals
                System.out.println("The match is tied. Enter 2 or 4 to break the tie:");
                int tiebreak = sc.nextInt();
                if (tiebreak == 2)
                    final2_2 = 11;
                else
                    final1_2 = 11;
            }

            goalsFinals.add(semi2_1);
            goalsFinals.add(semi1_1);

            order.add(first2);
            order.add(first);

            System.out.println("Final Match Results:\n "+second2+" vs "+second+"\n"+final2_2+":"+final1_2);

            if (final2_2 > final1_2){                   // if group 2's second scorer wins
                System.out.println(second2+" is the winner of this tournament!!!!");

                order.add(second);
                goalsFinals.add(semi1_2+final1_2);
                goalsFinals.add(semi2_2+final2_2);
            }
            else {                                      // if group 1's second scorer wins
                System.out.println(second + " is the winner of this tournament!!!");

                order.add(second2);
                goalsFinals.add(semi2_2+final2_2);
                goalsFinals.add(semi1_2+final1_2);
            }
        }


        //group 2's second scorer and top scorer wins. But they don't compete.
        else if (semi1_1 < semi2_2) {

            System.out.println(first2 + " is the winner of this tournament!!!!");
            order.add(second);
            order.add(first);
            order.add(second2);
            order.add(first2);

            goalsFinals.add(semi1_2);
            goalsFinals.add(semi1_1);
            goalsFinals.add(semi2_2);
            goalsFinals.add(semi2_1);
        }


        //if the top scorers win
        else if (semi1_1 > semi2_2 && semi2_1 > semi1_2){

            int final2_1 = (int)(Math.random()*10+0);
            int final1_1 = (int)(Math.random()*10+0);

            if (final2_1 == final1_1){ //If there is a tie in finals
                System.out.println("The match is tied. Enter 2 or 4 to break the tie:");
                int tiebreak = sc.nextInt();
                if (tiebreak == 2)
                    final2_1 = 11;
                else
                    final1_1 = 11;
            }

            order.add(second);
            order.add(second2);
            goalsFinals.add(semi1_2);
            goalsFinals.add(semi2_2);

            System.out.println("Final Match Results:\n "+first2+" vs "+first+"\n"+final2_1+":"+final1_1);

            if (final2_1 > final1_1){   //if group 2's top scorer wins
                System.out.println(first2 + " is the winner of this tournament!!!!");

                order.add(first);
                order.add(first2);

                goalsFinals.add(semi1_1+final1_1);
                goalsFinals.add(semi2_1+final2_1);
            }
            else {                       //if group 1's top scorer wins
                System.out.println(first + " is the winner of this tournament!!!!");
                order.add(first2);
                order.add(first);

                goalsFinals.add(semi2_1+final2_1);
                goalsFinals.add(semi1_1+final1_1);
            }
        }


        //group 1's top scorer and second scorer wins. But they don't compete.
        else if (semi1_1 > semi2_2){
            System.out.println(first + " is the winner of this tournament!!!!");
            order.add(second2);
            order.add(first2);
            order.add(second);
            order.add(first);

            goalsFinals.add(semi2_2);
            goalsFinals.add(semi2_1);
            goalsFinals.add(semi1_2);
            goalsFinals.add(semi1_1);
        }

        //Printing final standings
        System.out.println("\nRankings and Final Standings:");
        for (int i = 3; i != -1; i--){
            System.out.println(order.get(i)+":\nGoals Scored: "+goalsFinals.get(i));
        }

        //Tournament Summary
        System.out.println("\nTournament Summary:");

        for (int i = 0; i < 4; i++) { //Shows team standings

            System.out.println(group1.get(i) + ":\nTotal score: " + scores[i] + "\nGoals scored: " + goals[i] + "\nGoals received: " + received[i]);
            System.out.println(group2.get(i) + ":\nTotal score: " + scores[i + 4] + "\nGoals scored: " + goals[i + 4] + "\nGoals received: " + received[i + 4]);
        }


        sc.close();
    }
}
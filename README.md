# Programming-Project

String [] names = new String [8]; //This array stores the name of the 8 teams. 
I chose an array because I know the number of elements I want.

int notUnique = 0; //acts as a counter to check for uniqueness (for team names)

ArrayList <String> group1 = new ArrayList <>(); //Stores the name of 4 random teams.
ArrayList <String> group2 = new ArrayList <>();


ArrayList <Integer> nums = new ArrayList <> (); //Stores the random numbers generated

By using the numbers generated, we can access the names of the teams from array names and randomly 
assign them to a group. The unique numbers from 0-7 is generated in a random order. 
Then the first 4 names accessed from array names are put in group 1 and the rest in group 2.


int[] scores = new int[8]; //stores the scores of each team. 
If a team wins then 3 points (or if tied, 1 point) is added to the index allocated to them in the array (scores).
The score at index 0 belongs to the team at index 0 from the Arraylist group1. Then this order proceeds.

int[] goals = new int[8];//stores randomly generated numbers from 0-9
The score at index 0 belongs to the team at index 0 from the Arraylist group1. Then this order proceeds.

int[] received = new int[8]; //stores the number of goals received for each team.
The score at index 0 belongs to the team at index 0 from the Arraylist group1, and so on.
Whenever teams play against each other, the goals scored is added to the other team's goal received.(at their allocated index in the array.)


int goal1 = (int)(Math.random()*10 +0); //# of goals are generated for each team at each match
int goal2 = (int)(Math.random()*10 +0);
These are temporary(local) variables used to store the goals and then is added to the array named goals.

String first = ""; //Stores top scorer from group 1
String second = ""; //Stores Second top scorer from group 1
String first2 = ""; //Stores top scorer in group 2
String second2 = ""; //Stores second top scorer in group 2

int topScore1 = -1; // For Group 1 scores
int secondTopScore1 = -1;
int topScore2 = -1; // For Group 2 scores
int secondTopScore2 = -1; 
These variables store the highest and second highest scoring teams from group 1 and group 2.

//semifinal scores for teams. group number then the rank. group#_rank
int semi1_1 = (int)(Math.random()*10+0); //top from group 1
int semi1_2 = (int)(Math.random()*10+0); //second place from group 1
int semi2_1 = (int)(Math.random()*10+0); //top from group 2
int semi2_2 = (int)(Math.random()*10+0); //second place from group 2
Randomly generated numbers are stored as the # of goals scored for the teams.

ArrayList <String> order = new ArrayList <>(); //To store the teams in ranking order after finals. (stores them from low to high rank)

ArrayList <Integer> goalsFinals = new ArrayList <>(); //stores the goals of each team that progressed to semis and to finals

int final2_2 = (int)(Math.random()*10+0);
int final1_2 = (int)(Math.random()*10+0);
int final2_1 = (int)(Math.random()*10+0);
int final1_1 = (int)(Math.random()*10+0);
All of these variables are temporary. They generate and store goals for teams that progress to finals.

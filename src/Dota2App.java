import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Dota2App {
    public static ArrayList<Hero> PlayerA = new ArrayList<>();
    public static ArrayList<Hero> PlayerB = new ArrayList<>();
    public static void main (String[]args) {

        Hero hero1 = new Hero(1);
        Hero hero2 = new Hero(2);
        Hero hero3 = new Hero(3);
        Hero hero4 = new Hero(4);
        Hero hero5 = new Hero(5);
        Hero hero6 = new Hero(6);
        Hero hero7 = new Hero(7);
        Hero hero8 = new Hero(8);
        Hero hero9 = new Hero(9);
        Hero hero10 = new Hero(10);

        Scanner input = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.print("Player A, pick a hero (select 1-10):");
            int hero_no = input.nextInt();
            switch (hero_no) {
                case 1:
                    PlayerA.add(hero1);
                    break;
                case 2:
                    PlayerA.add(hero2);
                    break;
                case 3:
                    PlayerA.add(hero3);
                    break;
                case 4:
                    PlayerA.add(hero4);
                    break;
                case 5:
                    PlayerA.add(hero5);
                    break;
                case 6:
                    PlayerA.add(hero6);
                    break;
                case 7:
                    PlayerA.add(hero7);
                    break;
                case 8:
                    PlayerA.add(hero8);
                    break;
                case 9:
                    PlayerA.add(hero9);
                    break;
                case 10:
                    PlayerA.add(hero10);
                    break;
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.print("Player B, pick a hero (select 1-10):");
            int hero_no = input.nextInt();
            switch (hero_no) {
                case 1:
                    PlayerB.add(hero1);
                    break;
                case 2:
                    PlayerB.add(hero2);
                    break;
                case 3:
                    PlayerB.add(hero3);
                    break;
                case 4:
                    PlayerB.add(hero4);
                    break;
                case 5:
                    PlayerB.add(hero5);
                    break;
                case 6:
                    PlayerB.add(hero6);
                    break;
                case 7:
                    PlayerB.add(hero7);
                    break;
                case 8:
                    PlayerB.add(hero8);
                    break;
                case 9:
                    PlayerB.add(hero9);
                    break;
                case 10:
                    PlayerB.add(hero10);
                    break;
            }
        }

        team_stat();

        Random turn = new Random();
        int randomturn = turn.nextInt() % 2;

        boolean gameOver = false;
        while (!gameOver) {
            if (randomturn == 0) {
                System.out.print("Player A, What is your next move?");
                int hero_1 = input.nextInt();
                char action = input.next().charAt(0);
                int hero_2 = input.nextInt();
                if (action == 'A') {
                    if (PlayerA.get(hero_1).isAlive()) {
                        PlayerA.get(hero_1).attack();
                        PlayerB.get(hero_2).getAttackedBy(PlayerA.get(hero_1));
                    }
                    else {
                        System.out.println("Sorry " + PlayerA.get(hero_1).name + " is dead");
                    }
                } else if (action == 'U') {
                    if (PlayerA.get(hero_1).isAlive()) {
                        PlayerA.get(hero_1).ultimate() ;
                        PlayerB.get(hero_2).ultimatedBy(PlayerA.get(hero_1));

                    } else {
                        System.out.print("Sorry" + PlayerA.get(hero_1).name + "is dead");
                    }
                } else{
                    System.out.println("Command no recognized.");
                }
                randomturn = 1;

            }
            else  {
                System.out.print("Player B, What is your next move?");
                int hero_1 = input.nextInt();
                char action = input.next().charAt(0);
                int hero_2 = input.nextInt();
                if (action == 'A') {
                    if (PlayerB.get(hero_1).isAlive()) {
                        PlayerB.get(hero_1).attack();
                        PlayerA.get(hero_2).getAttackedBy(PlayerB.get(hero_1));
                    }
                    else {
                        System.out.println("Sorry " + PlayerA.get(hero_2).name + " is dead");
                    }
                } else if (action == 'U') {
                    if (PlayerB.get(hero_1).isAlive()) {
                        if(PlayerB.get(hero_1).ultimate()==true){
                            PlayerA.get(hero_2).ultimatedBy(PlayerB.get(hero_1));
                        }


                    }
                    else {
                        System.out.print("Sorry" + PlayerA.get(hero_2).name + "is dead");
                    }
                }else {
                    System.out.println("Command no recognized.");
                }
                randomturn=0;
            }
            team_stat();
            boolean r1 = areAllDead(PlayerA);
            boolean r2 = areAllDead(PlayerB);

            if (r1 || r2){
                gameOver = true;
                if (!r1) System.out.println("Player A won.");
                if (!r2) System.out.println("Player A won.");
            }
            else {
                gameOver = false;
            }
        }
    }


    public static void team_stat(){
        System.out.println("---------------------------------------");
        System.out.println("Player A \t\t\t\t\t\t\t\t\t Player B");
        for (int i=0;i<3;i++){
        System.out.printf("%d) %-20s (%d) %d/%d \t\t %d) %-20s (%d) %d/%d\n",i,
                PlayerA.get(i).name,(int)PlayerA.get(i).damage,(int)PlayerA.get(i).currentHP,(int)PlayerA.get(i).currentMP,i,
                PlayerB.get(i).name,(int)PlayerB.get(i).damage,(int)PlayerB.get(i).currentHP,(int)PlayerB.get(i).currentMP);

        }
    }

    public static boolean areAllDead(ArrayList<Hero> hero_list) {
        for (Hero hero : hero_list) {
            if (hero.currentHP > 0)
                return false;
        }
        return true;
    }

}

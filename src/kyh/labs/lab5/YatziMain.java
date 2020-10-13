package kyh.labs.lab5;

import java.util.Scanner;

public class YatziMain {
    private static final Scanner sc = new Scanner(System.in);   // Global scanner, för att inte öppna en massa nya hela tiden.
    private static boolean gameOn = true;                       // Global flagga för att fortsätta spela.
    private static int faceValue = 0;                           // Sparar senaste tärningens värde globalt för att kunna visa det vid Yatsi. Finns det ett bättre sätt?

    public static void main(String[] args) {
        System.out.println("Welcome to Yatzi!");
        do
        {
            gameRound();            // Kör en spelrunda.
        } while (gameOn);           // Upprepa tills gameOn blir falsk.
        sc.close();
        System.out.println("Bye bye!");
    }

    private static void gameRound() {
        for (int i = 1; i < 4; i++) {   // Kör tre omgångar i stöten.
            gameTurn(i);                // Kör en ny omgång.
            if(!gameOn) return;         // Återvänd om gameOn är falsk (Yatsi eller avbryt).
        }
    }

    private static void gameTurn(int i){
        System.out.println("Starting turn " + i + " of 3, rolling dice.");
        if (rollDiceAndCheckIfYatzi()){                     // Rullar tärningarna och returnerar sant om det blir Yatsi.
            System.out.println("You got YATZI! in " + faceValue + "'s");
            gameOn = false;                                 // Sätter flaggan gameOn till falsk och återvänder.
            return;
        } else if(i<3) {                                    // Under pågående runda.
            System.out.println("Want to throw again? (y for yes, anything else for no)");
        } else {                                            // Efter rundans slut.
            System.out.println("Game over! Want to play again? (y for yes, anything else for no)");
        }
        gameOn = sc.nextLine().toLowerCase().equals("y");   // Lyssna på svar. Accepterar både stort och litet Y.
    }

    private static boolean rollDiceAndCheckIfYatzi(){
        Die[] dice = new Die[5];                                   //
        for (int i = 0; i < 5; i++) {
            dice [i] = new Die();
        }
        return checkIfYatzi(dice);
    }

    public static boolean checkIfYatzi(Die[] dice){                 // Metoden är public bara för att kunna test den.
        int lastFaceValue = 0;                                      // Sparar föregående värde för jämförelse.
        boolean yatzi = true;                                       // Sätter flaggan för yatsi till sann.
        for (int i = 0; i < 5; i++) {
            faceValue = dice[i].faceValue;
            if(lastFaceValue >0 && faceValue != lastFaceValue){     // Från andra varvet, sätt yatsi-flaggan till falsk
                yatzi = false;                                      // om tärningen värde inte är samma som föregående.
                }
            System.out.println(i + ": Dice shows " + faceValue);    // Visa tärningens värde.
            lastFaceValue = faceValue;                              // Spara värdet till nästa varv.
            }
        return yatzi;                                               // Returnera yatsi-flaggan.
        }


/*  Den gamla koden, för referens.

        int iturn = 0;
        ds = new Die[5];
        for(int d=0;d<5;d++) {
            ds[d] = new Die();
        }
        //We will continue until the game is over


        while(bGameIsOn == true) {
            iturn = 0;
            System.out.println("Welcome to Yatzi!");
            while(iturn < 3) {
                System.out.println("Starting turn " + (iturn+1) + " of 3, rolling dice.");
                for(int i=0;i<ds.length;i++) {
                    ds[i].DieRoll();
                    //ds[i].value = 5; //Test if yatzi work
                    System.out.println(i + ": " + ds[i].getString());
                }
                //YATZI
                boolean flag = true;
                for(int j=1;j<5;j++) {
                    if(ds[j].value!=ds[j-1].value) {
                        //Set flag to false
                        flag = false;
                    }
                }
                if(flag == true) {
                    System.out.println("You got YATZI! in " + ds[0].value + "'s");
                    return;
                } else {
                    //Here we check if there is no Yatzy: then we check what turn we are on and asks the player if we want to continue or not
                    if(iturn != 2) {
                        System.out.println("Want to throw again? (y for yes, anything else for no)");
                        Scanner sc = new Scanner(System.in);
                        if(sc.next().equals("y")) {
                            ++iturn;
                        } else {
                            bGameIsOn = !bGameIsOn;
                            break;
                        }
                    } else {
                        System.out.println("Game over! Want to play again?");
                        Scanner sc = new Scanner(System.in);
                        if(sc.next().equals("y")) {
                            iturn = 0;
                        } else {
                            bGameIsOn = !bGameIsOn;
                            break;
                        }
                    }
                }
            }
        }
    }*/
}
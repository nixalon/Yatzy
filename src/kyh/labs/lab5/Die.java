package kyh.labs.lab5;

public class Die {
   int faceValue;

    public Die() {
        faceValue = (int)(Math.random()*6+1);
        //faceValue = 1;
    }

    public Die(int value) {         //Konstruktor används bara i test, ej i spel.
        faceValue = value;
    }

/*    public int DieRoll() {
        value = (int)(Math.random()*6+1);
        return value;
    }

    public int DieReroll() {
        return DieRoll();
    }

    public String getString() {
        return "Dice shows " + value;
    }*/
}

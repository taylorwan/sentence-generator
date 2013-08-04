import java.io.*;
import java.util.*;

public class SenGen {

    private InputStreamReader isr;
    private BufferedReader br;

    private Words words;
    private boolean done;


    public SenGen() {
        words = new Words();
        done = false;

        isr = new InputStreamReader(System.in);
        br = new BufferedReader(isr);

        String s = "\nWelcome to the Sentence Generator! Please select an option to continue.\n";
        System.out.println(s);

        while(!done)
            go();

        s = "\nHave a good day! Goodbye!";
        System.out.println(s);
    }


    public String read() {
        String d = "";
        try {
            d = br.readLine();
        }
        catch (IOException e) { }
        return d;
    }


    public String menu() {
        String s = "";
        s += "1: Generate a sentence!\n";
        s += "2: Add Adjectives\n";
        s += "3: Add Nouns\n";
        s += "4: Add Verbs\n";
        s += "5: Clear all Adjectives\n";
        s += "6: Clear all Nouns\n";
        s += "7: Clear all Verbs\n";
        s += "8: View current wordlists\n";
        s += "9: Exit\n";
        s += "\nSelection: ";
        return s;
    }


    public void addAdj() {
        System.out.print("\tEnter an adjective: ");
        String g = read();
        System.out.println();

        words.addAdj(new Adjective(g));
        System.out.println("\nAdjective successfully added!\n");
    }



    public void addNoun() {
        String s = "\tEnter a noun: ";
        System.out.print(s);
        String g = read();

        s = "\n\tIs your noun singular or plural?";
        s += "\n\t1: Singular";
        s += "\n\t2: Plural";
        s += "\n\tSelection: ";

        int t = -1;
        try {
            while ( t <= 0 || t > 2 ) {
                System.out.println(s);
                t = Integer.parseInt( br.readLine() );
            }
        }
        catch (IOException e) {}

        boolean temp = false;
        if (t == 1)
            temp = true;

        String s2 = "\n\tSelect which article best fits your noun:";
        s2 += "\n\t1: a";
        s2 += "\n\t2: an";
        s2 += "\n\t3: the";
        s2 += "\n\t4: No article";
        s2 += "\n\tSelection: ";
        
        int t2 = -1;
        try {
            while ( t2 <= 0 || t2 > 4 ) {
              System.out.println(s2);
              t2 = Integer.parseInt( br.readLine() );
            }
        }
        catch (IOException e) {}
        
        if (t2 == 1) {
          words.addNoun(new Noun(g, temp, "a"));
          s2 = "\nNoun1 successfully added!\n";
          System.out.println(s2);
        }
        else if (t2 == 2) {
          words.addNoun(new Noun(g, temp, "an"));
          s2 = "\nNoun2 successfully added!\n";
          System.out.println(s2);     
        }
        else if (t2 == 3) {
          words.addNoun(new Noun(g, temp, "the"));
          s2 = "\nNoun3 successfully added!\n";
          System.out.println(s2);
        }
        else {
          words.addNoun(new Noun(g, temp));                     
          s2 = "\nNoun4 successfully added!\n";
          System.out.println(s2);
        }
    }



    public void addVerb() {
        String s = "\tEnter a singular verb (e.g. teaches, works): ";
        System.out.print(s);
        String x = read();
        s = "\n\tEnter the plural form of your verb (e.g. teach, work): ";
        System.out.print(s);
        String y = read();
        s = "\n\tEnter the past form of your verb (e.g. taught, worked): ";
        System.out.print(s);
        String z = read();
        words.addVerb(new Verb(x,y,z));
        s = "\nVerb successfully added!\n";
        System.out.println(s);
    }



    public void clearAdj() {
        words.clearAdj();
        System.out.println("\nAll Adjectives successfully cleared! Please add new ones!\n");
    }
    
    
    
    public void clearNoun() {
        words.clearNoun();
        System.out.println("\nAll Nouns successfully cleared! Please add new ones!\n");
    }
    
    
    
    public void clearVerb() {
        words.clearVerb();
        System.out.println("\nAll Verbs successfully cleared! Please add new ones!\n");
    }
    
    
    
    public void go() {
        int p = -1;
        try {
            while ( p <= 0 || p > 9 ) {
                System.out.print(menu());
                p = Integer.parseInt( br.readLine() );
                System.out.println();
            }
        }
        catch (IOException e) {}

        if (p == 1)
            System.out.println("Your sentence is: " + words.sentence() + ".\n");
        if (p == 2)
            addAdj();
        if (p == 3)
            addNoun();
        if (p == 4)
            addVerb();
        if (p == 5)
            clearAdj();
        if (p == 6)
            clearNoun();
        if (p == 7)
            clearVerb();
        if (p == 8)
            System.out.println(words.toString() + "\n");
        if (p == 9)
            done = true;
    }


    public static void main(String[] args) {
        SenGen a = new SenGen();
    }
}
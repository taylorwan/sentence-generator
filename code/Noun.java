import java.io.*;
import java.util.*;

public class Noun {

    private boolean singular;
    private String noun;

    private String article;
    private boolean hasarticle;

    public Noun(String input, boolean x) {
        noun = input;
        singular = x;
        hasarticle = false;
    }
    public Noun(String input, boolean x, String z) {
        noun = input;
        singular = x;
        article = z;
        hasarticle = true;
    }

    public String getNoun() { return noun; }
    public boolean isSingular() { return singular; }
    public boolean hasArticle() { return hasarticle; }
    public String getArticle() { return article; }

    public String toString() {
        if (hasarticle)
            return "[" + article + " " + noun + "]";
        return "[" + noun + "]";
    }

}
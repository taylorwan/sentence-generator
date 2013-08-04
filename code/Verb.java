import java.io.*;
import java.util.*;

public class Verb {

    private String singular;
    private String plural;
    private String past;

    public Verb(String x, String y) {
        singular = x;
        plural = y;
    }

    public Verb(String x, String y, String z) {
        singular = x;
        plural = y;
        past = z;
    }

    public String getSingular() {
        return singular;
    }
    public String getPlural() {
        return plural;
    }
    public String getPast() {
        return past;
    }

    public String toString() {
        return "[" + singular + "]";
    }

}
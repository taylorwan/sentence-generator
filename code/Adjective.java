import java.io.*;
import java.util.*;

public class Adjective {

    private String adj;

    public Adjective(String input) {
        adj = input;
    }

    public String getAdj() {
        return adj;
    }

    public String toString() {
        return  "[" + adj + "]";
    }

}
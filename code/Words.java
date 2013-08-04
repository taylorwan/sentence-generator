import java.io.*;
import java.util.*;

public class Words {

    private ArrayList<Adjective> a;
    private ArrayList<Noun> n;
    private ArrayList<Verb> v;

    private boolean singular;
    private String article;
    private boolean hasarticle;

    public Words() {
        a = new ArrayList<Adjective>();
        n = new ArrayList<Noun>();
        v = new ArrayList<Verb>();
        
        // The default nouns, verbs, and adjectives
        n.add(new Noun("Santa's elves", false));
        n.add(new Noun("Zeppelin", true));
        n.add(new Noun("Mr. Z", true));
        n.add(new Noun("Mr. DW", true));
        n.add(new Noun("Ghostbusters", false, "the"));
        n.add(new Noun("Harry Potter", true));
        n.add(new Noun("Stuyvesant", true));
        n.add(new Noun("computer", true, "a"));
        n.add(new Noun("seniors", false, "the"));
        n.add(new Noun("freshmen", false, "the"));
        n.add(new Noun("alien", true, "an"));
        n.add(new Noun("Thluffy", true));
        n.add(new Noun("sandwich", true, "a"));
        n.add(new Noun("doctors", false, "the"));
        n.add(new Noun("Darth Vader", true));
        n.add(new Noun("Marge Simpson", true));
        n.add(new Noun("Selena Gomez", true));
        n.add(new Noun("Mr. Teitel", true));
        n.add(new Noun("Barack Obama", true));
        n.add(new Noun("giraffes", false, "the"));
        n.add(new Noun("penguins", false, "the"));
        n.add(new Noun("lawyer", true, "a"));
        n.add(new Noun("guitarist", true, "a"));
        n.add(new Noun("Canadian", true, "a"));     
        n.add(new Noun("President of Uzbekistan", true, "the"));        
        //      n.add(new Noun("", ));

        v.add(new Verb("teaches", "teach", "taught"));
        v.add(new Verb("watches", "watch", "watched"));
        v.add(new Verb("eats", "eat", "ate"));
        v.add(new Verb("runs", "run", "ran"));
        v.add(new Verb("asks", "ask", "asked"));
        v.add(new Verb("sings", "sing", "sang"));
        v.add(new Verb("understands", "understand", "understood"));
        v.add(new Verb("flirts", "flirt", "flirted"));
        v.add(new Verb("cries", "cry", "cried"));
        v.add(new Verb("promises", "promise", "promised"));
        v.add(new Verb("reads", "read", "read"));
        v.add(new Verb("swims", "swim", "swam"));
        v.add(new Verb("writes", "write", "wrote"));
        v.add(new Verb("entertains", "entertain", "entertained"));
        v.add(new Verb("crawls", "crawl", "crawled"));
        v.add(new Verb("enjoys", "enjoy", "enjoyed"));
        v.add(new Verb("jumps", "jump", "jumped"));
        v.add(new Verb("yells", "yell", "yelled"));
        v.add(new Verb("paints", "paint", "painted"));
        v.add(new Verb("loves", "love", "loved")); 
        v.add(new Verb("despises", "despise", "despised"));
        v.add(new Verb("screams", "scream", "screamed"));
        v.add(new Verb("discombobulates", "discombobulate", "discombobulated"));        
        v.add(new Verb("disrupts", "disrupt", "disrupted"));        
        v.add(new Verb("ostracizes", "ostracize", "ostracized"));        
        //      v.add(new Verb("", "", ""));

        a.add(new Adjective("mysterious"));
        a.add(new Adjective("jittery"));
        a.add(new Adjective("quirky"));
        a.add(new Adjective("slick"));
        a.add(new Adjective("classy"));
        a.add(new Adjective("rhetorical"));
        a.add(new Adjective("entertaining"));
        a.add(new Adjective("fabulous"));
        a.add(new Adjective("beautiful"));
        a.add(new Adjective("tantalizing"));
        a.add(new Adjective("ugly"));
        a.add(new Adjective("scrumptious"));
        a.add(new Adjective("handsome"));
        a.add(new Adjective("healthy"));
        a.add(new Adjective("dangerous"));
        a.add(new Adjective("lackadaisical"));
        a.add(new Adjective("groovy"));
        a.add(new Adjective("scary"));
        a.add(new Adjective("extraordinary"));
        a.add(new Adjective("flirtatious"));
        a.add(new Adjective("flattering"));
        a.add(new Adjective("ecstatic"));
        a.add(new Adjective("deranged"));  
        a.add(new Adjective("glamorous"));        
        a.add(new Adjective("fuzzy"));          
        //      a.add(new Adjective(""));
    }


    public String getAdj() {
        int rand = (int)(Math.random()*2);
        int index = (int)(Math.random()*a.size());
        int index2 = (int)(Math.random()*a.size());
        String adj = a.get(index).getAdj();
        if (rand == 0)
             return adj;
        else
             return adj + " " + a.get(index2).getAdj();
        }


    public String getNoun() {
        int rand = (int)(Math.random()*2);
        int index = (int)(Math.random()*n.size());
        Noun temp = n.get(index);
        String noun = temp.getNoun();
        singular = temp.isSingular();

        if (temp.hasArticle()) {
            hasarticle = true;
            article = temp.getArticle();
            if (article.equals("a") || article.equals("an")) { //if the article is 'a' or 'an', change the article to 'the' half the time
                if (rand == 0)
                    article = "the";
            }
        }
        else
            hasarticle = false;

        return noun;
    }

    public String getVerb(boolean singularnoun) {
        int rand = (int)(Math.random()*3);
        int index = (int)(Math.random()*v.size());
        String verb;

        if (rand == 0)
            verb = v.get(index).getPast();

        else {
            if (singularnoun)
                verb = v.get(index).getSingular();
            else
                verb = v.get(index).getPlural();
        }

        return verb;
    }


    public void addAdj(Adjective x) { a.add(x); }
    public void addNoun(Noun x) { n.add(x); }
    public void addVerb(Verb x) { v.add(x); }
   
   
    public void clearAdj() {
        a.clear();
    }
    public void clearNoun() {
        n.clear();
    }

    public void clearVerb() {
        v.clear();
    }

    /* List of sentence structure possibilities (art = article (if it exists), adj = adjective):
       1. art + adj + noun + verb
       2. art + adj + noun + verb + "and" + art + adj + noun + verb 
       3. art + adj + noun + verb + "while" + art + adj + noun + verb
       4. art + adj + noun + verb + "because" + art + adj + noun + verb
       5. art + adj + noun + verb + art +  noun
       6. art + adj + noun + verb + art + adj + noun
       7. art + adj + noun + verb + art + adj + noun + "and" + art + adj + noun + verb + art + adj + noun
       8. art + adj + noun + verb + art + adj + noun + "while" + art + adj + noun + verb + art + adj + noun
       9. art + adj + noun + verb + art + adj + noun + "because" + art + adj + noun + verb + art + adj + noun
      10. art + noun + verb
      11. art + noun + verb + "and" + art + noun + verb
      12. art + noun + verb + "while" + art + noun + verb
      13. art + noun + verb + "because" + art  + noun + verb
      14. art + noun + verb + art + noun
      15. art + noun + verb + art + adj + noun
      16. art + noun + verb + art + adj + noun + "and" + art +  noun + verb + art + adj + noun
      17. art + noun + verb + art + adj + noun + "while" + art +  noun + verb + art + adj + noun
      18. art + noun + verb + art + adj + noun + "because" + art +  noun + verb + art + adj + noun
    */ 
    
    public String sentence() {
        int rand = (int)(Math.random()*18);
        String s = "";
        if (rand == 0)
            s = sentence1();
        if (rand == 1)
            s = sentence2();
        if (rand == 2)
            s = sentence3();
        if (rand == 3)
            s = sentence4();
        if (rand == 4)
            s = sentence5();
        if (rand == 5)
            s = sentence6();
        if (rand == 6)
            s = sentence7();
        if (rand == 7)
            s = sentence8();
        if (rand == 8)
            s = sentence9();
        if (rand == 9)
            s = sentence10();
        if (rand == 10)
            s = sentence11();
        if (rand == 11)
            s = sentence12();
        if (rand == 12)
            s = sentence13();
        if (rand == 13)
            s = sentence14();           
        if (rand == 14)
            s = sentence15();
        if (rand == 15)
            s = sentence16();           
        if (rand == 16)
            s = sentence17();
        if (rand == 17)
            s = sentence18();          
        String firstletter = s.substring(0,1);
        String therest = s.substring(1);
        s = firstletter.toUpperCase() + therest;
        return s;
    }

    public String sentence1() {
        String s = "";
        String adj = getAdj();
        String noun = getNoun();
        String verb = getVerb(singular);
        if (hasarticle)
            s = article + " " + adj + " " + noun + " " + verb;
        else
            s = adj + " " + noun + " " + verb;
        return s;
    }
    
    public String sentence2() {
        String s = "";
        String adj = getAdj();
        String noun = getNoun();
        String verb = getVerb(singular);

        if (hasarticle)
            s = article + " " + adj + " " + noun + " " + verb;
        else {
            article = null;
            s = adj + " " + noun + " " + verb;
        }

        adj = getAdj();
        noun = getNoun();
        verb = getVerb(singular);

        if (hasarticle)
            s += " " + "and" + " " + article + " " + adj + " " + noun + " " + verb;
        else {
            s += " " + "and" + " " + adj + " " + noun + " " + verb;
        }
        return s;
    }
    
    public String sentence3() {
        String s = "";
        String adj = getAdj();
        String noun = getNoun();
        String verb = getVerb(singular);

        if (hasarticle)
            s = article + " " + adj + " " + noun + " " + verb;
        else {
            article = null;
            s = adj + " " + noun + " " + verb;
        }

        adj = getAdj();
        noun = getNoun();
        verb = getVerb(singular);

        if (hasarticle)
            s += " " + "while" + " " + article + " " + adj + " " + noun + " " + verb;
        else {
            s += " " + "while" + " " + adj + " " + noun + " " + verb;
        }
        return s;
    } 
    
    public String sentence4() {
        String s = "";
        String adj = getAdj();
        String noun = getNoun();
        String verb = getVerb(singular);

        if (hasarticle)
            s = article + " " + adj + " " + noun + " " + verb;
        else {
            article = null;
            s = adj + " " + noun + " " + verb;
        }

        adj = getAdj();
        noun = getNoun();
        verb = getVerb(singular);

        if (hasarticle)
            s += " " + "because" + " " + article + " " + adj + " " + noun + " " + verb;
        else {
            s += " " + "because" + " " + adj + " " + noun + " " + verb;
        }
        return s;
    } 
    
    public String sentence5() {
        String s = "";
        String adj = getAdj();
        String noun = getNoun();
        String verb = getVerb(singular);

        if (hasarticle)
            s = article + " " + adj + " " + noun + " " + verb;
        else {
            article = null;
            s = adj + " " + noun + " " + verb;
        }

        noun = getNoun();

        if (hasarticle)
            s += " " + article + " " + noun;
        else {
            s += " " + noun;
        }
        return s;
    }     

    public String sentence6() {
        String s = "";
        String adj = getAdj();
        String noun = getNoun();
        String verb = getVerb(singular);

        if (hasarticle)
            s = article + " " + adj + " " + noun + " " + verb;
        else {
            article = null;
            s = adj + " " + noun + " " + verb;
        }

        adj = getAdj();
        noun = getNoun();

        if (hasarticle)
            s += " " + article + " " + adj + " " + noun;
        else {
            s += " " + adj + " " + noun;
        }
        return s;
    } 
    
    public String sentence7() {
        String s = "";
        String adj = getAdj();
        String noun = getNoun();
        String verb = getVerb(singular);

        if (hasarticle)
            s = article + " " + adj + " " + noun + " " + verb;
        else {
            article = null;
            s = adj + " " + noun + " " + verb;
        }

        adj = getAdj();
        noun = getNoun();

        if (hasarticle)
            s += " " + article + " " + adj + " " + noun;
        else {
            s += " " + adj + " " + noun;
        }
        
        adj = getAdj();
        noun = getNoun();        
        verb = getVerb(singular);        
        
        if (hasarticle)
            s += " " + "and" + " " + article + " " + adj + " " + noun + " " + verb;
        else {
            article = null;
            s += " " + "and" + " " + adj + " " + noun + " " + verb;
        }

        adj = getAdj();
        noun = getNoun();

        if (hasarticle)
            s += " " + article + " " + adj + " " + noun;
        else {
            s += " " + adj + " " + noun;
        }
        return s;
    }
    
    public String sentence8() {
        String s = "";
        String adj = getAdj();
        String noun = getNoun();
        String verb = getVerb(singular);

        if (hasarticle)
            s = article + " " + adj + " " + noun + " " + verb;
        else {
            article = null;
            s = adj + " " + noun + " " + verb;
        }

        adj = getAdj();
        noun = getNoun();

        if (hasarticle)
            s += " " + article + " " + adj + " " + noun;
        else {
            s += " " + adj + " " + noun;
        }
        
        adj = getAdj();
        noun = getNoun();        
        verb = getVerb(singular);        
        
        if (hasarticle)
            s += " " + "while" + " " + article + " " + adj + " " + noun + " " + verb;
        else {
            article = null;
            s += " " + "while" + " " + adj + " " + noun + " " + verb;
        }

        adj = getAdj();
        noun = getNoun();

        if (hasarticle)
            s += " " + article + " " + adj + " " + noun;
        else {
            s += " " + adj + " " + noun;
        }
        return s;
    } 
    
    public String sentence9() {
        String s = "";
        String adj = getAdj();
        String noun = getNoun();
        String verb = getVerb(singular);

        if (hasarticle)
            s = article + " " + adj + " " + noun + " " + verb;
        else {
            article = null;
            s = adj + " " + noun + " " + verb;
        }

        adj = getAdj();
        noun = getNoun();

        if (hasarticle)
            s += " " + article + " " + adj + " " + noun;
        else {
            s += " " + adj + " " + noun;
        }
        
        adj = getAdj();
        noun = getNoun();        
        verb = getVerb(singular);        
        
        if (hasarticle)
            s += " " + "because" + " " + article + " " + adj + " " + noun + " " + verb;
        else {
            article = null;
            s += " " + "because" + " " + adj + " " + noun + " " + verb;
        }

        adj = getAdj();
        noun = getNoun();

        if (hasarticle)
            s += " " + article + " " + adj + " " + noun;
        else {
            s += " " + adj + " " + noun;
        }
        return s;
    }
    
    public String sentence10() {
        String s = "";
        String noun = getNoun();
        String verb = getVerb(singular);

        if (hasarticle)
            s = article + " " + noun + " " + verb;
        else {
            article = null;
            s = noun + " " + verb;
        }
        return s;
    }  
    
    public String sentence11() {
        String s = "";
        String noun = getNoun();
        String verb = getVerb(singular);

        if (hasarticle)
            s = article + " " + noun + " " + verb;
        else {
            article = null;
            s = noun + " " + verb;
        }
        
        noun = getNoun();        
        verb = getVerb(singular);        
        
        if (hasarticle)
            s += " " + "and" + " " + article + " " + noun + " " + verb;
        else {
            article = null;
            s += " " + "and" + " " + noun + " " + verb;
        }       
        return s;
    }  
    
    public String sentence12() {
        String s = "";
        String noun = getNoun();
        String verb = getVerb(singular);

        if (hasarticle)
            s = article + " " + noun + " " + verb;
        else {
            article = null;
            s = noun + " " + verb;
        }
        
        noun = getNoun();        
        verb = getVerb(singular);        
        
        if (hasarticle)
            s += " " + "while" + " " + article + " " + noun + " " + verb;
        else {
            article = null;
            s += " " + "while" + " " + noun + " " + verb;
        }       
        return s;
    }
    
    public String sentence13() {
        String s = "";
        String noun = getNoun();
        String verb = getVerb(singular);

        if (hasarticle)
            s = article + " " + noun + " " + verb;
        else {
            article = null;
            s = noun + " " + verb;
        }
        
        noun = getNoun();        
        verb = getVerb(singular);        
        
        if (hasarticle)
            s += " " + "because" + " " + article + " " + noun + " " + verb;
        else {
            article = null;
            s += " " + "because" + " " + noun + " " + verb;
        }       
        return s;
    }         
    
     public String sentence14() {
        String s = "";
        String noun = getNoun();
        String verb = getVerb(singular);

        if (hasarticle)
            s = article + " " + noun + " " + verb;
        else {
            article = null;
            s = noun + " " + verb;
        }
        
        noun = getNoun();             
        
        if (hasarticle)
            s += " " + article + " " + noun;
        else {
            article = null;
            s += " " + noun;
        }       
        return s;
    }            
    
    public String sentence15() {
        String s = "";
        String noun = getNoun();
        String verb = getVerb(singular);

        if (hasarticle)
            s = article + " " + noun + " " + verb;
        else {
            article = null;
            s = noun + " " + verb;
        }
        
        String adj = getAdj();        
        noun = getNoun();             
        
        if (hasarticle)
            s += " " + article + " " + adj + " " + noun;
        else {
            article = null;
            s += " " + adj + " " + noun;
        }       
        return s;
    }             
    
    public String sentence16() {
        String s = "";
        String noun = getNoun();
        String verb = getVerb(singular);

        if (hasarticle)
            s = article + " " + noun + " " + verb;
        else {
            article = null;
            s = noun + " " + verb;
        }
        
        String adj = getAdj();        
        noun = getNoun();             
        
        if (hasarticle)
            s += " " + article + " " + adj + " " + noun;
        else {
            article = null;
            s +=  " " + adj + " " + noun;
        }     
        
        adj = getAdj();
        noun = getNoun();        
        verb = getVerb(singular);        
        
        if (hasarticle)
            s += " " + "and" + " " + article + " " + noun + " " + verb;
        else {
            article = null;
            s += " " + "and" + " " + noun + " " + verb;
        }

        adj = getAdj();
        noun = getNoun();

        if (hasarticle)
            s += " " + article + " " + adj + " " + noun;
        else {
            s += " " + adj + " " + noun;
        }
        return s;
    }         
    
    public String sentence17() {
        String s = "";
        String noun = getNoun();
        String verb = getVerb(singular);

        if (hasarticle)
            s = article + " " + noun + " " + verb;
        else {
            article = null;
            s = noun + " " + verb;
        }
        
        String adj = getAdj();        
        noun = getNoun();             
        
        if (hasarticle)
            s += " " + article + " " + adj + " " + noun;
        else {
            article = null;
            s += " " + adj + " " + noun;
        }     
        
        adj = getAdj();
        noun = getNoun();        
        verb = getVerb(singular);        
        
        if (hasarticle)
            s += " " + "while" + " " + article + " " + noun + " " + verb;
        else {
            article = null;
            s += " " + "while" + " " + noun + " " + verb;
        }

        adj = getAdj();
        noun = getNoun();

        if (hasarticle)
            s += " " + article + " " + adj + " " + noun;
        else {
            s += " " + adj + " " + noun;
        }
        return s;
    }    
    
    public String sentence18() {
        String s = "";
        String noun = getNoun();
        String verb = getVerb(singular);

        if (hasarticle)
            s = article + " " + noun + " " + verb;
        else {
            article = null;
            s = noun + " " + verb;
        }
        
        String adj = getAdj();        
        noun = getNoun();             
        
        if (hasarticle)
            s += " " + article + " " + adj + " " + noun;
        else {
            article = null;
            s += " " + adj + " " + noun;
        }     
        
        adj = getAdj();
        noun = getNoun();        
        verb = getVerb(singular);        
        
        if (hasarticle)
            s += " " + "because" + " " + article + " " + noun + " " + verb;
        else {
            article = null;
            s += " " + "because" + " " + noun + " " + verb;
        }

        adj = getAdj();
        noun = getNoun();

        if (hasarticle)
            s += " " + article + " " + adj + " " + noun;
        else {
            s += " " + adj + " " + noun;
        }
        return s;
    }
    
    
    public String toString() {
        String s = "";

        s += "Adjectives:\n";
        for (Adjective x : a)
            s += x + " ";

        s += "\n\nNouns:\n";
        for (Noun y : n)
            s += y + " ";

        s += "\n\nVerbs:\n";
        for (Verb z : v)
            s += z + " ";

        s += "\n";
        return s;
    }

}
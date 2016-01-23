import java.io.*;


interface findFriend{
    public static String logan = "君子之交"; 
    public abstract void shoutOut(String s);
}

class classmate{
    int age;
    int grade;
    boolean sameClass;
    public static final String slogan = "淡如水!";

    public classmate(){
        age = 18;
        grade = 12;
        sameClass = true;
    }

    public classmate(int age, int grade){
        this.age = age;
        this.grade = grade;
        sameClass = true;
    }

    public void shoutOut(String s){
        System.out.println(s);
    }
}

public class goodFriend extends classmate implements findFriend{
    public goodFriend(){
        super();
    }

    public goodFriend(int age, int grade){
        super(age, grade);
    }

    public void shoutOut(String s){
        System.out.println(s);
    }

    public static void main(String[] args){
        goodFriend John = new goodFriend();
        goodFriend Amanda = new goodFriend();
        //String slogan = "aha";
        John.shoutOut(logan);
        Amanda.shoutOut(slogan);
    }
}

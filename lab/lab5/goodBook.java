import java.io.*;

class book{

    int pages;
    int douBanScore;
    boolean withImage;

    public book(){
        pages = 300;
        douBanScore = 10;
        withImage = true;
    }

    public book(int pages, int score){
        this.pages = pages;
        this.douBanScore = score;
        this.withImage = true;
    }

    public book(int pages, int score, boolean withImage){
        this.pages = pages;
        this.douBanScore = score;
        this.withImage = withImage;
    }

    public void introduction(String info){
        String s = new String();
        s = "I am super " + info;
        System.out.println(s);
    }
}

public class goodBook extends book{
    protected String name;

    public goodBook(){
        super();
        name = "Gone with the wind";
    }

    public goodBook(int pages, int score){
        super(pages, score);
        name = "Gone with the wind";
    }

    public goodBook(int pages, int score, boolean withImage){
        super(pages, score, withImage);
        name = "Gone with the wind";
    }

    public goodBook(int pages, int score, boolean withImage, String name){
        super(pages, score, withImage);
        this.name = name;
    }

    public void introduction(String info){
        //System.out.println(name);
        String s = new String();
        s = "I am sub " + info;
        System.out.println(s);
    }

    public static void main(String[] args){
        goodBook A = new goodBook(800, 10, true, "Gone with the wind");
        String info = "\n" + "Pages " + A.pages + "\n" + "Score " + A.douBanScore + "\n" +
            "With Image " + A.withImage + "\n" + "Book Name " + A.name;
        ((book) A).introduction(info);
        //A.introduction(info);
    } 
}

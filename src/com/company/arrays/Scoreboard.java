package com.company.arrays;

public class Scoreboard {
    private int numEntries=0;
    private GameEntry[] board;

    public Scoreboard(int capacity){
        board=new GameEntry[capacity];
    }

    public void add(GameEntry e){
        int newScore=e.getScore();

//        we need to know the new score is a really high score
        if(numEntries<board.length||newScore>board[numEntries-1].getScore()){
            if (numEntries<board.length)   //here no entries dropes out
                numEntries++;
            int j=numEntries-1;
            while(j>0 && board[j-1].getScore()<newScore){
                board[j]=board[j-1];
                j--;
            }
            board[j]=e;
        }
    }
//    remove and return the high score at index i
    public GameEntry remove(int i) throws IndexOutOfBoundsException{
        if(i<0||i>numEntries)
            throw new IndexOutOfBoundsException("Invalid Index: "+i);
        GameEntry temp=board[i];
        for(int j=i;j<numEntries-1;j++)
            board[j]=board[j+1];

        board[numEntries-1]=null;
        numEntries--;
        return temp;

    }

    public void displayDetails(){
        for(GameEntry gameEntry:board){
            if(gameEntry !=null){
                System.out.println(gameEntry);
                System.out.println("=========================");
            }
        }
    }

    public static void main(String[] args) {
        Scoreboard scoreboard=new Scoreboard(10);

         scoreboard.add(new GameEntry("Mike", 1105));
         scoreboard.add(new GameEntry("Rose", 590));
         scoreboard.add(new GameEntry("Rob", 750));
         scoreboard.add(new GameEntry("Paul", 720));
         scoreboard.add(new GameEntry("Anna", 660));

        long startTimeAdd = System.currentTimeMillis();
        for (int i = 1; i <= 10000000; i++) {
            scoreboard.add(new GameEntry("Jack" + i, i));
        }
        long endTimeAdd = System.currentTimeMillis();
        long elapsedAdd = endTimeAdd - startTimeAdd;
        System.out.println("Time taken to add: " + elapsedAdd);

         System.out.println("========== Initial values ends =====");

         System.out.println("Insert Selva 800 Score");

         scoreboard.add(new GameEntry("Selva", 800));

         scoreboard.displayDetails();

         System.out.println("Remove Anna");
         scoreboard.remove(4);
        long startTime = System.currentTimeMillis();
        scoreboard.displayDetails();
        long endTime = System.currentTimeMillis();
        long elapsed = endTime - startTime;
        System.out.println("Time taken to display: " + elapsed);


    }

}

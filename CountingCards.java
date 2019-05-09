import java.util.*;
import java.io.File;

/**
 * The CountingCards class. Will take a series of Bridge hands and output a display of the hand as well as its total value.
 * @authors Ansh Sharma, Nabiha Islam
 * @version 1 2019.04.03
 */

public class CountingCards {
  
  public CountingCards() {
    
  }
  
  public void sortSuit(ArrayList<Integer> values, int n) {
    while (n > 1) {
      int maxPos = 0;
      for (int k = 1; k < n; k++)
        if (values.get(k) < values.get(maxPos) )
        maxPos = k;
      int temp = values.get(maxPos);
      values.set(maxPos,values.get(n-1));
      values.set(n-1,temp);
      n--;
    }
  }
  
  public void inputSortCalculateAndDisplay()
  {
    String input = "";
    try {
      Scanner sc = new Scanner(new File("MyCards.txt"));
      input = sc.nextLine();
    }
    catch (Exception e){
    }
    int points = 0;
    
    ArrayList<Character> diamonds = new ArrayList<Character>();
    ArrayList<Character> hearts = new ArrayList<Character>();
    ArrayList<Character> spades = new ArrayList<Character>();
    ArrayList<Character> clubs = new ArrayList<Character>();
    
    ArrayList<Integer> diamondsInt = new ArrayList<Integer>();
    ArrayList<Integer> heartsInt = new ArrayList<Integer>();
    ArrayList<Integer> spadesInt = new ArrayList<Integer>();
    ArrayList<Integer> clubsInt = new ArrayList<Integer>();
    
    for (int i = 0; i < 26; i+=2)
    {
      if (input.charAt(i+1)== 'D')
        diamonds.add(input.charAt(i));
      else if (input.charAt(i+1)== 'H')
        hearts.add(input.charAt(i));
      else if (input.charAt(i+1)== 'S')
        spades.add(input.charAt(i));
      else if (input.charAt(i+1)== 'C')
        clubs.add(input.charAt(i)); 
    }
    
    for (int i = 0; i < diamonds.size(); i++)
    {
      if (diamonds.get(i)=='T')
        diamondsInt.add(10);
      else if (diamonds.get(i)=='J')
        diamondsInt.add(11);
      else if (diamonds.get(i)=='Q')
        diamondsInt.add(12);
      else if (diamonds.get(i)=='K')
        diamondsInt.add(13);
      else if (diamonds.get(i)=='A')
        diamondsInt.add(14);
      else
        diamondsInt.add(Character.getNumericValue(diamonds.get(i)));
    }
    
    for (int i = 0; i < hearts.size(); i++)
    {
      if (hearts.get(i)=='T')
        heartsInt.add(10);
      else if (hearts.get(i)=='J')
        heartsInt.add(11);
      else if (hearts.get(i)=='Q')
        heartsInt.add(12);
      else if (hearts.get(i)=='K')
        heartsInt.add(13);
      else if (hearts.get(i)=='A')
        heartsInt.add(14);
      else
        heartsInt.add(Character.getNumericValue(hearts.get(i)));
    }
    
    for (int i = 0; i < spades.size(); i++)
    {
      if (spades.get(i)=='T')
        spadesInt.add(10);
      else if (spades.get(i)=='J')
        spadesInt.add(11);
      else if (spades.get(i)=='Q')
        spadesInt.add(12);
      else if (spades.get(i)=='K')
        spadesInt.add(13);
      else if (spades.get(i)=='A')
        spadesInt.add(14);
      else
        spadesInt.add(Character.getNumericValue(spades.get(i)));
    }
    
    for (int i = 0; i < clubs.size(); i++)
    {
      if (clubs.get(i)=='T')
        clubsInt.add(10);
      else if (clubs.get(i)=='J')
        clubsInt.add(11);
      else if (clubs.get(i)=='Q')
        clubsInt.add(12);
      else if (clubs.get(i)=='K')
        clubsInt.add(13);
      else if (clubs.get(i)=='A')
        clubsInt.add(14);
      else
        clubsInt.add(Character.getNumericValue(clubs.get(i)));
    }
    
    sortSuit(diamondsInt,diamondsInt.size());
    sortSuit(heartsInt,heartsInt.size());
    sortSuit(spadesInt,spadesInt.size());
    sortSuit(clubsInt,clubsInt.size());
    
    System.out.println("diamonds: " + diamondsInt);
    System.out.println("hearts: " + heartsInt);
    System.out.println("spades: " + spadesInt);
    System.out.println("clubs: " + clubsInt);
    
    for (int i = 0; i < 4; i++) {
      ArrayList<Integer> suit = new ArrayList<Integer>();
      if (i == 0) {
        suit = spadesInt;
        System.out.print("Spades: ");
      } else if (i == 1) {
        suit = heartsInt;
        System.out.print("Hearts: ");
      } else if (i == 2) {
        suit = diamondsInt;
        System.out.print("Diamonds: ");
      } else if (i == 3) {
        suit = clubsInt;
        System.out.print("Clubs: ");
      }
      for (int j = 0; j < suit.size(); j++){
        if (suit.get(j) == 14) {
          points += 4;
          System.out.print("Ace, 4pts ");
        }
        else if (suit.get(j) == 13) {
          points += 3; 
          System.out.print("King, 3pts ");
        }
        else if (suit.get(j) == 12) {
          points += 2; 
          System.out.print("Queen, 2pts ");
        }
        else if (suit.get(j) == 11) {
          points += 1; 
          System.out.print("Jack, 1pt ");
        }
        else {
          System.out.print(suit.get(j) + ", 0pts ");
        }
      }
      if (suit.size() == 0) {
        points += 3;
        System.out.print("Void, 3pts ");
      }
      else if (suit.size() == 1){
        points += 2;
        System.out.print("Singleton, 2pts ");
      }
      else if (suit.size() == 2){
        points += 1;
        System.out.print("Doubleton, 1pt ");
      }
      System.out.println();
    }
    System.out.println("Total points in hand: " + points);
    
  }
  
  public static void main (String[] args) {
    CountingCards test = new CountingCards();
    test.inputSortCalculateAndDisplay();
    test.inputSortCalculateAndDisplay();
    test.inputSortCalculateAndDisplay();
    test.inputSortCalculateAndDisplay();
  }
}
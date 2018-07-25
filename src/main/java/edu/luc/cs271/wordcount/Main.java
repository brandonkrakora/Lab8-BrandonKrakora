package edu.luc.cs271.wordcount;

import java.util.*;



public class Main {

  public static void main(final String[] args) throws InterruptedException {

    // set up the scanner so that it separates words based on space and punctuation
    final Scanner input = new Scanner(System.in).useDelimiter("[^\\p{Alnum}]+");

    WordCounter wordCounter = new WordCounter(new TreeMap<>());


    // Read input of words into a List
    ArrayList wordList = new ArrayList();
    while(input.hasNextLine()) {
      String word = input.nextLine();
      if (word.equals("")) {
        break;
      }
      wordList.add(word);
    }

    // Get the iterator of the wordList to count the frequencies of each word
    Iterator<String> wordIt = wordList.iterator();
    wordCounter.countWords(wordIt);

    //Determine the size of the map
    int mapSize = wordCounter.mapSize();

    // retrieve map's entries set and store each entry to the list
    List<Map.Entry<String, Integer>> descendingOrderList = new ArrayList<>(mapSize);
    int i = 0;
    for (Map.Entry<String, Integer> entry : wordCounter.getCounts().entrySet()) {
      descendingOrderList.add(entry);
      System.out.println(descendingOrderList.get(i));
      i++;
    }


    // Completed this main program
    // 1. create a WordCounter instance
    // 2. use this to count the words in the input
    // 3. determine the size of the resulting map
    // 4. create an ArrayList of that size and
    // 5. store the map's entries in it (these are of type Map.Entry<String, Integer>
    // 6. sort the ArrayList in descending order by count
    //    using Collections.sort and an instance of the provided comparator (after fixing the latter)
    // 7. print the (up to) ten most frequent words in the text
    Collections.sort(descendingOrderList, new DescendingByCount());


    System.out.println("Finished sorting\n");
    for (int j = 0; j < descendingOrderList.size(); j++) {
      if (j==10) break;
      System.out.println(descendingOrderList.get(j).getKey() + "=" + descendingOrderList.get(j).getValue());
    }
  }
}

package edu.luc.cs271.wordcount;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/** A map-based class for counting word frequencies from an iterator. */
public class WordCounter {

  /** The map for storing the word counts. */
  private final Map<String, Integer> theMap;



  /** Creates a word counter instance based on the given map. */
  public WordCounter(final Map<String, Integer> theMap) {

    // Completed
    this.theMap = theMap;

  }

  /** Counts the frequencies of all words in the given iterator. */
  public void countWords(final Iterator<String> words) {

    while (words.hasNext()) {
      String word = words.next();
      int frequency = 0;
      if(theMap.containsKey(word)){
        frequency = theMap.get(word);
      }
      frequency++;
      theMap.put(word, frequency);
    }
    // Completed for each word in the iterator, update the corresponding frequency in the map
    // HINT to do this without a conditional, use the getOrDefault method

  }

  /** Retrieve the frequency of a particular word. */
  public int getCount(final String word) {

    // Completed
    if(theMap.containsKey(word))
      return theMap.get(word);
    else
      return 0;
  }

  /** Retrieve the map representing all word frequencies. */
  public Map<String, Integer> getCounts() {
    return Collections.unmodifiableMap(theMap);
  }

  public int mapSize() {
    return theMap.size();
  }

  public void displayMap() {
    Iterator it = theMap.entrySet().iterator();
    while(it.hasNext()) {
      Map.Entry pair = (Map.Entry)it.next();
      System.out.println(pair.getKey() + " = " + pair.getValue());
      it.remove();
    }
  }




}

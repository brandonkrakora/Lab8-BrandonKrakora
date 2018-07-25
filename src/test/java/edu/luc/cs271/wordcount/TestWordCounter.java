package edu.luc.cs271.wordcount;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestWordCounter {

  // Complete complete this test class
  WordCounter fixture;
  // Complete declare a reference to the SUT (system under test), i.e., WordCounter

  @Before
  public void setUp() {
    // Complete create the SUT instance
    Map<String, Integer> myMap = new HashMap<>();
    fixture = new WordCounter(myMap);
  }

  @After
  public void tearDown() {
    // Complete set the SUT instance to null
    fixture = null;
  }

  @Test
  public void testGetCountEmpty() {

    // Complete verify that the SUT initially returns an empty map
    assertTrue(fixture.getCounts().isEmpty());

  }

  @Test
  public void testGetCountNonEmpty() {

    // TODO run the SUT on a specific String iterator with some repeated words,
    // then use assertions to verify the correct counts
    // do this for at least two words in the iterator and two not in the iterator
    ArrayList<String> words = new ArrayList<>();
    words.add("tim");
    words.add("tim");
    words.add("john");
    Iterator<String> wordIt = words.iterator();
    fixture.countWords(wordIt);

    assertTrue(fixture.getCount("tim") == 2);
    assertTrue(fixture.getCount("john") == 1);
    assertTrue(fixture.getCount("kim") == 0);
    assertTrue(fixture.getCount("sam") == 0);
  }
}

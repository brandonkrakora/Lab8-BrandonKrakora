- Try using a `TreeMap` instead of a `HashMap`. Does this make any difference?
    -   No, it doesn't make any difference.

- What happens if you invoke `countWords` multiple times for different String iterators?
    -   It would update the frequency in the Map, and if word is not previously in the Map it would add the word.

- What crucial role does the Iterator abstraction play in making `WordCounter` testable?
    -   It provides an adapter for different types of data to coexist.

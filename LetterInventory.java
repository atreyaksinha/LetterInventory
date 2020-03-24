public class LetterInventory {
    private int size;
    private int[] elementData;

    public static final int ALPHABETS = 26;

    // post: constructs an inventory(elementData) for the letters in a given string
    //       and counts the number of times each letter occurred and then puts them
    //       in inventory and then increases the size
    //       upper case is same as lower in the inventory
    public LetterInventory(String data) {
        elementData = new int[ALPHABETS];
        data = data.toLowerCase();
        for (int i = 0; i < data.length(); i++) {
            if (Character.isLetter(data.charAt(i))) {
                size++;
                elementData[data.charAt(i) - 'a']++;
            }
        }
    }

    // pre: throws IllegalArgumentException if letters are not alphabets
    // post: returns the count stored in inventory
    public int get(char letter) {
        if (!Character.isLetter(letter)) {
            throw new IllegalArgumentException();
        }
        letter = Character.toLowerCase(letter);
        return elementData[letter - 'a'];
    }

    // pre: throws IllegalArgumentException if letters are not alphabets
    //      and positive or 0
    // post: sets the value in inventory
    public void set(char letter, int value) {
        if (!Character.isLetter(letter) || value < 0) {
            throw new IllegalArgumentException();
        }
        letter = Character.toLowerCase(letter);
        size -= elementData[letter - 'a'];
        elementData[letter - 'a'] = value;
        size += value;
    }

    // post: returns the size of inventory
    //       size -> sum of character counts
    public int size() {
        return size;
    }

    // post: returns true if inventory is Empty
    //       returns false if inventory is not Empty
    public boolean isEmpty() {
        return size == 0;
    }

    // post: returns an alphabetically organized version of the
    //       inventory with brackets
    public String toString() {
        String result = "[";
        for (int i = 0; i < ALPHABETS; i++) {
            for (int j = 0; j < elementData[i]; j++) {
                result += (char) (i + 'a');
            }
        }
        return result + "]";
    }

    // Pre:  Accepts LetterInventory 'other' as parameter
    // Post: Returns new LetterInventory object with counts of each letter
    //       equal to the sum of counts of each letter in 'other' and the
    //       counts of each letter in current LetterInventory object
    public LetterInventory add(LetterInventory other) {
        LetterInventory sum = new LetterInventory("");
        for (int i = 0; i < ALPHABETS; i++) {
            char ch = (char) ('a' + i);
            int value = elementData[i] + other.get(ch);
            sum.set(ch, value);
        }
        return sum;
    }

    // Pre:  Accepts LetterInventory 'other' as parameter
    // Post: Returns new LetterInventory object with counts of each letter
    //       equal to the difference of counts of each letter in 'other' and the
    //       counts of each letter in current LetterInventory object
    //       null if the difference is negative
    public LetterInventory subtract(LetterInventory other) {
        LetterInventory diff = new LetterInventory("");
        for (int i = 0; i < ALPHABETS; i++) {
            char ch = (char) ('a' + i);
            int value = elementData[i] - other.get(ch);
            if (value < 0) {
                return null;
            }
            diff.set(ch, value);
        }
        return diff;
    }
}

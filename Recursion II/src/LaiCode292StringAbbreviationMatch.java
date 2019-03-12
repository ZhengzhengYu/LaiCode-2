public class LaiCode292StringAbbreviationMatch {
    //Method 1: Recursive way
    //Time: O(n)
    //Space: O(n)
  /*
  public boolean match(String input, String pattern) {
    // Write your solution here
    return helper(input, 0, pattern, 0);
  }

  //i is the start index of word; j is start index of abbr
  private boolean helper(String word, int i, String abbr, int j) {
    if (i == word.length() && j == abbr.length()) {
      return true;
    }
    if (i >= word.length() || j >= abbr.length()) {
      return false;
    }
    //case 1 is Letter
    if (abbr.charAt(j) < '0' || abbr.charAt(j) > '9') {
      if (word.charAt(i) == abbr.charAt(j)) {
        return helper(word, i + 1, abbr, j + 1);
      }
      return false;
    }
    //case 2 is Number
    int count = 0;
    while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
      count = count * 10 + (abbr.charAt(j) - '0');
      j++;
    }
    return helper(word, i + count, abbr, j);
  }
  */

    //Method 2: Iterative way
    //Time: O(n)
    //Space: O(1)
    public boolean match(String input, String pattern) {
        // Write your solution here
        int i = 0;
        int j = 0;
        while (i < input.length() && j < pattern.length()) {
            if (pattern.charAt(j) < '0' || pattern.charAt(j) > '9') {
                if (input.charAt(i) != pattern.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            } else {
                int count = 0;
                while (j < pattern.length() && pattern.charAt(j) >= '0' && pattern.charAt(j) <= '9') {
                    count = count * 10 + (pattern.charAt(j) - '0');
                    j++;
                }
                i += count;
            }
        }
        return i == input.length() && j == pattern.length();
    }
}

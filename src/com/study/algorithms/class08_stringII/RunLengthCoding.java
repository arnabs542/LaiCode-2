package com.study.algorithms.class08_stringII;

public class RunLengthCoding {
  // Given a string, replace adjacent, repeated characters with the character followed by the number of repeated occurrences.
  // Notice, if only one character, you still need append a 1 after it.

  public String compress(String input) {
    if (input == null || input.length() == 0) {
      return input;
    }
    char[] array = input.toCharArray();
    return encode(array);
  }

  private String encode(char[] input) {
    // Step 1: deal with the cases where the adjacent occurrence of the letters >= 2
    int reader = 0; // the letter is under evaluating
    int writer = 0; // the next position to write
    int newLength = 0; // count new length
    while (reader < input.length) {
      // record the begin index, and count occurrence
      int begin = reader;
      while (reader < input.length && input[reader] == input[begin]) {
        reader++;
      }
      // write letter and move
      input[writer++] = input[begin];
      // write occurrence and move
      if (reader - begin == 1) {
        newLength += 2; // reserve the space for "1"
      } else {
        // 注意：可能是多位数
        int len = copyDigits(input, writer, reader - begin);
        writer += len; // next letter to write
        newLength += len + 1; // "digits" + "letter"
      }
    }

    // Step 2: deal with the cases where the adjacent occurrence of the letters == 1
    // Notice: here, since the input char is not large enough,
    // we need a big enough array to implement in-place method.
    // 从右往左
    char[] result = new char[newLength];
    reader = writer - 1; // last written letter, i.e. the first letter to read from right to left
    writer = newLength - 1;
    while (reader >= 0) {
      // case 1: meet a number --> copy all digits and their letter
      // case 2: meed a letter after a "letter,number" pair
      if (Character.isDigit(input[reader])) {
        // copy all digits
        while (reader >= 0 && Character.isDigit(input[reader])) {
          result[writer--] = input[reader--];
        }
        // copy their letter
        result[writer--] = input[reader--];
      } else {
        // add digit '1'
        result[writer--] = '1';
        // copy the letter
        result[writer--] = input[reader--];
      }
    }
    return new String(result);
  }

  private int copyDigits(char[] input, int offset, int count) {
    // compute how many digits we need:
    int numberOfDigits = 0;
    for (int i = count; i > 0; i /= 10) {
      numberOfDigits++;
    }
    // write digits down, offset initially stay in the next position of letter
    // if 2-digits, move 1
    // if 1-digits, don't move
    offset += numberOfDigits - 1; // a__
                                  //   w
    for (int i = count; i > 0; i /= 10) {
      int digit = i % 10;
      input[offset--] = (char) (digit + '0');
    }

    return numberOfDigits;
  }
}

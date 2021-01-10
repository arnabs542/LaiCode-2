package com.study.algorithms.class08_stringII;

public class RunLengthDecoding {
  // use StringBuilder to help
  public String decompress(String input) {
    // sanity check
    if (input == null || input.length() == 0) {
      return input;
    }
    char[] array = input.toCharArray();
    int reader = 0; // reader
    StringBuilder sb = new StringBuilder(); // writer
    char letter = array[0];

    while (reader < array.length) {
      if (!Character.isDigit(array[reader])) {
        // case 1: letter,    record this letter. move reader
        letter = array[reader];
        reader++;
      } else {
        // case 2: digit,    move reader and parse the value, append letter.
        int begin = reader;
        while (reader < array.length && Character.isDigit(array[reader])) {
          reader++;
        }
        // int number = parseDigits(array, begin, reader - begin);  // 效果同下
        int number = Integer.parseInt(input.substring(begin, reader));
        for (int i = 0; i < number; i++) {
          sb.append(letter);
        }
      }
    }
    return sb.toString();
  }

  private int parseDigits(char[] array, int begin, int numberOfDigits) {
    // compute how many digits we need:
    int value = 0;
    for (int i = 0; i < numberOfDigits; i++) {
      int digit = (int) (array[begin + i] - '0');
      value *= 10;
      value += digit;
    }
    return value;
  }
}

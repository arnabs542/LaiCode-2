package com.study.algorithms.class07_hash_table_stringI;

public class RemoveSpaces {
    // Given a string,
    // remove all leading/trailing/duplicated spaces
    public String removeSpaces(String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] array = input.toCharArray();
        int end = 0;
        for (int i = 0; i < array.length; i++) {
            // [0,end) output part
            // [i, length) need to be evaluate
            // if the space is leading or duplicated:
            if (array[i] == ' ' && (i == 0 || array[i - 1] == ' ')) { // 注意优先级。||没有&&优先。
                continue;
            }
            array[end] = array[i];
            end++;
        }
        // remove trailing spaces:
        // 如果有trailing spaces，只会copy第一个空格。之后的空格会走continue分支，不再移动end
        if (end > 0 && array[end - 1] == ' ') {
            end--;
        }
        return new String(array, 0, end);
    }
}

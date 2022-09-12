package string;

// Leetcode - 6. Zigzag Conversion
class ZigzagConversion {

    public String convert(String s, int numRows) {
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        char[] charArr = s.toCharArray();
        int n = charArr.length;
        int index = 0;
        while (index < n) {
            for (int i = 0; i < numRows && index < n; i++) {
                stringBuilders[i].append(charArr[index++]);
            }
            for (int j = numRows - 2; j > 0 && index < n; j--) {
                stringBuilders[j].append(charArr[index++]);
            }
        }
        StringBuilder res = stringBuilders[0];
        for (int i = 1; i < stringBuilders.length; i++) {
            res.append(stringBuilders[i]);
        }
        return stringBuilders[0].toString();
    }
}

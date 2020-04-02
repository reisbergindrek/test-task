package com.fortumotest.indrek;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddTwoNumberStrings {

    private String a;
    private String b;

    public AddTwoNumberStrings(String x, String y)
    {
        a = x;
        b = y;
    }

    public String sum()
    {
        int maxChars = Math.max(a.length(), b.length());

        int[] list1 = new int[maxChars];
        int[] list2 = new int[maxChars];

        for (int i = 0; i < a.length(); i++) {
            list1[i] = a.charAt(a.length() - 1 - i) - 48;
        }

        for (int i = 0; i < b.length(); i++) {
            list2[i] = b.charAt(b.length() - 1 - i) - 48;
        }

        int buffer = 0;

        int[] sum = new int[maxChars + 1];
        for (int j = 0; j < maxChars; j++) {
            sum[j] = (list1[j] + list2[j] + buffer) % 10;
            buffer = ((list1[j] + list2[j] + buffer) >= 10) ? 1 : 0;
        }

        if (buffer != 0) {
            sum[maxChars] = buffer;
        }

        for(int i = 0; i < sum.length / 2; i++)
        {
            int temp = sum[i];
            sum[i] = sum[sum.length - i - 1];
            sum[sum.length - i - 1] = temp;
        }

        String result;
        result = Arrays.toString(sum);

        Pattern p = Pattern.compile("[0-9]*");
        Matcher m = p.matcher(result);

        StringBuilder sb = new StringBuilder();
        while(m.find()) sb.append(m.group());

        char zero = '0';
        if (sb.charAt(0) == zero) {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}

package vip.housir.bookspider.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author housirvip
 */
@Slf4j
public class StringUtils {

    private static final String CN_NUM = "零一二三四五六七八九";
    private static final String CN_UNIT = "十百千万亿";
    private static final int[] INTS = {10, 100, 1000, 10000, 100000000};

    private static Pattern siteIdPattern = Pattern.compile("http.+/[a-z]+/([0-9]+)/?.*");
    private static Pattern mixNumPattern = Pattern.compile("[零一二三四五六七八九十百千0-9]+");
    private static Pattern bigNumPattern = Pattern.compile("[零一二三四五六七八九]+");
    private static Pattern numPattern = Pattern.compile("[0-9]+");

    public static Integer chinese2Int(String chinese) {

        if (chinese == null || chinese.isEmpty()) {
            return null;
        }

        // 只取和数字有关的部分
        Matcher matcher = mixNumPattern.matcher(chinese);
        if (!matcher.find()) {
            return null;
        }
        chinese = matcher.group();

        // 完全由小写数字组成
        if (numPattern.matcher(chinese).matches()) {
            return Integer.parseInt(chinese);
        }

        // 完全由汉子数字组成，没有单位
        if (bigNumPattern.matcher(chinese).matches()) {
            return strToInt1(chinese);
        }

        return strToInt2(chinese);
    }

    private static Integer strToInt1(String str) {

        char[] arr = str.toCharArray();
        for (char s : arr) {
            str = str.replace(String.valueOf(s), String.valueOf(CN_NUM.indexOf(s)));
        }

        return Integer.parseInt(str);
    }

    private static Integer strToInt2(String str) {

        int num = 0;
        char[] arr = str.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (char s : arr) {
            //跳过零
            if (s == '零') {
                continue;
            }
            //用下标找到对应数字
            int index = CN_UNIT.indexOf(s);
            //如果不在 CN_UNIT 中，即当前字符为数字，直接入栈
            if (index == -1) {
                stack.push(CN_NUM.indexOf(s));
            } else { //当前字符为单位。
                int tempsum = 0;
                int val = INTS[index];
                //如果栈为空则直接入栈
                if (stack.isEmpty()) {
                    stack.push(val);
                    continue;
                }
                //如果栈中有比 val 小的元素则出栈，累加，乘 N，再入栈
                while (!stack.isEmpty() && stack.peek() < val) {
                    tempsum += stack.pop();
                }
                //判断是否经过乘法处理
                if (tempsum == 0) {
                    stack.push(val);
                } else {
                    stack.push(tempsum * val);
                }
            }
        }
        //计算最终的和
        while (!stack.isEmpty()) {
            num += stack.pop();
        }

        return num;
    }

    public static String getSiteId(String url) {

        return siteIdPattern.matcher(url).replaceAll("$1");
    }
}

package vip.housir.bookspider.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author housirvip
 */
@Slf4j
public class StringUtils {

    private static final String[] CN_ARR = new String[]{"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};

    public static Integer chinese2Int(String chinese) {

        if (chinese == null || chinese.isEmpty()) {
            return null;
        }

        for (int i = 0; i < CN_ARR.length; i++) {
            chinese = chinese.replace(CN_ARR[i], String.valueOf(i));
        }
        chinese = chinese.replace("十", "");

        return Integer.parseInt(chinese);
    }
}

package com.osm.antievil.Tools;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;


/**
 * @author wellCh4n
 * @DESCRIPTION 句子转换拼音，暂时不支持多音字
 * @create 2017 - 11 - 12 21:05
 */
public class PinyinQuery {

    /**
     * 句子到拼音
     * @param s
     * @return
     */
    public static String getPinyin(String s){
        if (s == null){
            s = "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        char[] words = s.toCharArray();
        for (char c:words) {
            stringBuilder.append(getSinglePinyin(c) + " ");
//            System.out.println(getSinglePinyin(c));
        }

        return stringBuilder.toString();
    }

    /**
     * 字到拼音
     * @param zhWord
     * @return
     */
    public static String getSinglePinyin(char zhWord){
        if (zhWord=='\0'){  // 判定字符是否为空
            zhWord = ' ';
        }
        HanyuPinyinOutputFormat hanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();
        hanyuPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        hanyuPinyinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
        String pinyin[] = new String[0];
        try {
            pinyin= PinyinHelper.toHanyuPinyinStringArray(zhWord,hanyuPinyinOutputFormat);
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            badHanyuPinyinOutputFormatCombination.printStackTrace();
        }
        return  pinyin[0];
    }

//    public static void main(String[] args) {
//        System.out.println(getPinyin("陈伟豪"));
//    }
}

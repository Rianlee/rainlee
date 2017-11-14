package com.osm.antievil.Tools;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.Arrays;


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
            stringBuilder.append(getSinglePinyin(c));
            if(!getSinglePinyin(c).equals("")){
                stringBuilder.append("");
            }
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
        String pinyin[] = new String[0];
        if (zhWord=='\0'){  // 判定字符是否为空
            return "";
        }
        if (zhWord=='(' || zhWord==')' || zhWord=='/'){
            return "";
        }
        HanyuPinyinOutputFormat hanyuPinyinOutputFormat = new HanyuPinyinOutputFormat();
        hanyuPinyinOutputFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        hanyuPinyinOutputFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
        try {
            pinyin= PinyinHelper.toHanyuPinyinStringArray(zhWord,hanyuPinyinOutputFormat);
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            badHanyuPinyinOutputFormatCombination.printStackTrace();
        }
        return  pinyin[0];
    }

    /**
     * 判断字符是不是中文
     * @param c 待检测的字符
     * @return 返回真假
     */
    public static boolean isChinese(char c) {
        return c >= 0x4E00 &&  c <= 0x9FA5;// 根据字节码判断
    }

    /**
     * 将中文和拼音混合的字符变成拼音
     * @param str 待转换的字符串
     * @return
     */
    public static String changeToPinyin(String str){
        String[] oldarr=str.split("");
        for (int i=0;i<oldarr.length;i++){
            for(char c:oldarr[i].toCharArray()) {
                if (isChinese(c)){ //判断是否是中文
                    oldarr[i]=getSinglePinyin(c); //中文替换成拼音
                    //System.out.println(oldarr[i]+getSinglePinyin(c));
                }
            }
        }
        StringBuffer newStr = new StringBuffer();
        for (String string : oldarr) {
            newStr.append(string);
        }
        //System.out.println(newStr);
        return newStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(changeToPinyin("de科"));
    }
}

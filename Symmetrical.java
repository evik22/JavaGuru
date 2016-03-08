package JavaGuru;

import java.util.Scanner;
/**
 * Created by feodoeve on 2016.03.07..
 * Написать программу, проверяющую, является ли строка симметричной.

 Пример: "asa" -> симметрична
 "asdf" -> не симметрична
 Не использовать циклы.
 */
public class Symmetrical {
    public static void main(String[] args) {
        String userWord = getWord();
        boolean yesOrNo = checkWord(userWord);
        System.out.println("Word you have entered is symmetric: " + yesOrNo);

    }

    public static String getWord() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the word you want to check: ");
        return in.nextLine();
    }

    public static boolean checkWord(String word){
        String halfString1, halfString2;
        if (word.length()%2 == 0) {
            halfString1 = word.substring(0,(word.length())/2);
            halfString2 = word.substring((word.length())/2, word.length());
        }
        else {
            halfString1 = word.substring(0,(word.length())/2);
            halfString2 = word.substring((word.length())/2+1, word.length());
        }
        String reversedString = new StringBuilder(halfString2).reverse().toString();
        return compareStrings(halfString1, reversedString);
    }

    public static boolean compareStrings(String a, String b) {
        boolean symmetric = false;
        if (a.equals(b)) {
            symmetric = true;
        }
        return symmetric;
    }
}
/*
Please enter the word you want to check:
asdkjds
Word you have entered is symmetric: false
//
Please enter the word you want to check:
asumusa
Word you have entered is symmetric: true
//
Please enter the word you want to check:
asummusa
Word you have entered is symmetric: true
 */
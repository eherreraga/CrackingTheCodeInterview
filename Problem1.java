import java.util.Hashtable;
import java.util.Scanner;

//Chapter 1
public class Problem1{
    public static void main(String[]args){
        
        //Problem 1.1
        System.out.println(isUnique("Eddie"));

        //Problem 1.2
        System.out.println("Problem 1.2: "+checkPermutation("Eddie", "eidde"));

        //Problem 1.3
        URLi("Mr John Smith ", 13);

        //Problem 1.5
        System.out.println("Problem 1.5\n"+oneWay("pale", "bake"));

        //Problem 1.6
        stringCompression("aabcccccaaa");
    }

    /**
     * Problem 1.1
     * Is Unique: Implement an algorithm to determine if a string has all unique characters.
     *  What if you cannot use additional data structures?
     * *this is going to treat capitalized letters and lower case letters as different characters.
     * Runtime O(n)
     */
    public static boolean isUnique(String str){
         for (char var : str.toCharArray()) {
            if(str.indexOf(var) == str.lastIndexOf(var)){
                //this means that that character is unique since it has only one index
                continue;
            }else{
                //this means that var is not unique, because it has different index throught the String
                return false;
            }
         }
        return true;    
    }

    /**Problem 1.2
     * Check Permutation: Given two strings,write a method to decide if one is a permutation of the other.
     * O(n)
     */
    public static boolean checkPermutation(String word0, String word1){

        //theyhave to be the same size.
        if(word0.length() != word1.length())
            return false;  
        word0 = word0.toUpperCase(); 
        word1 = word1.toUpperCase();
        boolean sameChar = false;

        char[] a0 = word0.toCharArray();
        char[] a1 = word1.toCharArray();    
        Hashtable<Character, Integer> table = new Hashtable<>(word0.length());
        
        for (char var : a0) {
            int value = table.getOrDefault(var, 0);
            value++;
            table.put(var,value);
        }
        for (char var : a1) {
            int value = table.getOrDefault(var, 0);
            value--;
        }
        for (int var : table.values()) {
            if(var != 0)
                return false;
        }

        return true;
    }
    /**
     * Problem 1.3
     * Write a method to replace all spaces in a string with '%20  You may assume that the string has suf cient space at the end to hold the additional characters,and that you are given the "true" length of the string. (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)
     * 
     */
    public static void URLi(String str, int length){
        //trim the end of white space with the true length
        String newStr = str.substring(0, length);
        
        //replace the white spaces with '%20'
        newStr = newStr.replaceAll("\\s", "%20");
        System.out.println(newStr);
    }

    /**
     * Problem 1.6
     * String Compression: Implement a method to perform basic string compression using the counts of repeated characters. For example, the string aabcccccaaa     would become a2blc5a3. If the "compressed" string would not become smaller than the original string, your method should return
        the original string. You can assume the string has only uppercase and lowercase letters (a - z).
        O(n)
     */

     public static void stringCompression(String str){
        StringBuilder sb = new StringBuilder();
        char tempChar = str.charAt(0);
        int counter = 0;
        
        for(int i = 0; i < str.length(); i++){            
            counter++;
            if(str.charAt(i) != tempChar || (i + 1) == str.length()){
                sb.append(tempChar+String.valueOf(counter));
                tempChar = str.charAt(i);
                counter = 0;
            }
        }

        System.out.println("Problem 1.6 \n"+sb.toString());
     }

    /**Problem 1.5
     * One Away: There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. Given two strings, write a function to check if they are one edit (or zero edits) away.
     * *There has to be atleast two words different to decided that its a different word, and assuming that words with not equal length are edited
     * O(n)
     */
    public static boolean oneWay(String word0, String word1){
        
        int differenceLimit = 2; 

        if(word0.length() != word1.length())
            return true;
        for(int i = 0; i < word0.length(); i++ )
            if(word0.charAt(i) != word1.charAt(i))
                differenceLimit--;
                if(differenceLimit <= 0)
                    return false;
        return true;
    }
}
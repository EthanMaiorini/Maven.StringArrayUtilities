package com.zipcodewilmington;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
           // Arrays.sort(array);
       // return Arrays.binarySearch(array,value) >=0;
        return Arrays.asList(array).contains(value);
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        String[] reverseArray = Arrays.copyOf(array,array.length);
        Collections.reverse(Arrays.asList(reverseArray));
        return reverseArray;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
//        boolean isTrue = false;
//        int x=0;
//        String[] array2 = Arrays.copyOf(StringArrayUtils.reverse(array),array.length);
//        for(String s: array){
//            if(s.equals(array2[x])){
//                isTrue = true;
//            }
//            x++;
//        }
        //return isTrue;
        return Arrays.equals(array,StringArrayUtils.reverse(array));
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        StringBuilder s = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        for(int x=0;x<array.length;x++){
            s = s.append(array[x].toLowerCase());
        }
        String patternString = "[a-z]";
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(s);
        for (int i = 0;matcher.find(); i++) {
            if(answer.indexOf(matcher.group()) == -1)
            answer.append(matcher.group()).toString();
        }
        if(answer.length() == 26)
            return true;
        else
            return false;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count = 0;
        for(String s:array){
            if(s.equals(value)){
                count++;
            }
        }
        return count;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        String[] newArray = new String[array.length-1];
        int x = 0;
         for(String s: array){
            if (!(s.equals(valueToRemove))){
                newArray[x] = s;
              x++;
              break;
          }
        }
        return newArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
       ArrayList<String> newArr = new ArrayList<>();
//
            int n = array.length;
            if (n==0 || n==1){
                return array;
            }
            int j = 0;//for next element
            for (int i=0; i < n-1; i++){
                if (array[i] != array[i+1]){
                    newArr.add(array[i]);
                }
            }
            newArr.add(array[n-1]);
            return newArr.toArray(new String[0]);
        }
   // }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        ArrayList<String> result = new ArrayList<String>(Arrays.asList(array));
            String s ="";
        boolean removed = true;
        for (int i=0; i < ((result.size())-1); i++){
               s = result.get(i);
            while((result.get(i)).equals(result.get(i+1)) && (i+1 <= result.size())) {
                s = s.concat(result.get(i+1));
                removed = result.remove(result.get(i+1));
                if(result.size()-1 == i)
                    break;
            }
            result.set(i,s);
            s="";
        }
        return (result.toArray(new String[0]));
    }


}

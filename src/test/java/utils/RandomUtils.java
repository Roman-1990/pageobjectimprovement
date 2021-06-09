package utils;

import java.util.Arrays;
import java.util.List;

import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {


    //ввод рандомных данных по фрормам
    public static String getRandomGender() {
        List<String> list = Arrays.asList("Female", "Male", "Other");
        return getRandomElementFromList(list);
    }

    public static String getRandomHobby() {
        List<String> list = Arrays.asList("Sports", "Reading", "Music");
        return getRandomElementFromList(list);
    }

    public static String getRandomElementFromList(List<String> list) {
        int size = list.size();
        int randIdx = ThreadLocalRandom.current().nextInt(size);
        return list.get(randIdx);
    }

    public static String getRandomMonth() {
        List<String> list = Arrays.asList("January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December");
        return getRandomElementFromList(list);
    }

    public static String getRandomDay() {
        List<String> list = Arrays.asList(
                "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25",
                "26", "27", "28");
        return getRandomElementFromList(list);
    }

    public static String getRandomYear() {
        List<String> list = Arrays.asList("2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012");
        return getRandomElementFromList(list);
    }

    public static String getRandomSubject() {
        List<String> list = Arrays.asList("Hindi", "Arts", "English", "History");
        return getRandomElementFromList(list);
    }
}
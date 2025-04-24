package utils;

import java.security.SecureRandom;
import java.time.Year;
import java.util.concurrent.ThreadLocalRandom;

import static tests.TestDataFaker.*;

public class RandomUtils {

    public static void main(String[] args) {
        System.out.println(getRandomString(10));
        System.out.println(getRandomInt(10,100));
        System.out.println(getRandomEmail());

        String[] names = {"a","b","c","d","e"};
        System.out.println(getRandomItemFromArray(names));
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomIntString() {
        return String.valueOf(ThreadLocalRandom.current().nextInt(1, 29));
    }

    public static String getRandomYearString() {
        int currentYear = Year.now().getValue(); // Получаем текущий год
        return String.valueOf(ThreadLocalRandom.current().nextInt(1900, currentYear + 1));
    }


    public static String getRandomString(int length) {
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String getRandomEmail() {
        return getRandomString(10) + "@qa.ru";
    }

    public static String getRandomItemFromArray(String[] values){
        int index = getRandomInt(0, values.length -1);
        return values[index];
    }

    public static String getRandomCity(String state){

        if (state.equals("NCR") ){
            return getRandomItemFromArray(cityNcr);
        }
        else if(state.equals("Uttar Pradesh")){
            return getRandomItemFromArray(cityUttar); //new String[]{"Agra", "Lucknow",  "Merrut"}
        }
        else if(state.equals("Haryana")){
            return getRandomItemFromArray(cityHaryana);
        }
        else if(state.equals("Rajasthan")){
            return getRandomItemFromArray(cityRajasthan);
        }
        else{
            throw new IllegalArgumentException("Unknown state: " + state);
        }
    }

}

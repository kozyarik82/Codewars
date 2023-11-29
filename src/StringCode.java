import java.util.List;

public class StringCode {
    // Дезоксирибонуклеиновая кислота, ДНК, является основной молекулой хранения информации в биологических системах. Он состоит из четырех оснований нуклеиновых кислот: гуанина («G»), цитозина («C»), аденина («А») и тимина («Т»).
    //
    //Рибонуклеиновая кислота, РНК, является основной молекулой-мессенджером в клетках. РНК несколько отличается от ДНК по химической структуре и не содержит тимина. В РНК тимин заменен другой нуклеиновой кислотой урацилом («U»).
    //
    //Создайте функцию, которая переводит заданную строку ДНК в РНК.

    public static String dnaToRna(String dna) {
        for (int i = 0; i < dna.length(); i++) {

            dna = dna.replace('U', 'T');
        }

        return dna;  // Do your magic!
    }

    public static String dnaToRnaBest(String dna) {
        return dna.replaceAll("U", "T");
    }

    //Напишите функцию RemoveExclamationMarks, которая удаляет
    // все восклицательные знаки из заданной строки.
    static String removeExclamationMarks(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (!"!".contains(String.valueOf(s.charAt(i)))) {
                result += s.charAt(i);
            }
        }
        return result;
    }
    static String removeExclamationMarksBest(String s) {
        return s.replaceAll("!", "");
    }

    //Учитывая строку цифр, вы должны заменить любую цифру ниже 5 на «0», а любую цифру от 5 и выше на «1».
    // Верните полученную строку.
    //Примечание: ввод никогда не будет пустой строкой.
    public static String fakeBin(String numberString) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numberString.length(); i++) {
            char digit = numberString.charAt(i);
            int intValue = Character.getNumericValue(digit);

            // Replace digits below 5 with '0' and 5 and above with '1'
            if (intValue < 5) {
                result.append('0');
            } else {
                result.append('1');
            }
        }
        return result.toString();
    }
    public static String fakeBinBest(String numberString) {
        return numberString.replaceAll("[0-4]", "0").replaceAll("[5-9]", "1");
    }
    //Изограмма – это слово, в котором нет повторяющихся букв, как последовательных, так и непоследовательных.
    // Реализуйте функцию, которая определяет, является ли строка, содержащая только буквы, изограммой.
    // Предположим, что пустая строка является изограммой. Не обращайте внимания на регистр букв.
    public static boolean  isIsogram(String str) {
        // ...
        String result = str.toLowerCase().chars().distinct().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        if (result.equalsIgnoreCase(str)) {
            return true;
        }else{
            return false;
        }
    }
    public static boolean  isIsogramClever(String str) {
        return str.length() == str.toLowerCase().chars().distinct().count();
    }
    public static boolean isIsogramBest(String str) {
        return str.toLowerCase()
                .chars()
                .distinct()
                .count() == str.length();
    }

    //Возвращает количество гласных в заданной строке.
    //Мы будем считать a, e, i, o, u гласными для этой Ката (но не y)
    //Входная строка будет состоять только из строчных букв и/или пробелов.

    public static int getCount(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if ("a,e,i,o,u".contains(String.valueOf(str.charAt(i)))) {
                count ++;
            }
        }
        return count;
    }
    public static int getCountClever(String str) {
        return str.replaceAll("(?i)[^aeiou]", "").length();
    }
    public static int getCountBest(String str) {
        return (int) str.chars().filter(c -> "aeiou".indexOf(c) >= 0).count();
    }

    //Тролли атакуют ваш раздел комментариев!
    //Распространенный способ справиться с этой ситуацией — удалить все гласные из комментариев троллей, нейтрализуя угрозу.
    //Ваша задача — написать функцию, которая принимает строку и возвращает новую строку, из которой удалены все гласные.
    //Например, строка «This website is for losers LOL!» станет «Ths wbst s fr lsrs LL!».
    //Примечание: для этой ката y не считается гласной.

    public static String disemvowel(String str) {
        return str.replaceAll("(?i)[aeiou]", "");
    }
    public static String disemvowelLight(String str) {
        return str.replaceAll("[aAeEiIoOuU]", "");
    }
}

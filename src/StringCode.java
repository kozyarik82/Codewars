import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;

public class StringCode {
    // Дезоксирибонуклеиновая кислота, ДНК, является основной молекулой хранения информации в биологических системах. Он состоит из четырех оснований нуклеиновых кислот: гуанина («G»), цитозина («C»), аденина («А») и тимина («Т»).
    //Рибонуклеиновая кислота, РНК, является основной молекулой-мессенджером в клетках. РНК несколько отличается от ДНК по химической структуре и не содержит тимина. В РНК тимин заменен другой нуклеиновой кислотой урацилом («U»).
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

    // Напишите функцию RemoveExclamationMarks, которая удаляет
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

    //Напишите функцию, которая принимает массив слов, объединяет их в предложение и возвращает это предложение.
    // Вы можете игнорировать необходимость очистки слов или добавления знаков препинания,
    // но вам следует добавлять пробелы между каждым словом. Будьте внимательны:
    // ни в начале, ни в конце предложения не должно быть пробела!

    public static String smash(String... words) {
        return String.join(" ", words);
    }
    public static String smashBest(String... words) {
        return words != null ? String.join(" ", words) : null;
    }

    // Напишите функцию, которая преобразует входную строку в верхний регистр.

    public static String MakeUpperCase(String str){
        return str.toUpperCase();
    }
    public static String MakeUpperCaseBest(String str){
        return str == null ? null : str.toUpperCase();
    }

    // Завершите решение так, чтобы оно возвращало true,
    // если первый переданный аргумент (строка) заканчивается вторым аргументом (также строкой).

    public static boolean solution(String str, String ending) {
        return str.endsWith(ending) ? true : false;
    }
    public static boolean solutionBest(String str, String ending) {
        return str.endsWith(ending);
    }

    // На фабрике принтер печатает этикетки для коробок. Для одного вида коробок принтеру приходится использовать цвета,
    // которые для простоты называются буквами от a to m.
    //Цвета, используемые принтером, записываются в управляющую строку.
    // Например, «хорошая» управляющая строка будет aaabbbbhaijjjm означать,
    // что принтер трижды использовал цвет a, четыре раза цвет b, один раз цвет h, затем один раз цвет a...
    //Иногда возникают проблемы: отсутствие цветов, техническая неисправность и выдается "плохая" управляющая строка,
    // например, aaaxbbbbyyhwawiwjjjwwmс буквами не из a to m.
    //Вам нужно написать функцию printer_error, которая по заданной строке будет возвращать частоту ошибок
    // принтера в виде строки , представляющей рациональное число, числитель которого — это количество ошибок,
    // а знаменатель — длина управляющей строки. Не сводите эту дробь к более простому выражению.
    //Строка имеет длину большую или равную единице и содержит только буквы от aдо z.

    public static String printerError(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if ("[nopqrstuvwxyz]".contains(String.valueOf(s.charAt(i)))) {
                count++;
            }
        }
        return count + "/" + s.length();
    }
    public static String printerErrorClever(String s) {
        return s.replaceAll("[a-m]", "").length() + "/" + s.length();
    }
    public static String printerErrorBest(String s) {
        long errs = s.chars().filter( ch -> ch > 'm').count();
        return errs+"/"+s.length();
    }

    // Напишите функцию для преобразования имени в инициалы.
    // Эта ката состоит из двух слов с одним пробелом между ними.
    //В результате должны быть две заглавные буквы с точкой, разделяющей их.
    //Это должно выглядеть так:
    //Sam Harris=>S.H
    //patrick feeney=>P.F

    public static String abbrevName(String name) {
        StringBuilder initials = new StringBuilder();

        String[] nameParts = name.split(" ");

        for (String part : nameParts) {
            if (!part.isEmpty()) {
                initials.append(nameParts[0].charAt(0)).append(".").append(nameParts[1].charAt(0));
            }
        }
        return initials.toString().toUpperCase();
    }
    public static String convertToInitials(String name) {
        StringBuilder initials = new StringBuilder();
        String[] nameParts = name.split(" ");
        if (nameParts.length == 2) {
            initials.append(nameParts[0].charAt(0)).append(".").append(nameParts[1].charAt(0));
        }
        return initials.toString().toUpperCase();
    }
    public static String abbrevNameBest(String name) {
        String[] names = name.split(" ");
        return (names[0].charAt(0) + "." + names[1].charAt(0)).toUpperCase();
    }
    public static String abbrevNameBest1(String name) {
        return stream(name.split(" "))
                .map(String::toUpperCase)
                .map(word -> word.substring(0, 1))
                .collect(Collectors.joining("."));
    }

    // Создайте функцию, которая будет возвращать оператор приветствия, использующий входные данные;
    // ваша программа должна вернуть, "Hello, <name> how are you doing today?".
    public static String greet(String name) {
        return String.format("Hello, %s how are you doing today?", name);
    }

    // Если не можешь заснуть, просто посчитай овец!!
    //Задача:
    //3 Например, если задано неотрицательное целое число, верните строку с ропотом:
    // "1 sheep...2 sheep...3 sheep...". Ввод всегда будет действительным,
    // т.е. отрицательных целых чисел не будет.

    public static String countingSheep(int num) {
        String result = "";
        for (int i = 1; i <= num; i++) {
            result += i + " sheep...";
        }
        return result;
    }
    public static String countingSheepClever(int num) {
        return IntStream.rangeClosed(1, num)
                .mapToObj(i -> i + " sheep...")
                .collect(Collectors.joining());
    }
    public static String countingSheepBest(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= num; i++) {
            stringBuilder.append(i).append(" sheep...");
        }
        return stringBuilder.toString();
    }

    // Подсчитайте количество дубликатов
    // Напишите функцию, которая будет возвращать количество различных буквенных символов и числовых цифр,
    // не зависящих от регистра, которые встречаются во входной строке более одного раза.
    // Можно предположить, что входная строка содержит только буквы алфавита
    // (как прописные, так и строчные) и числовые цифры.

    public static int duplicateCount(String text) {
        text = text.toLowerCase();
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : text.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        // Count characters that occur more than once
        int duplicateCount = 0;
        for (int count : charCount.values()) {
            if (count > 1) {
                duplicateCount++;
            }
        }
        return duplicateCount;
    }
    public static int duplicateCountBest(String text) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : text.toLowerCase().toCharArray()) {
            map.put(c, map.containsKey(c) ? 1 : 0);
        }
        return (int) map.values().stream().filter(e -> e > 0).count();
    }
    public static int duplicateCountClever(String text) {
        int ans = 0;
        text = text.toLowerCase();
        while (text.length() > 0) {
            String firstLetter = text.substring(0,1);
            text = text.substring(1);
            if (text.contains(firstLetter)) ans ++;
            text = text.replace(firstLetter, "");
        }
        return ans;
    }
    public static int duplicateCountBest1(String text) {
        return (int)text.toLowerCase().chars()
                .boxed()
                .collect(Collectors.groupingBy(k->k,Collectors.counting()))
                .values().stream().filter(e->e>1).count();
    }

    // В этом небольшом задании вам дается строка чисел, разделенных пробелами,
    // и вы должны вернуть наибольшее и наименьшее число.
    public static String highAndLow(String numbers) {
        String[] numberArray = numbers.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (String numStr : numberArray) {
            int num = Integer.parseInt(numStr);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return max + " " + min;
    }
    static String highAndLowBest(String numbers) {
        var stats = stream(numbers.split(" ")).mapToInt(Integer::parseInt).summaryStatistics();
        return stats.getMax() + " " + stats.getMin();
    }
    public static String highAndLowBest1(String numbers) {
        List<Integer> nums = Arrays.stream(numbers.split(" ")).map(Integer::parseInt).toList();
        return "%s %s".formatted(Collections.max(nums), Collections.min(nums));
    }

    // Банкоматы допускают использование 4- или 6-значных PIN-кодов,
    // а PIN-коды не могут содержать ничего, кроме ровно 4 или ровно 6 цифр.
    //Если функции передана действительная строка PIN-кода, return true, иначе return false.
    public static boolean validatePin(String pin) {
        if (pin.length() == 4 || pin.length() == 6) {
            if (pin.replaceAll("[0-9]", "").isEmpty()) {
                return true;
            }
        }
        return false;
    }
    public static boolean validatePin1(String pin) {
        return pin.matches("\\d{4}|\\d{6}");
    }
    public static boolean validatePin2(String pin) {
        return pin.matches("[0-9]{4}|[0-9]{6}");
    }
    public static boolean validatePin3(String pin) {
        if (pin.length() == 4 || pin.length() == 6)
            return pin.chars().allMatch(Character::isDigit);
        return false;
    }
}

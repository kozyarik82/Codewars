import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

public class Array {

    // Рассмотрим массив/список овец, в котором некоторые овцы могут отсутствовать на своем месте.
    // Нам нужна функция,
    // которая подсчитывает количество овец, присутствующих в массиве (истина означает наличие).

    public int countSheeps(Boolean[] arrayOfSheeps) {
        int result = 0;
        for (int i = 0; i < arrayOfSheeps.length; i++) {
            if(arrayOfSheeps[i]!= null && arrayOfSheeps[i].equals(true)) {
                result += 1;
            }
        }
        return result;
    }
    public int countSheepsBest(Boolean[] arrayOfSheeps) {
        int counter = 0;
        for (Boolean present : arrayOfSheeps) {
            if (present != null && present) {
                counter += 1;
            }
        }
        return counter;
    }
    public int countSheepsClever(Boolean[] arrayOfSheeps) {
        return Collections.frequency(asList(arrayOfSheeps), true);
    }

    //Вы получаете массив чисел, возвращаете сумму всех положительных чисел.
    //
    //Пример [1,-4,7,12]=>1 + 7 + 12 = 20
    //
    //Примечание. Если суммировать нечего, сумма по умолчанию равна 0.
    public static int sum(int[] arr)
    {
        int sum = 0;

        for(int i=0; i<arr.length; i++) {
            if(arr[i] > 0)
            {
                sum += arr[i];
            }
        }
        return sum;
    }
    public static int sumBest(int[] arr){
        int result = 0;
        for (int i : arr) {
            if (i > 0) {
                result += i;
            }
        }
        return result;
    }
    public static int sumClever(int[] arr){
        return Arrays.stream(arr).filter(v -> v > 0).sum();
    }

    //Найдите наименьшее число в массиве
    public static int findSmallestInt(int[] args) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < args.length; i++) {
            if (args[i] < result) {
                result = args[i];
            }
        }
        return result;
    }
    public static int findSmallestIntClever(int[] args) {
        Arrays.sort(args);
        return args[0];
    }
    public static int findSmallestIntBest(int[] args) {
        return IntStream.of(args).min().getAsInt();
    }

    //Учитывая треугольник последовательных нечетных чисел:
    //
    //             1
    //          3     5
    //       7     9    11
    //   13    15    17    19
    //21    23    25    27    29
    //...
    //Вычислите сумму чисел в n- й строке этого треугольника (начиная с индекса 1), например: ( Ввод --> Выход )

    public static int rowSumOddNumbers(int n) {
        int startNumber = (n * (n - 1)) + 1;

        // Calculate the sum of the numbers in the nth row
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += startNumber + (2 * i);
        }

        return sum;
    }
    public static int rowSumOddNumbersBest(int n) {
    /* sum of consequent M numbers is (M+1)M/2, so
     * we may know how many numbers were below
     * our ROW : numbersBelow = ((n-1)*(n))/2.
     * Now we may calculate first number in row:
     * firstNumberInRow = 2*numbersBelow+1.
     * So, firstNumberInRow = n*n-n+1 and
     * last number in ROW is n*n-n+1 + 2(n-1).
     * Let assume that last number before row is
     * x1 and last number in row is x2. It's known
     * that 1+3+5+...+(2k-1) = k*k.
     * Sum in row must be x2*x2 - x1*x1.
     // OUR x1 = (n*n-n)/2 and x2 = (n*n+n)/2.
     * After some simplification: SUM = n*n*n. */
        return n*n*n;
    }
    public static int rowSumOddNumbersClever(int n) {
        return (int) Math.pow(n,3);
    }

    //Напишите функцию, которая принимает массив чисел и возвращает сумму чисел.
    // Числа могут быть отрицательными или нецелыми.
    // Если массив не содержит чисел, вам следует вернуть 0.

    public static double sum(double[] numbers) {
        return DoubleStream.of(numbers).sum();
    }
    public static double sumBest(double[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    //Сможете ли вы найти иголку в стоге сена?
    //Напишите функцию findNeedle(), которая принимает arrayполный мусор, но содержит один"needle"
    //После того, как ваша функция найдет иглу, она должна вернуть сообщение (в виде строки), в котором говорится:
    //"found the needle at position "плюс indexон нашел иголку, так что:

    public static String findNeedle(Object[] haystack) {
        String result = "needle";
        int index =0;
        for (int i = 0; i < haystack.length; i++) {
            if (haystack[i] == result) {
                index = i;
            }
        }
        return "found the needle at position " + index;
    }
    public static String findNeedleClever(Object[] haystack) {
        return String.format("found the needle at position %d", asList(haystack).indexOf("needle"));
    }
    public static String findNeedleBest(Object[] haystack) {

        for (int i = 0; i < haystack.length; i++) {
            if (haystack[i] == "needle") {
                return "found the needle at position " + i;
            }
        }
        return "needle be lost, yo";
    }
    static String findNeedleClever1(Object[] haystack) {
        return "found the needle at position " + asList(haystack).indexOf("needle");
    }

    //Напишите функцию, которая вычисляет среднее значение чисел в заданном списке.
    //Примечание. Пустые массивы должны возвращать 0.

    public static double find_average(int[] array){
        double sum = Arrays.stream(array).sum();
        long count = Arrays.stream(array).count();
        return sum / count;
    }
    public static double find_averageClever(int[] array){
        return Arrays.stream(array).average().orElse(0);
    }
    public static double find_averageBest(int[] array){
        double sum = 0;
        for (int val : array)
            sum += val;
        return sum / array.length;
    }

    // По городу движется автобус, который на каждой остановке забирает и высаживает несколько человек.
    //Вам предоставляется список (или массив) пар целых чисел. Элементы каждой пары представляют собой количество людей, входящих в автобус (первый элемент) и количество людей, выходящих из автобуса (второй элемент) на остановке.
    //Ваша задача — вернуть количество людей, которые все еще находятся в автобусе после последней остановки (после последнего массива). Несмотря на то, что это последняя автобусная остановка, автобус может быть не пустым, и в автобусе все еще могут быть люди, они, вероятно, там спят :D
    //Взгляните на тестовые примеры.
    //Имейте в виду, что тестовые примеры гарантируют, что количество людей в автобусе всегда >= 0. Поэтому возвращаемое целое число не может быть отрицательным.
    //Второе значение в первой паре массива равно 0, поскольку на первой остановке автобус пуст.

    public static int countPassengers(ArrayList<int[]> stops) {
        int passengers = 0;
        for (int[] stop : stops) {
            passengers += stop[0];
            passengers -= stop[1];
        }
        return passengers;
    }
    public static int countPassengersBest(ArrayList<int[]> stops) {
        return stops.stream()
                .mapToInt(x -> x[0] - x[1])
                .sum();
    }

    // Учитывая набор чисел, верните аддитивную обратную величину каждого из них.
    // Каждое положительное становится отрицательным, а отрицательное становится положительным.
    //invert([1,2,3,4,5]) == [-1,-2,-3,-4,-5]
    //invert([1,-2,3,-4,5]) == [-1,2,-3,4,-5]
    //invert([]) == []

    public static int[] invertBest(int[] array) {
        return Arrays.stream(array).map(x -> -x).toArray();
    }
    public static int[] invert(int[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] *= -1;
        }
        return array;
    }

    // Учитывая непустой массив целых чисел, верните результат умножения значений по порядку. Пример:
    //[1, 2, 3, 4] => 1 * 2 * 3 * 4 = 24
    public static int grow(int[] x){
        int result = 1;
        for (int j : x) {
            result = result * j;
        }
        return result;
    }
    public static int growClever(int[] x){
        return Arrays.stream(x).reduce(1 ,(a, b) -> a * b);
    }
}

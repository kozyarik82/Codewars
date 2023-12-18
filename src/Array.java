import java.util.*;
import java.util.function.Predicate;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.iterate;

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

    // Вы получаете массив чисел, возвращаете сумму всех положительных чисел.
    // Пример [1,-4,7,12]=>1 + 7 + 12 = 20
    // Примечание. Если суммировать нечего, сумма по умолчанию равна 0.
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
        return stream(arr).filter(v -> v > 0).sum();
    }

    // Найдите наименьшее число в массиве
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

    // Учитывая треугольник последовательных нечетных чисел:
    //             1
    //          3     5
    //       7     9    11
    //   13    15    17    19
    // 21    23    25    27    29
    // ...
    // Вычислите сумму чисел в n- й строке этого треугольника (начиная с индекса 1), например:
    // ( Ввод --> Выход )

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
        return stream(numbers).sum();
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
        double sum = stream(array).sum();
        long count = stream(array).count();
        return sum / count;
    }
    public static double find_averageClever(int[] array){
        return stream(array).average().orElse(0);
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
        return stream(array).map(x -> -x).toArray();
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
        return stream(x).reduce(1 ,(a, b) -> a * b);
    }

    // Есть массив с некоторыми числами. Все числа равны, кроме одного. Попробуйте найти его!
    public static double findUniq(double arr[]) {
        Arrays.sort(arr);
        if (arr[0] != arr[1]) {
            return arr[0];
        } else {
            return arr[arr.length - 1];
        }
    }
    public static double findUniqBest(double[] arr) {
        Arrays.sort(arr);
        return arr[0] == arr[1] ? arr[arr.length-1]:arr[0];
    }
    // Учитывая случайное неотрицательное число,
    // вам необходимо вернуть цифры этого числа в массиве в обратном порядке.
    public static int[] digitize(long n) {
        return new StringBuilder().append(n)
                .reverse()
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }

    public static int[] abs(String string) {
        return new StringBuilder().append(string).reverse().chars().map(Character::getNumericValue).toArray();
    }
    static int[] digitizeBest(long n) {
        return new StringBuilder(String.valueOf(n))
                .reverse()
                .chars()
                .map(Character::getNumericValue)
                .toArray();
    }

    // В вашем классе был тест, и вы его сдали. Поздравляем!
    // Но вы амбициозный человек. Вы хотите знать, лучше ли вы, чем средний ученик в вашем классе.
    // Вы получаете массив с результатами тестов ваших сверстников.
    // Теперь подсчитайте среднее значение и сравните свой результат!
    // Возвращайся, Trueесли тебе станет лучше, иначе False!
    public static boolean betterThanAverage(int[] classPoints, int yourPoints) {
//        int averagePoint = 0;
//        for (int i = 0; i < classPoints.length; i++) {
//            averagePoint += classPoints[i]/classPoints.length;
//            if (yourPoints > averagePoint) {
//                return true;
//            }
//        }
//        return false;
        return stream(classPoints).average().getAsDouble() <= yourPoints;
    }

    // Дан массив целых чисел.
    // Возвращает массив, где первый элемент — это количество положительных чисел,
    // а второй элемент — сумма отрицательных чисел. 0 не является ни положительным, ни отрицательным.
    // Если входные данные представляют собой пустой массив или имеют значение NULL, верните пустой массив.
    public static int[] countPositivesSumNegatives(int[] input) {
        if (input == null || input.length == 0) {
            return new int[]{};
        }
        int countPositives = 0;
        int sumNegatives = 0;
        for (int i = 0; i < input.length; i++) {

            if (input[i] > 0) {
                countPositives++;
            }
            if (input[i] < 0) {
                sumNegatives += input[i];
            }
        }
        return new int[]{countPositives,sumNegatives};
    }
    public static int[] countPositivesSumNegativesBest(int[] input) {
        return input == null || input.length == 0 ?
                new int[0] :
                new int[] { (int)IntStream.of(input).filter(i->i>0).count(), IntStream.of(input).filter(i->i<0).sum() };
    }

    // Вам будет предоставлен массив a и значение x. Все, что вам нужно сделать, это проверить,
    // содержит ли предоставленный массив значение.
    // Массив может содержать числа или строки. Х может быть любым.
    // Возврат, true если массив содержит значение, false если нет.
    public static boolean check(Object[] a, Object x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i].equals(x)) {
                return true;
            }
        }
        return false;
    }
    public static boolean checkBest(Object[] a, Object x) {
        return Arrays.asList(a).contains(x);
    }
    public static boolean checkBest1(Object[] a, Object x) {
        for (Object o : a) {
            if (Objects.equals(o, x)) {
                return true;
            }
        }
        return false;
    }

    // Вы живете в городе Картезия, где все дороги расположены идеальной сеткой.
    // Вы пришли на встречу на десять минут раньше и решили воспользоваться возможностью прогуляться.
    // Город предоставляет своим гражданам приложение для создания ходьбы на их телефонах — каждый раз,
    // когда вы нажимаете кнопку, оно отправляет вам массив однобуквенных строк,
    // представляющих направления для ходьбы (например, ['n', 's', 'w', 'е']).
    // Вы всегда проходите только один квартал для каждой буквы (направления), и вы знаете,
    // что прохождение одного городского квартала занимает у вас одну минуту, поэтому создайте функцию,
    // которая будет возвращать true , если прогулка, которую предлагает вам приложение, займет у вас ровно десять минут
    // (вы не хочу ни рано, ни поздно!) и, конечно же, вернет вас в исходную точку.
    // В противном случае верните false .
    public static boolean isValid(char[] walk) {
        StringBuilder north = new StringBuilder();
        StringBuilder south = new StringBuilder();
        StringBuilder west = new StringBuilder();
        StringBuilder east = new StringBuilder();
        for (int i = 0; i < walk.length; i++) {
            if (walk[i] == 'n') {
                north.append(walk[i]);
            }
            if (walk[i] == 's') {
                south.append(walk[i]);
            }
            if (walk[i] == 'w') {
                west.append(walk[i]);
            }
            if (walk[i] == 'e') {
                east.append(walk[i]);
            }
        }
        if (north.length() == south.length() && west.length() == east.length() && walk.length ==10) {
            return true;
        }
        return false;
    }
    public static boolean isValidBest(char[] walk) {
        if (walk.length != 10) {
            return false;
        }
        int x = 0, y = 0;
        for (int i = 0; i < 10; i++) {
            switch (walk[i]) {
                case 'n':
                    y++;
                    break;
                case 'e':
                    x++;
                    break;
                case 's':
                    y--;
                    break;
                case 'w':
                    x--;
                    break;
            }
        }
        return x == 0 && y == 0;
    }
    public static boolean isValidClever(char[] walk) {
        if (walk.length != 10) return false;

        int x = 0, y = 0;
        for (char c: walk) {
            switch (c) {
                case 'n': y++; break;
                case 's': y--; break;
                case 'w': x++; break;
                case 'e': x--; break;
            }
        }

        return x == 0 && y == 0;
    }

    // Создайте функцию, которая возвращает массив целых чисел от n до 1, где n>0.
    // Пример: n=5-->[5,4,3,2,1]
    public static int[] reverse(int n){
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = n - i;
        }
        return result;
    }
    public static int[] reverseBest(int n){
        return IntStream.range(-n, 0).map(Math::abs).toArray();
    }
    public static int[] reverseClever(int n){
        return iterate(n, i -> i - 1).limit(n).toArray();
    }

    // В массиве целых чисел найдите то, которое встречается нечетное количество раз.
    //Всегда будет только одно целое число, которое появляется нечетное количество раз.
    public static int findIt(int[] a) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int num : a) {
            result.put(num, result.getOrDefault(num, 0) + 1);
        }
            for (Map.Entry<Integer, Integer> entry : result.entrySet()) {
                if (entry.getValue() % 2 != 0) {
                    return entry.getKey();
                }
            }
        throw new IllegalArgumentException("В массиве нет числа с нечетным количеством вхождений.");
    }
    public static int findItBest(int[] arr) {
        return stream(arr).reduce(0, (x, y) -> x ^ y);
    }

    // Возьмите массив и удалите из него каждый второй элемент. Всегда сохраняйте первый элемент и начинайте
    // удаление со следующего элемента.
    public static Object[] removeEveryOther(Object[] arr) {
        List<Object> result = new ArrayList<>();
        for (int i = 0; i< arr.length; i += 2) {
            result.add(arr[i]);
        }
        return result.toArray();
    }
    public static Object[] removeEveryOtherBest(Object[] arr) {
        return IntStream.range(0, arr.length).filter(n -> n % 2 == 0).mapToObj(i->arr[i]).toArray();
    }
    static Object[] removeEveryOtherBest1(Object[] arr) {
        return iterate(0, i -> i < arr.length, i -> i + 2).mapToObj(i -> arr[i]).toArray();
    }

    // Учитывая массив целых чисел, верните новый массив, в котором каждое значение удвоено.
    public static int[] map(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[i] * 2;
        }
        return result;
    }
    public static int[] mapBest1(int[] arr) {
        return Arrays.stream(arr).map(x -> x*2).toArray();
    }
    public static int[] mapClever(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
        return arr;
    }

    // При наличии массива (arr) в качестве аргумента завершите функцию countSmileys, которая должна возвращать
    // общее количество улыбающихся лиц.
    // Правила улыбающегося лица:
    // Каждый смайлик должен содержать действительную пару глаз. Глаза могут быть отмечены как : или .;
    // У смайлика может быть нос, но это не обязательно. Допустимые символы для носа: - или .~
    // У каждого улыбающегося лица должен быть улыбающийся рот, который должен быть помечен либо ), либо .D
    // Никакие дополнительные символы, кроме упомянутых, не допускаются.
    // Примеры допустимых смайлов: :) :D ;-D :~)
    // Недопустимые смайлы: ;( :> :} :]
    public static int countSmileys(List<String> arr) {
        // Just Smile :)
        List<String> validSmileys = Arrays.asList(":)", ";)", ":D", ";D", ":-)", ";-)", ":~)", ";~)", ":~D", ";~D");
        int count = 0;
        for (String smile : arr) {
            if (validSmileys.contains(smile)) {
                count++;
            }
        }
        return count;
    }
    public static int countSmileysBest(List<String> arr) {
        return (int)arr.stream().filter( x -> x.matches("[:;][-~]?[)D]")).count();
    }

    // Вам будет предоставлен массив целых чисел. Ваша задача — взять этот массив и найти индекс N,
    // в котором сумма целых чисел слева от N равна сумме целых чисел справа от N.
    // Если индекса, который мог бы сделать это, не существует, верните < /span>-1.
    public static int findEvenIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (sumLeft(arr, i) == sumRight(arr, i)) {
                return i;
            }
        }
        return -1;
    }

    private static int sumLeft(int[] arr, int index) {
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private static int sumRight(int[] arr, int index) {
        int sum = 0;
        for (int i = index + 1; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int findEvenIndexBest(int[] arr) {
        int left = 0;
        int right = Arrays.stream(arr).sum();
        for (int i=0; i<arr.length; i++){
            right -= arr[i];
            if (left == right) return i;
            left += arr[i];
        }
        return -1;
    }

}

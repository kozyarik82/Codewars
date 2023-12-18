import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.awt.Color.green;
import static java.awt.Color.yellow;
import static java.lang.Math.sqrt;

public class NumberCode {
    //  по заданному целому числу или числу с плавающей запятой найдите его противоположность.
    public static int opposite(int number)
    {
        number = number*-1;
        return number;
    }
    public static int oppositeBest(int number)
    {
        return -number;
    }

    // Вы были в походе с друзьями далеко от дома, но когда приходит время возвращаться, вы понимаете, что у вас заканчивается топливо, а ближайшая заправка находится в нескольких 50милях отсюда! Вы знаете, что в среднем пробег вашей машины составляет около 25миль на галлон. Остались 2галлоны.
    //Учитывая эти факторы, напишите функцию, которая сообщит вам, можно ли добраться до насоса или нет.
    //Функция должна вернуться, trueесли это возможно, а falseесли нет.

    public static boolean zeroFuel(double distanceToPump, double mpg, double fuelLeft) {
        // Your code here!
        double result = mpg * fuelLeft - distanceToPump;
        if(result>=0){
            return true;
        }
        return false;
    }
    static boolean zeroFuelBest(double distanceToPump, double mpg, double fuelLeft) {
        return distanceToPump <= mpg * fuelLeft;
    }

    // Первое столетие охватывает от 1 года до 100 года включительно ,
    // второе столетие — от 101 года до 200 года включительно и т. д.
    // Учитывая год, верните столетие, в котором он находится.

    public static int century(int number) {
        // your code goes here
        if(number % 100 !=0){
            number = number /100 + 1;
        }else {
            number/=100;
        }
        return number;
    }
    public static int centuryClever(int number) {
        return (number + 99) / 100;
    }

    //Напишите программу, которая находит сумму всех чисел от 1 до num.
    // Число всегда будет положительным целым числом, большим 0.
    public static int summation(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
            System.out.println(list);}
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        return sum;
    }

    public static int summationClever(int n) {

        return  n*(n+1)/2;
    }

    public static int summationBest(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    //Ваша задача — создать функцию, выполняющую четыре основные математические операции.
    //Функция должна принимать три аргумента — операция(строка/символ), значение1(число), значение2(число).
    //Функция должна возвращать результат чисел после применения выбранной операции.
    public static Integer basicMath(String op, int v1, int v2) {
        Integer total = 0;
        switch (op) {
            case "+":
                total = v1 + v2;
                break;
            case "-":
                total = v1 - v2;
                break;
            case "*":
                total = v1 * v2;
                break;
            case "/":
                total = v1 / v2;
                break;
        }
        return total;
    }
    public static Integer basicMathBest(String op, int v1, int v2) {
        switch (op) {
            case "-":
                return v1 - v2;
            case "+":
                return v1 + v2;
            case "*":
                return v1 * v2;
            case "/": {
                if (v2 == 0)
                    throw new IllegalArgumentException("Division by zero");
                return v1 / v2;
            }
            default:
                throw new IllegalArgumentException("Unknown operation: " + op);
        }
    }

    //Создайте функцию, которая принимает целое число в качестве аргумента
    // и возвращает результат "Even"для четных или "Odd"нечетных чисел.
    public static String evenOrOdd(int number) {
        if(number % 2 == 0) {
            return "Even";
        } else
            return "Odd"; // Place code here;
    }
    public static String evenOrOddBeast(int number) {
        return (number % 2) != 0 ? "Odd" : "Even";
    }

    //Реализуйте функцию, которая принимает 3 целочисленных значения a, b, c. Функция должна возвращать true,
    // если треугольник можно построить со сторонами заданной длины, и false в любом другом случае.
    //(В этом случае все треугольники должны иметь поверхность больше 0, чтобы их можно было принять).
    public static boolean isTriangle(int a, int b, int c){
        if ((a + b) > c && (b + c) > a && (c + a) > b) {
            return true;
        }else if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        } else {
            return false;
        }
    }
    public static boolean isTriangleBest(int a, int b, int c){
        return ((a < b + c) && (b < a + c) && (c < a + b));
    }
    public static boolean isTriangleClever(int a, int b, int c){
        return ((a + b) > c && (a + c) > b && (b + c) > a) ? true : false;
    }


    // Напишите функцию bmi, вычисляющую индекс массы тела (bmi = вес/рост 2 ).
    //если ИМТ <= 18,5, верните «Недостаточный вес»
    //если ИМТ <= 25,0, верните «Нормальный»
    //если ИМТ <= 30,0, верните «Избыточный вес»
    //если ИМТ > 30, вернуть «Ожирение»

    public static String bmi(double weight, double height) {
        double bmi = weight/(height*height);
        if (bmi <= 18.5) {
            return "Underweight";
        }
        if (bmi <= 25.0 && bmi > 18.0) {
            return "Normal";
        }
        if (bmi <= 30.0 && bmi > 25.0) {
            return "Overweight";
        }
        if (bmi > 30.0) {
            return "Obese";
        }
        return "Try again!";
    }
    public static String bmiBest(double weight, double height) {
        double bmi = weight / (height * height);
        if ( bmi <= 18.5) return "Underweight";
        if ( bmi <= 25) return "Normal";
        if ( bmi <= 30) return "Overweight";
        return "Obese";
    }
    public static String bmiClever(double weight, double height) {
        double bmi =weight/(height*height);
        return bmi <= 18.5 ? "Underweight": bmi <=25.0 ? "Normal" : bmi<=30.0 ? "Overweight" : "Obese";
    }

    // Суть этой ката заключается в умножении заданного числа на восемь,
    // если оно четное, и на девять в противном случае.

    public static int simpleMultiplication(int n) {
        if (n % 2 == 0) {
            return n * 8;
        }else {
            return n * 9;
        }
    }
    public static int simpleMultiplicationBest(int n) {
        return n % 2 == 0 ? n * 8 : n * 9;
    }
    public static int simpleMultiplicationClever(int n) {
        return n * (n % 2 + 8);
    }

    // В небольшом городе численность населения p0 = 1000на начало года.
    // Население регулярно увеличивается на 2 percentгод, причем 50каждый год в город приезжают новые жители.
    // Сколько лет нужно городу, чтобы его население превысило или сравнялось с p = 1200жителями?

    public static int nbYear(int p0, double percent, int aug, int p) {
        int years = 0;
        while (p0 < p) {
            p0 += (int) (p0 * (percent / 100)) + aug;
            years++;
        }
        return years;
    }

    // Учитывая два целых числа aи b, которые могут быть положительными или отрицательными,
    // найдите сумму всех целых чисел между ними и включая их и верните ее.
    // Если два числа равны, верните aили b.
    // Примечание: a и bне з аказываются!

    public static int getSum(int a, int b) {
        if (a != b) {
            return a + b;
        } else {
            return a;
        }
    }
    public int getSumBest(int a, int b) {
        int res = 0;
        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
            res += i;
        }
        return a == b ? a : res;
    }

    // Ваши одноклассники попросили вас скопировать для них кое-какие документы.
    // Вы знаете, что одноклассников n, а в документах m страниц.
    // Ваша задача — посчитать, сколько пустых страниц вам нужно. Если n < 0или m < 0вернуть 0.

    public static int paperWork(int n, int m) {
        if (n < 0 || m < 0) {
            return 0;
        } else {
            return n * m;
        }
    }
    public static int paperWorkSecond(int n, int m) {
        return n < 0 || m < 0 ? 0 : n * m;
    }
    public static int paperWork3(int n, int m) {
        return (n | m) < 0 ? 0 : n * m;
    }

    // Герой направляется в замок, чтобы выполнить свою миссию. Однако ему сказали,
    // что замок окружен парой могущественных драконов! каждому дракону для победы требуется 2 пули,
    // наш герой понятия не имеет, сколько пуль он должен нести. Если предположить,
    // что он возьмет определенное количество пуль и двинется вперед, чтобы сразиться с другим
    // определенным заданным количеством драконов, выживет ли он?
    // Возвращайте true, если да, и false в противном случае :)

    public static boolean hero(int bullets, int dragons) {
        return bullets >= (long)dragons * 2;
    }

    // Ваша задача — создать функцию, которая может принимать в качестве аргумента любое неотрицательное целое число
    // и возвращать его с цифрами в порядке убывания. По сути, переставьте цифры,
    // чтобы получить максимально возможное число.

    public static int sortDesc(final int num) {
        String numberStr = Integer.toString(num);
        char[] digits = numberStr.toCharArray();
        Arrays.sort(digits);
        reverseArray(digits);
        String sortedNumberStr = new String(digits);
        int sortedNumber = Integer.parseInt(sortedNumberStr);

        return sortedNumber;
    }

    private static void reverseArray(char[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }
    }
    public static int sortDescBest(final int num) {
        String[] array = String.valueOf(num).split("");
        Arrays.sort(array, Collections.reverseOrder());
        return Integer.valueOf(String.join("", array));
    }
    public static int sortDescClever(final int num) {
        return Integer.parseInt(String.valueOf(num)
                .chars()
                .mapToObj(i -> String.valueOf(Character.getNumericValue(i)))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining()));
    }

    // Учитывая целое число, определите, является ли оно квадратным :
    // В математике квадратное число или идеальный квадрат — это целое число, которое является квадратом целого числа;
    // другими словами, это произведение некоторого целого числа само на себя.
    // В тестах всегда будет использоваться некоторое целое число,
    // поэтому не беспокойтесь об этом в языках с динамической типизацией.
    public static boolean isSquare(int n) {
        for (int i = 0; i <= n / 2; i++) {
            if (n < 0) {
                return false;
            }
            if (i * i == n) {
                return true;
            }
            if (i * i > n) {
                break;
            }
        }
        return false;
    }
    public static boolean isSquareClever(int n) {
        return sqrt(n) % 1 == 0;
    }

    // Возможно, вы знаете несколько довольно больших идеальных квадратов. А как насчет СЛЕДУЮЩЕГО?
    // Завершите findNextSquareметод, который находит следующий целочисленный идеальный квадрат после переданного
    // в качестве параметра. Напомним, что целочисленный совершенный квадрат — это целое число n такое,
    // что sqrt(n) также является целым числом.
    // Если параметр сам по себе не является идеальным квадратом, его -1следует вернуть.
    // Вы можете предположить, что параметр неотрицательный.
    public static long findNextSquare(long sq) {
        if (sqrt(sq) % 1 != 0) {
            return -1;
        }
        long result = 0;
        for (long i = sq +1; i > sq; i++) {
            if (sqrt(i) % 1 == 0) {
                result = i;
                break;
            }
        }
        return result;
    }
    public static long findNextSquareBest(long sq) {
        return Math.sqrt(sq) % 1 != 0 ? -1 : (long)Math.pow(Math.sqrt(sq)+1,2);
    }
    public static long findNextSquareClever(long sq) {
        long root = (long) Math.sqrt(sq);
        return root * root == sq ? (root + 1) * (root + 1) : -1;
    }

    // Натан любит кататься на велосипеде.
    // Поскольку Натан знает, как важно избегать обезвоживания, он выпивает 0,5 литра воды за час езды на велосипеде.
    // Вам дано время в часах, и вам нужно вернуть количество литров, которое выпьет Натан, округленное до наименьшего значения.
    public static int liters(double time)  {
        return (int) (time * 0.5) - (int) (time * 0.5 % 1);
    }
    public int litersBest(double time)  {
        return (int)(time / 2);
    }

    // Вы пишете код для управления светофорами вашего города. Вам нужна функция для обработки каждого изменения
    // от green, до yellow, до red и затем green снова.
    // Завершите функцию, которая принимает строку в качестве аргумента, представляющую текущее состояние
    // источника света, и возвращает строку, представляющую состояние, в которое должен перейти источник света.
    // Например, если на входе green, на выходе должно быть yellow.
    public static String updateLight(String current) {
        switch (current) {
            case "green":
                return "yellow";
            case "yellow":
                return "red";
            case "red":
                return "green";
        }
        return "not relevant";
    }

    public static String updateLightBest(String current) {
        return (current.equals("red") ? "green" : current.equals("yellow") ? "red" : "yellow");
    }

    // Тимми и amp; Сара думает, что они влюблены, но где они живут, они узнают об этом только тогда,
    // когда сорвут каждый по цветку. Если у одного цветка четное количество лепестков, а у другого нечетное,
    // это означает, что они влюблены.
    // Напишите функцию, которая будет принимать количество лепестков каждого цветка и возвращать true,
    // если они влюблены, и false, если нет.
    public static boolean isLove(final int flower1, final int flower2) {
        return (flower1 + flower2) % 2 != 0;
    }
    public static boolean isLoveClever(final int flower1, final int flower2) {
        return flower1 % 2 != flower2 % 2;
    }
    // Создайте функцию, которая выдает персонализированное приветствие. Эта функция принимает два параметра:
    // name и owner.
    // Используйте условные выражения, чтобы вернуть правильное сообщение:
    // случай	возвращаться
    // имя равно владельцу	«Привет, босс!»
    // в противном случае	«Здравствуйте, гость!»
    public static String greet(String name, String owner) {
        return name.equals(owner) ? "Hello boss" : "Hello guest";
    }

    // Учитывая список целых чисел, определите, является ли сумма его элементов нечетной или четной.
    // Дайте ответ в виде строки, соответствующей "odd" или "even".
    // Если входной массив пуст, рассматривайте его как: [0] (массив с нулем).
    public static String oddOrEven (int[] array) {
        return Arrays.stream(array).sum() % 2 == 0 ? "even" : "odd";
    }

    // Алекс только что купил новый обруч, он ему нравится, но он расстроен, потому что его младший брат лучше его.
    // Напишите программу, в которой Алекс может ввести (n), сколько раз обруч пройдет круг, и она вернет ему обнадеживающее сообщение :)
    // Если Алекс наберет 10 или более обручей, верните строку «Отлично, теперь переходим к трюкам».
    // Если он не наберет 10 обручей, верните строку «Продолжайте, пока не получите».
    public static String hoopCount(int n){
        return n>=10 ? "Great, now move on to tricks" : "Keep at it until you get it" ;
    }

    // Таракан – одно из самых быстрых насекомых. Напишите функцию, которая принимает скорость в км в час
    // и возвращает ее в см в секунду, округляя до целого числа (= пол).
    public static int cockroachSpeed(double x){
        return  (int)((x * 100000) / 3600);
    }
}

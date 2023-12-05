import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCode {
    //Учитывая массив целых чисел в виде строк и чисел, верните сумму значений массива,
    // как если бы все они были числами.
    //Верните свой ответ в виде числа.

    /*
     * Assume input will be only of Integer o String type
     */
    public int sum(List<?> mixed) {
        int sum = 0;
        for (Object element : mixed) {
            if (element instanceof String) {
                sum += Integer.parseInt((String) element);
            } else if (element instanceof NumberCode) {
                sum += ((Number) element).intValue();
            }
        }
        return sum;
    }
    public int sumClever(List<?> mixed) {
        return mixed.stream().mapToInt(o -> Integer.parseInt(o.toString())).sum();
    }

    // Ваша задача — создать две функции ( maxи min, или maximumи и minimumт. д., в зависимости от языка),
    // которые получают на вход список целых чисел и возвращают наибольшее и наименьшее число
    // в этом списке соответственно.

    public static int min(int[] list) {
        return Arrays.stream(list).min().getAsInt();
    }

    public static int max(int[] list) {
        return Arrays.stream(list).max().getAsInt();
    }
    public int min1(int[] list) {
        Arrays.sort(list);
        return list[0];
    }

    public int max1(int[] list) {
        Arrays.sort(list);
        return list[list.length-1];
    }
}

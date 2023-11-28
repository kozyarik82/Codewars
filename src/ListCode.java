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
}

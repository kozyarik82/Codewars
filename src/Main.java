import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println(StringCode.fakeBin("125761"));
        System.out.println(StringCode.isIsogram("moOse"));
        System.out.println(StringCode.getCount("pear tree"));
        System.out.println(Array.rowSumOddNumbers(3));
        System.out.println(Array.rowSumOddNumbersBest(3));
        System.out.println(Array.rowSumOddNumbersClever(2));
        System.out.println(NumberCode.isTriangle(-2, 2, 2));
        System.out.println(StringCode.disemvowel("What are you, a communist?"));
        double[] number = new double[]{1, 5.2, 4, 0, -1};
        System.out.println(Array.sum(number));
        Object[] haystack = new Object[]{"283497238987234", "a dog", "a cat", "some random junk", "a piece of hay", "needle", "something somebody lost a while ago"};
        System.out.println(Array.findNeedle(haystack));
        System.out.println(StringCode.smash( "Bilal", "Djaghout" ));
        System.out.println(NumberCode.bmi(80, 1.80));
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[] {10,0});
        list.add(new int[] {3,5});
        list.add(new int[] {2,5});
        System.out.println(Array.countPassengers(list));
        int[] input = new int[] {-1,-2,-3,-4,-5};
        System.out.println(Array.invertBest(input));
        System.out.println(NumberCode.nbYear(1500, 5, 100, 5000));
    }
}
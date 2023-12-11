import java.util.ArrayList;
import java.util.Arrays;

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
        String s = "aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz";
        System.out.println(StringCode.printerError(s));
        System.out.println(StringCode.abbrevName("Evan Cole"));
        System.out.println(Array.grow(new int[]{2, 2, 2, 2, 2, 2}));
        System.out.println(NumberCode.getSum(-20, -301));
        System.out.println(NumberCode.paperWorkSecond(5,5));
        System.out.println(NumberCode.hero(1947123137, 1762811205));
        System.out.println(StringCode.countingSheep(5));
        System.out.println(NumberCode.sortDesc(254637));
        System.out.println(StringCode.duplicateCountClever("abcdeabc"));
        System.out.println(NumberCode.isSquare(188664625));
        System.out.println(StringCode.validatePin1("1232"));
        System.out.println(ListCode.min(new int[]{-52, 56, 30, 29, -54, 0, -110}));
        System.out.println(ListCode.max(new int[]{4, 6, 2, 1, 9, 63, -134, 566}));
        System.out.println(Array.findUniq(new double[]{0, 1, 0,0,0}));
        System.out.println(Arrays.toString(Array.digitize(35231)));
        System.out.println(Arrays.toString(Array.abs("425846")));
        System.out.println(Array.betterThanAverage(new int[] {100, 90}, 11));
        System.out.println(Arrays.toString(Array.countPositivesSumNegatives(new int[] {0, 2, 3, 0, 5, 6, 7, 8, 9, 10, -11, -12, -13, -14})));
        System.out.println(Array.check(new Object[] {"what", "a", "great", "kata"}, "kat"));
        System.out.println(StringCode.whoLikesIt("Max", "John", "Mark"));
        System.out.println(Array.isValid(new char[] {'n','s','n','s','n','s','n','s','n','s'}));
    }
}
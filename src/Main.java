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
    }
}
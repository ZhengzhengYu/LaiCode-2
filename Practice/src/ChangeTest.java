public class ChangeTest {
    public static void main(String[] args) {
        Simple originalSimple = new Simple(5);
        changeSimpleValue1(originalSimple);
        System.out.println(originalSimple.value);

        Simple originalSimple2 = new Simple(5);
        changeSimpleValue2(originalSimple2);
        System.out.println(originalSimple2.value);

        Simple originalSimple3 = new Simple(5);
        originalSimple3 = changeSimpleValue3(originalSimple3);
        System.out.println(originalSimple3.value);

        int x = 5;
        changeValue(5);
        System.out.println(x);


    }
    private static void changeSimpleValue1(Simple simple) {
        Simple newSimple = new Simple(10);
        simple = newSimple;
    }

    private static void changeSimpleValue2(Simple simple) {
        simple.value = 10;
    }

    private static Simple changeSimpleValue3(Simple simple) {
        Simple newSimple = new Simple(10);
        return newSimple;
    }

    private static void changeValue(int x) {
        x = 10;
    }
}

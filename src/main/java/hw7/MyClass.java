package hw7;

public class MyClass {
    @BeforeSuite
    public static void pbo() {
        System.out.println("Method PBO");
    }

    @Test
    public static void m1() {
        System.out.println("Метод m1, приоритет 1");
    }

    @Test(priority = 2)
    public static void m2() {
        System.out.println("Метод m2, приоритет 2");
    }

    @Test(priority = 1)
    public static void m3() {
        System.out.println("Метод m3, приоритет 1");
    }

    @Test(priority = 3)
    public static void m4() {
        System.out.println("Метод m4, приоритет 3");
    }

    @Test(priority = 4)
    public static void m5() {
        System.out.println("Метод m5, приоритет 4");
    }

    @Test(priority = 6)
    public static void m6() {
        System.out.println("Метод m6, приоритет 6");
    }

    @AfterSuite
    public static void pai() {
        System.out.println("Method PAI");
    }
}

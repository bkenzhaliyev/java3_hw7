package hw7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyTest {
    private static List<MyMethods> mList = new ArrayList<>(Arrays.asList());

    public static void main(String[] args) {
        start(MyClass.class);
    }


    public static void start(Class c) {
        System.out.println(c.getName());
        Method[] methods = c.getDeclaredMethods();
        int pbo = 0;
        int pai = 0;

        for (Method m : methods) {
//            System.out.printf("Метод %s \n", m);

            if (m.isAnnotationPresent(BeforeSuite.class)) {
                BeforeSuite Ano = m.getAnnotation(BeforeSuite.class);
                MyMethods myMethods = new MyMethods(m.getName(), 0);
                mList.add(myMethods);
                if (pbo == 1) {
                    throw new RuntimeException("аннотация BeforeSuite встречается больше 1 раза");
                }
                pbo++;
            }


            if (m.isAnnotationPresent(AfterSuite.class)) {
                AfterSuite Ano = m.getAnnotation(AfterSuite.class);
                MyMethods myMethods = new MyMethods(m.getName(), 99);
                mList.add(myMethods);
                if (pai == 1) {
                    throw new RuntimeException("аннотация AfterSuite встречается больше 1 раза");
                }
                pai++;
            }


            if (m.isAnnotationPresent(Test.class)) {
                Test Ano = m.getAnnotation(Test.class);
                MyMethods myMethods = new MyMethods(m.getName(), Ano.priority());
                mList.add(myMethods);
            }
        }

        Collections.sort(mList);
        System.out.println("Печать всех методов с приоритетами");
        for (MyMethods m : mList) {
            System.out.println("Method " + m.getName() + " Priority " + m.getPriority());
        }

        System.out.println("Выполнение всех методов согласно приоритетам");
        for (MyMethods m : mList) {
            try {
                Method method = c.getDeclaredMethod(m.getName());
                method.setAccessible(true);
                method.invoke(c.getClass());
            } catch (NoSuchMethodException e) {

            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }

}

package ru.otus.sizeof;


import org.openjdk.jol.info.GraphLayout;

/**
 *
 */
public class ObjectsMeasurementStand {
    private static final int SIZE = 10000000;
    private Runtime runtime = Runtime.getRuntime();

    /**
     * Для расчета использовалась утилита JOL (Java Object Layout)
     * http://openjdk.java.net/projects/code-tools/jol/
     * Печатает размер любого объекта
     * Подсчет осуществляется через построение графа до Object
     */
    public void sizeOf(Object object) {
        System.out.println("Type of given object: " + object.getClass().getSimpleName() + "\n" +
                "Size of given object: " + GraphLayout.parseInstance(object).totalSize() + " bytes.\n");
    }

    /**
     * Мой вариант
     * Мне не совсем понятны результаты, видимо я что то не то делаю, но
     * все тесты что я находил показывают что то странное
     */
    public void sizeOf() throws InterruptedException {

        runtime.gc();
        long freeMem = memory();
        long result = 0;

        for (int i = 0; i < 20; i++) {

            String[] array = new String[SIZE];

            for (int j = 0; j < SIZE; j++) {
                array[j] = new String();
            }

            result += (freeMem - memory()) / SIZE;

            Thread.sleep(10);
            array = null;
            Thread.sleep(10);
            runtime.gc();
        }

        //средний размер пустой строки 34 байта ¯\_(ツ)_/¯
        System.out.println(result / 20 + "bytes");
    }

    private long memory() {
        return runtime.freeMemory();
    }
}
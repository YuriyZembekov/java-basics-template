package com.epam.izh.rd.online.service;

public class SimpleMathService implements MathService {

    /**
     * Метод возвращает 0, если value1 = value2.
     * Метод возвращает -1, если value1 < value2.
     * Метод возвращает 1, если value1 > value2.
     * <p>
     * Например для (-1, -1) метод должен вернуть 0;
     * Например для (-3, -1) метод должен вернуть -1;
     * Например для (3, 1) метод должен вернуть 1;
     */
    @Override
    public int compare(int value1, int value2) {
        if (value1 > value2) {
            return 1;
        }
        return (value1 < value2) ? -1 : 0;
    }

    /**
     * Метод возвращает максимальное число из пары.
     * Например для списка (-1, 2) метод должен вернуть 2
     */
    @Override
    public int maxFrom(int value1, int value2) {
        return (value1 > value2) ? value1 : value2;
    }

    /**
     * Метод возвращает максимальное число из переданного массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 22
     */
    @Override
    public int maxFrom(int[] values) {
        int max = values[0];
        for (int n : values) {
            if (n > max) {
                max = n;
            }
        }
        return max;
    }

    /**
     * Метод возвращает сумму чисел массива.
     * Например для списка {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть 30
     */
    @Override
    public int sum(int[] values) {
        int sum = 0;
        for (int n : values) {
            sum += n;
        }
        return sum;
    }

    /**
     * Метод фильтрует массив, оставляя только четные числа.
     * Например для списка {-1, -3, 4, 8, 5, 22, 17} метод должен вернуть {4, 8, 22}
     */
    @Override
    public int[] getEvenDigits(int[] values) {
        int countEven = 0;
        // считаем количество чётных элементов
        for (int n : values) {
            if (n % 2 == 0) {
                countEven++;
            }
        }
        //создаём массив с длиной по количеству чётных элементов
        int[] evenDigits = new int[countEven];
        int iteration = 0;
        for (int n : values) {
            if (n % 2 == 0) {
                evenDigits[iteration] = n;
                iteration++;
            }
        }
        return evenDigits;
    }

    /**
     * Метод считает факториал из заданного числа.
     * Например для числа 5 метод должен вернуть 120.
     * Факториал 0 должен быть равен 1.
     */
    @Override
    public long calcFactorial(int initialVal) {
        long result = 1;
        for (int i = 2; i <= initialVal; i++) {
            result *= i;
        }
        return result;
    }

    /**
     * Метод возвращает число, которе находится на заданной позиции (счет начинается с нуля) в ряду фибоначчи.
     * <p>
     * Ряд фибоначчи - ряд, следующие элементы которого состоят из суммы двух предыдущих.
     * Ряд начинается 0 и 1.
     * Пример 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ...
     * <p>
     * Для числа 9 метод должен вернуть 34
     * Для числа 0 метод должен вернуть 0
     */
    @Override
    public long calcFibonacci(int number) {
        long[] fibonacci = new long[number + 1];
        fibonacci[0] = 0;
        if (number > 0) {
            fibonacci[1] = 1;
        }
        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci[number];
    }

    /**
     * Метод возвращает отсортированный по возрастанию массив.
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод должен вернуть {-5, -3, -1, 4, 5, 8, 22}
     */
    @Override
    public int[] sort(int[] values) {
        int minIndex = 0;
        int buffer = 0;
        // Реализую сортировку перестановкой
        // Данную задачу можно реализовать с помощью Arrays.sort();
        // но практики составления алгоритмов мне это не даст
        for (int i = 0; i < values.length; i++) {
            minIndex = i;
            //проходим по массиву ищем индекс массива с минимумом
            for (int j = i; j < values.length; j++) {
                if (values[j] < values[minIndex]) {
                    minIndex = j;
                }
            }
            // меняем минимальный элемент с элементом, с которого
            // начался проход(внешний цикл for)
            buffer = values[i];
            values[i] = values[minIndex];
            values[minIndex] = buffer;
        }
        return values;
    }

    /**
     * Метод определяет, является ли заданное число простым.
     * Простое число - число, которое делится только на 1 и на само себя.
     * <p>
     * Например для числа 22 вернется false, а для числа 23 true.
     */
    @Override
    public boolean isPrimary(int number) {
        for (int i = 2; (number / i) >= i; i++) {
            // Проверяем делится ли число без остатка в промежутке
            // от 2 до (number/i); конечное значение (number/i)
            // узнал ранее в книге Шилдта "Руководство для начинающих"
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Метод возвращает массив, в котором элементы расположены в обратном порядке.
     * <p>
     * Например для массива {-1, -3, 4, 8, 5, 22, -5} метод вернет {-5, 22, 5, 8, 4, -3, -1}
     */
    @Override
    public int[] reverseArray(int[] values) {
        int buffer = 0;
        // Данный цикл меняет первый и последний элемент массива
        // На следующих итерациях происходит сдвиг: второй элемент
        // и предпоследний, и так далее. Количество итераций зависит
        // от длины массива делённой на два. При этом остаток
        // не учитывается, т.к. в массиве с нечетным количеством
        // элементов средний элемент остаётся на месте.
        for (int i = 0; i < (values.length / 2); i++) {
            buffer = values[i];
            values[i] = values[values.length - 1 - i];
            values[values.length - 1 - i] = buffer;
        }
        return values;
    }
}

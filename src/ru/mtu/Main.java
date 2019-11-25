package ru.mtu;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    /**
     * Задача 7. В целочисленной матрице А размером NyM заменить
     * элементы главной диагонали и расположенные ниже нее на значение
     * 3 (числа N и М задаются с клавиатуры в диапазоне от 3 до 10).
     * Первоначальное заполнение массива А. осуществить при помощи датчика
     * случайных чисел в диапазоне от -5 до 15.
     * Исходную и видоизмененную матрицы вывести на экран.
     */
    public static void main(String[] args) {
        initRandomMatrix(10, 5, 3);
    }

    public static void initRandomMatrix(int n, int m, int numberFoReplacement) {
        int[][] resultMatrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                resultMatrix[i][j] = ThreadLocalRandom.current().nextInt(-5, 16);
            }
        }
        System.out.println("Исходная матрица: ");
        printMatrix(resultMatrix);

        int mainDCounter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j <= mainDCounter) {
                    resultMatrix[i][j] = numberFoReplacement;
                    if (j == mainDCounter) {
                        mainDCounter++;
                        break;
                    }
                }
            }
        }

        System.out.println("Матрица после преобразований: ");
        printMatrix(resultMatrix);

    }

    public static void printMatrix(int mat[][]) {
        for (int[] row : mat) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println("\n");
    }
}

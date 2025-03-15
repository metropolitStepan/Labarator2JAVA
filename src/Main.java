import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Работа с одномерным массивом");
            System.out.println("2. Работа с двумерным массивом");
            System.out.println("3. Завершить программу");
            System.out.println("Выберите нужный вам вариант: ");

            String input = sc.next();
            switch (input) {
                case "1":
                    oneDimensionalArray();
                    break;
                case "2":
                    twoDimensionalArrayOperation();
                    break;
                case "3":
                    System.out.println("\nПрограмма успешно завершена!");
                    return;
                default:
                    System.out.println("\nНеверный выбор, повторите попытку!\n\n");
            }

        } while (true);
    }


    // Работа с одномерным массивом
    static void oneDimensionalArray() {
        Scanner sc = new Scanner(System.in);
        int[] arrRandom = null;
        int[] arrManual = null;
        do {
            System.out.println("1. Сформировать массив с помощью рандома");
            System.out.println("2. Сформировать массив посредством ручного ввода");
            System.out.println("3. Распечатать массив");
            System.out.println("4. Удалить из массива максимальный элемент");
            System.out.println("5. Добавить в массив элемент(-ы)");
            System.out.println("6. Изменить порядок элементов в массиве(четные слева, нечетные справа)");
            System.out.println("7. Поиск элемента в массиве");
            System.out.println("8. Выполнить сортировку массива");
            System.out.println("9. Бинарный поиск элемента в массиве");
            System.out.println("10. Вернуться к выбору массива");
            System.out.println("Выберите нужный вам вариант: ");

            String input = sc.next();
            switch (input) {
                case "1":
                    arrRandom = randomArray();
                    break;
                case "2":
                    arrManual = manualArray();
                    break;
                case "3":
                    if (arrRandom != null) {
                        printingArray(arrRandom, "Random");
                    } else {
                        System.out.println("Массив, созданный с помощью Random, пуст!");
                    }
                    if (arrManual != null) {
                        printingArray(arrManual, "Manual");
                    } else {
                        System.out.println("Массив, созданный с помощью ввода с клавиатуры, пуст!");
                    }
                    break;
                case "4":
                    System.out.println("Из какого массива хотите удалить максимальный элемент?");
                    System.out.println("1. Массив, созданный c помощью Random");
                    System.out.println("2. Массив, созданный вручную");
                    System.out.println("3. Вернуться назад");
                    System.out.println("Выберите нужный вам вариант: ");
                    String choice = sc.next();
                    switch (choice) {
                        case "1":
                            if (arrRandom != null && arrRandom.length > 0) {
                                arrRandom = deleteMaxItem(arrRandom);
                                System.out.println("Максимальный элемент удален из массива Random!");
                            } else {
                                System.out.println("Массив Random пуст!");
                            }
                            break;
                        case "2":
                            if (arrManual != null && arrManual.length > 0) {
                                arrManual = deleteMaxItem(arrManual);
                                System.out.println("Максимальный элемент удален из массива Manual!");
                            } else {
                                System.out.println("Массив Manual пуст!");
                            }
                            break;
                        case "3":
                            break;
                        default:
                            System.out.println("Неверный выбор, попробуйте снова!");
                    }
                    break;
                case "5":
                    System.out.println("В какой массив хотите добавить элемент(-ы)?");
                    System.out.println("1. Массив, созданный c помощью Random");
                    System.out.println("2. Массив, созданный вручную");
                    System.out.println("3. Вернуться назад");
                    System.out.println("Выберите нужный вам вариант: ");
                    String addChoice = sc.next();
                    switch (addChoice) {
                        case "1":
                            if (arrRandom != null && arrRandom.length > 0) {
                                arrRandom = addItemArray(arrRandom);
                                System.out.println("Элементы успешно добавлены в массив Random!");
                            } else {
                                System.out.println("Ошибка: массив Random пуст или не создан!");
                            }
                            break;
                        case "2":
                            if (arrManual != null && arrManual.length > 0) {
                                arrManual = addItemArray(arrManual);
                                System.out.println("Элементы успешно добавлены в массив Manual!");
                            } else {
                                System.out.println("Ошибка: массив Manual пуст или не создан!");
                            }
                            break;
                        case "3":
                            break;
                        default:
                            System.out.println("Неверный выбор, попробуйте снова!");
                    }
                    break;
                case "6":
                    System.out.println("Какой массив следует преобразовать?");
                    System.out.println("1. Массив, созданный c помощью Random");
                    System.out.println("2. Массив, созданный вручную");
                    System.out.println("3. Вернуться назад");
                    System.out.println("Выберите нужный вам вариант: ");
                    String elementTransport = sc.next();
                    switch (elementTransport) {
                        case "1":
                            if (arrRandom != null && arrRandom.length > 0) {
                                arrRandom = elementTranspositionArray(arrRandom);
                                System.out.println("Элементы успешно переставлены в массиве Random!");
                            } else {
                                System.out.println("Ошибка: массив Random пуст или не создан!");
                            }
                            break;
                        case "2":
                            if (arrManual != null && arrManual.length > 0) {
                                arrManual = elementTranspositionArray(arrManual);
                                System.out.println("Элементы успешно переставлены в массиве Manual!");
                            } else {
                                System.out.println("Ошибка: массив Manual пуст или не создан!");
                            }
                            break;
                        case "3":
                            break;
                        default:
                            System.out.println("Неверный выбор, попробуйте снова!");
                    }
                    break;
                case "7":
                    System.out.println("В каком массиве нужно найти элемент?");
                    System.out.println("1. Массив, созданный c помощью Random");
                    System.out.println("2. Массив, созданный вручную");
                    System.out.println("3. Вернуться назад");
                    System.out.println("Выберите нужный вам вариант: ");
                    String elementSearch = sc.next();
                    switch (elementSearch) {
                        case "1":
                            if (arrRandom != null && arrRandom.length > 0) {
                                arrayElementSearch(arrRandom);
                            } else {
                                System.out.println("Ошибка: массив Random пуст или не создан!");
                            }
                            break;
                        case "2":
                            if (arrManual != null && arrManual.length > 0) {
                                arrayElementSearch(arrManual);
                            } else {
                                System.out.println("Ошибка: массив Manual пуст или не создан!");
                            }
                            break;
                        case "3":
                            break;
                        default:
                            System.out.println("Неверный выбор, попробуйте снова!");
                    }
                    break;
                case "8":
                    System.out.println("Какой массив нужно отсортировать?");
                    System.out.println("1. Массив, созданный c помощью Random");
                    System.out.println("2. Массив, созданный вручную");
                    System.out.println("3. Вернуться назад");
                    System.out.println("Выберите нужный вам вариант: ");
                    String elementSort = sc.next();
                    switch (elementSort) {
                        case "1":
                            if (arrRandom != null && arrRandom.length > 0) {
                                 arraySimpleSort(arrRandom);
                            } else {
                                System.out.println("Ошибка: массив Random пуст или не создан!");
                            }
                            break;
                        case "2":
                            if (arrManual != null && arrManual.length > 0) {
                                arraySimpleSort(arrManual);
                            } else {
                                System.out.println("Ошибка: массив Manual пуст или не создан!");
                            }
                            break;
                        case "3":
                            break;
                        default:
                            System.out.println("Неверный выбор, попробуйте снова!");
                    }
                    break;
                case "9":
                    System.out.println("В каком массиве нужно найти элемент?");
                    System.out.println("1. Массив, созданный c помощью Random");
                    System.out.println("2. Массив, созданный вручную");
                    System.out.println("3. Вернуться назад");
                    System.out.println("Выберите нужный вам вариант: ");
                    String binarySearch = sc.next();
                    switch (binarySearch) {
                        case "1":
                            if (arrRandom != null && arrRandom.length > 0) {
                                arrayBinarySearch(arrRandom);
                            } else {
                                System.out.println("Ошибка: массив Random пуст или не создан!");
                            }
                            break;
                        case "2":
                            if (arrManual != null && arrManual.length > 0) {
                                arrayBinarySearch(arrManual);
                            } else {
                                System.out.println("Ошибка: массив Manual пуст или не создан!");
                            }
                            break;
                        case "3":
                            break;
                        default:
                            System.out.println("Неверный выбор, попробуйте снова!");
                    }
                    break;
                case "10":
                    return;
                default:
                    System.out.println("\nНеверный выбор, повторите попытку!\n\n");
            }
        } while (true);
    }


    // Создание массива с помощью рандома
    static int[] randomArray() {
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        int count = 0;

        while (true) {
            System.out.println("Введите желаемое количество элементов в массиве: ");
            if (sc.hasNextInt()) {
                count = sc.nextInt();
                if (count > 0) {
                    break;
                } else {
                    System.out.println("Количество элементов должно быть положительно, попробуйте снова");
                }
            } else {
                System.out.println("Ошибка: введите корректное целое число!");
                sc.next(); // очистка ввода
            }
        }

        int[] arrRandom = new int[count];
        for (int i = 0; i < count; i++) {
            arrRandom[i] = rnd.nextInt(-100, 100);
        }
        System.out.println("Массив сформирован успешно!");
        return arrRandom;
    }


    // Создание массива при помощи ручного ввода
    static int[] manualArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите желаемое количество элементов");
        // проверка ввода
        int count = 0;
        while (true) {
            if (sc.hasNextInt()) {
                count = sc.nextInt();
                if (count > 0) {
                    break;
                } else {
                    System.out.println("Количество элементов в массиве должно быть больше нуля, попробуйте снова");
                }
            } else {
                System.out.println("Ошибка: введите корректное целое число!");
                sc.next();
            }
        }

        int[] arrManual = new int[count];
        System.out.println("Введите элементы массива");

        // ввод элемента с проверкой
        for (int i = 0; i < count; i++) {
            while (true) {
                System.out.printf("Элемент" + (i + 1) + ": ");
                if (sc.hasNextInt()) {
                    arrManual[i] = sc.nextInt();
                    break;
                } else {
                    System.out.println("Ошибка: введите целое число!");
                    sc.next();
                }
            }
        }
        System.out.println("Массив сформирован успешно!");
        return arrManual;
    }


    // Распечатка массива
    static void printingArray(int[] arr, String arrayType) {
        System.out.printf(arrayType + ": ");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
        System.out.println();
    }


    // Удалить максимальный элемент
    static int[] deleteMaxItem(int[] arr) {
        int max = arr[0], count = 1;
        for (int i = 1; i < arr.length; i++)
            if (max < arr[i]) {
                max = arr[i];
                count = 1;
            } else if (max == arr[i])
                count++;

        int[] newArr = new int[arr.length - count];

        for (int i = 0, index = 0; i < arr.length; i++)
            if (arr[i] != max)
                newArr[index++] = arr[i];
        return newArr;
    }


    // Добавить элемент в массив, начиная с определенного индекса
    static int[] addItemArray(int[] arr) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите индекс, с которого начинать добавление элементов: ");
        int index;
        while (true) {
            if (sc.hasNextInt()) {
                index = sc.nextInt();
                if (index >= 0 && index <= arr.length) {
                    break;
                } else {
                    System.out.println("Ошибка: индекс должен быть в пределах массива!");
                }
            } else {
                System.out.println("Ошибка: введите корректное целое число!");
                sc.next();
            }
        }

        System.out.println("Введите количество элементов для добавления: ");
        int count;
        while (true) {
            if (sc.hasNextInt()) {
                count = sc.nextInt();
                if (count > 0) {
                    break;
                } else {
                    System.out.println("Ошибка: количество элементов должно быть положительным!");
                }
            } else {
                System.out.println("Ошибка: введите корректное целое число!");
                sc.next();
            }
        }

        int[] newArr = new int[arr.length + count];
        // Копирование элементов до вставки
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }
        System.out.println("Введите элементы:");
        for (int i = index; i < index + count; i++) {
            while (true) {
                if (sc.hasNextInt()) {
                    newArr[i] = sc.nextInt();
                    break;
                } else {
                    System.out.println("Ошибка: введите корректное целое число!");
                    sc.next();
                }
            }
        }

        // Копирование оставшихся элементов после вставки
        for (int i = index; i < arr.length; i++) {
            newArr[i + count] = arr[i];
        }
        System.out.println("Элементы успешно добавлены");
        return newArr;
    }


    // Перестановка элементов в массиве: четные в начало массива, а нечетные - в конец
    static int[] elementTranspositionArray(int[] arr) {
        // Вставка четных
        int[] newArray = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (num % 2 == 0) {
                newArray[index++] = num;
            }
        }

        // Вставка нечетных
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (num % 2 != 0) {
                newArray[index++] = num;
            }
        }

        return newArray;
    }


    // Поиск элемента в массиве с первого элемента
    static void arrayElementSearch(int[] arr) {
        int number;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Введите целое число для поиска: ");
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                break;
            } else {
                System.out.println("Ошибка: введите корректное целое число!");
                sc.next();
            }
        }
        int operations = 0;
        for (int i = 0; i < arr.length; i++) {
            operations++;
            if (arr[i] == number) {
                System.out.println("Элемент " + number + " найден под индексом " + i + ". Количество операций: " + operations);
                return;
            }
        }
        System.out.println("Элемент " + number + " не найден. Количество операций: " + operations);
    }


    // Сортировка массива пузырьковым методом
    static void arraySimpleSort(int[] arr) {
        boolean swapped;
        for (int i = 0; i < arr.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (swapped == false) {
                System.out.println("Массив отсортирован!");
                break;
            }
        }
    }


    // Бинарный поиск элемента
    static void arrayBinarySearch(int[] arr) {

        // Проверяем массив на сортировку
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                System.out.println("Ошибка: массив не отсортирован! Сначала отсортируйте его");
                return;
            }
        }

        int number;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Введите целое число для поиска: ");
            if (sc.hasNextInt()) {
                number = sc.nextInt();
                break;
            } else {
                System.out.println("Ошибка: введите корректное целое число!");
                sc.next();
            }
        }
        int left = 0;
        int right = arr.length - 1;
        int comparisons = 0;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            comparisons++;

            if (arr[middle] == number) {
                System.out.println("Элемент " + number + " найден под индексом " + middle + ". Количество операций: " + comparisons);
                return;
            }

            if (arr[middle] < number) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        System.out.println("Элемент " + number + " не найден " + comparisons + ". Количество операций:");
    }




    // Работа с двумерным массивом
    static void twoDimensionalArrayOperation(){
        Scanner sc = new Scanner(System.in);
        int[][] arrRandom = null;
        int[][] arrManual = null;
        int[][] arrJaggedRandom = null;
        int[][] arrJaggedManual = null;
        do{
            System.out.println("1. Сформировать двумерный массив с помощью рандома ");
            System.out.println("2. Сформировать двумерный массив посредством ручного ввода");
            System.out.println("3. Распечатать массивы");
            System.out.println("4. Удалить строки с максимальным элементом в двумерном массиве");
            System.out.println("5. Сформировать рваный массив с помощью рандома");
            System.out.println("6. Сформировать рваный массив с помощью ручного ввода");
            System.out.println("7. Добавить строку в начало рваного массива");
            System.out.println("8. Вернуться");
            System.out.println("Выбери:");

            String input = sc.next();

            switch(input){
                case "1":
                    arrRandom = randomArray2D();
                    break;
                case "2":
                    arrManual = manualArray2D();
                    break;
                case "3":
                    if (arrRandom != null) {
                        printingArray2D(arrRandom, "Двумерный Random");
                    } else {
                        System.out.println("Двумерный массив, созданный с помощью Random, пуст!");
                    }
                    if (arrManual != null) {
                        printingArray2D(arrManual, "Двумерный Manual");
                    } else {
                        System.out.println("Двумерный Массив, созданный с помощью ввода с клавиатуры, пуст!");
                    }
                    if (arrJaggedRandom != null) {
                        printingArray2D(arrJaggedRandom, "Рваный Random");
                    } else {
                        System.out.println("Рваный массив, созданный с помощью Random, пуст!");
                    }
                    if (arrJaggedManual != null) {
                        printingArray2D(arrJaggedManual, "Рваный Manual");
                    } else {
                        System.out.println("Рваный массив, созданный с помощью ввода с клавиатуры, пуст!");
                    }
                    break;
                case "4":
                    System.out.println("В каком двумерном массиве нужно удалить строку с максимальным элементом?");
                    System.out.println("1. Массив, созданный c помощью Random");
                    System.out.println("2. Массив, созданный вручную");
                    System.out.println("3. Вернуться назад");
                    System.out.println("Выберите нужный вам вариант: ");
                    String deleteElement = sc.next();
                    switch (deleteElement) {
                        case "1":
                            if (arrRandom != null && arrRandom.length > 0) {
                                arrRandom = deleteMaxElementLine(arrRandom);
                            } else {
                                System.out.println("Ошибка: массив Random пуст или не создан!");
                            }
                            break;
                        case "2":
                            if (arrManual != null && arrManual.length > 0) {
                                arrManual = deleteMaxElementLine(arrManual);
                            } else {
                                System.out.println("Ошибка: массив Manual пуст или не создан!");
                            }
                            break;
                        case "3":
                            break;
                        default:
                            System.out.println("Неверный выбор, попробуйте снова!");
                    }
                    break;
                case "5":
                    arrJaggedRandom = jaggedArrayRandom();
                    break;
                case "6":
                    arrJaggedManual = jaggedArrayManual();
                    break;
                case "7":
                    System.out.println("В каком рваном массиве нужно добавить строку в начало?");
                    System.out.println("1. Массив, созданный c помощью Random");
                    System.out.println("2. Массив, созданный вручную");
                    System.out.println("3. Вернуться назад");
                    System.out.println("Выберите нужный вам вариант: ");
                    String addLine = sc.next();
                    switch (addLine) {
                        case "1":
                            if (arrJaggedRandom != null && arrJaggedRandom.length > 0) {
                                arrJaggedRandom = addLineJagged(arrJaggedRandom);
                            } else {
                                System.out.println("Ошибка: рваный массив Random пуст или не создан!");
                            }
                            break;
                        case "2":
                            if (arrJaggedManual != null && arrJaggedManual.length > 0) {
                                arrJaggedManual = addLineJagged(arrJaggedManual);
                            } else {
                                System.out.println("Ошибка: рваный массив Manual пуст или не создан!");
                            }
                            break;
                        case "3":
                            break;
                        default:
                            System.out.println("Неверный выбор, попробуйте снова!");
                    }
                    break;
                case "8":
                    return;

                default:
                    System.out.println("Неверный выбор, повторите команду");
            }
        }while (true);
    }


    // Создание двумерного массива при помощи рандома
    static int[][] randomArray2D(){
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        int column = 0;
        int line = 0;


        // Ввод строки
        while (true) {
            System.out.println("Введите желаемое количество строк в массиве: ");
            if (sc.hasNextInt()) {
                line = sc.nextInt();
                if (line > 0) {
                    break;
                } else {
                    System.out.println("Количество строк должно быть положительно, попробуйте снова");
                }
            } else {
                System.out.println("Ошибка: введите корректное целое число!");
                sc.next();
            }
        }

        // Ввод столбца
        while (true) {
            System.out.println("Введите желаемое количество столбцов в массиве: ");
            if (sc.hasNextInt()) {
                column = sc.nextInt();
                if (column > 0) {
                    break;
                } else {
                    System.out.println("Количество столбцов должно быть положительно, попробуйте снова");
                }
            } else {
                System.out.println("Ошибка: введите корректное целое число!");
                sc.next();
            }
        }


        int[][] arrRandom = new int[line][column];
        for (int i=0; i < line; i++){
            for(int j = 0; j < column; j++){
                arrRandom[i][j] = rnd.nextInt(-100, 100);
            }
        }
        System.out.println("Массив сформирован успешно!");
        return arrRandom;
    }


    // Создание массива при помощи ручного ввода
    static int[][] manualArray2D(){
        Scanner sc = new Scanner(System.in);
        int column = 0;
        int line = 0;


        // Ввод строки
        while (true) {
            System.out.println("Введите желаемое количество строк в массиве: ");
            if (sc.hasNextInt()) {
                line = sc.nextInt();
                if (line > 0) {
                    break;
                } else {
                    System.out.println("Количество строк должно быть положительно, попробуйте снова");
                }
            } else {
                System.out.println("Ошибка: введите корректное целое число!");
                sc.next();
            }
        }


        // Ввод столбца
        while (true) {
            System.out.println("Введите желаемое количество столбцов в массиве: ");
            if (sc.hasNextInt()) {
                column = sc.nextInt();
                if (column > 0) {
                    break;
                } else {
                    System.out.println("Количество столбцов должно быть положительно, попробуйте снова");
                }
            } else {
                System.out.println("Ошибка: введите корректное целое число!");
                sc.next();
            }
        }

        int[][] arrManual = new int[line][column];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                while (true) {
                    System.out.printf("Элемент [%d][%d]: ", i, j);
                    if (sc.hasNextInt()) {
                        arrManual[i][j] = sc.nextInt();
                        break;
                    } else {
                        System.out.println("Ошибка: введите корректное целое число!");
                        sc.next();
                    }
                }
            }
        }
        System.out.println("Массив сформирован успешно!");
        return arrManual;
    }


    // Распечатка массива
    static void printingArray2D(int[][] arr, String arrayType){
        System.out.println("Массив " + arrayType + ":");
        for (int[] row : arr) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }


    // Удалить строку(-и) в которой наибольший элемент матрицы
    static int[][] deleteMaxElementLine(int[][] arr){
        int max = Integer.MIN_VALUE;

        // Ищем максимальный элемент в матрице
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (arr[i][j] > max){
                    max = arr[i][j];
                }
            }
        }


        // Определяем строки, которые содержат максимальный элемент
        boolean[] delete = new boolean[arr.length];
        int newCountLine = 0;

        for (int i = 0; i < arr.length; i++){
            for (int num : arr[i]){
                if ( num == max){
                    delete[i] = true;
                    break;
                }
            }
            if (delete[i] == false){
                newCountLine++;
            }
        }


        // Создаем новый массив, не включая туда строки с флагом true
        int[][] newArr = new int[newCountLine][];
        int index = 0;

        for (int i = 0; i < arr.length; i++){
            if (delete[i] == false){
                newArr[index++] = arr[i];
            }
        }

        System.out.println("Удалены строки с максимальным элементом "  + max);
        return newArr;
    }


    // Создать рваный массив при помощи рандома
    static int[][] jaggedArrayRandom(){
        Random rnd = new Random();
        int line = rnd.nextInt(11);
        int[][] arrJaggedRandom = new int[line][];

        for (int i = 0; i < line; i++){
            int columns = rnd.nextInt(11);
            arrJaggedRandom[i] = new int[columns];
            for (int j = 0; j < columns; j++){
                arrJaggedRandom[i][j] = rnd.nextInt(-100,100);
            }
        }
        System.out.println("Массив сформирован успешно!");
        return arrJaggedRandom;
    }


    // Создать рваный массив при помощи ручного ввода
    static int[][] jaggedArrayManual(){
        Scanner sc = new Scanner(System.in);
        int line = 0;


        // Ввод строки
        while (true) {
            System.out.println("Введите желаемое количество строк в массиве: ");
            if (sc.hasNextInt()) {
                line = sc.nextInt();
                if (line > 0) {
                    break;
                } else {
                    System.out.println("Количество строк должно быть положительно, попробуйте снова");
                }
            } else {
                System.out.println("Ошибка: введите корректное целое число!");
                sc.next();
            }
        }


        int[][] arrJaggedManual = new int[line][];
        for (int i = 0; i < line; i++) {
            System.out.println("Введите количество элементов в строке " + (i + 1) + ":");
            int size;

            while (true) {
                if (sc.hasNextInt()) {
                    size = sc.nextInt();
                    if (size > 0) {
                        break;
                    } else {
                        System.out.println("Ошибка: количество элементов должно быть больше 0");
                    }
                } else {
                    System.out.println("Ошибка: введите корректное число!");
                    sc.next();
                }
            }
            arrJaggedManual[i] = new int[size];
            System.out.println("Введите " + size + " элементов:");

            for (int j = 0; j < size; j++) {
                while (true) {
                    if (sc.hasNextInt()) {
                        arrJaggedManual[i][j] = sc.nextInt();
                        break;
                    } else {
                        System.out.println("Ошибка: введите целое число!");
                        sc.next();
                    }
                }
            }
        }

        System.out.println("Рваный массив успешно создан!");
        return arrJaggedManual;
    }


    // Добавление строки в начало рваного массива
    static int[][] addLineJagged(int[][] arr){
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество элементов для добавления: ");

        int count;
        while (true) {
            if (sc.hasNextInt()) {
                count = sc.nextInt();
                if (count > 0) {
                    break;
                } else {
                    System.out.println("Ошибка: количество элементов должно быть положительным!");
                }
            } else {
                System.out.println("Ошибка: введите корректное целое число!");
                sc.next();
            }
        }


        // Вводи новую строку
        int[] newLine = new int[count];
        System.out.println("Введите " + count + " элементов:");
        for (int i = 0; i < count; i++) {
            while (true) {
                if (sc.hasNextInt()) {
                    newLine[i] = sc.nextInt();
                    break;
                } else {
                    System.out.println("Ошибка: введите целое число!");
                    sc.next();
                }
            }
        }

        int[][] newArr = new int[arr.length + 1][];
        newArr[0] = newLine;
        for (int i = 0; i < arr.length; i++) {
            newArr[i + 1] = arr[i];
        }

        System.out.println("Новая строка добавлена в начало массива!");
        return newArr;
    }

}

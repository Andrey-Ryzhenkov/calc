import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);//Создаем экземпляр класса Scanner
        System.out.println("Калькулятор");
        System.out.print("Input: ");
        String input = scanner.nextLine();// Ввод с клавиатуры математической операции
        scanner.close();// Закрытие сканера 
        System.out.print("Output: " + calc(input));// вывод результата функции calc
    }

    public static String calc(String input) throws Exception  {// Обозначили метод и что могут быть исключения
        input=input.trim();// убираем пробелы по краям
        String[] argument = input.split(" ");//Указываем пробел в качестве разделителя и передаем в массив полученные аргументы
        if (argument.length != 3){//если кол-во аргументов не равно 3
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        int a = 0;
        int b = 0;
        int result = 0;
        try {
            a= Integer.parseInt(argument[0]); // Первое число    
            b= Integer.parseInt(argument[2]); // Второе число      
        } catch (NumberFormatException e) {
            throw new Exception("Аргументы должны быть целым числом");
        }
        String operation = argument[1];// Опперанд
        if (a <1 || a>10 || b<1 || b>10){//Проверяем в допустимых ли пределах находятся числа
            throw new Exception("Аргументы должны находиться в допустимом диапазоне значений от 0 до 10");  
        }
        switch (operation) {
            case "+" -> result = a + b;
            case "-" -> result = a - b;
            case "*" -> result = a * b;
            case "/" -> result = a / b;
            default -> throw new Exception("Опперанд не является допустимым");
        }
        return (Integer.toString(result)); // Вывод результата в виде строки
    }
}
import java.util.Scanner;
/**
 * Created by Eva on 16/02/2016.
 * Загадайка - загадывает

 1. Программа загадывает число от 1 до 100.
 2. Пользователь вводит число. Программа отвечает, было ли это число больше,меньше или равно загаданному.
 3. Если число не отгадано, переход к шагу 2.
 */
public class GuessingGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = (int) (Math.random()*101);
        System.out.println("I am thinking of a number between 0 and 100... Make a guess: ");
        int n = in.nextInt();

        while (n != x) {
            if (n > x) {
                System.out.println("The number I'm thinking of is smaller than " + n);
            }
            else {
                System.out.println("The number I'm thinking of is bigger than " + n);
            }
            System.out.println("Try another number:");
            n = in.nextInt();
        }
        System.out.println("You have guessed right! The number I was thinking of was " + x);
    }
}
/*
I am thinking of a number between 0 and 100... Make a guess:
67
The number I'm thinking of is bigger than 67
Try another number:
95
The number I'm thinking of is smaller than 95
Try another number:
80
The number I'm thinking of is smaller than 80
Try another number:
75
The number I'm thinking of is smaller than 75
Try another number:
74
The number I'm thinking of is smaller than 74
Try another number:
73
The number I'm thinking of is smaller than 73
Try another number:
72
The number I'm thinking of is smaller than 72
Try another number:
71
The number I'm thinking of is smaller than 71
Try another number:
70
You have guessed right! The number I was thinking of was 70
 */

import java.util.Scanner;
/**
 * Created by feodoeve on 2016.02.18..
 Угадайка - отгадывает

 1. Пользователь загадывает число от 1 до 100.
 2. Программа выводит число. Пользователь отвечает, было ли это число больше,меньше или равно загаданному.
 3. Если число не отгадано, переход к шагу 2.

 Возможны 2 реализации:
 1. Программа стремится сделать минимальное число ходов.

 2. Программа делает случайные ходы.

 В любом случае предполагаем, что пользователь не обманывает программу, т.е. если пользователь на число 50 ответил, что загаданное число больше, то программа не должна называть числа меньше 51.
 */
public class ComputerGuessingGame {
    public static void main(String[] args) {
        int min = 0;
        int max = 101;
        Scanner in = new Scanner(System.in);
        int n = (int) (Math.random()*max);

        System.out.println("You are thinking of a number between 0 and 100. I am going to guess this number. Please give me some feedback: ");
        System.out.println("If the number you are thinking of is bigger than the number I am guessing with type 'bigger';");
        System.out.println("If the number you are thinking of is small than the number I am guessing with type 'smaller';");
        System.out.println("If they are equal, write 'equal'. Let's play!");
        System.out.println("Is it " + n + "?");
        String reply = in.nextLine();

        while(!(reply.equals("equal"))) {
            if (reply.equals("bigger")) {
                min = n;
                n = (int) (Math.random()*(max-min+1)+min);
            }
            else if (reply.equals("smaller")) {
                max = n;
                n = (int) (Math.random()*(max-min+1)+min);
            }
            else {
                System.out.println("Houston, we've got a problem. Are you sure you answered with one of the words we have agreed to? Let's try again.");
            }
            System.out.println("Is it " + n + "?");
            reply = in.nextLine();
        }
        System.out.println("Finally I have guessed the number, it's " + n);

    }
}
/*
You are thinking of a number between 0 and 100. I am going to guess this number. Please give me some feedback: 
If the number you are thinking of is bigger than the number I am guessing with type 'bigger';
If the number you are thinking of is small than the number I am guessing with type 'smaller';
If they are equal, write 'equal'. Let's play!
Is it 84?
smaller
Is it 72?
smaller
Is it 41?
biger
Houston, we've got a problem. Are you sure you answered with one of the words we have agreed to? Let's try again.
Is it 41?
bigger
Is it 49?
bigger
Is it 65?
smaller
Is it 51?
bigger
Is it 57?
smaller
Is it 54?
bigger
Is it 55?
bigger
Is it 57?
smaller
Is it 55?
bigger
Is it 57?
smaller
Is it 56?
equal
Finally I have guessed the number, it's 56
*/

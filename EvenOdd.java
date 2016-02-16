import java.util.Scanner; 

/** 
* Программа с консоли запрашивает у пользователя целые (в Java это тип данных int) числа. 
* Пользователь вводит по одному числу. Может ввести неограниченное количество чисел. 
* Конец ввода - число ноль. После окончания ввода программа должна вывести сколько чисел 
* пользователь ввёл чётных и сколько нечётных. 
*/ 

public class CountOddEven { 
	public static void main(String[] args) { 
		Scanner in = new Scanner(System.in); 
		int a = in.nextInt(); 
		int odd = 0; 
		int even = 0; 

		while (a != 0){ 
			if (a%2 == 0) { 
				even++; 
			} 
			else { 
				odd++; 
			} 
			a = in.nextInt(); 
		} 
	System.out.println("You have entered " + even + " even numbers."); 
	System.out.println("You have entered " + odd + " odd numbers."); 
	} 
} 
/* 
4 
7 
6 
4 
5 
6 
7 
8 
9 
0 
You have entered 5 even numbers. 
You have entered 4 odd numbers. 

3 
6 
8 
7 
5 
0 
You have entered 2 even numbers. 
You have entered 3 odd numbers. 
*/

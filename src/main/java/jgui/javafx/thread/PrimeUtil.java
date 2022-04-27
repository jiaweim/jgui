package jgui.javafx.thread;

/**
 * @author JiaweiMao
 * @version 1.0.0
 * @since 15 Jan 2018, 4:42 PM
 */
public class PrimeUtil
{
    public static boolean isPrime(long num)
    {
        if (num <= 1 || num % 2 == 0) {
            return false;
        }
        int upperDivisor = (int) Math.ceil(Math.sqrt(num));
        for (int divisor = 3; divisor <= upperDivisor; divisor += 2) {
            if (num % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}

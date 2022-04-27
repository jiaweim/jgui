package jgui.ms;

/**
 * 
 * @author JiaweiMao
 *
 */
public class MathUtil {

	/**
	 * Rounds a double value to the wanted number of decimal places.
	 *
	 * @param value a double value
	 * @param scale number of decimal digits
	 * @return rounded double value
	 * @since 1.00
	 */
	public static double round(double value, int scale) {

		return Math.round(value * Math.pow(10, scale)) / Math.pow(10, scale);
	}
}

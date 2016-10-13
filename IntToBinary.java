import java.util.Scanner;

/**
 * @author phil
 *
 * fun fact: this is about what happens under the hood if one invokes
 * java.lang.Integer.toBinaryString
 */
public class IntToBinary {

	public static void main(String[] args) {

		Scanner console = new Scanner(System.in);
		int z = console.nextInt();

		System.out.println(toBinary(z));

	}

	public static String toBinary(int i){
		char [] buffer = new char[32];
		int charPos = 32;

		do{
			/*
			 * notice how the digit 1 is actually a bit mask. resulting in
			 * only writing the rightmost piece of the bitstring to the char
			 * array.
			 * 0110 & (000)1 = 0
			 * 0110 >>> 1 = 0011
			 * 0011 & (000)1 = 1
			 *
			 * PS: using the 1 or 0 as index to the digits array is just
			 * a way to avoid some int to char typecast / conversion.
			 */
			buffer[--charPos] = digits[i & 1];
			/*
			 * bit shift right 1 time i.e 1100 >>> 1 = 0110
			 * essentially the same as dividing by 2 but with more swag
			 */
			i >>>= 1;
			// repeat these shenanigans until i is 0
		} while (i != 0);

		// return string from char array with offset and count
		return new String(buffer, charPos, (32 - charPos));
	}

	final static char[] digits = {
		'0', '1'
	};
}

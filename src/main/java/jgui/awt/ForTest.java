package jgui.awt;

public class ForTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[]  one={1, 2, 3, 8 ,65 };
		String result=null;
		boolean flag = true;
		for(int li:one){
			 if (flag) {
                 flag = false;
             } else {
                 result += " and ";
             }
             result += li;
		}
		System.out.println(result);
	}

}

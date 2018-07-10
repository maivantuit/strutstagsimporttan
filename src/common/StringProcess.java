package common;

public class StringProcess {	
	/**
	 * Kiem tra rong
	 * @param s
	 * @return
	 */
	public static boolean notVaild(String s){
		if(s==null || s.length() ==0){
			return true;
		}
		return false;
	}
}

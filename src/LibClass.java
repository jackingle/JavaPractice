

public class LibClass {
	public static String acrostic(String[] args) {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < args.length; i++) {
			if (args[i].length() > i) {
				buffer.append(args[i].charAt(i));
			} else {
				buffer.append('?');
			}
		} 
	return buffer.toString();
	}
}

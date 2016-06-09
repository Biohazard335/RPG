package menu;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MethodIterator {
	public static void main(String[] args) throws IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		MethodIterator i = new MethodIterator();
		for (Method object : MethodIterator.class.getDeclaredMethods()) {
			if (!object.getName().equals("main"))
				System.out.println(object.invoke(i));
		}
	}

	public static int five() {
		return 5;
	}

	public int one() {
		return 1;
	}

	@SuppressWarnings("unused")
	private static int two() {
		return 2;
	}

	@SuppressWarnings("unused")
	private int three() {
		return 3;
	}

}

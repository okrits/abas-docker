package exer;

import java.util.HashSet;
import java.util.Set;

public class EqualsExample {

	public static void main(String[] args) {
		Test obj1 = new Test(11, 12);
		Test obj2 = new Test(11, 12);

		Set<Test> objects = new HashSet<Test>();

		objects.add(obj1);
		objects.add(obj2);

		System.out.println("Obejects :\n\tobj1 = " + obj1 + "\n\tobj2 = " + obj2);
		System.out.println(
				"hashCode :" + "\n\tobj1.hashCode = " + obj1.hashCode() + "\n\tobj2.hashCode = " + obj2.hashCode());
		System.out.println("equals :" + "\n\tobj1.equals(obj2) = " + obj1.equals(obj2));
		System.out.println("Collection :\n\t" + objects);
	}
}

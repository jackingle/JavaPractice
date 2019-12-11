
public abstract class Abstracto {
	abstract void print(String a);
	Abstracto() {
		System.out.println("Abstracto did it.");
	}
	void normal(String a) {
		
	}
}
class Derived extends Abstracto {
	Derived() {
		System.out.println("Derived did it.");
	}
	
	void print(String a) {
		System.out.println("Did the thing.");
		
	}
	Derived(String a) {
		System.out.println(a);
	}


	public static void main(String[] args) {
		Abstracto b = new Derived();
//		Derived d = new Abstracto();
		String c = "new String";
		
		Derived e = new Derived2();
		b.print(c);
		Derived f = new Derived2(c);
	}
}
class Derived2 extends Derived {
	Derived2() {
		super();
		
		System.out.println("Derived2 the thing.");
	}
	Derived2(String a) {
		super(a);
		System.out.println(a+"!");
	}
}
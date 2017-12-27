package Intermidiate;

public class BoundedType<E extends A & D> {
	
	private E obj;
	
	public BoundedType(E obj) {
		this.obj = obj;
	}
	
	public static void main(String[] args) {
		BoundedType a = new BoundedType<>(new A());
	
		BoundedType b = new BoundedType<>(new B());
		
		BoundedType c = new BoundedType<>(new C());
		
//		BoundedType<String> d = new BoundedType<String>("");
		
		b.obj.display();
		a.obj.display();
		c.obj.display();
	}
}

class A implements D {
	public void display() {
		System.out.println("In class A");
	}
}

class B extends A {
	public void display() {
		System.out.println("In class B");
	}
}

class C extends B {
	public void display() {
		System.out.println("In class C");
	}
}

interface D {
	public void display();
}
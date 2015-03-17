package inner;

import org.junit.Test;

public class InnerHell {
	private int x = 10;
	
	@Test
	public void testThisHell(){
		InnerHell innerHell = new InnerHell();
		InnerHell.B b = innerHell.new B();
		InnerHell.B.C c = b.new C();
		c.go();
	}
	@Test
	public void test(){
		new InnerHell().new B().new C().go();
	}
	
	public class B {
		private int x = 15;

		public class C {
			private int x = 20;

			public void go() {
				System.out.println(x);
				System.out.println(this.x);//the same value as just x
				System.out.println(B.this.x);
				System.out.println(InnerHell.this.x);
			}
		}
	}
}
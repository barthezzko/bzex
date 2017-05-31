package com.barthezzko.java8;

public class SimpleLambda {


	
	private void passLambda(MyFunc myFunc){
		System.out.println(myFunc);
	}
	
	public static void main(String[] args) {
		SimpleLambda sl = new SimpleLambda();
		String someString = "value";
		sl.passLambda((a)->{
			return someString.equals("abc");
		});
	}
	
	@FunctionalInterface
	static interface MyFunc{
		
		public boolean processMyString(String str);
		
	} 
}

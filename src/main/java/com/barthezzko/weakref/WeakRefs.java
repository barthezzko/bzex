package com.barthezzko.weakref;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class WeakRefs {

	
	public static void main(String[] args) {
		String object = "asd";
		
		System.gc();
		Reference<String> ref = new WeakReference<String>(object);
		System.out.println(ref.get());
		
		System.gc();
		Reference<String> ref1 = new SoftReference<String>(object);
		System.out.println(ref1.get());
		
		ReferenceQueue<String> que = new ReferenceQueue<String>();
		Reference<String> ref3 = new PhantomReference<String>(object, que);
		System.out.println(ref3.get());
	}
}

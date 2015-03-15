package com.barthezzko.collections;

import java.util.HashMap;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LostKey {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void testLost(){
		HashMap<Car, Mate> cars = new HashMap<Car, Mate>();
		cars.put(new Car("civic"), new Mate());
		logger.info("from map:{}", cars.get(new Car("civic")));
 	}
	
	public static class Car {
		private String model;
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((model == null) ? 0 : model.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Car other = (Car) obj;
			if (model == null) {
				if (other.model != null)
					return false;
			} else if (!model.equals(other.model))
				return false;
			return true;
		}

		public Car(String model) {
			super();
			this.model = model;
		}
		
		
	}
	
	public static class Mate {
		
	}
}

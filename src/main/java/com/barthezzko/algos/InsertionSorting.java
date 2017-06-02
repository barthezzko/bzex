package com.barthezzko.algos;

import java.util.Arrays;

import org.apache.log4j.Logger;

public class InsertionSorting  implements Sorting {

	Logger logger = Logger.getLogger(InsertionSorting.class);
	
	@Override
	public int[] sort(int[] input) {
		int[] resArr = new int[input.length];
		for(int i=0;i<input.length;i++){
			resArr[i] = Integer.MIN_VALUE;
		}
		for(int i=0;i<input.length;i++){
			logger.debug("----- INSERTING [" + input[i] + "]");
			insert(resArr, input[i]);
			logger.debug(Arrays.toString(resArr));
		}
		return resArr;
	}

	private void insert(int[] resArr, int value) {
		boolean inserted = false;
		int saved = Integer.MIN_VALUE;
		for (int k=0;k<resArr.length;k++){
			logger.debug(Arrays.toString(resArr));
			if (!inserted && resArr[k] == Integer.MIN_VALUE){
				resArr[k] = value;
				inserted = true;
				return;
			} else if (!inserted && resArr[k]>= value) {
				saved = resArr[k];
				logger.debug("SAVING " + saved);
				logger.debug("INSERTING " + value);
				resArr[k] = value;
				inserted = true;
				logger.debug("SHIFT");
			} else if(inserted) {
				int tmp = resArr[k];
				resArr[k] = saved;
				saved = tmp;
				if (saved == Integer.MIN_VALUE){
					logger.debug("STOP");
					return;
				}
			}
		}
	}

}

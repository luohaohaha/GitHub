/*
 *  Copyright 2010 Yuri Kanivets
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.gdctclock.view;


/**
 * Numeric Wheel adapter.
 */
public class MSWheelAdapter implements WheelAdapter {
	
	/** The default min value */
	public static final int DEFAULT_MAX_VALUE = 9;

	/** The default max value */
	private static final int DEFAULT_MIN_VALUE = 0;
	
	// Values
	private int minValue;
	private int maxValue;
	
	// format
	private String format;
	private String[] this_data;
	
	/**
	 * Default constructor
	 */
	public MSWheelAdapter() {
		this(DEFAULT_MIN_VALUE, DEFAULT_MAX_VALUE);
	}

	/**
	 * Constructor
	 * @param minValue the wheel min value
	 * @param maxValue the wheel max value
	 */
	public MSWheelAdapter(int minValue, int maxValue) {
		this(minValue, maxValue, null);
	}

	/**
	 * Constructor
	 * @param minValue the wheel min value
	 * @param maxValue the wheel max value
	 * @param format the format string
	 */
	public MSWheelAdapter(int minValue, int maxValue, String format) {
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.format = format;
	}
	
	public MSWheelAdapter(String[] Str_data) {
		this.minValue = 0;
		this.maxValue = Str_data.length-1;
		this_data=Str_data;
//		this.format = format;
	}

	@Override
	public String getItem(int index) {
		if (index >= 0 && index < getItemsCount()) {
			int value = minValue + index;
			return this_data[value];
		}
		return null;
	}

	@Override
	public int getItemsCount() {
		return maxValue - minValue + 1;
	}
	
	@Override
	public int getMaximumLength() {
		int max = Math.max(Math.abs(maxValue), Math.abs(minValue));
		int maxLen = Integer.toString(max).length();
		if (minValue < 0) {
			maxLen++;
		}
		return maxLen;
	}
}

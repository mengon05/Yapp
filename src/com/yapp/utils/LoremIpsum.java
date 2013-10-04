package com.yapp.utils;

import java.util.ArrayList;
import java.util.List;

public class LoremIpsum {
	private boolean orangeThing = false;
	private String text1 = "Lorem ipsum dolor sit amet";
	private String text2 = "Morbi condimentum, sapien eu tempor tincidunt, nunc lacus blandit lorem, sit amet euismod tortor augue vel arcu.";

	public LoremIpsum(boolean orangeThing) {
		super();
		this.orangeThing = orangeThing;
	}

	public String getText1() {
		return text1;
	}

	public void setText1(String text1) {
		this.text1 = text1;
	}

	public String getText2() {
		return text2;
	}

	public void setText2(String text2) {
		this.text2 = text2;
	}

	public boolean isOrangeThing() {
		return orangeThing;
	}

	public static List<LoremIpsum> createList(int items) {
		List<LoremIpsum> lorems = new ArrayList<LoremIpsum>();
		for (int i = 0; i < items; i++) {
			lorems.add(new LoremIpsum(i % 4 != 0));
		}
		return lorems;
	}
}

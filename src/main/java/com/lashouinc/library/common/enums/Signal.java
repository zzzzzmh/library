package com.lashouinc.library.common.enums;

public class Signal {
	public static void main(String[] args) {
		//System.out.println(Signals.RED.toString());
		
		for(Signals s:Signals.values()) {
			System.out.println(s.getIndex());
			System.out.println(s.ordinal());
			System.out.println(s.name());
		}
	}
}

enum Signals {
	
	RED("红色",1), GREEN("绿色", 2), BLACK("黑色",3);
	
	private String name;
	private int index;
	
	private Signals(String name, int index) {
		this.name = name;
		this.index = index;
	}
	
	public static String getName(int index) {
		for (Signals s:Signals.values()) {
			if (s.getIndex() == index) {
				return s.name;
			}
		}
		return null;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
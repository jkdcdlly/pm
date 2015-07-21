package com.thinkgem.jeesite.modules.oa.entity;

public class Pie {
	private String name;
	private long y;
	private boolean sliced;
	private boolean selected;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getY() {
		return y;
	}

	public void setY(long y) {
		this.y = y;
	}

	public boolean isSliced() {
		return sliced;
	}

	public void setSliced(boolean sliced) {
		this.sliced = sliced;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}

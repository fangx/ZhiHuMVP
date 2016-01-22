package me.fangx.zhihu.modle.bean;

public class NavDrawerItem {

	private String title;
	private int icon;
	//图片颜色
	private int tint;
	private String count = "0";
	// boolean to set visiblity of the counter
	private boolean isCounterVisible = false;

	public NavDrawerItem(){}

	public NavDrawerItem(String title, int icon ,int tint){
		this.title = title;
		this.icon = icon;
        this.tint = tint;
	}

	public NavDrawerItem(String title, int icon, boolean isCounterVisible, String count){
		this.title = title;
		this.icon = icon;
		this.isCounterVisible = isCounterVisible;
		this.count = count;
	}

	public String getTitle(){
		return this.title;
	}

	public int getIcon(){
		return this.icon;
	}

	public String getCount(){
		return this.count;
	}

	public boolean getCounterVisibility(){
		return this.isCounterVisible;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public void setIcon(int icon){
		this.icon = icon;
	}

	public void setCount(String count){
		this.count = count;
	}

	public int getTint() {
		return tint;
	}

	public void setTint(int tint) {
		this.tint = tint;
	}

	public void setCounterVisibility(boolean isCounterVisible){
		this.isCounterVisible = isCounterVisible;
	}
}

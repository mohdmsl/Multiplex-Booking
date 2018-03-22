package model;

public class Halls {
	
	 
	private String hallDesc; 
	private int totalCapacity;
	
	
	public Halls(String hallDesc, int totalCapacity) {
		super();
		this.hallDesc = hallDesc;
		this.totalCapacity = totalCapacity;
	}
	
	public String getHallDesc() {
		return hallDesc;
	}
	public void setHallDesc(String hallDesc) {
		this.hallDesc = hallDesc;
	}
	public int getTotalCapacity() {
		return totalCapacity;
	}
	public void setTotalCapacity(int totalCapacity) {
		this.totalCapacity = totalCapacity;
	}
	


}

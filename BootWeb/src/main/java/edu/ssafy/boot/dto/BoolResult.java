package edu.ssafy.boot.dto;

public class BoolResult {
	private String name;
	private boolean count = false;
	private String status = "true";

	public BoolResult() {
		// TODO Auto-generated constructor stub
	}

	public BoolResult(String name, boolean count, String status) {
		super();
		this.name = name;
		this.count = count;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isCount() {
		return count;
	}

	public void setCount(boolean count) {
		this.count = count;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BoolResult [name=" + name + ", count=" + count + ", status=" + status + "]";
	}

}

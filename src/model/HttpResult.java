package model;

public class HttpResult {
	private int status;
	private String result;
	public HttpResult(){
		
	}
	public HttpResult(boolean flag) {
		status = flag?200:202;
		result = flag?"success":"fail";
		// TODO Auto-generated constructor stub
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	

}

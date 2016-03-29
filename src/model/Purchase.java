package model;

public class Purchase {
	private String userame;
	private String purchase_id;
	private String package_id;
	private int count;
	private String purchase_date;
	private String status;
	private boolean if_rate;
	
	
	public String getPurchase_id() {
		return purchase_id;
	}
	public void setPurchase_id(String purchase_id) {
		this.purchase_id = purchase_id;
	}
	public String getUserame() {
		return userame;
	}
	public void setUserame(String userame) {
		this.userame = userame;
	}
	public String getPackage_id() {
		return package_id;
	}
	public void setPackage_id(String package_id) {
		this.package_id = package_id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getPurchase_date() {
		return purchase_date;
	}
	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isIf_rate() {
		return if_rate;
	}
	public void setIf_rate(boolean if_rate) {
		this.if_rate = if_rate;
	}
	
	
}


public class Insurance {
	private int no;
	private String name;
	private int tenure;
	private int amount;
	public Insurance() {}
	public Insurance(int no, String name, int tenure, int amount) {
		super();
		this.no = no;
		this.name = name;
		this.tenure = tenure;
		this.amount = amount;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	

}

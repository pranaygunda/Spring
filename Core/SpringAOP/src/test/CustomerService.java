package test;

public class CustomerService {

	private String name;
	private String url;
	
	public void printName() {
		System.out.println("Customer Name :"+this.name);
	}
	public void setName(String name) {
		this.name = name;
	}
	public void printUrl() {
		System.out.println("Customer URL :"+this.url);
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void printThrowException(){
		throw new IllegalArgumentException();
	}
	
	
}

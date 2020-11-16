
public class SatilliteClass {

	public String name;
	public String site;
	
	public void init() {
		System.out.println("Bean is going through init.");
		this.name=name;
		this.site=site;	
	}
	public void destroy() {
	      System.out.println("Bean will destroy now.");
	   }
	
	public void display() {
		System.out.println("Name :"+this.name);
		System.out.println("Site :"+this.site);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
}

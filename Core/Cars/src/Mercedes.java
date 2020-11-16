public class Mercedes {

	public String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int cost;
	public String carname;

	public String getCarname() {
		return carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}
	
	public void display() {
		System.out.println("Name :"+name);
		System.out.println("Car Name :"+carname);
		System.out.println("Cost :"+cost);
	}
}

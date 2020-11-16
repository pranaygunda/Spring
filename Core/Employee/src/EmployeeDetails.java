import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
public class EmployeeDetails implements BeanPostProcessor {
	public int id;
	public String name;
	public int salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	 public Object postProcessBeforeInitialization(Object bean, String beanName) 
		      throws BeansException {
		      
		      System.out.println("BeforeInitialization : " );
		      return bean;  // you can return any other object as well
		   }
		   public Object postProcessAfterInitialization(Object bean, String beanName) 
		      throws BeansException {
		      
		      System.out.println("AfterInitialization : " );
		      return bean;  // you can return any other object as well
		   }
	

}

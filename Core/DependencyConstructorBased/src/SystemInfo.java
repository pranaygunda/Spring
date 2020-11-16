public class SystemInfo {
public int accuracy;
public int accessability;
private Processor processor;

SystemInfo(Processor processor){
	this.processor=processor;
}
public Processor getProcessor() {
	return processor;
}
public void setProcessor(Processor processor) {
	this.processor = processor;
}
public int getAccuracy() {
	return accuracy;
}
public void setAccuracy(int accuracy) {
	this.accuracy = accuracy;
}
public int getAccessability() {
	return accessability;
}
public void setAccessability(int accessability) {
	this.accessability = accessability;
}
public void display() {
	System.out.println("Accuracy :"+accuracy);
	System.out.println("Accessability :"+accessability);
	processor.display();
	
}
}

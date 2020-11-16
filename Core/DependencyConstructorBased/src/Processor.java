
public class Processor {
	public int cpuid;
	public int processorid;
	public int getCpuid() {
		return cpuid;
	}
	public void setCpuid(int cpuid) {
		this.cpuid = cpuid;
	}
	public int getProcessorid() {
		return processorid;
	}
	public void setProcessorid(int processorid) {
		this.processorid = processorid;
	}
	public void display() {
			
		System.out.println("cpuid :"+cpuid);
		System.out.println("processorid :"+processorid);
	}

}

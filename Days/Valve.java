package Days;

public class Valve {
	public final String name;
	public int value;
	public final String[] connections;
	public boolean closed = false;
	
	public Valve() {
		name = null;
		value = 0;
		connections = null;
	}
	
	public Valve(String name, int value, String[] connect) {
		this.name = name;
		this.value = value;
		connections = connect;
	}
}

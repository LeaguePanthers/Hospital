
public class Patient {

	protected boolean feelsCaredFor = false;
	protected boolean alive = true;
	
	public boolean feelsCaredFor() {
		return feelsCaredFor;
	}

	public void checkPulse() {
		feelsCaredFor = true;
	}

	public boolean isAlive() {
		return alive;
	}

	public void kill() {
		alive = false;
	}
}

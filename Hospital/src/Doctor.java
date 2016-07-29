import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Doctor {

	private static final int MAX_PATIENTS = 3;
	protected List<Patient> assignedPatients = new ArrayList<>();
	protected boolean isEvil = false;
	protected Hospital hospital;
	
	public Doctor() {
	}
	
	public Doctor(String id) {
		this();
		if (id.equals("666")) {
			this.isEvil = true;
		}
	}

	public Doctor(String id, Hospital aHospital) {
		this(id);
		this.hospital = aHospital;
	}

	public boolean performsSurgery() {
		return false;
	}

	public boolean makesHouseCalls() {
		return false;
	}

	public void assignPatient(Patient patient) throws DoctorFullException {
		if (assignedPatients.size() >= MAX_PATIENTS) {
			throw new DoctorFullException();
		}
		assignedPatients.add(patient);
	}

	public List<Patient> getPatients() {
		return assignedPatients;
	}

	public void doMedicine() {
		for (Patient p : assignedPatients) {
			if (isEvil()) {
				p.kill();
				if (hospital != null) {
					hospital.removePatient(p);
					hospital.addZombie(new Zombie(new Date().toString()));
				}
			} else {
				p.checkPulse();
			}
		}
	}

	public boolean isEvil() {
		return isEvil ;
	}

	public void joinTheDarkSide() {
		isEvil = true;
	}

	public Hospital getHospital() {
		return hospital;
	}

}

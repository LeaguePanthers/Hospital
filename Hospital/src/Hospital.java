import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hospital {

	protected List<Doctor> doctors = new ArrayList<>();
	protected List<Patient> patients = new ArrayList<>();
	protected List<Zombie> zombies = new ArrayList<>();

	public void addDoctor(Doctor doctor) {
		doctors.add(doctor);
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void addPatient(Patient patient) {
		patients.add(patient);
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void assignPatientsToDoctors() throws NoDoctorsAvailableException, NoPatientsAvailableException {
		if (doctors.isEmpty()) {
			throw new NoDoctorsAvailableException();
		} else if (patients.isEmpty()) {
			throw new NoPatientsAvailableException();
		}
		Iterator<Doctor> doctorIterator = doctors.iterator();
		Iterator<Patient> patientIterator = patients.iterator();
		Patient currentPatient = patientIterator.next();

		while (doctorIterator.hasNext()) {
			Doctor currentDoctor = doctorIterator.next();

			while (true) {
				try {
					currentDoctor.assignPatient(currentPatient);
				} catch (DoctorFullException e) {
					break;
				}
				if (!patientIterator.hasNext()) {
					return;
				} else {
					currentPatient = patientIterator.next();
				}
			}
		}

		throw new NoDoctorsAvailableException();
	}

	public void add(Object person) {
		if (person instanceof Doctor) {
			this.addDoctor((Doctor) person);
		} else if (person instanceof Patient){
			this.addPatient((Patient) person);
		}
		
	}
	
	public void add(Doctor doctor) {
		this.addDoctor(doctor);
	}
	
	public void add(Patient patient) {
		this.addPatient(patient);
	}

	public void makeDoctorsWork() {
		for (Doctor d : doctors) {
			d.doMedicine();
		}
	}

	public void removePatient(Patient p) {
		patients.remove(p);
	}

	public void addZombie(Zombie zombie) {
		zombies.add(zombie);
	}
	
	public List<Zombie> getZombies() {
		return zombies;
	}
}

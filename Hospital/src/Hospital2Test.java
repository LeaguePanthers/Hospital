public class Hospital2Test {

	public void testAPatientCanDie() throws Exception {
		Patient doomedPatient = new Patient();
		assertEquals(true, doomedPatient.isAlive());
		doomedPatient.kill();
		assertEquals(false, doomedPatient.isAlive());
	}

	public void testSomeDoctorsAreEvil() throws Exception {
		Doctor doctor = new Doctor();
		assertEquals(false, doctor.isEvil());
		doctor.joinTheDarkSide();
		assertEquals(true, doctor.isEvil());
	}

	public void testEvilDoctorsKillPatients() throws Exception {
		Doctor evilDoctor = new Doctor();
		evilDoctor.joinTheDarkSide();
		Patient doomedPatient = new Patient();
		assertEquals(true, doomedPatient.isAlive());
		evilDoctor.assignPatient(doomedPatient);
		evilDoctor.doMedicine();
		assertEquals(false, doomedPatient.isAlive());

		Doctor goodDoctor = new Doctor();
		Patient luckyPatient = new Patient();
		assertEquals(true, luckyPatient.isAlive());
		goodDoctor.assignPatient(luckyPatient);
		goodDoctor.doMedicine();
		assertEquals(true, luckyPatient.isAlive());
	}

	// use “instanceof”
	public void testNewWayToAddDoctorsAndPatients() throws Exception {
		Hospital hospital = new Hospital();
		hospital.add(new Doctor());
		hospital.add(new Patient());
		hospital.add(new Patient());
		assertEquals(1, hospital.getDoctors().size());
		assertEquals(2, hospital.getPatients().size());
	}

	// please use foreach loop
	public void testHospitalMakesDoctorsWork() throws Exception {
		Hospital hospital = new Hospital();
		hospital.add(new Doctor());
		hospital.addPatient(new Patient());
		hospital.addPatient(new Patient());
		hospital.assignPatientsToDoctors();
		hospital.makeDoctorsWork();
		assertTrue(hospital.getPatients().get(0).feelsCaredFor());
		assertTrue(hospital.getPatients().get(1).feelsCaredFor());
	}

	public void testDoctorNumber666IsEvil() throws Exception {
		Hospital elHospital = new Hospital();

		Doctor niceDoctor = new Doctor("777");
		elHospital.addDoctor(niceDoctor);
		Patient luckyPatient = new Patient();
		niceDoctor.assignPatient(luckyPatient);

		Doctor evilDoctor = new Doctor("666");
		elHospital.addDoctor(evilDoctor);
		Patient doomedPatient = new Patient();
		evilDoctor.assignPatient(doomedPatient);

		elHospital.makeDoctorsWork();
		assertEquals(false, doomedPatient.isAlive());
		assertEquals(true, luckyPatient.isAlive());
	}

	/* Add a new constructor to Doctor that makes use of the other using "this()" */
	public void testDoctorConstructors() throws Exception {
		Hospital aHospital = new Hospital();
		Doctor doctor = new Doctor("1", aHospital);
		assertEquals(aHospital, doctor.getHospital());
	}

	public void testZombieConstructor() throws Exception {
		Zombie zombie = new Zombie("June 1st");
		assertEquals("June 1st", zombie.getTimeOfDeath());
	}

	/*
	 * When a patient is killed they move from the Patient list to the Zombie list. 
	 * This will give you the current date and time: new Date().toString()
	 */
	public void testDeadPatientsBecomeZombies() throws Exception {
		Hospital walkingDeadHospital = new Hospital();
		Doctor evilDoctor = new Doctor("666", walkingDeadHospital);
		Doctor niceDoctor = new Doctor("777", walkingDeadHospital);
		walkingDeadHospital.add(evilDoctor);
		walkingDeadHospital.add(niceDoctor);
		walkingDeadHospital.add(new Patient());
		walkingDeadHospital.add(new Patient());
		walkingDeadHospital.add(new Patient());
		walkingDeadHospital.add(new Patient());
		walkingDeadHospital.add(new Patient());
		walkingDeadHospital.assignPatientsToDoctors();
		walkingDeadHospital.makeDoctorsWork();

		assertEquals(3, walkingDeadHospital.getZombies().size());
		assertEquals(2, walkingDeadHospital.getPatients().size());
	}



}

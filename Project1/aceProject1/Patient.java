package aceProject1;

import java.util.ArrayList;

public class Patient implements PatientADT {
	private String patientName;
	private String id;
	private int totalACE;
	private ArrayList<String> patientACE;

	public Patient() {
		totalACE = 0;
		patientACE = new ArrayList<String>();
	}

	public Patient(String id) {
		totalACE = 0;
		patientACE = new ArrayList<String>();
		setId(id);
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setId(String id, String name) {
		setId(id);
		setName(name);
	}

	public String getId() {
		return id;
	}

	public void setName(String id) {
		patientName = id;
	}

	public String getName() {
		return patientName;
	}

	public void addACE(String ace) {
		if (totalACE == 0 || patientACE.indexOf(ace) == -1) {
			patientACE.add(ace);
			totalACE++;
		}

	}

	public void removeACE(String ace) {
		if (patientACE.indexOf(ace) > -1) {
			patientACE.remove(ace);
			totalACE--;
		}

	}

	public ArrayList<String> getACEs() {
		ArrayList<String> holder = new ArrayList<String>();
		holder = patientACE;
		return holder;
	}

	public boolean equals(Object rhs) { // test for equality
		return id.contentEquals(((Patient) rhs).getId());
	}

	public String toString() {
		String toReturn = "[Patient: " + patientName + " ID: " + id + " Recorded ACE's: " + totalACE + "]\n";
		int i = 1;
		for (String obj : patientACE) {
			toReturn += i + ": " + obj + "\n";
			i++;
		}
		toReturn += "_______________________________________";
		return toReturn;
	}

}

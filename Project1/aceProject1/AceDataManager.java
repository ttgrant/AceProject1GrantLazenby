package aceProject1;

import java.util.ArrayList;

public class AceDataManager  implements AceDataManagerADT{
	private int totalACEPatients;
	private ArrayList<Patient> AcePatientsList = new ArrayList<Patient>();

	@Override
	public void addPatient(PatientADT p) {
		if(totalACEPatients < 0)
		{
			totalACEPatients = 0;
		}
		AcePatientsList.add((Patient) p);
		totalACEPatients++;
	}

	@Override
	public PatientADT getPatient(String id) {
		int index2 = AcePatientsList.indexOf(new Patient (id));
		if (index2 > -1) {
			Patient searched = AcePatientsList.get(index2);
			return searched;
		}
		else
			return null;

	}

	@Override
	public ArrayList<String> getRiskFactors(ArrayList<String> aces) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeToFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeToFile(String fn) {
		// TODO Auto-generated method stub
		
	}

}

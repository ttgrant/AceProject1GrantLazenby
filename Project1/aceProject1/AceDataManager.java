package aceProject1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

public class AceDataManager  implements AceDataManagerADT{
	private int totalACEPatients;
	private ArrayList<Patient> AcePatientsList = new ArrayList<Patient>();
	private String defualtFile = "./aceProject1/PatientFile";

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
		ArrayList<String> riskFactors = new ArrayList<String>();
		if (aces.size() == 1 )
		{
			riskFactors.add("Alchohalism");
		}
		else if (aces.size() == 2 ) {
			riskFactors.add("Alchohalism");
			riskFactors.add("Depression");
		}
		else if (aces.size() == 3 ) {
			riskFactors.add("Alchohalism");
			riskFactors.add("Depression");
			riskFactors.add("drug abuse");
		}
		else if (aces.size() == 4 ) {
			riskFactors.add("Alchohalism");
			riskFactors.add("Depression");
			riskFactors.add("drug abuse");
			riskFactors.add("promiscuity");
			riskFactors.add("chronic lung disease");
			riskFactors.add("cancer");
			
		}
		else if (aces.size() >= 5) {
			riskFactors.add("Alchohalism");
			riskFactors.add("Depression");
			riskFactors.add("drug abuse");
			riskFactors.add("promiscuity");
			riskFactors.add("heart disease");
			riskFactors.add("chronic lung disease");
			riskFactors.add("cancer");
			riskFactors.add("emphysema");
			riskFactors.add("shortened lifespan");
			riskFactors.add("stroke");
			riskFactors.add("diabetes");
		
			
		}
		return riskFactors;
	}

	@Override
	public void writeToFile()  {
		try
		{

			FileWriter fw = new FileWriter(defualtFile);
			BufferedWriter myOutfile = new BufferedWriter(fw);			
			
			for (Patient patient : AcePatientsList) { 
				Patient pat = patient;
				
					myOutfile.write ("Patient: ");
					myOutfile.write (pat.getName()+"\n");
					myOutfile.write ("Patient ID: " + pat.getId()+"\n");
					ArrayList<String> ace = pat.getACEs();
						for (String string : ace) {
							myOutfile.write (string + ", ");
						}
					myOutfile.write("\n\n");
			}
			myOutfile.flush();
			myOutfile.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Didn't save to " + defualtFile);
		}
	}
	
	

	@Override
	public void writeToFile(String fn) {
		// TODO Auto-generated method stub
		
		try
		{

			FileWriter fw = new FileWriter(fn);
			BufferedWriter myOutfile = new BufferedWriter(fw);			
			
			for (Patient patient : AcePatientsList) { 
				Patient pat = patient;
				
					myOutfile.write ("Patient: ");
					myOutfile.write (pat.getName()+"\n");
					myOutfile.write ("Patient ID: " + pat.getId()+"\n");
					ArrayList<String> ace = pat.getACEs();
						for (String string : ace) {
							myOutfile.write (string + ", ");
						}
					myOutfile.write("\n\n");
			}
			myOutfile.flush();
			myOutfile.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Didn't save to " + fn);
		}
	}

	public String toString()
	{
		String toReturn = null;
		for (Patient patient : AcePatientsList) {
			toReturn = patient.toString();
		}
		
		return toReturn;
	}


}

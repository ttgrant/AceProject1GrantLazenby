package aceProject1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class AceDataManager implements AceDataManagerADT {
	private int totalACEPatients;
	private ArrayList<Patient> AcePatientsList;
	private String defualtFile = "./aceProject1/PatientFile";
	
	
	public AceDataManager()
	{
		totalACEPatients = 0;
		AcePatientsList =  new ArrayList<Patient>();
		ReadFromFile();
	}

	public void addPatient(PatientADT p) {
		int index2 = AcePatientsList.indexOf(new Patient(p.getId()));
		if (index2 == -1) {
			AcePatientsList.add((Patient) p);
			totalACEPatients++;
		}

	}

	public PatientADT getPatient(String id) {
		int index2 = AcePatientsList.indexOf(new Patient(id));
		if (index2 > -1) {
			Patient searched = AcePatientsList.get(index2);
			return searched;
		} else
			return null;

	}

	public ArrayList<String> getRiskFactors(ArrayList<String> aces) {
		ArrayList<String> riskFactors = new ArrayList<String>();
		if (aces.size() >= 1) {
			riskFactors.add("Alchohalism");
			if (aces.size() >= 2) {
				riskFactors.add("Depression");
				if (aces.size() >= 3) {
					riskFactors.add("drug abuse");
					if (aces.size() >= 4) {
						riskFactors.add("drug abuse");
						riskFactors.add("promiscuity");
						riskFactors.add("chronic lung disease");
						riskFactors.add("cancer");
						if (aces.size() >= 5) {
							riskFactors.add("emphysema");
							riskFactors.add("shortened lifespan");
							riskFactors.add("stroke");
							riskFactors.add("diabetes");
						}
					}
				}
			}
		}

		return riskFactors;
	}

	@Override
	public void writeToFile() {
		try {

			FileWriter fw = new FileWriter(defualtFile);
			BufferedWriter myOutfile = new BufferedWriter(fw);

			for (Patient patient : AcePatientsList) {
				Patient pat = patient;

				myOutfile.write(pat.getName() + "\n");
				myOutfile.write(pat.getId() + "\n");
				ArrayList<String> ace = pat.getACEs();
				for (String string : ace) {
					myOutfile.write(string + ",");
				}
				myOutfile.write("\n\n");
			}
			myOutfile.flush();
			myOutfile.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Didn't save to " + defualtFile);
		}
	}

	public void writeToFile(String fn) {

		try {

			FileWriter fw = new FileWriter(fn);
			BufferedWriter myOutfile = new BufferedWriter(fw);

			for (Patient patient : AcePatientsList) {
				Patient pat = patient;

				myOutfile.write(pat.getName() + "\n");
				myOutfile.write(pat.getId() + "\n");
				ArrayList<String> ace = pat.getACEs();
				for (String string : ace) {
					myOutfile.write(string + ",");
				}
				myOutfile.write("\n\n");
			}
			myOutfile.flush();
			myOutfile.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Didn't save to " + fn);
		}
	}

	public String toString() {
		String toReturn = " ";
		for (Patient patient : AcePatientsList) {
			toReturn += patient.toString() + "\n";
		}

		return toReturn;
	}

	public void ReadFromFile() {

		// private method that reads the file and stores into people array
		BufferedReader lineReader = null;

		try {

			lineReader = new BufferedReader(
					new InputStreamReader(new FileInputStream(defualtFile), Charset.forName("UTF-8")));

			String line = null;
			while ((line = lineReader.readLine()) != null) {
				if (!line.equals("")) {
					String id = lineReader.readLine();
					String ace = lineReader.readLine();
					PatientADT holder = new Patient();
					holder.setId(id);
					holder.setName(line);

					String[] arrOfStr = ace.split(",");
					for (String string : arrOfStr) {
						holder.addACE(string);
					}

					addPatient(holder);
				}

			}
		} catch (Exception e) {
			System.err.println("there was a problem with the file.  either no such file or format error");
		} finally {
			if (lineReader != null)
				try {
					lineReader.close();
				} catch (IOException e) {
					System.err.println("could not close BufferedReader");
				}
		}
	}

}

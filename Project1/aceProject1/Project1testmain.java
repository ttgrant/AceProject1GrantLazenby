package aceProject1;

import java.util.ArrayList;

public class Project1testmain {

	public static void main(String[] args) {

		PatientADT p1 = new Patient();
		p1.setName("Grant Lazenby");
		p1.setId("1239");
		PatientADT p2 = new Patient();
		p2.setName("Katentlyn Lazenby");
		p2.setId("1238");
		PatientADT p3 = new Patient();
		p3.setName("teresa Lazenby");
		p3.setId("1237");

		p1.addACE("Physical abuse");
		p1.addACE("Sexual abuse");
		p1.addACE("Emotional abuse");
		p1.addACE("Physical neglect");
		p2.addACE("Physical neglect");
		p3.addACE("Physical neglect");
		p1.addACE("Emotional neglect");
		p3.addACE("Emotional neglect");
		p3.addACE("Exposure to domestic violence");
		p1.addACE("Exposure to domestic violence");
		System.out.println(p1);
		p1.addACE("Exposure to domestic violence");
		System.out.println(p1);
		p1.removeACE("Sexual abuse");
		System.out.println(p1);
		System.out.println(p1.getName());
		System.out.println(p1.getId());

		AceDataManager PM1 = new AceDataManager();
		PM1.addPatient(p1);
		PM1.addPatient(p2);
		PM1.addPatient(p3);

		PM1.writeToFile("./aceProject1/PatientFile");

		System.out.println(PM1);
		System.out.println(PM1.getRiskFactors(p1.getACEs()));
		System.out.println(PM1.getRiskFactors(p2.getACEs()));
		System.out.println(PM1.getRiskFactors(p3.getACEs()));
		System.out.println(PM1);

		// PM1.ReadFromFile();

		PM1.ReadFromFile();
		System.out.println("after Read" + PM1);

	}

}

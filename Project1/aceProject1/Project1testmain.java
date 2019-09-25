package aceProject1;

public class Project1testmain {

	public static void main(String[] args) {
		
		Patient p1 = new Patient();
		p1.setId("yeeter", "Grant Lazenby");
		
		p1.addACE("Physical abuse");
		p1.addACE("Sexual abuse");
		p1.addACE("Emotional abuse");
		p1.addACE("Physical neglect");
		p1.addACE("Emotional neglect");
		p1.addACE("Exposure to domestic violence");
		System.out.println(p1);
		p1.addACE("Exposure to domestic violence");
		System.out.println(p1);
		p1.removeACE("Sexual abuse");
		System.out.println(p1);
		System.out.println(p1.getName());
		System.out.println(p1.getId());
		
		
		
		
		
		
		

	}

}

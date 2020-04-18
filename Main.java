public class Main{
	public static void main (String[] args){
		Module cs200 = new Module("CS200","CS200","Leigh",1);
		Module cs210 = new Module("CS210","CS210","Leigh",2);
		Student screbz = new Student("Screbz","988");
		Student screbz1 = new Student("Screbz1","9881");
		Student screbz2 = new Student("Screbz2","9881");
		screbz.modulesToJoin.add(cs200);
		screbz.modulesToSwitch.add(cs200);
		screbz.modulesToSwitch.add(cs210);
		screbz2.modulesToJoin.add(cs210);
		screbz1.modulesToJoin.add(cs210);
		screbz1.modulesToSwitch.add(cs210);
		screbz1.modulesToSwitch.add(cs200);
		Thread s1 = new Thread(screbz);
		Thread s2 = new Thread(screbz1);
		Thread s3 = new Thread(screbz2);
		// Thread s3 = new Thread(screbz2);
		// Thread s4 = new Thread(screbz3);
		try{
			s1.start();
			// Thread.sleep(1000);
			s3.start();
			s2.start();
			// Thread.sleep(1000);
			//s3.start();
			// Thread.sleep(1000);
			//s4.start();
			// Thread.sleep(1000);
			// cs200.printEnrolledStudents();
			// cs200.printEnrolledStudents();
			// cs210.printEnrolledStudents();
			s1.join();
			s2.join();
			// s3.join();
			// s4.join();
		}catch(Exception ex){
			System.out.println(ex + "main");
		}
	}
}

//	public Module (String name, String moduleCode, String moduleCoordinator){

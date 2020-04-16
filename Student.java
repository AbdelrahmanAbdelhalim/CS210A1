import java.util.ArrayList;
public class Student implements Runnable{
	private String name;
	private String studentID;
	private int numOfModulesEnrolled;
	private ArrayList<Module> modules = new ArrayList<>();
	ArrayList<Module> modulesToJoin = new ArrayList<>(); //this arraylist is used for purposes of testing
	private boolean online = true;
	

	public Student(String name, String studentID){
		this.name = name;
		this.studentID = studentID;
	}
	public void enroll(Module module){
		try{
			if(!module.alreadyEnrolled(this) && module.canEnroll(this)){
			module.addStudent(this);
			this.notify();
			modules.add(module);
			System.out.println("Student " + name + " Successfully Enrolled in module: " + module.getModuleId());
			}else{
				// while(!module.canEnroll(this)){
				// 	try{
				// 		this.wait();
				// 	}catch(Exception ex){
				// 		System.out.println(ex + "student");
				// 	}
				// }
			}
		}catch(Exception ex){
			System.out.println(ex + studentID);
		}
	}
	public void withdraw(Module module){
		for(Module md : modules){
			if(module.equals(md)){

			}
		}
	}

	public String getStudentId(){
		return studentID;
	}

	public void run(){
		for(Module module: modulesToJoin){
			enroll(module);
		}
	}
}
/*
modules can enroll
change their minds
number of modules can not exceed the limit of modules a student can enroll in
can't enroll on the same module twice.
states for moduels enrolled (mysterious thoughts)
*/
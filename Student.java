import java.util.ArrayList;
public class Student implements Runnable{
	private String name;
	private String studentID;
	private int numOfModulesEnrolled;
	private ArrayList<Module> modules = new ArrayList<>();
	ArrayList<Module> modulesToJoin = new ArrayList<>(); //this arraylist is used for purposes of testing
	ArrayList<Module> modulesToLeave = new ArrayList<>();
	ArrayList<Module> modulesToSwitch = new ArrayList<>();
	private boolean online = true;
	

	public Student(String name, String studentID){
		this.name = name;
		this.studentID = studentID;
	}
	public void enroll(Module module){
		try{
			if(!module.alreadyEnrolled(this)){
				module.addStudent(this);
				modules.add(module);
				System.out.println("Student " + name + " Successfully Enrolled in module: " + module.getModuleId());
			}
		}catch(Exception ex){
			System.out.println(ex + studentID);
		}	
	}
	public void enroll(Module moduleToGo, Module moduleToLeave){
		try{
			if(!moduleToGo.alreadyEnrolled(this)){
				if (moduleToGo.moduleHasSpace()){
					withdraw(moduleToLeave);
					enroll(moduleToGo);
				}else{
					boolean conflictResolved = false;
					moduleToGo.addToWaitingList(this);
					conflictResolved = moduleToGo.crossCheckCurrentStudentsWithWaitingList(moduleToLeave);
					moduleToLeave.removeStudent(this);
					enroll(moduleToGo);
				}
			}
		}catch(Exception ex){
			System.out.println(ex + studentID);
		}	
	}
	public void withdraw(Module module){
		for(Module md : modules){
			if(module.equals(md)){
				module.removeStudent(this);
				System.out.println("Student " + name + " Left the module " + module.getModuleId());
			}
		}
	}
	public void switchModules(Module moduleToLeave, Module moduleToGo){
		enroll(moduleToGo,moduleToLeave);
	}

	public String getStudentId(){
		return studentID;
	}

	public void run(){
		for(Module module: modulesToJoin){
			enroll(module);
		}
		for(Module module : modulesToLeave){
			withdraw(module);
		}
		if(modulesToSwitch.size() > 0){
			Module m1 = modulesToSwitch.get(0);
			Module m2 = modulesToSwitch.get(1);
			switchModules(m1,m2);
		}
	}
}

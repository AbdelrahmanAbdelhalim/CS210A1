import java.util.concurrent.CopyOnWriteArrayList; 
import java.util.*; 

public class Module{
	private String name;
	private int capacity;
	private String moduleCode;
	private String moduleCoordinator;
	private CopyOnWriteArrayList<Student> currentStudents = new CopyOnWriteArrayList<Student>(); // to prevent the same student from enrolling twice
	private CopyOnWriteArrayList<Student> waitingList = new CopyOnWriteArrayList<Student>();
	private CopyOnWriteArrayList<Student> leavingList = new CopyOnWriteArrayList<Student>();

	/*
	total number of students ina module can not exceed its capacity
	passive process
	*/
	public Module (String name, String moduleCode, String moduleCoordinator, int capacity){
		this.name = name;
		this.moduleCode = moduleCode;
		this.moduleCoordinator = moduleCoordinator;
		this.capacity = capacity;
	}
	public  boolean alreadyEnrolled(Student student){
		for(Student s : currentStudents){
			if(student.equals(s)){
				String studentId = student.getStudentId();
				System.out.println("Studnt("+ studentId + ") is already enrolled");
				return true;
			}
		}
		return false;
	}

	public synchronized void addStudent(Student student){
		try{
			while(currentStudents.size() >= capacity){
				waitingList.add(student);
				wait();
			}
			currentStudents.add(student);
			notifyAll();
		}catch(Exception ex){
				System.out.println(ex + " add Module");
		}
	}
	public synchronized void addStudent(Student student, Module moduleToSwitchWith){
		Student temp = null;
		try{
			boolean conflictResolved = false;
			waitingList.add(student);
			System.out.println("Student " + student.getStudentId() + " is waiting for module " + moduleCode);
			for(Student st : currentStudents){
				if(moduleToSwitchWith.isWaitingForThisModule(st)){
					temp = st;
					conflictResolved = true;
					waitingList.remove(st);
					this.removeStudent(temp);
				}
			}	
			while(currentStudents.size() >= capacity & !conflictResolved){
				wait();
			}
			notifyAll();
		}catch(Exception ex){
				System.out.println(ex + " " + student.getStudentId());
		}
	}

	public void removeStudent(Student student){
		try{
			for(Student st : currentStudents){
				if(student.equals(st)){
					currentStudents.remove(student);
				}
			}
		}catch(Exception exc){

		}
	}
	public boolean isWaitingForThisModule(Student student){
		for (Student st : waitingList){
			if(st.equals(student)){
				return true;
			}
		}
		return false;
	}
	public void printEnrolledStudents(){
		for(Student st : currentStudents){
			System.out.println(st.getStudentId());
		}
	}
	public String getModuleId(){
		return moduleCode;
	}
	public boolean equals(Module module){
		if(this.moduleCode == module.moduleCode){
			return true;
		}
		return false;
	}
}
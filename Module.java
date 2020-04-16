import java.util.ArrayList;
public class Module{
	private String name;
	private int capacity;
	private String moduleCode;
	private String moduleCoordinator;
	private ArrayList<Student> currentStudents = new ArrayList<Student>(); // to prevent the same student from enrolling twice
	private ArrayList<Student> waitingList = new ArrayList<Student>();

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
	public  boolean canEnroll (Student student){
		if(currentStudents.size() < capacity){
			return true;
		}
		System.out.println("Module " + name + " is full at the moment");
		waitingList.add(student);
		return false;
	}
	public  void addStudent(Student student){
		currentStudents.add(student);
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
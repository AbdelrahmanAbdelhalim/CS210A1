import java.util.ArrayList;
public class Module{
	String name;
	int capacity;
	String moduleCode;
	String moduleCoordinator;
	ArrayList<Student> currentStudents = new ArrayList<Student>(); // to prevent the same student from enrolling twice
	ArrayList<Student> waitingList = new ArrayList<Student>();

	/*
	total number of students ina module can not exceed its capacity
	passive process
	*/
	public boolean alreadyEnrolled(Student student){
		for(Student s : currentStudents){
			if(student.equals(s)){
				System.out.println("Studnt("student.getStudentId()") is already enrolled")
				return true;
			}
		}
		return false;
	}
	public boolean canEnroll (){
		return currentStudents.size() < capacity;
	}
	public void enroll(Student student){
		if(!alreadyEnrolled(student) && canEnroll()){
			currentStudents.add(student);
		}	
	}

	public boolean equals(Module module){
		if(this.moduleCode == module.moduleCode){
			return true;
		}
		return false;
	}
}
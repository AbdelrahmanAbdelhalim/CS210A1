import java.util.ArrayList;
public class Student implements Runnable{
	String name;
	String studentID;
	int numOfModulesEnrolled;
	ArrayList<Module> Modules = new ArrayList<>();

	public void run(){
		
	}
}
/*
modules can enroll
change their minds
number of modules can not exceed the limit of modules a student can enroll in
can't enroll on the same module twice.
states for moduels enrolled (mysterious thoughts)
*/
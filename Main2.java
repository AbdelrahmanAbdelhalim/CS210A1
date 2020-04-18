public class Main2{
	public static void main(String[]args){
		Module cs200 = new Module("CS200","CS200","Leigh",1);
		Module cs210 = new Module("CS210","CS210","Leigh",1);
		Student screbz = new Student("Screbz","988");
		screbz.modulesToSwitch.add(cs200);
		screbz.modulesToSwitch.add(cs210);
		screbz.modulesToJoin.add(cs200);
		Thread s1 = new Thread(screbz);
		try{
			s1.start();
		}catch(Exception ex){
			System.out.println(ex + "");
		}
	}
}

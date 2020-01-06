package trail.jgui.awt;

public class RuntimeTest {
	public static void main(String[] args) {
		Runtime run = Runtime.getRuntime();
		Process p = null;
		try{
			p = run.exec("notepad");
		}catch(Exception e){
			System.out.println("Error executing notepad");
		}

	}

}

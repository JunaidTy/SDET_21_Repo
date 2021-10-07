package practice;

public class S11 extends S10 
{
	public void lock()
	{
		System.out.println("calling lock");
	}
	public void camera()
	{
		System.out.println("camera 16 mp");
	}
	public static void main(String[] args) {
		Phone obj= new S11();
		obj.calling();
		obj.camera();
	}

}

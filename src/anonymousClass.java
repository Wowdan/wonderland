/*

*/

class Some{

	public void doSome(){
		class Other{
			void playSome(){
				System.out.println("Play Some....");
			}
		}
		Other b = new Other();
		b.playSome();
	}
		
}

public class anonymousClass{

	public static void main(String[] args){
	
		Some a = new Some();
		a.doSome();
		
		
		Some c = new Some(){
			@Override
			public void doSome(){
				System.out.println("Do Some Thing...");
			}	
		};
		c.doSome();
	}

}
package Demo8;
/*


*/

import Clothes.Pants;
import Human.*;
import Washer.Washer;

public class Demo8{

	public static void main(String[] args){
	
		doQuickWash(new Pants("Blue",1000));
	    doQuickWash(new Human("Peter"));
	}
	private static void doQuickWash(Pants pants) {
		// TODO Auto-generated method stub
		
	}
	static void doWash(Washer washers){
		washers.wash();
	}
	static void doQuickWash(Human human){
		human.quickWash();
	}
}

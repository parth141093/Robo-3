import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;

public class GoAhead {
	private static DataExchange DE; 
	private static MoveForward MFObj;
	private static ColourDetector CDObj; 
	private static ObstacleDetector ODObj;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DE = new DataExchange();
		ODObj = new ObstacleDetector(DE);
		CDObj = new ColourDetector(DE);
		MFObj = new MoveForward(DE); 
		
		ODObj.start();
		CDObj.start();
		MFObj.start();

		while(!Button.ESCAPE.isDown()){
		//Empty
		}
		
		LCD.drawString("Finished",0, 7); LCD.refresh();
		System.exit(0);
	}
}

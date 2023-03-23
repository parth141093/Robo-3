import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;

public class MoveForward extends Thread {
	DataExchange DEObj;

	private static EV3LargeRegulatedMotor leftWheel;
	private static EV3LargeRegulatedMotor rightWheel;

	public MoveForward(DataExchange DE) {
		DEObj = DE;
		leftWheel = new EV3LargeRegulatedMotor(MotorPort.A);
		rightWheel = new EV3LargeRegulatedMotor(MotorPort.D);

		leftWheel.setSpeed(200);
		rightWheel.setSpeed(200);
	}

	public void run() {
		// Infinite Task
		while (true) {
			if (!DEObj.getIsObstacleDetected() && !DEObj.getIsColourDetected()) {
				leftWheel.forward();
				rightWheel.forward();

			} else if (!DEObj.getIsObstacleDetected()) {
				if (!DEObj.getIsColourDetected()) {
					leftWheel.forward();
					rightWheel.forward();
				} else {
					leftWheel.stop();
					rightWheel.stop();

//					leftWheel.backward();
//					rightWheel.backward();



					leftWheel.setSpeed(200);;

				}
			} else {
				// Stop MotorPort.B.controlMotor(0, 3);
				leftWheel.stop();
				rightWheel.stop();
			}
		}
	}
}

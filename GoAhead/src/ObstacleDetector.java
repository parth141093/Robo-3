import lejos.hardware.Sound;
import lejos.hardware.lcd.LCD;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;

public class ObstacleDetector extends Thread {
	private DataExchange DEObj;

	private EV3UltrasonicSensor us;
	private final int securityDistance = 25;
	private static SampleProvider usDistance;
	private static float[] sample;
	
	public ObstacleDetector(DataExchange DE) {
		DEObj = DE;
		us = new EV3UltrasonicSensor(SensorPort.S1);
		
		usDistance = us.getDistanceMode();
		sample = new float[usDistance.sampleSize()];
	}

	public void run() {
		while (true) {
			usDistance.fetchSample(sample, 0);
			float distance = sample[0] * 100;
			if (distance > securityDistance) {
				DEObj.setIsObstacleDetected(false);
			} else {
				DEObj.setIsObstacleDetected(true);

				// LCD Output
				LCD.drawString("Object found!", 0, 1);
				LCD.refresh();
				Sound.twoBeeps();
				Sound.twoBeeps();
			}
		}
	}
}

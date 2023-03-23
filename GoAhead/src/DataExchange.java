
public class DataExchange {

	//Robot has the following commands: Follow Line, Stop
	private boolean isObstacleDetected = false;
	private boolean isColourDetected = false;
	/*
	* Getters & Setters
	*/
	public void setIsObstacleDetected(boolean command){ 
		isObstacleDetected  = command;
	}

	public boolean getIsObstacleDetected(){
		return isObstacleDetected;
	}

	public void setIsColourDetected(boolean command){ 
		isColourDetected  = command;
	}

	public boolean getIsColourDetected(){
		return isColourDetected;
	}
}

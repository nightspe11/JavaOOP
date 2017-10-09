package hw5;

public class Carrige {

	private boolean isLampOn;
	
	public Carrige (){
		this.isLampOn = (Math.random() < 0.5);
	}
		
	public boolean isLampOn(){
		return isLampOn;
	}
	
	public void changeLampStatus(){
		isLampOn = !isLampOn;
	}
}
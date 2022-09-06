package drawingGraphics.graphicState;

import drawingGraphics.Scene;

public class CloudState  extends State{

	private static CloudState instance;
	
	private CloudState(Scene context) {
		this.context = context;
		clouds=this;
	}
	
	public static CloudState getInstance(Scene context) {
		if(instance == null) {
			instance = new CloudState(context);
		}
		return instance;
	}	
	
	@Override
	public
	State drawVillage() {
		context.clear();
		context.addSomeHouses();
		context.addSomeCloud();
		context.addSomeLight();
		context.addBrokenLamp();
		return SceneState.getInstance(context);
	}

	@Override
	public State drawCloud() {
		context.clear();
		context.addSomeCloud();
		return this;
	}

	@Override
	public State drawHouses() {
		context.clear();
		context.addSomeHouses();
		return HouseState.getInstance(context);
	}

	@Override
	public State drawStreetLight() {
		context.clear();
		context.addSomeLight();
		context.addBrokenLamp();
		return StreetLightState.getInstance(context);
	}

	@Override
	public State drawLamps() {
		context.clear();
		context.addSomeLight();
		return LampsState.getInstance(context);
	}

	@Override
	public State drawBrokenLamps() {
		context.clear();
		context.addBrokenLamp();
		return BrokenLampsState.getInstance(context);
	}

}

package drawingGraphics.graphicState;

import drawingGraphics.Scene;

public class SceneState  extends State{

	public static SceneState instance;
	
	private SceneState(Scene context) {
		this.context = context;
		scene=this;
	}
	

	public static SceneState getInstance (Scene context) {
		if(instance ==null) {
			instance = new SceneState(context);
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
		return this;
	}

	@Override
	public State drawCloud() {
		context.clear();
		context.addSomeCloud();
		return CloudState.getInstance(context);
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

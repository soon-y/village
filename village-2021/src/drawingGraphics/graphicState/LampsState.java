package drawingGraphics.graphicState;

import drawingGraphics.Scene;

public class LampsState extends State{
	
	public static LampsState instance;
	
	private LampsState(Scene context) {
		this.context = context;
		lamps=this;
	}
	
	public static LampsState getInstance(Scene context) {
		if(instance == null) {
			instance = new LampsState(context);
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
		return this;
	}

	@Override
	public State drawBrokenLamps() {
		context.clear();
		context.addBrokenLamp();
		return BrokenLampsState.getInstance(context);
	}

}

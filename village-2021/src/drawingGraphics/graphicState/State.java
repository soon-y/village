package drawingGraphics.graphicState;

import drawingGraphics.DrawingTool;
import drawingGraphics.Scene;

public abstract class State{

	protected Scene context;

	protected static SceneState scene;
	protected static HouseState houses;
	protected static CloudState clouds;
	protected static StreetLightState streetLights;
	protected static LampsState lamps;
	protected static BrokenLampsState brokenLamps;

	public abstract State drawVillage();

	public abstract State drawCloud();

	public abstract State drawHouses();

	public abstract State drawStreetLight();	

	public abstract State drawLamps();	

	public abstract State drawBrokenLamps();

}
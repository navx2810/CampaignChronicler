package abstracts;

import app.ScreenController;

public abstract class AbstractViewController {

	public ScreenController screenController;
	
	public void setScreenController(ScreenController screenController) {
		this.screenController = screenController;
	}

	abstract public void init();
	
}

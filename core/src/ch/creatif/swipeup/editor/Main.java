package ch.creatif.swipeup.editor;

import com.badlogic.gdx.Game;

public class Main extends Game {
	
	@Override
	public void create () {
		AssetHelper as = new AssetHelper();
		setScreen(new Editor());
	}

	@Override
	public void render () {
		super.render();//Delegate the render-methode to the active screen
	}
	
	@Override
	public void dispose () {
	}
}

//ToDo
//tiles only rendering correct when maximum
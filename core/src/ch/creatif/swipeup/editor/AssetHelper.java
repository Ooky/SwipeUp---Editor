package ch.creatif.swipeup.editor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class AssetHelper {

	private static Texture texture = new Texture("Tiles/defaultTile.png");
	private static TextureRegion textureRegion = new TextureRegion(texture, 0, 0, 4, 4);
	public static Image tiles = new Image(textureRegion);

}

package ch.creatif.swipeup.editor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import java.util.ArrayList;

public class AssetHelper {

	private static Texture texture = new Texture("Tiles/tiles.png");
	private static TextureRegion textureRegion = new TextureRegion(texture, 0, 0, Constants.TILE_SIZE, Constants.TILE_SIZE);
	public static Image tiles = new Image(textureRegion);

	private ArrayList<Image> allTiles = new ArrayList<Image>();

	public AssetHelper() {
		//Fill Array
		for (int i = 0; i < 10; i++) {//Number of tiles column in tiles.png
			for (int j = 0; j < 3; j++) {
				allTiles.add(new Image(new TextureRegion(texture, j * Constants.TILE_SIZE, i * Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE)));
			}
		}

	}

	public ArrayList<Image> getAllTiles() {
		return this.allTiles;
	}

}

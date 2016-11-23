package ch.creatif.swipeup.editor;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetHelper {

	private final Texture texture = new Texture("Tiles/tiles.png");
	public final int numberOfColumnTiles = 10;
	public final int numberOfRowTiles = 3;

	private TextureRegion[][] allTextureRegions = new TextureRegion[10][3];

	public AssetHelper() {
		for (int i = 0; i < numberOfColumnTiles; i++) {
			for (int j = 0; j < numberOfRowTiles; j++) {
				allTextureRegions[i][j] = new TextureRegion(texture, j * Constants.TILE_SIZE, i * Constants.TILE_SIZE, Constants.TILE_SIZE, Constants.TILE_SIZE);
			}
		}
	}

	public TextureRegion[][] getAllTextureRegions() {
		return allTextureRegions;
	}

}

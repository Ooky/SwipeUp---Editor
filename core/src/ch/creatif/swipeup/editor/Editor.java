package ch.creatif.swipeup.editor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;

/**
 *
 * @author Creat-if
 */
public class Editor implements Screen {

	//Stage
	private Stage stage = new Stage();
	//Tables
	private Table tableLeft = new Table();
	//Buttons
	private TextButton newFile;
	private TextButton loadFile;
	private TextButton saveFile;
	private TextButtonStyle buttonBlueStyle;
	private TextButtonStyle buttonGreenStyle;
	//Font
	private BitmapFont font = new BitmapFont();
	//Skin
	private Skin skin = new Skin();
	//TextureAtlas
	private final TextureAtlas buttonAtlas = new TextureAtlas(Gdx.files.internal("Buttons/pack.atlas"));
	//ShapeRenderer
	ShapeRenderer shapeRenderer = new ShapeRenderer();
	//Tiles
	private float tileSectionWidth;
	private float tileSectionHeight;
	private float tileSide;
	private AssetHelper assetHelper = new AssetHelper();
	private Image[][] defaultGrid = new Image[Constants.NUMBER_OF_TILES_COLUMN][Constants.NUMBER_OF_TILES_ROW];

	public Editor() {
		//Skin
		skin.addRegions(buttonAtlas);

		generateButtonStyle();

		//Buttons
		newFile = new TextButton("Neu", buttonBlueStyle);
		loadFile = new TextButton("Laden", buttonBlueStyle);
		saveFile = new TextButton("Speichern unter...", buttonGreenStyle);
		//Stage
		Gdx.input.setInputProcessor(stage);
		//TableLeft
		tableLeft.setFillParent(true);//size rootTable to stage, only rootTable!
		tableLeft.left().top();
		tableLeft.add(newFile).width(0.1f * Constants.WINDOW_WIDTH).height(0.04f * Constants.WINDOW_WIDTH);
		tableLeft.add(loadFile).width(0.1f * Constants.WINDOW_WIDTH).height(0.04f * Constants.WINDOW_WIDTH);
		tableLeft.row();
		tableLeft.add(saveFile).width(0.2f * Constants.WINDOW_WIDTH).height(0.04f * Constants.WINDOW_WIDTH).expandY().bottom().colspan(2).right();
		stage.addActor(tableLeft);

		//MiddleField
		defineTileSide();
		drawDefaultGrid();

		//tableRenderer
		tableLeft.setDebug(true);
	}

	private void defineTileSide() {
		tileSectionWidth = (float) Constants.WINDOW_WIDTH * 0.38f;//Available width
		tileSectionHeight = (float) Constants.WINDOW_HEIGTH * 0.98f;//Available height
		if ((tileSectionWidth / Constants.NUMBER_OF_TILES_ROW) > (tileSectionHeight / Constants.NUMBER_OF_TILES_COLUMN)) {
			tileSide = (tileSectionHeight / Constants.NUMBER_OF_TILES_COLUMN);
		} else {
			tileSide = (tileSectionWidth / Constants.NUMBER_OF_TILES_ROW);
		}
	}

	private void drawDefaultGrid() {
		for (int i = 0; i < Constants.NUMBER_OF_TILES_COLUMN; i++) {
			for (int j = 0; j < Constants.NUMBER_OF_TILES_ROW; j++) {
				defaultGrid[i][j] = new Image(assetHelper.getAllTextureRegions()[0][0]);
				defaultGrid[i][j].setX(Constants.WINDOW_WIDTH * 0.21f + (j * tileSide));
				defaultGrid[i][j].setY(Constants.WINDOW_HEIGTH * 0.99f - tileSide - (i * tileSide));
				defaultGrid[i][j].setScale(tileSide / Constants.TILE_SIZE, tileSide / Constants.TILE_SIZE);
				stage.addActor(defaultGrid[i][j]);
			}
		}
	}

	private void generateButtonStyle() {
		//ButtonStyle Blue
		buttonBlueStyle = new TextButtonStyle();
		buttonBlueStyle.font = font;
		buttonBlueStyle.up = skin.getDrawable("Blue");
		buttonBlueStyle.down = skin.getDrawable("Grey");
		//ButtonStyle Green
		buttonGreenStyle = new TextButtonStyle();
		buttonGreenStyle.font = font;
		buttonGreenStyle.up = skin.getDrawable("Green");
		buttonGreenStyle.down = skin.getDrawable("Grey");
	}

	@Override
	public void render(float f) {
		Gdx.gl.glClearColor(42 / 255f, 47 / 255f, 48 / 255f, 1);//0-1, Float.
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.getCamera().update();
		stage.act(Gdx.graphics.getDeltaTime());

		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		//Sets WindowSize
		Constants.setWINDOW_WIDTH(Gdx.graphics.getWidth());
		Constants.setWINDOW_HEIGTH(Gdx.graphics.getHeight());
		//update stage
		stage.getViewport().update(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGTH, true);
		//Updats of Values5
//		defineTileSide();
//
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void dispose() {
		stage.dispose();
	}

	@Override
	public void show() {
	}

}

package ch.creatif.swipeup.editor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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
	private float tileSide;
	
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

		tableLeft.setDebug(true);
		
		tileSide = (((float) Constants.WINDOW_WIDTH) / (100f / 2.375f));
		
		AssetHelper.tiles.setX(Constants.WINDOW_WIDTH * 0.21f);
		AssetHelper.tiles.setY(Constants.WINDOW_HEIGTH * 0.99f - tileSide);
		AssetHelper.tiles.setWidth(tileSide);
		AssetHelper.tiles.setHeight(tileSide);
		
		stage.addActor(AssetHelper.tiles);
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
	public void show() {
	}

	@Override
	public void render(float f) {
		Gdx.gl.glClearColor(42 / 255f, 47 / 255f, 48 / 255f, 1);//0-1, Float.
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		
		
//		tileSide = (((float) Constants.WINDOW_WIDTH) / (100f / 2.375f));

//		shapeRenderer.setColor(new Color(Color.WHITE));
//		shapeRenderer.setProjectionMatrix(stage.getCamera().combined);
//		shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
//		shapeRenderer.rect((Constants.WINDOW_WIDTH * 0.21f), (Constants.WINDOW_HEIGTH * 0.99f - tileSide), tileSide, tileSide);
////		System.out.println("Tileside: " +tileSide);
////		System.out.println("Gerechnet: " +Constants.WINDOW_WIDTH*0.21f);
////		System.out.println("Width: "+Constants.WINDOW_WIDTH);
//		shapeRenderer.end();

		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		//Sets WindowSize
		Constants.setWINDOW_WIDTH(Gdx.graphics.getWidth());
		Constants.setWINDOW_HEIGTH(Gdx.graphics.getHeight());
		//update stage
		stage.getViewport().update(Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGTH, true);
//		//Center cam, shaperenderer shit
//		stage.getCamera().viewportWidth = width;
//		stage.getCamera().viewportHeight = height;
//		stage.getCamera().position.set(width / 2f, height / 2f, 0);
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

}

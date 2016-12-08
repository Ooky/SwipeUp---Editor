package ch.creatif.swipeup.editor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import java.awt.EventQueue;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Creat-if
 */
public class LoadArrayFromFile {

	private JFileChooser chooser;
	private FileNameExtensionFilter filter;
	private int returnVal = 0;
	private String filePath = "";
	private AssetHelper assetHelper = new AssetHelper();

	public void initFile() {
		chooser = new JFileChooser();
		filter = new FileNameExtensionFilter(".txt", "txt");
		chooser.setFileFilter(filter);
		chooser.addChoosableFileFilter(filter);
		returnVal = chooser.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			filePath = chooser.getSelectedFile().getAbsolutePath();
		}

	}

	public TextureRegion[][] loadFile() {
		if (!"".equals(filePath)) {
			return(loadFile(filePath));
		}
		else {
			return null;
		}
	}

	private TextureRegion[][] loadFile(String filePath) {
		this.filePath = filePath;
		FileHandle file = Gdx.files.absolute(this.filePath);
		String level = file.readString();
		//remove endlines
		level = level.replace("\n", "").replace("\r", "");

		TextureRegion[][] loadedGrid = new TextureRegion[Constants.NUMBER_OF_TILES_COLUMN][Constants.NUMBER_OF_TILES_ROW];

		Pattern p = Pattern.compile("\\[(.*?)\\]");
		Matcher m = p.matcher(level);
		ArrayList<String> obj = new ArrayList<String>();

		while (m.find()) {
			obj.add(m.group(1));
		}

		int gridValues[][] = new int[Constants.NUMBER_OF_TILES_COLUMN][Constants.NUMBER_OF_TILES_ROW];

		for (int i = 0; i < Constants.NUMBER_OF_TILES_COLUMN; i++) {//26
			for (int j = 0; j < Constants.NUMBER_OF_TILES_ROW; j++) {//16
				gridValues[i][j] = Integer.valueOf(obj.get(i * Constants.NUMBER_OF_TILES_ROW + j));
			}
		}
		for (int i = 0; i < Constants.NUMBER_OF_TILES_COLUMN; i++) {//26
			for (int j = 0; j < Constants.NUMBER_OF_TILES_ROW; j++) {//16
				if (gridValues[i][j] < 3) {
					loadedGrid[i][j] = assetHelper.getAllTextureRegions()[0][gridValues[i][j]];//[10][3]
				} else if (gridValues[i][j] < 6) {
					loadedGrid[i][j] = assetHelper.getAllTextureRegions()[1][gridValues[i][j] - 3];
				} else if (gridValues[i][j] < 9) {
					loadedGrid[i][j] = assetHelper.getAllTextureRegions()[2][gridValues[i][j] - 6];
				} else if (gridValues[i][j] < 12) {
					loadedGrid[i][j] = assetHelper.getAllTextureRegions()[3][gridValues[i][j] - 9];
				} else if (gridValues[i][j] < 15) {
					loadedGrid[i][j] = assetHelper.getAllTextureRegions()[4][gridValues[i][j] - 12];
				} else if (gridValues[i][j] < 18) {
					loadedGrid[i][j] = assetHelper.getAllTextureRegions()[5][gridValues[i][j] - 15];
				} else if (gridValues[i][j] < 21) {
					loadedGrid[i][j] = assetHelper.getAllTextureRegions()[6][gridValues[i][j] - 18];
				} else if (gridValues[i][j] < 24) {
					loadedGrid[i][j] = assetHelper.getAllTextureRegions()[7][gridValues[i][j] - 21];
				} else if (gridValues[i][j] < 27) {
					loadedGrid[i][j] = assetHelper.getAllTextureRegions()[8][gridValues[i][j] - 24];
				} else if (gridValues[i][j] < 30) {
					loadedGrid[i][j] = assetHelper.getAllTextureRegions()[9][gridValues[i][j] - 27];
				}

			}
		}

		return loadedGrid;
	}

}

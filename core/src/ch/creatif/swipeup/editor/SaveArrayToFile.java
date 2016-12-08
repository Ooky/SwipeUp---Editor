package ch.creatif.swipeup.editor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Creat-if
 */
public class SaveArrayToFile {

	private JFileChooser chooser;
	private FileNameExtensionFilter filter;
	private int returnVal = 0;
	private String filePath = "";

	public void initFile() {
		chooser = new JFileChooser();
		filter = new FileNameExtensionFilter(".txt", "txt");
		chooser.setFileFilter(filter);
		chooser.addChoosableFileFilter(filter);
		returnVal = chooser.showSaveDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			filePath = chooser.getSelectedFile().getAbsolutePath();
		}
	}

	public void saveFile(TextureRegion[][] actuallGrid) {
		if (!"".equals(filePath)) {
			FileHandle file = Gdx.files.absolute(addEndingIfNotWritten(this.filePath));
			file.writeString(arrayToString(actuallGrid), false);
		}
	}

	private String arrayToString(TextureRegion[][] actuallGrid) {
		String level = "";
		for (int i = 0; i < Constants.NUMBER_OF_TILES_COLUMN; i++) {//26
			for (int j = 0; j < Constants.NUMBER_OF_TILES_ROW; j++) {//16
				level += "[" + actuallGrid[i][j] + "]";
			}
			level += System.getProperty("line.separator");
		}
		return level;
	}

	private String addEndingIfNotWritten(String filePath) {
		String myFilePath = filePath;

		if (myFilePath.length() < 4) {
			myFilePath += ".txt";
		} else if (!".txt".equals(myFilePath.substring(myFilePath.length() - 4))) {
			myFilePath += ".txt";
		}
		return myFilePath;
	}

}

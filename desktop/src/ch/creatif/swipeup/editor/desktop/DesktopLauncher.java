package ch.creatif.swipeup.editor.desktop;

import ch.creatif.swipeup.editor.Constants;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ch.creatif.swipeup.editor.Main;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

/**
 *
 * @author Creat-if
 */
public class DesktopLauncher {

	public static void main(String[] arg) {
		LwjglApplicationConfiguration config;
		config = new LwjglApplicationConfiguration();

		config.width = Constants.WINDOW_WIDTH;
		config.height = Constants.WINDOW_HEIGTH;
		config.title = Constants.TITLE;
		config.resizable = false;
		config.addIcon(Constants.FAVICON, Files.FileType.Internal);
		new LwjglApplication(new Main(), config);

	}
}

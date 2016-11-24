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

		if (Constants.FULLSCREEN) {
//			Constants.setWINDOW_WIDTH(LwjglApplicationConfiguration.getDesktopDisplayMode().width);
//			Constants.setWINDOW_HEIGTH(LwjglApplicationConfiguration.getDesktopDisplayMode().height);
			config.fullscreen = true;

		}

		config.width = Constants.WINDOW_WIDTH;
		config.height = Constants.WINDOW_HEIGTH;
		config.title = Constants.TITLE;
		config.resizable = Constants.RESZIABLE;
		config.addIcon(Constants.FAVICON, Files.FileType.Internal);

		if (Constants.BORDERLESSWINDOW) {
			System.setProperty("org.lwjgl.opengl.Window.undecorated", "true");
		}

		new LwjglApplication(new Main(), config);
	}
}

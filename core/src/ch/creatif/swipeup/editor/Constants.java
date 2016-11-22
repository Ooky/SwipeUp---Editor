package ch.creatif.swipeup.editor;

/**
 *
 * @author Creat-if
 */
public class Constants {

//==============================================================================
//Desktoplauncher
//==============================================================================
	public static int WINDOW_WIDTH = 1283; // Fix for textureregions
	public static int WINDOW_HEIGTH = 724;
	public static final String TITLE = "SwipeUp! - Editor";
	public static final String FAVICON = "Graphics/Icon/Icon.png";
	public static final boolean FULLSCREEN = false;
	public static final boolean BORDERLESSWINDOW = false;
	public static final boolean RESZIABLE = true;

//==============================================================================
//Tiles
//==============================================================================
	public static int TILE_SIZE = 64;
	public static int NUMBER_OF_TILES_ROW=16;
	public static int NUMBER_OF_TILES_COLUMN=26;
//==============================================================================
//Setter
//==============================================================================	
	public static void setWINDOW_WIDTH(int WINDOW_WIDTH) {
		Constants.WINDOW_WIDTH = WINDOW_WIDTH;
	}

	public static void setWINDOW_HEIGTH(int WINDOW_HEIGTH) {
		Constants.WINDOW_HEIGTH = WINDOW_HEIGTH;
	}

}

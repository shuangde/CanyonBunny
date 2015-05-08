package com.packtpub.libgdx.canyonbunny;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2;
import com.badlogic.gdx.tools.imagepacker.TexturePacker2.Settings;

public class Main {
//	rebuildAtlas controls whether the atlas is rebuilt on startup or not by setting it to true or false .
	private static boolean rebuildAtlas = true;
	private static boolean drawDebugOutline = true;

	public static void main(String[] args) {
		if (rebuildAtlas) {
			Settings settings = new Settings();
//			The maxWidth and maxHeight variables of the Settings instance define the
//			maximum dimensions (in pixels) for the texture atlas. Always make sure that a single
//			subimage does not exceed the maximum size of the atlas either in width or height
//			or both dimensions.
			settings.maxWidth = 1024;
			settings.maxHeight = 1024;
//			The debug variable controls whether the debug lines should be added to the atlas or not.
			settings.debug = drawDebugOutline;
			TexturePacker2.process(settings, "assets-raw/images",
					"../CanyonBunny-android/assets/images", "canyonbunny.pack");
		}
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "CanyonBunny";
		cfg.useGL20 = false;
		cfg.width = 800;
		cfg.height = 480;

		new LwjglApplication(new CanyonBunnyMain(), cfg);
	}
}

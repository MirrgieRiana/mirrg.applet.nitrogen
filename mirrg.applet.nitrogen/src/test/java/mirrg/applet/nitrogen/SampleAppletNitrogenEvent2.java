package mirrg.applet.nitrogen;

import java.awt.Graphics2D;

import mirrg.applet.nitrogen.AppletNitrogen;
import mirrg.applet.nitrogen.NitrogenEventApplet;
import mirrg.applet.nitrogen.modules.threading.ModuleGameThread;
import mirrg.applet.nitrogen.modules.threading.NitrogenEventGameThread;

public class SampleAppletNitrogenEvent2 extends AppletNitrogen
{

	private static final long serialVersionUID = 6370904732290917883L;

	private Game1 game;

	public SampleAppletNitrogenEvent2()
	{
		ModuleGameThread moduleGameThread = new ModuleGameThread(this);
		moduleGameThread.objectiveFPS = 20;

		getEventManager().register(NitrogenEventApplet.Init.class, event -> {
			game = new Game1(this);
		});
		getEventManager().register(NitrogenEventGameThread.Init.class, event -> {
			game.init();
		});
		getEventManager().register(NitrogenEventGameThread.Tick.class, event -> {
			game.move();
		});
		getEventManager().register(NitrogenEventGameThread.Render.class, event -> {
			repaint();
		});

		//

		getEventManager().register(NitrogenEventApplet.Paint.Pre.class, event -> {
			event.cancelled = true;
		});
		getEventManager().register(NitrogenEventApplet.Paint.class, event -> {
			game.paint((Graphics2D) event.graphics);
		});
	}

}

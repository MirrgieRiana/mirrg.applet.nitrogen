package mirrg.applet.nitrogen;

import mirrg.applet.nitrogen.AppletNitrogen;
import mirrg.applet.nitrogen.ModuleComponentEvent;
import mirrg.applet.nitrogen.NitrogenEventApplet;
import mirrg.applet.nitrogen.modules.rendering.ModuleTripleBuffer;
import mirrg.applet.nitrogen.modules.threading.ModuleGameThread;
import mirrg.applet.nitrogen.modules.threading.NitrogenEventGameThread;

public class SampleAppletNitrogenEvent3 extends AppletNitrogen
{

	private static final long serialVersionUID = 6370904732290917883L;

	private Game1 game;

	public SampleAppletNitrogenEvent3()
	{
		ModuleGameThread moduleGameThread = new ModuleGameThread(this);
		moduleGameThread.objectiveFPS = 50;

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

		ModuleComponentEvent moduleComponentEvent = new ModuleComponentEvent(this);
		ModuleTripleBuffer moduleTripleBuffer = new ModuleTripleBuffer(this, moduleComponentEvent, moduleGameThread);

		getEventManager().register(NitrogenEventApplet.Paint.class, event -> {

			game.paint(moduleTripleBuffer.getBufferDirty().getGraphics());
			moduleTripleBuffer.flip();

			event.graphics.drawImage(moduleTripleBuffer.getBufferSafety().getBuffer(), 0, 0, this);
		});
	}

}

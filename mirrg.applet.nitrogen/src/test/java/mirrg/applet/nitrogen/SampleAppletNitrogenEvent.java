package mirrg.applet.nitrogen;

import java.awt.Graphics2D;

import mirrg.applet.nitrogen.AppletNitrogen;
import mirrg.applet.nitrogen.NitrogenEventApplet;

public class SampleAppletNitrogenEvent extends AppletNitrogen
{

	private static final long serialVersionUID = 6370904732290917883L;

	private Game1 game;
	private Thread thread;

	public SampleAppletNitrogenEvent()
	{
		getEventManager().register(NitrogenEventApplet.Init.class, event -> {
			game = new Game1(this);
		});
		getEventManager().register(NitrogenEventApplet.Start.class, event -> {

			thread = new Thread(() -> {

				while (true) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						break;
					}

					game.move();
					repaint();
				}

			});

			game.init();
			thread.start();
		});
		getEventManager().register(NitrogenEventApplet.Stop.class, event -> {
			thread.interrupt();
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

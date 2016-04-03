package mirrg.applet.nitrogen.modules.threading;

import mirrg.applet.nitrogen.AppletNitrogen;
import mirrg.applet.nitrogen.Module;
import mirrg.applet.nitrogen.NitrogenEventApplet;

public class ModuleGameThread extends Module
{

	public double objectiveFPS = 50;
	private Thread thread;

	/**
	 * @see NitrogenEventGameThread
	 */
	public ModuleGameThread(AppletNitrogen applet)
	{
		super(applet);

		applet.getEventManager().register(NitrogenEventApplet.Start.class, event -> {

			thread = new Thread(() -> {

				while (true) {

					{
						NitrogenEventGameThread.Sleep event2 = new NitrogenEventGameThread.Sleep(this);
						applet.getEventManager().post(event2);

						if (!event2.cancelled) {
							try {
								Thread.sleep((long) (1000 / this.objectiveFPS));
							} catch (InterruptedException e) {
								break;
							}
						}
						if (event2.interrupted) break;
					}

					applet.getEventManager().post(
						new NitrogenEventGameThread.Tick(this));

					applet.getEventManager().post(
						new NitrogenEventGameThread.PostTick(this));

					applet.getEventManager().post(
						new NitrogenEventGameThread.Render(this));

				}

			});
			thread.setDaemon(true);

			applet.getEventManager().post(
				new NitrogenEventGameThread.Init(this));

			thread.start();
		});
		applet.getEventManager().register(NitrogenEventApplet.Stop.class, event -> {
			thread.interrupt();
		});
	}

	public Thread getThread()
	{
		return thread;
	}

}

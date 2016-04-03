package mirrg.applet.nitrogen;

import java.awt.Graphics;

import javax.swing.JApplet;

import mirrg.event.nitrogen.HNitrogenEvent;
import mirrg.event.nitrogen.api.INitrogenEventManager;

/**
 * コンストラクタ内やインスタンスの生成時で以下のことようなをすると、
 * イベントを受け取れる。
 *
 * <pre>
 * getEventManager().register(NitrogenEventApplet.Init.class, event -&gt; {
 * 	System.out.println(&quot;on init&quot;);
 * });
 * </pre>
 */
public class AppletNitrogen extends JApplet
{

	private static final long serialVersionUID = 155419117197430297L;

	public AppletNitrogen()
	{
		eventManager = HNitrogenEvent.createInstance();

		eventManager.register(NitrogenEventApplet.Start.class, event -> {
			eventManager.post(new NitrogenEventApplet.Rebuffer(
				this,
				event.applet.getWidth(),
				event.applet.getHeight()));
		});
		eventManager.register(NitrogenEventComponent.Resized.class, event -> {
			eventManager.post(new NitrogenEventApplet.Rebuffer(
				this,
				event.componentEvent.getComponent().getWidth(),
				event.componentEvent.getComponent().getHeight()));
		});
	}

	//

	private INitrogenEventManager eventManager;

	public INitrogenEventManager getEventManager()
	{
		return eventManager;
	}

	//

	@Override
	public final void init()
	{
		getEventManager().post(new NitrogenEventApplet.Init(this));
	}

	@Override
	public final void start()
	{
		isRunning = true;
		getEventManager().post(new NitrogenEventApplet.Start(this));
	}

	@Override
	public final void stop()
	{
		isRunning = false;
		getEventManager().post(new NitrogenEventApplet.Stop(this));
	}

	@Override
	public final void destroy()
	{
		getEventManager().post(new NitrogenEventApplet.Destroy(this));
	}

	//

	private boolean isRunning = false;

	@Override
	public final void paint(Graphics graphics)
	{
		if (!isRunning) {
			super.paint(graphics);
			return;
		}

		NitrogenEventApplet.Paint.Pre event = new NitrogenEventApplet.Paint.Pre(this);
		getEventManager().post(event);

		if (!event.cancelled) super.paint(graphics);

		getEventManager().post(new NitrogenEventApplet.Paint(this, graphics));
	}

	@Override
	public final void update(Graphics graphics)
	{
		if (!isRunning) {
			super.update(graphics);
			return;
		}

		NitrogenEventApplet.Update.Pre event = new NitrogenEventApplet.Update.Pre(this);
		getEventManager().post(event);

		if (!event.cancelled) super.update(graphics);

		getEventManager().post(new NitrogenEventApplet.Update(this, graphics));
	}

}

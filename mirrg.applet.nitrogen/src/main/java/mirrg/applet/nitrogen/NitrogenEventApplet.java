package mirrg.applet.nitrogen;

import java.applet.Applet;
import java.awt.Graphics;

public class NitrogenEventApplet
{

	public Applet applet;

	public NitrogenEventApplet(Applet applet)
	{
		this.applet = applet;
	}

	public static class Init extends NitrogenEventApplet
	{

		public Init(Applet applet)
		{
			super(applet);
		}

	}

	public static class Start extends NitrogenEventApplet
	{

		public Start(Applet applet)
		{
			super(applet);
		}

	}

	public static class Stop extends NitrogenEventApplet
	{

		public Stop(Applet applet)
		{
			super(applet);
		}

	}

	public static class Destroy extends NitrogenEventApplet
	{

		public Destroy(Applet applet)
		{
			super(applet);
		}

	}

	/**
	 * @see NitrogenEventApplet.Start
	 * @see NitrogenEventComponent.Resized
	 */
	public static class Rebuffer extends NitrogenEventApplet
	{

		public int width;
		public int height;

		public Rebuffer(Applet applet, int width, int height)
		{
			super(applet);
			this.width = width;
			this.height = height;
		}

	}

	//

	public static class EventCancelable extends NitrogenEventApplet
	{

		public boolean cancelled = false;

		public EventCancelable(Applet applet)
		{
			super(applet);
		}

	}

	public static class EventPaintBase extends NitrogenEventApplet
	{

		public Graphics graphics;

		public EventPaintBase(Applet applet, Graphics graphics)
		{
			super(applet);
			this.graphics = graphics;
		}

	}

	public static class Paint extends EventPaintBase
	{

		public Paint(Applet applet, Graphics graphics)
		{
			super(applet, graphics);
		}

		public static class Pre extends EventCancelable
		{

			public Pre(Applet applet)
			{
				super(applet);
			}

		}

	}

	public static class Update extends EventPaintBase
	{

		public Update(Applet applet, Graphics graphics)
		{
			super(applet, graphics);
		}

		public static class Pre extends EventCancelable
		{

			public Pre(Applet applet)
			{
				super(applet);
			}

		}

	}

}

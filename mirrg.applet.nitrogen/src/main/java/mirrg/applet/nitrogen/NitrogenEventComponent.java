package mirrg.applet.nitrogen;

import java.awt.event.ComponentEvent;

public class NitrogenEventComponent
{

	public ComponentEvent componentEvent;

	public NitrogenEventComponent(ComponentEvent componentEvent)
	{
		this.componentEvent = componentEvent;
	}

	public static class Shown extends NitrogenEventComponent
	{

		public Shown(ComponentEvent componentEvent)
		{
			super(componentEvent);
		}

	}

	public static class Resized extends NitrogenEventComponent
	{

		public Resized(ComponentEvent componentEvent)
		{
			super(componentEvent);
		}

	}

	public static class Moved extends NitrogenEventComponent
	{

		public Moved(ComponentEvent componentEvent)
		{
			super(componentEvent);
		}

	}

	public static class Hidden extends NitrogenEventComponent
	{

		public Hidden(ComponentEvent componentEvent)
		{
			super(componentEvent);
		}

	}

}

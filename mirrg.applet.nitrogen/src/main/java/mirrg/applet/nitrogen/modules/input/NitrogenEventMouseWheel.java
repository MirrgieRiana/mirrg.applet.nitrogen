package mirrg.applet.nitrogen.modules.input;

import java.awt.event.MouseWheelEvent;

public class NitrogenEventMouseWheel
{

	public MouseWheelEvent mouseWheelEvent;

	public NitrogenEventMouseWheel(MouseWheelEvent mouseWheelEvent)
	{
		this.mouseWheelEvent = mouseWheelEvent;
	}

	public static class Moved extends NitrogenEventMouseWheel
	{

		public Moved(MouseWheelEvent mouseWheelEvent)
		{
			super(mouseWheelEvent);
		}

	}

}

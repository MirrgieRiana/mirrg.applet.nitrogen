package mirrg.applet.nitrogen.modules.input;

import java.awt.event.MouseEvent;

public class NitrogenEventMouseMotion
{

	public MouseEvent mouseEvent;

	public NitrogenEventMouseMotion(MouseEvent mouseEvent)
	{
		this.mouseEvent = mouseEvent;
	}

	public static class Dragged extends NitrogenEventMouseMotion
	{

		public Dragged(MouseEvent mouseEvent)
		{
			super(mouseEvent);
		}

	}

	public static class Moved extends NitrogenEventMouseMotion
	{

		public Moved(MouseEvent mouseEvent)
		{
			super(mouseEvent);
		}

	}

}

package mirrg.applet.nitrogen.modules.input;

import java.awt.event.MouseEvent;

public class NitrogenEventMouse
{

	public MouseEvent mouseEvent;

	public NitrogenEventMouse(MouseEvent mouseEvent)
	{
		this.mouseEvent = mouseEvent;
	}

	public static class Released extends NitrogenEventMouse
	{

		public Released(MouseEvent mouseEvent)
		{
			super(mouseEvent);
		}

	}

	public static class Pressed extends NitrogenEventMouse
	{

		public Pressed(MouseEvent mouseEvent)
		{
			super(mouseEvent);
		}

	}

	public static class Exited extends NitrogenEventMouse
	{

		public Exited(MouseEvent mouseEvent)
		{
			super(mouseEvent);
		}

	}

	public static class Entered extends NitrogenEventMouse
	{

		public Entered(MouseEvent mouseEvent)
		{
			super(mouseEvent);
		}

	}

	public static class Clicked extends NitrogenEventMouse
	{

		public Clicked(MouseEvent mouseEvent)
		{
			super(mouseEvent);
		}

	}

}

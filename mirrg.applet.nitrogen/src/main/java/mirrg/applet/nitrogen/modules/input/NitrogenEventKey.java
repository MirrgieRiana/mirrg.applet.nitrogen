package mirrg.applet.nitrogen.modules.input;

import java.awt.event.KeyEvent;

public class NitrogenEventKey
{

	public KeyEvent keyEvent;

	public NitrogenEventKey(KeyEvent keyEvent)
	{
		this.keyEvent = keyEvent;
	}

	public static class Typed extends NitrogenEventKey
	{

		public Typed(KeyEvent keyEvent)
		{
			super(keyEvent);
		}

	}

	public static class Pressed extends NitrogenEventKey
	{

		public Pressed(KeyEvent keyEvent)
		{
			super(keyEvent);
		}

	}

	public static class Released extends NitrogenEventKey
	{

		public Released(KeyEvent keyEvent)
		{
			super(keyEvent);
		}

	}

}

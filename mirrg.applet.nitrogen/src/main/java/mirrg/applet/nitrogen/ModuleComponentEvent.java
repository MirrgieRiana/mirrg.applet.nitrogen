package mirrg.applet.nitrogen;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class ModuleComponentEvent extends Module
{

	public ModuleComponentEvent(AppletNitrogen applet)
	{
		super(applet);

		applet.addComponentListener(new ComponentListener() {

			@Override
			public void componentShown(ComponentEvent componentEvent)
			{
				applet.getEventManager().post(
					new NitrogenEventComponent.Shown(componentEvent));
			}

			@Override
			public void componentResized(ComponentEvent componentEvent)
			{
				applet.getEventManager().post(
					new NitrogenEventComponent.Resized(componentEvent));
			}

			@Override
			public void componentMoved(ComponentEvent componentEvent)
			{
				applet.getEventManager().post(
					new NitrogenEventComponent.Moved(componentEvent));
			}

			@Override
			public void componentHidden(ComponentEvent componentEvent)
			{
				applet.getEventManager().post(
					new NitrogenEventComponent.Hidden(componentEvent));
			}

		});
	}

}

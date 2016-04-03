package mirrg.applet.nitrogen.modules.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import mirrg.applet.nitrogen.AppletNitrogen;
import mirrg.applet.nitrogen.Module;

public class ModuleInputEvent extends Module
{

	public ModuleInputEvent(AppletNitrogen applet)
	{
		super(applet);

		applet.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent mouseEvent)
			{
				applet.getEventManager().post(
					new NitrogenEventMouse.Released(mouseEvent));
			}

			@Override
			public void mousePressed(MouseEvent mouseEvent)
			{
				applet.getEventManager().post(
					new NitrogenEventMouse.Pressed(mouseEvent));
			}

			@Override
			public void mouseExited(MouseEvent mouseEvent)
			{
				applet.getEventManager().post(
					new NitrogenEventMouse.Exited(mouseEvent));
			}

			@Override
			public void mouseEntered(MouseEvent mouseEvent)
			{
				applet.getEventManager().post(
					new NitrogenEventMouse.Entered(mouseEvent));
			}

			@Override
			public void mouseClicked(MouseEvent mouseEvent)
			{
				applet.getEventManager().post(
					new NitrogenEventMouse.Clicked(mouseEvent));
			}

		});
		applet.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent mouseEvent)
			{
				applet.getEventManager().post(
					new NitrogenEventMouseMotion.Dragged(mouseEvent));
			}

			@Override
			public void mouseMoved(MouseEvent mouseEvent)
			{
				applet.getEventManager().post(
					new NitrogenEventMouseMotion.Moved(mouseEvent));
			}

		});
		applet.addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent mouseWheelEvent)
			{
				applet.getEventManager().post(
					new NitrogenEventMouseWheel.Moved(mouseWheelEvent));
			}

		});
		applet.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent keyEvent)
			{
				applet.getEventManager().post(
					new NitrogenEventKey.Typed(keyEvent));
			}

			@Override
			public void keyPressed(KeyEvent keyEvent)
			{
				applet.getEventManager().post(
					new NitrogenEventKey.Pressed(keyEvent));
			}

			@Override
			public void keyReleased(KeyEvent keyEvent)
			{
				applet.getEventManager().post(
					new NitrogenEventKey.Released(keyEvent));
			}

		});
	}

}

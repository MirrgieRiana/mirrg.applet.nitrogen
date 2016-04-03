package mirrg.applet.nitrogen;

import java.awt.Font;
import java.awt.Graphics2D;

import mirrg.applet.nitrogen.AppletNitrogen;
import mirrg.applet.nitrogen.HAppletNitrogen;
import mirrg.applet.nitrogen.NitrogenEventApplet;
import mirrg.applet.nitrogen.HAppletNitrogen.ResponceApplyStandard;
import mirrg.applet.nitrogen.modules.threading.ModuleFPSAdjuster;
import mirrg.applet.nitrogen.modules.threading.NitrogenEventGameThread;

public class SampleAppletNitrogenEvent5 extends AppletNitrogen
{

	private static final long serialVersionUID = 6370904732290917883L;

	private Game2 game;

	public SampleAppletNitrogenEvent5()
	{
		ResponceApplyStandard responce = HAppletNitrogen.applyStandard(this);
		responce.moduleGameThread.objectiveFPS = 30;

		//

		getEventManager().register(NitrogenEventApplet.Init.class, event -> {
			game = new Game2(this);
		});
		getEventManager().register(NitrogenEventGameThread.Init.class, event -> {
			game.init();
		});
		getEventManager().register(NitrogenEventGameThread.Tick.class, event -> {
			game.setPlayerPosition(
				1.0 * responce.moduleInputStatus.getMouseX() / getWidth(),
				1.0 * responce.moduleInputStatus.getMouseY() / getHeight());
			game.move();
		});
		getEventManager().register(NitrogenEventGameThread.PostTick.class, event -> {
			responce.moduleInputStatus.spend();
		});
		getEventManager().register(NitrogenEventGameThread.Render.class, event -> {
			repaint();
		});
		getEventManager().register(NitrogenEventApplet.Paint.class, event -> {

			{
				Graphics2D graphics = responce.moduleTripleBuffer.getBufferDirty().getGraphics();

				game.paint(graphics);

				drawFPS(graphics, responce.moduleFPSAdjuster);
			}

			responce.moduleTripleBuffer.flip();

			event.graphics.drawImage(responce.moduleTripleBuffer.getBufferSafety().getBuffer(), 0, 0, this);
		});

	}

	private void drawFPS(Graphics2D graphics, ModuleFPSAdjuster fpsAdjuster)
	{
		graphics.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		graphics.drawString(String.format(
			"FPS: %.2f",
			fpsAdjuster.getFPS()),
			0, getHeight());
		graphics.drawString(String.format(
			"CPU: %.2f%%",
			fpsAdjuster.getLoadFactor() * 100),
			0, getHeight() - graphics.getFont().getSize());
	}

}

package mirrg.applet.nitrogen;

import mirrg.applet.nitrogen.modules.input.ModuleInputEvent;
import mirrg.applet.nitrogen.modules.input.ModuleInputStatus;
import mirrg.applet.nitrogen.modules.rendering.ModuleTripleBuffer;
import mirrg.applet.nitrogen.modules.threading.ModuleFPSAdjuster;
import mirrg.applet.nitrogen.modules.threading.ModuleGameThread;

public class HAppletNitrogen
{

	public static ResponceApplyStandard applyStandard(AppletNitrogen applet)
	{
		applet.setFocusable(true);

		ResponceApplyStandard responce = new ResponceApplyStandard();

		responce.moduleGameThread = new ModuleGameThread(applet);
		responce.moduleFPSAdjuster = new ModuleFPSAdjuster(applet, responce.moduleGameThread);
		responce.moduleComponentEvent = new ModuleComponentEvent(applet);
		responce.moduleTripleBuffer = new ModuleTripleBuffer(applet, responce.moduleComponentEvent, responce.moduleGameThread);
		responce.moduleInputEvent = new ModuleInputEvent(applet);
		responce.moduleInputStatus = new ModuleInputStatus(applet, responce.moduleInputEvent);

		return responce;
	}

	public static class ResponceApplyStandard
	{

		public ModuleGameThread moduleGameThread;
		public ModuleFPSAdjuster moduleFPSAdjuster;
		public ModuleComponentEvent moduleComponentEvent;
		public ModuleTripleBuffer moduleTripleBuffer;
		public ModuleInputEvent moduleInputEvent;
		public ModuleInputStatus moduleInputStatus;

	}

}

package mirrg.applet.nitrogen.modules.threading;

public class NitrogenEventGameThread
{

	public ModuleGameThread moduleGameThread;

	public NitrogenEventGameThread(ModuleGameThread moduleGameThread)
	{
		this.moduleGameThread = moduleGameThread;
	}

	public static class Init extends NitrogenEventGameThread
	{

		public Init(ModuleGameThread moduleGameThread)
		{
			super(moduleGameThread);
		}

	}

	public static class Sleep extends NitrogenEventGameThread
	{

		/**
		 * 本来のSleepの処理を行わない場合にtrue。
		 */
		public boolean cancelled = false;

		/**
		 * InterruptedExceptionなどでループを抜けなければならない場合にtrue。
		 */
		public boolean interrupted = false;

		public Sleep(ModuleGameThread moduleGameThread)
		{
			super(moduleGameThread);
		}

	}

	public static class Tick extends NitrogenEventGameThread
	{

		public Tick(ModuleGameThread moduleGameThread)
		{
			super(moduleGameThread);
		}

	}

	public static class PostTick extends NitrogenEventGameThread
	{

		public PostTick(ModuleGameThread moduleGameThread)
		{
			super(moduleGameThread);
		}

	}

	public static class Render extends NitrogenEventGameThread
	{

		public Render(ModuleGameThread moduleGameThread)
		{
			super(moduleGameThread);
		}

	}

}

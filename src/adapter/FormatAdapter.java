package adapter;


//Adapter
public class FormatAdapter implements MediaPlayer
{
	private MediaPackage media;
	
	public FormatAdapter(MediaPackage m)
	{
		media = m;
	}
	
	@Override
	public void play(String filename)
	{
		System.out.println("Using Adapter -->");
		media.playFile(filename);
	}
}

import com.jsv.Driver;
import com.jsv.process.Instance;


public class OTH implements Comparable<OTH>
{
	private int exitTime;
	private Instance process;
	public OTH(Instance p)
	{
		this.process = p;
		this.exitTime = Driver.clock + process.getNextOthEventTime();
	}
	public int getExitTime()
	{
		return this.exitTime;
	}
	
	public Instance getProcess()
	{
		return this.process;
	}
	
	public int compareTo(OTH o) 
	{
		if(o.getExitTime() > this.getExitTime())
		{
			return 1;
		}
		else if(o.getExitTime() == this.getExitTime())
		{
			return 0;
		}
		return -1;
	}
	
}

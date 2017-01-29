package comparison;

public class TimeInterval {
	
	private double timeBegin = 0;
	private double timeEnd = 0;
	private double timeInterval;
	private boolean[] dayInWeek = {false,false,false,false,false};
	
	public double getTimeBegin() {
		return timeBegin;
	}
	public void setTimeBegin(double d) {
		this.timeBegin = d;
	}
	public double getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(double timeEnd) {
		this.timeEnd = timeEnd;
	}
	public double getTimeInterval() {
		return timeInterval;
	}
	public void setDaysInWeek(int n)
	{
		dayInWeek[n] = true;
	}
	public boolean[] getDaysInWeek()
	{
		return dayInWeek;
	}
	
	

}

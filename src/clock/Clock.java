package clock;

public class Clock {
  private long time_start;
  private long time_stop;
  public void start(){
    setTimeStart (System.currentTimeMillis());
  }
  
  public void stop(){
    setTimeStop (System.currentTimeMillis());
  }
  
  public long elapsedTime(){
    return getTimeStop()-getTimeStart();
  }
  
  private void setTimeStart(long time){
    time_start = time;
  }
  
  private void setTimeStop(long time){
    time_stop = time;
  }
  
  private long getTimeStart(){
    return time_start;
  }
  
  private long getTimeStop(){
    return time_stop;
  }
}

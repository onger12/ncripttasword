package threads;

public class TimeOutThread {
    public static boolean getTime(long time){
        Thread timeOut = new Thread();
        try {
            timeOut.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

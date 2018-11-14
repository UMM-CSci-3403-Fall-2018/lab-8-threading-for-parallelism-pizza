package mpd;

public class ThreadedMinimumPairwiseDistance implements MinimumPairwiseDistance {
  private int[] values;
  private long globalResult = Integer.MAX_VALUE;

  @Override
  public long minimumPairwiseDistance(int[] values){

    Thread left = new Thread(new bottomLeft());
    Thread right = new Thread(new bottomRight());
    Thread mid = new Thread(new center());
    Thread top = new Thread(new topRight());

    Thread[] threads = new Thread[4];
    threads[0] = left;
    threads[1] = right;
    threads[2] = mid;
    threads[3] = top;

    this.values = values;
    for (int i=0; i<4; i++){
      threads[i].start();
    }
    for (int i=0; i<4; i++){
      try{
        threads[i].join();
      } catch (InterruptedException ioe) {
        ioe.printStackTrace();
      }
    }
    return globalResult;
  }
  private long updateGlobalResult(long localResult){
    if (localResult < globalResult){
      globalResult = localResult;
    }
    return globalResult;
  }
    private class bottomLeft implements Runnable {
      public void run(){
      long result = Integer.MAX_VALUE;
      for (int i = 0; i < values.length/2; ++i) {
          for (int j = 0; j < i; ++j) {
              long diff = Math.abs(values[i] - values[j]);
              if (diff < localresult) {
                  localresult = diff;
              }
          }
      }
        updateGlobalResult(result);
    }
  }

    private class bottomRight implements Runnable {
      public void run(){
      long result = Integer.MAX_VALUE;
      for (int i = 0; i < values.length; ++i) {
          for (int j = 0; j + values.length/2 < i ; ++j) {
              long diff = Math.abs(values[i] - values[j]);
              if (diff < result) {
                  result = diff;
              }
          }
      }
        updateGlobalResult(result);
    }
  }

    private class center implements Runnable{
      public void run(){
      long result = Integer.MAX_VALUE;
      for (int j = 0; j < values.length/2; ++j) {
          for (int i = values.length/2; i <= j + values.length/2; ++i) {
              long diff = Math.abs(values[j] - values[i]);
              if (diff < result) {
                  result = diff;
              }
          }
      }
        updateGlobalResult(result);
    }
  }

    private class topRight implements Runnable {
      public void run(){
      long result = Integer.MAX_VALUE;
      for (int i = values.length/2; i < values.length; ++i) {
          for (int j = values.length/2; j < i; ++j) {
              long diff = Math.abs(values[i] - values[j]);
              if (diff < result) {
                  result = diff;
              }
          }
      }
<<<<<<< HEAD
        updateGlobalResult(result);
    }
  }
=======
        return result;
    }

    for (int i = 0; i < numThreads; i++){
      threads.join();
    }

>>>>>>> daa565f2ce03cb34dd1b936f41c82cc1e7c15016
}

package mpd;

public class ThreadedMinimumPairwiseDistance implements MinimumPairwiseDistance {
  private int[] values;
  private long globalResult = Integer.MAX_VALUE

    public long bottomLeft(int[] values) {
      Thread[] threads = new Thread[numThreads]
      long localresult = Integer.MAX_VALUE;
      for (int i = 0; i < values.length/2; ++i) {
          for (int j = 0; j < i; ++j) {
              long diff = Math.abs(values[i] - values[j]);
              if (diff < localresult) {
                  localresult = diff;
              }
          }
      }
        return result;
    }

    public long bottomRight(int[] values) {
      long result = Integer.MAX_VALUE;
      for (int i = 0; i < values.length; ++i) {
          for (int j = 0; j <= i - values.length/2; ++j) {
              long diff = Math.abs(values[i] - values[j]);
              if (diff < result) {
                  result = diff;
              }
          }
      }
        return result;
    }

    public long center(int[] values) {
      long result = Integer.MAX_VALUE;
      for (int j = 0; j + values.length/2 < values.length; ++j) {
          for (int i = 0; i <= j; ++i) {
              long diff = Math.abs(values[j] - values[i]);
              if (diff < result) {
                  result = diff;
              }
          }
      }
        return result;
    }

    public long topRight(int[] values) {
      long result = Integer.MAX_VALUE;
      for (int i = 0; i < values.length; ++i) {
          for (int j = values.length/2; j < i; ++j) {
              long diff = Math.abs(values[i] - values[j]);
              if (diff < result) {
                  result = diff;
              }
          }
      }
        return result;
    }

    for (int i = 0; i < numThreads; i++){
      threads.join();
    }

}

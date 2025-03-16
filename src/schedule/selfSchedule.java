/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedule;

/**
 *
 * @author dell
 */
public class selfSchedule {
  public int startLoop, curLoop, endLoop;

   static  public class LoopRange {
        public int start, end;
    }
    
    int step;
            ///, modulo;
    public selfSchedule(int startLoop, int endLoop, int groupSize) {
        ///int numIterations=endLoop - startLoop + 1;        
        curLoop=startLoop-1;
        this.startLoop=startLoop;
        this.endLoop=endLoop;
        ///int numRanges=numIterations/groupSize;
        step=groupSize;
        ///modulo = numIterations % numRanges;
    }

    public  synchronized LoopRange loopGetRange() {
        if (curLoop >= endLoop)  return null;
        LoopRange range = new LoopRange();
        range.start = curLoop+1;
        curLoop += step;
        range.end = (curLoop < endLoop) ? curLoop : endLoop;
        return range;
    }
}

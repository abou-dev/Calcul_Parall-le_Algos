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

public class guidedSelfSchedule {
    public int startLoop, curLoop, endLoop, numThreads, minSize;
    public static class LoopRange {
        public int start, end;
    }
    
    ///public int step, modulo;
    public guidedSelfSchedule(int startLoop, int endLoop, int numThreads, int minSize) {
        ///int numIterations=endLoop - startLoop + 1;
        curLoop = startLoop - 1;
        this.startLoop = startLoop;
        this.endLoop = endLoop;
        this.numThreads = numThreads;
        this.minSize=minSize;
       /// step = numIterations / numThreads;
        ///modulo = numIterations % numThreads;
    }
       
    public  synchronized LoopRange loopGetRange() {
        if(curLoop>=endLoop) return null;
	LoopRange range=new LoopRange();
	range.start=curLoop+1;
        int  step=(endLoop-curLoop+1)/numThreads;
	curLoop+=(step>minSize)?step:minSize;
	range.end = (curLoop<endLoop) ? curLoop : endLoop;
        return range;
    }
}

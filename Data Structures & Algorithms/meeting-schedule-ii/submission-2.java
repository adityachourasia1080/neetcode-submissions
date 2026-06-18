/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    int count;
    private void recur(List<Interval>intervals){
        if(intervals.size()==0)  return ;
        count++;
        List<Interval> next = new ArrayList<>();
        int start =  intervals.get(0).start;
        int end= intervals.get(0).end;

        for (int i=1;i<intervals.size();i++){
             int currStart= intervals.get(i).start;
             int currEnd= intervals.get(i).end;
             if (currStart>=end){
                start=currStart;
                end= currEnd;
             }
             else{
                next.add(intervals.get(i));
             }

        }

        recur(next);
    }
    public int minMeetingRooms(List<Interval> intervals) {
        count=0;
        Collections.sort(intervals,(Interval a,Interval b)->Integer.compare(a.start,b.start));
         recur(intervals);
         return count;

    }
}

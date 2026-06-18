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
    public boolean canAttendMeetings(List<Interval> it) {
        if (it.size()==0)  return true;

        Collections.sort(it,(Interval a,Interval b)-> Integer.compare(a.start,b.start));
        int start =it.get(0).start;
        int end= it.get(0).end;
        for (int i=1;i<it.size();i++){
            if (it.get(i).start<end)  return false;
            else{
                start= it.get(i).start;
                end= it.get(i).end;
            }
        }

        return true;


    }
}

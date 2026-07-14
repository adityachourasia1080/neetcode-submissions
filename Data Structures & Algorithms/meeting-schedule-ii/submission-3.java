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
    public int minMeetingRooms(List<Interval> in) {
        int n= in.size();
        int start[]= new int[n];
        int end[]  = new int[n];

        for (int i=0;i<n;i++){
            start[i]=in.get(i).start;
            end[i]=in.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int count=0;
        int i=0;
        int j=0;
        int ans=0;
        while(i<n){
            if (start[i]<end[j]) {
                count++;
                i++;
                ans=Math.max(ans,count);
            }
            else{
                count--;
                j++;
            }
        }

        return ans;



    }
}

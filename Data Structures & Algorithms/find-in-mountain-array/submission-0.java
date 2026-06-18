/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    private int bs(int l,int h,MountainArray m,int target,HashMap<Integer,Integer>cache){
        while(l<=h){
            int mid=l+(h-l)/2;

            int curr;
            if (cache.containsKey(mid)) curr= cache.get(mid);
            else curr= m.get(mid);

            if (curr==target)  return mid;
            if (curr<target){
                l=mid+1;
            }
            else h=mid-1;
        }
        return -1;
    }
    private int bsr(int l,int h,MountainArray m,int target,HashMap<Integer,Integer>cache){
        while(l<=h){
            int mid=l+(h-l)/2;
            int curr;
            if (cache.containsKey(mid)) curr= cache.get(mid);
            else curr= m.get(mid);
            if (curr==target)  return mid;
            if (curr<target){
                h=mid-1;
            }
            else l=mid+1;
        }
        return -1;
    }
    public int findInMountainArray(int target, MountainArray m) {

        int n= m.length();
        int h=n-1;
        int l=1;
        int peak=0;
        HashMap<Integer,Integer>cache = new HashMap<>();
        while(l<=h){
            int mid= l+(h-l)/2;
            int prev= m.get(mid-1);
            int curr= m.get(mid);
            int next= m.get(mid+1);
            cache.put(mid-1,prev);
            cache.put(mid,curr);
            cache.put(mid+1,next);
            if (curr>prev && curr>next){
                peak=mid;
                break;
            }
            
            if (curr<next){
                l=mid+1;
            }
            else{
                h=mid-1;
            }

        }
         System.out.println("peak element is "+ peak);
        int ans= bs(0,peak,m,target,cache);
        if (ans!=-1)  return ans;
        return bsr(peak+1,n-1,m,target,cache);
        
    }
}
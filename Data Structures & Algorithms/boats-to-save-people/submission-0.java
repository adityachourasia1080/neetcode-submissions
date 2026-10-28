class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int low=0,high= people.length-1;
        int count=0;

        while(low<=high){
            if (low==high || people[low]+people[high] <=limit){
                count++;
                low++;
                high--;
            }
            else{
                count++;
                high--;
            }
        }

        return count;
        
    }
}
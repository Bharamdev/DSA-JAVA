class Solution {
    public class pair{
        int sum,i,j;
        pair(int sum, int i,int j){
            this.sum= sum;
            this.i = i;
            this.j = j;
        }
    }
    public ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // code here
        ArrayList<Integer> arr = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        int n=a.length;
        PriorityQueue<pair> pq = new PriorityQueue<>((x,y)-> y.sum-x.sum);
        Set<String> visited = new HashSet<>();
        int i=n-1,j=n-1;
        pq.offer(new pair(a[i]+b[j],i,j));
        visited.add(i+","+j);
        while(k-->0 && !pq.isEmpty()){
            pair current = pq.poll();
            arr.add(current.sum);
            i=current.i;
            j=current.j;
            
            if((i-1)>=0 && !visited.contains((i-1)+","+j)){
                pq.offer(new pair(a[i-1]+b[j],i-1,j));
                visited.add((i-1)+","+j);
            }
            if((j-1)>=0 && !visited.contains(i+","+(j-1))){
                pq.offer(new pair(a[i]+b[j-1],i,j-1));
                visited.add(i+","+(j-1));
            }
        }
        return arr;
    }
}
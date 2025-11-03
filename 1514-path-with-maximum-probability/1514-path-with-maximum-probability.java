class Solution {
    class pair{
        double prob;
        int node;
        pair(double prob, int node){
            this.prob = prob;
            this.node = node;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            adj.get(u).add(new pair(prob,v));
            adj.get(v).add(new pair(prob,u));
        }
        double[] dist = new double[n];
        Arrays.fill(dist,0.0);
        dist[start_node]=1.0;
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b) -> 
                                     Double.compare(b.prob,a.prob));
        pq.offer(new pair(1,start_node));
        while(!pq.isEmpty()){
            pair p =pq.poll();
            double prob = p.prob;
            int node = p.node;
            if(node==end_node) return prob;
            for(pair it: adj.get(node)){
                double addprob = it.prob;
                int adjNode = it.node;
                if((prob*addprob) > dist[adjNode]){
                    dist[adjNode] = (prob*addprob);
                    pq.offer(new pair((prob*addprob),adjNode));
                }
            }
        }
        return 0;
    }
}
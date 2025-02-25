class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<Integer>[] tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        // Step 2: Find Bob's path to the root (node 0)
        int[] bobTime = new int[n]; // Stores time taken for Bob to reach each node
        Arrays.fill(bobTime, -1);
        findBobPath(bob, 0, -1, 0, tree, bobTime);

        // Step 3: DFS for Alice to find the maximum income path
        return dfsAlice(0, -1, 0, 0, tree, bobTime, amount);
    }

    // Helper function to find the time taken for Bob to reach each node
    private boolean findBobPath(int node, int target, int parent, int time, List<Integer>[] tree, int[] bobTime) {
        if (node == target) {
            bobTime[node] = time;
            return true;
        }
        for (int neighbor : tree[node]) {
            if (neighbor == parent) continue;
            if (findBobPath(neighbor, target, node, time + 1, tree, bobTime)) {
                bobTime[node] = time;
                return true;
            }
        }
        return false;
    }

    // DFS for Alice to calculate maximum possible income
    private int dfsAlice(int node, int parent, int time, int currentIncome, List<Integer>[] tree, int[] bobTime, int[] amount) {
        // Step 4: Calculate the net amount at this node
        if (bobTime[node] == -1 || time < bobTime[node]) {
            currentIncome += amount[node]; // Alice alone at this node
        } else if (time == bobTime[node]) {
            currentIncome += amount[node] / 2; // Alice and Bob share the reward/cost
        }

        // Step 5: Traverse all child nodes
        int maxIncome = Integer.MIN_VALUE;
        boolean isLeaf = true;
        for (int neighbor : tree[node]) {
            if (neighbor == parent) continue;
            isLeaf = false;
            maxIncome = Math.max(maxIncome, dfsAlice(neighbor, node, time + 1, currentIncome, tree, bobTime, amount));
        }

        // If this is a leaf node, return the income
        return isLeaf ? currentIncome : maxIncome;
    }
}
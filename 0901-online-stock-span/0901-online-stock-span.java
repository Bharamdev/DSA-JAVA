class StockSpanner {
    Stack<int[]> st;
    int idx=-1;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        idx=idx+1;
        int span=0;
        while(!st.isEmpty() && st.peek()[0]<=price){
           st.pop();
        }
        span = idx - (st.isEmpty() ? -1 : st.peek()[1]);
        st.push(new int[]{price,idx});
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
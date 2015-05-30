public class Solution {
    
    static class MinHeap {
        
        int[] data;
        
        int currentSize = 0;
        
        MinHeap(int size){
            data = new int[size];    
        }
        
        int parent(int i){
            return (i - 1) / 2;
        }
        
        int left(int i){
            return 2 * i + 1;
        }
        
        int right(int i){
            return 2 * i + 2;
        }

        void add(int n){
            int i = currentSize;
            currentSize++;
            
            data[i] = n;
            
            while(i > 0 && data[parent(i)] > data[i]){
                swap(parent(i), i);
                i = parent(i);
            }
        }        
        
        void heapify(int i){
            
            int l   = left(i);
            int r   = right(i);
            int min = i;
            
            if(l < currentSize && data[l] < data[min]){
                min = l;
            }
            
            if(r < currentSize && data[r] < data[min]){
                min = r;
            }
            
            if(min != i){
                swap(i, min);
                heapify(min);
            }
            
        }
        
        void swap(int x, int y){
            int t   = data[x];
            data[x] = data[y];
            data[y] = t;
        }
    }
    
    public int findKthLargest(int[] nums, int k) {
        
        MinHeap heap = new MinHeap(k);
        
        for(int i = 0; i < Math.min(nums.length, k); i++){
            heap.add(nums[i]);    
        }
        
        for(int i = k; i < nums.length; i++){
            
            if(heap.data[0] < nums[i]){
                heap.data[0] = nums[i];
                heap.heapify(0);
            }
        }
        
        return heap.data[0];
    }
}

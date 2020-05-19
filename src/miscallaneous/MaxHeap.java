package miscallaneous;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int maxSize;

    public MaxHeap(int maxSize){
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new int[this.maxSize + 1];
        heap[0] = Integer.MAX_VALUE;
    }

    public static void main(String []args){
        System.out.println("The Max Heap is ");
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.print();
        System.out.println("The max val is " + maxHeap.extractMax());
        System.out.println("The max val is " + maxHeap.extractMax());
    }

    int parent(int pos){
        return pos / 2;
    }

    int leftChild(int pos){
        return 2 * pos;
    }

    int rightChild(int pos){
        return 2 * pos + 1;
    }

    boolean isLeaf(int pos){
        if (pos >= (size / 2) && pos <= size){
            return true;
        }
        return false;
    }

    void swap(int pos1, int pos2){
        int tmp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = tmp;
    }

    void maxHeapify(int pos){
        if(isLeaf(pos)){
            return;
        }
        if(heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]){
            if(heap[pos] < heap[leftChild(pos)]){
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }else{
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
        }
    }

    void insert(int n){
        heap[++size] = n;
        int current = size;
        while(heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    int extractMax(){
        int max = heap[1];
        heap[1] = heap[size--];
        maxHeapify(1);
        return max;
    }

    void print(){
        for (int i = 1; i <= size / 2; i++){
            System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " +
                    heap[2 * i] + " RIGHT CHILD :" + heap[2 * i + 1]);
        }
    }
}

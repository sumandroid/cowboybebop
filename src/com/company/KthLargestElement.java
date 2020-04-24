package com.company;

public class KthLargestElement {

    public static void main(String[] args) {
        int[] arr = {15, 5, 3, 17, 10, 84, 9};
        int k = 3;
        MaxHeap maxHeap = new MaxHeap(arr.length);
        maxHeap.create(arr);
        maxHeap.print();
        System.out.println("Kth largest element is: " + maxHeap.extractMax());
        System.out.println("Kth largest element is: " + maxHeap.extractMax());
        System.out.println("Kth largest element is: " + maxHeap.extractMax());
        System.out.println("Kth largest element is: " + maxHeap.extractMax());
        System.out.println("Kth largest element is: " + maxHeap.extractMax());
        maxHeap.print();
    }

    static class MaxHeap {

        private int size;
        private int maxSize;
        private int[] maxHeap;

        MaxHeap(int n){
            this.maxSize = n + 1;
            this.size = 0;
        }

        int[] create(int[] arr){
            this.maxHeap = new int[15];
            maxHeap[0] = Integer.MAX_VALUE;
            for(int i = 0; i < arr.length; i++){
                insert(arr[i]);
            }
            return maxHeap;
        }

        void insert(int data){
            maxHeap[++size] = data;
            int current = size;
            while(maxHeap[current] > maxHeap[parent(current)]){
                swap(current, parent(current));
                current = parent(current);
            }
        }

        void swap(int pos1, int pos2){
            int temp = maxHeap[pos2];
            maxHeap[pos2] = maxHeap[pos1];
            maxHeap[pos1] = temp;
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

        int extractMax(){
            int max = maxHeap[1];
            maxHeap[1] = maxHeap[size--];
            heapify(1);
            return max;
        }

        void heapify(int pos){
            int largest = pos;
            if(leftChild(pos) <= size && maxHeap[largest] < maxHeap[leftChild(pos)]){
                largest = leftChild(pos);
            }
            if(rightChild(pos) <= size && maxHeap[largest] < maxHeap[rightChild(pos)]){
                largest = rightChild(pos);
            }
            if(largest != pos){
                swap(largest, pos);
                heapify(largest);
            }
            /*if(maxHeap[pos] < maxHeap[leftChild(pos)] || maxHeap[pos] < maxHeap[rightChild(pos)]){
                if(maxHeap[pos] < maxHeap[leftChild(pos)]){
                    swap(pos, leftChild(pos));
                    heapify(leftChild(pos));
                }else{
                    swap(pos, rightChild(pos));
                    heapify(rightChild(pos));
                }
            }*/
        }

        boolean isLeaf(int pos){
            if(pos >= (size / 2) && pos <= size){
                return true;
            }
            return false;
        }

        void print(){
            for (int i = 1; i <= size / 2; i++){
                System.out.print(" PARENT : " + maxHeap[i] + " LEFT CHILD : " +
                        maxHeap[2 * i] + " RIGHT CHILD :" + maxHeap[2 * i + 1]);
            }
        }
    }

}

package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int[] nums = new int[length];
        int i = 0;
        while (i < length) {
            nums[i++] = sc.nextInt();
        }
        new QuickSort(nums).run();
    }

    public static class QuickSort {
        private int[] nums;

        public QuickSort(int[] nums) {
            this.nums = nums;
        }

        int partition(int[] a, int start, int end) {
            int i = start - 1;
            int pivot = a[end];
            for (int j = start; j < end; j++) {
                if (a[j] < pivot) {
                    i++;
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
            int c = a[i + 1];
            a[i + 1] = a[end];
            a[end] = c;
            return i + 1;
        }

        void quickSort(int[] a, int start, int end) {
            if(start < end){
                int piv_pos = partition(a, start, end);
                quickSort(a, start, piv_pos - 1);
                quickSort(a, piv_pos + 1, end);
            }
        }

        void run(){
            int start = 0;
            int end = nums.length - 1;
            quickSort(nums, start, end);
            for (int i = 0; i < nums.length; i++){
                System.out.print(nums[i] + " ");
            }
        }


    }
}

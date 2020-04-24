package com.company;

public class MergeSort {

    public static void main(String []args){
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr, 0, arr.length);
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    static void mergeSort(int[] arr, int l, int r){
        if(l < r){
            int mid = (l+r)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, r, mid);
        }

    }

    static void merge(int[] arr, int l, int r, int mid){

        int lSize = mid - l + 1;
        int rSize = r - mid;
        int[] lTemp = new int[lSize];
        int[] rTemp = new int[rSize];
        int k = l;
        for(int i = 0; i < lSize; ++i){
            lTemp[i] = arr[l + i];
        }
        for(int j = 0; j < rSize; ++j){
            rTemp[j] = arr[mid + 1 + j];
        }
        int i = 0, j = 0;
        while(i < lSize && j < rSize){
            if(lTemp[i] < rTemp[j]){
                arr[k] = lTemp[i];
                i++;
            }else{
                arr[k] = rTemp[j];
                j++;
            }
            k++;
        }

        while (i < lSize){
            arr[k] = lTemp[i];
            i++;
            k++;
        }

        while(j < rSize){
            arr[j] = rTemp[j];
            j++;
            k++;
        }
    }
}

package com.company;

public class MergeTwoSortedArrays {

    public static void main(String []args){
        int[] arr1 = {7,10,12};
        int[] arr2 = {9,11,13};
        int i = 0;
        int j = 0;
        int k = 0;
        int[] temp = new int[arr1.length + arr2.length];
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                temp[k] = arr1[i];
                i++;
            }else{
                temp[k] = arr2[j];
                j++;
            }
            k++;
        }
        while(i < arr1.length){
            temp[k] = arr1[i];
            i++;
            k++;
        }
        while(j < arr2.length){
            temp[k] = arr2[j];
            j++;
            k++;
        }
        for(int a = 0; a < temp.length; a++){
            System.out.print(temp[a] + "\t");
        }
    }
}

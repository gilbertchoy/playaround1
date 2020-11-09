package com.bort.playaround1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    String tag = "berttest output";
    int ar[]=new int[7];  //mergeSort
    int arr[]=new int[7];  //heapSort
    static int array[] = new int[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //factorial
        int facResult = this.factorial(3);
        Log.d("tag","factorial result:" + facResult);

        //bubblesort
        int a[]=new int[7];
        a[0]=4;
        a[1]=5;
        a[2]=3;
        a[3]=1;
        a[4]=2;
        a[5]=6;
        a[6]=7;
        int[] result = bubbleSort(a);
        printValues(result);

        //mergesort
        ar[0]=4;
        ar[1]=5;
        ar[2]=3;
        ar[3]=1;
        ar[4]=2;
        ar[5]=6;
        ar[6]=7;
        mergeSort(0,ar.length-1);
        Log.d(tag,"mergesort:");
        printValues(ar);

        //heapsort
        arr[0]=4;
        arr[1]=5;
        arr[2]=3;
        arr[3]=1;
        arr[4]=2;
        arr[5]=6;
        arr[6]=7;
        heapSort(arr);
        Log.d(tag,"heapsort:");
        printValues(arr);

        //quickSort
        array[0]=4;
        array[1]=5;
        array[2]=3;
        array[3]=1;
        array[4]=2;
        array[5]=6;
        array[6]=7;
        quickSort(array, 0, ar.length-1);
        Log.d(tag,"quicksort:");
        printValues(array);
    }

    /*
    public void mergeSort(int l, int r){
        Log.d(tag,"l:"+l+" r:"+r);
        if(l<r){
            int m = l+((r-l)/2);
            if((m+1)<r) {
                mergeSort(m + 1, r);
            }
            if(l<m) {
                mergeSort(l, m);
            }
            merge(l,r,m);
        }
    }

    public void merge(int l,int r,int m){
        int lsize = m-l+1;
        int rsize = r-m;

        int[] left = new int[lsize];
        int[] right = new int[rsize];

        for(int i=0; i<left.length; i++){
            left[i] = ar[l+i];
        }
        for(int i=0; i<right.length;i++){
            right[i] = ar[m+i];
        }

        int lc = 0;
        int rc = 0;
        int index = l;

        while(lc<left.length && rc<right.length){
            if(left[lc]<right[rc]){
                ar[index] = left[lc];
                lc++;
                index++;
            }
            else{
                ar[index] = right[rc];
                rc++;
                index++;
            }
        }

        while(lc<left.length){
            ar[index] = left[lc];
            lc++;
            index++;
        }
        while(rc<right.length){
            ar[index] = right[rc];
            rc++;
            index++;
        }
    }
    */

    public int[] bubbleSort(int[] a){
        for(int i=0; i<a.length; i++){
            int swaps = 0;
            for(int j=0; j<a.length-1; j++){
                if(a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    swaps++;
                }
            }
            if(swaps == 0){
                Log.d(tag, "no more swaps at: i=" + i);
                break;
            }
        }
        return a;
    }

    /*
    static void heapSort(int[] a){
        int n = a.length;

        //create binary heap
        for(int i= n/2 - 1; i>=0; i--){
            heapify(a,n,i);
        }

        for (int i=n-1;i>0; i--){
            int temp = a[0];
            a[0]=a[i];
            a[i] = temp;

            heapify(a, n, i);
        }
    }

    static void heapify(int []a,int n,int i){  //n is always the same n = a.length
        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if(l<a.length && a[l]>a[largest]){
            largest = l;
        }
        if(r<n && a[r]>a[largest]){
            largest = r;
        }

        //if the current root node is not the largest then have to swap and keep heapifying next child as root
        if(largest != i){
            int swap = a[i];
            a[i] = a[largest];
            a[largest] = swap;

            heapify(a, n, largest);
        }
    }

    */

/*
    static void heapSort(int[] a){
        int n = a.length;

        for(int i = n - 1; i > 0; i--){
            heapify(a, n, i);
        }

        for (int i = n-1; i>0; i--){
            int swap = a[i];
            a[0] = a[i];
            a[i] = swap;

            heapify(a,n,i);
        }
    }

    static void heapify(int[] a, int n,int i){

        int largest = i;
        int l = 2*i+1;
        int r = 2*i + 1;

        if(l<n && a[l]>a[largest]){
            largest = l;
        }

        if(r<n && a[r]>a[largest]){
            largest = r;
        }

        if(largest != i){
            int swap = a[i];
            a[i] = a[largest];
            a[largest] = a[i];

            heapify(a,n,largest);
        }

    }
*/


    public void printValues(int a[]){
        for(int i=0; i<a.length; i++){
            Log.d(tag, "print values: " + a[i]);
        }
    }


    //factorial
    public int factorial(int x){

        if(x==1){
            return 1;
        }else{
            return x * factorial(x-1);
        }

    }



    static void mergeSort(int[] a, int l, int r){
        if(l<r){
            int m = l+r/2;
            mergeSort(a,l,m);
            mergeSort(a,m+1, r);
            merge(a,l,m,r);
        }
    }

    static void merge(int[] a, int l, int m, int r){
        int lSize = m-l+1;
        int rSize = m - r;

        int[] left = new int[lSize];
        int[] right = new int[rSize];

        for(int i=0; i<lSize; i++){
            left[i] = a[l+i];
        }
        for(int i=0; i<rSize; i++){
            right[i] = a[m+1+i];
        }

        int index = l;
        int lc = 0;
        int rc = 0;
        while(lc < lSize && rc < rSize){
            if(left[lc]<right[rc]){
                a[index] = left[lc];
                lc++;
            }
            else{
                a[index] = right[rc];
                rc++;
            }
            index++;
        }
        while(lc<lSize){
            a[index] = left[lc];
            lc++;
            index++;
        }
        while(rc<rSize){
            a[index] = right[rc];
            rc++;
            index++;
        }
    }

    static void heapSort(int[] a){
        int n = a.length;

        for(int i = n/2-1; i>=0; i--){
            heapify(a,n,i);
        }

        for(int i=n-1; i>0; i--){  //last var
            int temp = a[0];
            a[0] = a[i];
            a[i]=temp;

            heapify(a,i,0);
        }
    }

    static void heapify(int[] a, int n, int i){ //n is length of array (length not including sorted part), i is the root
        int largest = i;
        int l = 2*i +1;
        int r = 2*i +2;

        if(l<n && a[l] > a[largest]){
            largest = l;
        }
        if(r<n && a[r] > a[largest]){
            largest = r;
        }

        if(largest !=i){
            int swap = a[largest];
            a[largest] = a[i];
            a[i] = a[largest];

            heapify(a,n,largest);
        }

    }

    public static void quickSort(int[] a, int l, int r){
        if(l<r){
            int pi = partition(a,l,r);
            quickSort(a,l,pi -1);
            quickSort(a,pi+1, r){
            }
        }
    }

    public static int partition(int[] a, int l, int r){
        int pivot = a[r];
        int i = l-1;
        for(int j = l; j<r; j++){
            i++;
            if(a[j]<pivot){
                int temp = a[j];
                a[j] = a[i];
                a[i]=temp;
            }
        }

        //swap pivot at
        int temp = a[i+1];
        a[i+1] = a[r];
        a[r] = temp;

        return i+1;
    }






}






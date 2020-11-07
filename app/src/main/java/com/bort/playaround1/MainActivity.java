package com.bort.playaround1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    String tag = "berttest output";
    int ar[]=new int[7];  //mergeSort

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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



    }

    public void mergeSort(int l, int r){
        Log.d(tag,"l:"+l+" r:"+r);
        if(l<r){
            int m = l+((l+r)/2);
            if(m+1<r) {
                mergeSort(m + 1, r);
            }
            if(l<m) {
                mergeSort(l, m-1);
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

    public void printValues(int a[]){
        for(int i=0; i<a.length; i++){
            Log.d(tag, "print values: " + a[i]);
        }
    }


}
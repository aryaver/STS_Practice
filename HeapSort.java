import java.util.*;

public class HeapSort{
    public static void sort(int arr[]){
        int n= arr.length;

        // starting form the last non-leaf node of the heap, traverse backwards to the root of the heap
        for(int i=n/2-1; i>=0; i--){
            heapify(arr, n, i);
        }
    
        // traverse arr backwards
        for(int i=n-1; i>=0; i--){
            int temp= arr[0];
            arr[0]= arr[i];
            arr[i]= temp;

            // heapify to ensure that the max element is at the root
            heapify(arr, i, 0);
        }
    }

    static void heapify(int arr[], int n, int i){
        int largest= i;

        // l is the left child index of current node i
        int l= 2*i+1;

        // r= right child index of current node i
        int r= 2*i+2;

        // if left or right child nodes are greater than the current node, update "largest"
        if(l<n && arr[l]>arr[largest]){
            largest= l;
        }

        if(r<n && arr[r]>arr[largest]){
            largest= r;
        }


        // if the current node is not the largest among itself and its children, swap and heapify
        if (largest!=i){
            int temp= arr[i];
            arr[i]= arr[largest];
            arr[largest]=temp;
            heapify(arr, n, largest);
        }
    }

    public static void main(String arya[]){
        Scanner s= new Scanner(System.in);

        int n=s.nextInt();
        int arr[]= new int[n];

        for(int i=0; i<n; i++){
            arr[i]= s.nextInt();
        }
        sort(arr);

        for(int i=0; i<n; i++){
            System.out.println(arr[i]+" ");
        }
        s.close();
    }
}

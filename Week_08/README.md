学习笔记
 ```java


import java.util.PriorityQueue;

public class SortTests {

    public static void main(String[] args) {
        int[] arr = new int[] {100,2,90,1,5,6};
        SortTests sortTests = new SortTests();
        //sortTests.mergeSort(arr, 0, arr.length - 1);
        //sortTests.heapSort(arr);
        sortTests.heapSort2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    public void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left + right) >> 1;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int k = 0;
        int i = left;
        int j = mid + 1;
        while (i <= mid && j <= right) temp[k++] = array[i] <= array[j] ? array[i++] : array[j++];
        while (i <= mid)  temp[k++] = array[i++];
        while (j <= right) temp[k++] = array[j++];

        for (int l = 0; l < temp.length; l++) {
            array[l + left] = temp[l];
        }
    }

    public void heapify(int[] arr, int len, int f) {
        int left = 2*f + 1;
        int right = 2* f + 2;
        int largest = f;
        if (left < len && arr[left] > arr[f]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[f]) {
            largest = right;
        }

        if (largest != f) {
            int temp = arr[f];
            arr[f] = arr[largest];
            arr[largest] = temp;
            heapify(arr, len, largest);
        }
    }

    public void heapSort(int[] arr) {
        if (arr == null) return;
        //构建堆
        for (int i = arr.length / 2 - 1; i >=0; i--) {
            heapify(arr, arr.length, i);
        }
        
        //以此将堆顶元素取出放到array前面
        for (int i = arr.length - 1; i >= 0; i--) {
            //将顶端的最小元素 取出，放到arr[i],
            int temp = arr[0]; arr[0] = arr[i]; arr[i] = temp;
            //从i出发再次构建小根堆
            heapify(arr, i, 0);
        }
    }

    public void heapSort2(int[] arr) {
        if (arr == null) return;
        PriorityQueue<Integer> heap = new PriorityQueue<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = heap.poll();
        }
    }
}

```
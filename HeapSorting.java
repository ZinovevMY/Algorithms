public class HeapSorting {
    public static void heapSorting(int[] array){
        int heap_size = array.length;
        for (int i = heap_size / 2 - 1; i >= 0; i--){
            heapify(array, heap_size, i);
        }
        for (int i = heap_size - 1; i >= 0; i--){
            int tmp = array[0];
            array[0] = array[i];
            array[i] = tmp;
            heapify(array, i, 0);
        }

    }
    public static void heapify(int[] array, int heap_size, int i){
        int root = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (heap_size > left && array[left] > array[root]){
            root = left;
        }
        if (heap_size > right && array[right] > array[root]){
            root = right;
        }
        if (root != i){
            int tmp = array[i];
            array[i] = array[root];
            array[root] = tmp;
            heapify(array, heap_size, root);
        }
    }

    public static void main(String[] args) {
        int[] array = {25, 6, 17, 1, 5, 3, 2, 0, 9, 11};
        heapSorting(array);
        for (int i = 0; i < array.length; i++){
            System.out.printf(array[i] + " ");
        }
    }
}

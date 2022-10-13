package example;

public class QuickSorter1 implements Sorter {

    private int[] a;

    @Override
    public void load(int[] a) {
        this.a = a;
    }

    private void swap(int i, int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        plan += "" + a[i] + "<->" + a[j] + "\n";
    }

    private String plan = "";

    @Override
    public void sort() {
        quickSort(0,a.length-1);
    }
    public void quickSort(int low, int high) {
        if (low < high) {
            // 获取划分子数组的位置
            int position = partition(low, high);
            // 左子数组递归调用
            quickSort(low, position -1);
            // 右子数组递归调用
            quickSort(position + 1, high);
        }
    }
    public int partition(int low, int high) {
        int pivot = a[high];
        int pointer = low;
        // 遍历数组中的所有元素，将比中心元素大的放在右边，比中心元素小的放在左边
        for (int i = low; i < high; i++) {
            if (a[i] <= pivot) {
                swap(i,pointer);
                pointer++;
            }
        }
        swap(high,pointer);
        return pointer;
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}

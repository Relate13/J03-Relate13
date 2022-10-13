package example;

public class SelectionSorter implements Sorter {

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
        int index,min;
        for(int i=0;i<a.length-1;i++){
            index = i;
            min = a[i];
            for(int j=i+1;j<a.length;j++){
                if(a[j]<min){
                    min = a[j];
                    index = j;
                }
            }
            swap(index,i);
        }
    }

    @Override
    public String getPlan() {
        return this.plan;
    }

}

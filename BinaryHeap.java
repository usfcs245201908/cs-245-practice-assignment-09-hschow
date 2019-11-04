public class BinaryHeap {

    int size = 0;
    int[] data =  new int[10];
    int maxSize = 10;

    void add(int item){
        if (size>=maxSize-1){
            growArray();
        }
        data[size++]=item;
        int child = size-1;
        if (size>1){
            int parent = (child-1)/2;
            if(parent>=0){
                while(data[child]<data[parent]){
                    swap(child,parent);
                    child=parent;
                    parent=(parent-1)/2;
                }
            }
        }
    }
    void growArray(){
        maxSize=maxSize*2;
        int[] temp = new int[maxSize];
        for (int i = 0; i<data.length;i++){
            temp[i]=data[i];
        }
        data=temp;
    }

    int remove(){
        if (size==0){
            throw new NullPointerException();
        }
        int removed=data[0];
        if (size==1){
            data[0]=0;
        }
        data[0]=data[--size];
        siftDown(0);
        return removed;
    }
    void siftDown(int index){
        if (size==0){
            return;
        }
        int child = (2*index)+1;
        if (child>=size){
            return;
        }
        if (child+1<size){
            if (data[child]>data[child+1]){
                child++;
            }
        }
        if (data[index]>data[child]){
            swap(index,child);
            siftDown(child);
        }
    }
    public void swap(int index1, int index2){
        int temp = data[index1];
        data[index1]=data[index2];
        data[index2]=temp;
    }

}

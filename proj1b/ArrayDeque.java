public class ArrayDeque<Item> implements Deque<Item>{
    int start;
    int end;
    int fullSize;
    Item[] arr;
    int size;
    public ArrayDeque(){
        start = 0;
        end = 0;
        arr = (Item[])(new Object[8]);
        size = 0;
        fullSize = 8;
    }
    private double loadFactor(){
        return (double)size / fullSize;
    }
    private void resize(int newsize){
        Item[] newarr = (Item[])(new Object[newsize]);
        for(int i = 0; i < size; i++){
            newarr[i + 1] = arr[(start + 1 + i) % fullSize];
        }
        arr = newarr;
        start = 0;
        end = size + 1;
        fullSize = newsize;
    }
    @Override
    public void addFirst(Item a){
        if(size == 0)
            end = (end + 1) % fullSize;
        if(size == fullSize){
            resize(fullSize * 2);
        }
        arr[start] = a;
        start = (start - 1 + fullSize) % fullSize;
        size++;
    }
    @Override
    public void addLast(Item a){
        if(size == 0){
            start = (start - 1 + fullSize) % fullSize;
        }
        if(size == fullSize){
            resize(fullSize * 2);
        }
        arr[end] = a;
        end = (end + 1 + fullSize) % fullSize;
        size++;
    }
    @Override
    public boolean isEmpty(){
        return size == 0;
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public void printDeque(){
        for(int i = 0; i < size; i++){
            if(i != size){
                System.out.print(arr[(start + 1 + i) % fullSize].toString() + " ");
            }
            else System.out.println(arr[(start + size) % fullSize].toString());
        }
    }
    @Override
    public Item removeFirst(){
        Item result;
        result = arr[(start + 1) % fullSize];
        arr[(start + 1) % fullSize] = null;
        start = (start + 1) % fullSize;
        size--;
        if(fullSize >= 16)
            if(loadFactor() <= 0.25)
                resize(fullSize / 2);
        return result;
    }
    @Override
    public Item removeLast(){
        Item result;
        result = arr[(end - 1 + fullSize) % fullSize];
        arr[(end - 1 + fullSize) % fullSize] = null;
        end = (end - 1 + fullSize) % fullSize;
        size--;
        if(fullSize >= 16)
            if(loadFactor() <= 0.25)
                resize(fullSize / 2);
        return result;
    }
    @Override
    public Item get(int index){
        return arr[(start + 1 + index) % fullSize];
    }
    public static void main(String[] args){
        ArrayDeque<Integer> test = new ArrayDeque<>();
        for(int i = 0; i < 5; i++){
            test.addFirst(i);
        }
        for(int i = 0; i < 5; i++)
            test.addLast(i);
        test.printDeque();
        for(int i = 0; i < 10; i++)
            System.out.print(test.removeLast() + " ");
    }
}

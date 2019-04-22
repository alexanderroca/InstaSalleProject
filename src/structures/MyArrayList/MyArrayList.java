package structures.MyArrayList;

public class MyArrayList<E> {

    public int CAPACITY_DEFAULT;
    private Object[] objects;
    private int size = 0;

    public MyArrayList(int dimension){
        objects = new Object[dimension];
        CAPACITY_DEFAULT = dimension;
    }

    public void add(E e){
        if(size == CAPACITY_DEFAULT)
            ensureCapacity();
        objects[size++] = e;
    }

    private void ensureCapacity(){
        int newCAPACITY_DEFAULT = objects.length * 2;
        Object[] newObjects = new Object[newCAPACITY_DEFAULT];

        for(int i = 0; i < objects.length; i++)
            newObjects[i] = objects[i];

        setCapacityDefault(newCAPACITY_DEFAULT);
        setObjects(newObjects);
    }

    public E get(int index){
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        return (E) objects[index];
    }

    public void rangeCheck(int index){
        if(index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }

    public E set(int index, E element) {
        rangeCheck(index);

        E oldValue = (E) objects[index];
        objects[index] = element;
        return oldValue;
    }

    public void remove(Object element){
        boolean found = false;
        int pos = 0;

        if(size < 0)
            throw new IndexOutOfBoundsException("Size: " + size);

        for(int i = 0; i < objects.length && !found; i++){
            if(objects[i].equals(element)) {
                found = true;
                pos = i;
            }   //if
        }   //for

        if(found && size > 0) {
            for (int i = pos; i < size - 1; i++)
                objects[i] = objects[i + 1];

            size--;
        }   //if
        else
            System.out.println("This element doesn't exist");
    }

    public void display(){
        for (int i = 0; i < size; i++)
            System.out.println(objects[i]);
    }

    public int getCapacityDefault() {
        return CAPACITY_DEFAULT;
    }

    public void setCapacityDefault(int capacityDefault) {
        CAPACITY_DEFAULT = capacityDefault;
    }

    public Object[] getObjects() {
        return objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

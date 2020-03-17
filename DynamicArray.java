import java.io.*;
import java.util.*;
/* to get rid of the error at runtime 
    use @SupressWarnings
*/
@SuppressWarnings("unchecked")
public class DynamicArray<T>{
    T[] arr;
    int capacity;
    int len;
    public DynamicArray()
    {
        this(16);//this will call the below constructor!!!
    }
    public DynamicArray(int capacity)
    {
        if(capacity<=0)throw new IllegalArgumentException();
        else{
            this.capacity=capacity;
            arr=(T[]) new Object[capacity];
            len=0;
        }
    }
    /* Remove by value */
    public void remove(T data)
    {
        int index=-1;
        for(int i=0;i<len;i++)
        {
            if(arr[i].equals(data))
            {
                index=i;
            }
        }
        if(index==-1)
        {
            System.out.println("\n Element Not Found");
        }
        else{
            int j=0;
            T[] obj=(T[]) new Object[capacity];
            for(int i=0;i<len;i++)
            {
                if(index!=i)
                {
                    obj[j]=arr[i];
                    j++;
                }
            }
            arr=obj;
            len--;
        }
        check_for_shrink();
  
    }
    /*
    Enlarge ArrayList if needed too.
    */
    public void extendArray(T data)
    {
        capacity=2*capacity;
        T[] obj=(T[]) new Object[capacity];
        for(int i=0;i<len;i++)
        {
            obj[i]=arr[i];
        }
        arr=obj;
        arr[len]=data;
    }
    /*
    APPEND LIKE FUNCTION
    */
    public void add(T data)
    {
        if(len+1>=capacity)
        {
            extendArray(data);
        }
        else
        {
            arr[len]=data;
        }
        len++;
    }
    /*
    Remove by Index
    */
    public void removeAt(int index)
    {
        int j=0;
        T[] obj=(T[]) new Object[capacity];
        for(int i=0;i<len;i++)
        {
            if(i==index)
            {
                continue;
            }
            obj[j]=arr[i];
            j++;
        }
        arr=obj;
        len--;
        check_for_shrink();
  
    }
    /*
    Clear the array as empty one
    */
    public void clear()
    {
        for(int i=0;i<len;i++)
        {
         arr[i]=null;
        }
        len=0;
    }
    /*
    Shrink array if unwanted capacity */
    public void check_for_shrink()
    {
        if(len%capacity==0)
        {

        }
        else
        {
            capacity=capacity/2;
        }
    }
    public void display()
    {
        for(int i=0;i<len;i++)
        {
            System.out.println(arr[i]);
        }
    }

    public void set(int index,T elem)
    {
        arr[index]=elem;
    }
    T get(int index)
    {
        return arr[index];
    }
    boolean IsEmpty()
    {
        return len==0;
    }

    public static void main(String args[])
    {
        DynamicArray<Integer> arr=new DynamicArray<Integer>();
        System.out.println(arr.capacity);
        for(int i=0;i<17;i++)
        {
        arr.add(i);
        }
        arr.remove(8);
        arr.display();
        System.out.println(arr.capacity);
        for(int i=0;i<17;i++)
        {
        arr.add(i);
        }
        System.out.println(arr.len);
        System.out.println(arr.capacity);
        System.out.println(arr.IsEmpty());
        arr.removeAt(1);
        arr.set(1,8);
        arr.clear();
        arr.display();
        System.out.println(arr.IsEmpty());
        
    }
}
import java.io.*;
import java.util.*;

@SuppressWarnings("unchecked")
public class LinkedList<T>
{
    int size=0;
    Node<T> head=null;
      public class Node<T>
      {
          T data;
          Node<T> next;
          public Node(T data,Node<T> next)
          {
              this.data=data;
              this.next=next;
          }
      }

      public void add(T elem)
      {
          addLast(elem);
      }
      public void addLast(T elem)
      {
          Node<T> temp,trav;
          if(head==null)
          {
            temp=new Node(elem,null);
            head=temp;
          }
          else
          {
              trav=head;
              while(trav.next!=null)
              {
                  trav=trav.next;
              }
              temp=new Node(elem,null);
              trav.next=temp;
          }
          size++;
      }
      public void addFirst(int elem)
      {
          Node<T> temp;
          if(head==null)
          {
              temp=new Node(elem,null);
              head=temp;
          }
          else
          {
              temp=new Node(elem,head);
              head=temp;
          }
          size++;
      }

      public int length()
      {
          return size;
      }
      public int find(T data)
      {
          Node<T> temp=head;
          int pos=0;
        while(temp.next!=null)
        {
            if(temp.data.equals(data))
            {
                return pos;
            }
            pos++;
            temp=temp.next;
        }
        return -1;
      }



      public void display()
      {
          Node<T> trav=head;
          while(trav!=null)
          {
              System.out.println(trav.data);
              trav=trav.next;
          }
      }
      boolean IsEmpty()
      {
          return head==null;
      }
      public void removeFirst()
      {
          if(IsEmpty())
          {
            throw new RuntimeException("Empty List");
          }
          else{
        Node<T> temp=head;
        head=head.next;
        temp.data=null;
        temp.next=null;
        size--;
            }
      }
      public void removeLast()
      {
        if(IsEmpty())
          {
            throw new RuntimeException("Empty List");
          }
          else{
              Node<T> fast=head.next;
              Node<T> slow=head;
              while(fast.next!=null)
              {
                slow=slow.next;
                fast=fast.next;
              }
              if(IsEmpty())
              {
                  head=null;
              }
              slow.next=null;
          }  
          size--;
      }  
      public void removeAt(int index)
      {
          if((index>=0 && index<=size))
          {
          if(IsEmpty())
          {
              throw new RuntimeException("Empty List");
          }
          else
          {
             if(index==0)
              {
                  removeFirst();
              }
              else
              {
                Node<T> slow=head;
              //System.out.println(slow.data);
                  for(int i=0;slow!=null && i<index-1;i++)
                  {
                      //System.out.println(slow.data);
                      slow=slow.next;
                  }
                  if(slow==null)
                  {
                    slow=null;
                  }
                  else{
                  Node<T>remain=slow.next.next;
                  slow.next=null;
                  slow.next=remain;
                  }
                }
          }
          size--;
        }
        else
        {
            throw new RuntimeException("IndexOutOfBoundsException");
        }
      }
      public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<Integer>();
        for(int i=0;i<8;i++)
        {
            list.add(i);
        }    
        list.display();
        
        System.out.println("\n addliast");
        for(int i=0;i<8;i++)
        {
            list.addFirst(i);
        }    
        list.addFirst(100);
        list.display();
        System.out.println("here");
        System.out.println(list.length());
        list.removeFirst();
        list.display();
        

        System.out.println("here");
        //System.out.println(list.length());
        list.removeLast();
        list.removeLast();
        list.display();
        
        System.out.println("here");
        //System.out.println(list.length());
        
        list.removeAt(0);
        list.removeAt(2);
        
        list.removeAt(3);
        list.removeAt(1);
        
        list.display();
       
        System.out.println(list.find(0));

      }
}
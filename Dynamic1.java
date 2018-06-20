package recursion;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Dynamic1 {
     int elem[];
     private  int index;
     
           public Dynamic1(){
                   elem = new int[6];
                   System.out.println("Dynamic Array");
           }
           
           public int size() {
                   return index;
           }
           
             public int get(int index1) {
                   if (index1 < 0 || index1 >= index) {
                           return -1;
                   }
                   return elem[index1];
           }

           public void set(int index1, int element) {
                    try{
                   if (index1 > index) {
                    throw new ArrayIndexOutOfBoundsException();
                   } else if (index1 == index) {
                           add(element);
                   } else {
                           elem[index1] = element;
		}
                    }
                    catch(ArrayIndexOutOfBoundsException e1)
                    {
                        System.out.println("Index out of bound");
                    }
            }

            public void add(int element) {
                   if (index == elem.length) {
                           restdyn();
                   }
                   elem[index] = element;
                   index++;
           }
            
           public int pop() {
                   if (index < 1) {
                           return -1;
                   }
                   int value = elem[index - 1];
                   elem[index - 1] = 0;
                   index--;
                   return value;
           }

           public void restdyn() {
                   int temp[] = elem;
                   elem = new int[(int)(elem.length * 1.5)];
                   for (int i = 0; i < temp.length; i++) {
                           elem[i] = temp[i];
                   }
           }
           
           public boolean isEmpty() {
                   if (size()==0) {
                           return true;
                   } else {
                           return false;
                   }
           }
           public void show()
           {
               for(int i=0;i<elem.length;i++)
                   System.out.print(elem[i]+" ");
           }

	public static void main(String[] args) throws InputMismatchException{
		Dynamic1 obj=new Dynamic1();
                Scanner sc = new Scanner(System.in);
                System.out.print("Empty : ");
                System.out.println(obj.isEmpty());
                System.out.println("Elements from 1 upto : ");
                int n=sc.nextInt();
		for(int i=0;i<n;i++)
                {
                    obj.add(i);
                }
                System.out.print("Size : ");
		System.out.println(obj.size());
                System.out.println("Set Element");
                System.out.print("Enter index : ");
                int i1=sc.nextInt();
                obj.set(i1,10);
                System.out.print("Pop element : ");
		System.out.println(obj.pop());
                try{
                    System.out.println("Get Element : ");
                    System.out.print("Element : ");
                    int i2=sc.nextInt();
                    int n1=obj.get(i2);
                    if(n1==-1)
                        throw new InputMismatchException();
                    else
                       System.out.println(obj.get(7)); 
                }
                catch(InputMismatchException e){
                        System.out.println("Not in Array");
                }
                System.out.println("Updated array : ");
                obj.show();
	}
}
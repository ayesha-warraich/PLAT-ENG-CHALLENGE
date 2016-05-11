  
import java.util.*;

public class Test{ 

	public static void main (String args[]){
  
    Queue que = new QueueImp();
    Queue que_a = new QueueImp();

    System.out.println("Que a");
    ((QueueImp) que_a).printContents();
    
    System.out.println("\nQue");
	((QueueImp) que).printContents();
    
    
 System.out.println("\n***Enqueue Tests***");  

	@SuppressWarnings("unchecked")
	Queue que_1 = (QueueImp) que.enQueue(1);
       System.out.println("\nQue1");
       ((QueueImp) que_1).printContents();
    
    Queue que_2 = (QueueImp) que_1.enQueue(2);
    	System.out.println("\nQue2");
    	((QueueImp) que_2).printContents();
    
    Queue que_3 = (QueueImp) que_2.enQueue(3);
    	System.out.println("\nQue3");
    	((QueueImp) que_3).printContents();
    
    Queue que_4 = (QueueImp) que_3.enQueue("4");
    	System.out.println("\nQue4");
    	((QueueImp) que_4).printContents();
    
    Queue que_5 = (QueueImp) que_4.enQueue(5);    
    	System.out.println("\nQue5");
    	((QueueImp) que_5).printContents();
   
    Queue que_6 = (QueueImp) que_5.enQueue("6");
    	System.out.println("\nQue6");
    	((QueueImp) que_6).printContents();
 
 //enqueing to que5 to see if the original que can be mutated.   
    que_5.enQueue(7);
    que_5.enQueue(8);
    que_5.enQueue(9);
   
    System.out.println("\nQue5 after adding more data");
    ((QueueImp) que_5).printContents();
 
    

  System.out.println("\n***Dequeue Tests***");  
 
  	que_a.deQueue();
   
  	System.out.println("\nQue a");
    ((QueueImp) que_a).printContents();

    ////Dequeuing 2,1    
    Queue que_deq = que_2.deQueue();
    Queue que_deq_a = que_deq.deQueue();

    System.out.println("\nQue2");
    ((QueueImp) que_2).printContents();
   
    System.out.println("\nNew Que 2 after one deQueue");
    ((QueueImp) que_deq).printContents();
 
    System.out.println("\nNew Que 2 after two dequeue");
    ((QueueImp) que_deq_a).printContents();
    
    System.out.println("\nQue2 not mutable test");
    ((QueueImp) que_2).printContents();
    //dequeuing orig queue2
    
    que_2.deQueue();
    que_2.deQueue();
    
    System.out.println("\nQue2 not mutable test");
    ((QueueImp) que_2).printContents();

    }
	   
  }
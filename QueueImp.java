public final class QueueImp<T> implements Queue<T> {
    
/****
 * Node class is used to implement the queue
-Queue generated from a singly linked list of nodes, from last pointer(where enQueue items are added) to first pointer
(where items are dequeued). Enqueue function just adds another node at end of the queue ( top of the list in theory 
since links are directed from last to first) and stores the new last pointer. Dequeue traverses the list until the head of the 
queue is reached,removes that node, stores the new first pointer and returns a new queue). 

***/	
	class Node<T> implements Cloneable{ 
	  
		public T data;
	    public Node<T> next;

	    Node(){
	    	this.data = null;
	    	this.next = null;
	    }
	  
	    Node(T data, Node<T> next){
	        this.data = data;
	        this.next = next;
	    }
	    
	    @Override
	    protected Object clone() throws CloneNotSupportedException {
	        return super.clone();
	    }
	}
	
	private Node<T> first;
    private Node<T> last;

    public QueueImp(){
        first = null;
        last = null;
    }

    public QueueImp(Node<T> first_p, Node<T> last_p){        
    	first = first_p;
    	last = last_p;        
     }

    @Override
    public Queue<T> enQueue(T data) {
    
    	Node<T> item_enq = new Node();
    	item_enq.data = data;
    	item_enq.next = null;
    	Node<T> first_clone; //pointer to first node in queue
    	Node<T> last_clone ; //pointer to last node in queue
    	
    	try {    
    		if ( isEmpty()==true ){    			
    			return new QueueImp(item_enq,item_enq);
          	}       	
        	else{
       		last_clone = (QueueImp<T>.Node<T>) last.clone();
        	first_clone = (QueueImp<T>.Node<T>) first.clone();        		        	
        		if (last_clone.next == null ){	
        			last_clone = item_enq;
        			last_clone.next = first_clone;
        			return new QueueImp(first_clone,last_clone);
        		}       		
        		else{  			
        		item_enq.next = last_clone;
        		return new QueueImp(first_clone,item_enq);
        		}  	    	
        	}
    	} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}	
    	return null;
  }
    
    @Override
    public Queue<T> deQueue() {   	
    	
    	Node<T> last_clone ;
    	Node<T> first_clone;   	
    	if (isEmpty() == true){
			return new QueueImp<T>();    			
    	}
    	else{
    		try {    
    			first_clone = (QueueImp<T>.Node<T>) first.clone();
    			last_clone = (QueueImp<T>.Node<T>) last.clone();

    			if (last_clone.next == null){
    				return new QueueImp<T>();    			
    			} else if(last_clone.next.next == null){
    				last_clone.next = null;
    				first_clone = last_clone;
    				return (new QueueImp<T>(first_clone,last_clone));   			
    			}
    			else{
    				Node<T> temp_que = new Node() ;
    				Node<T> finalQueue = new Node<T>(last_clone.data,temp_que);
    				Node<T> first_pointer =  null;
    				finalQueue.next = temp_que;
    				last_clone = last_clone.next;       	
    				while ( last_clone.next != null ){
    					temp_que.data = last_clone.data;
    					if (last_clone.next.next != null){
    						temp_que.next = new Node();
    						temp_que = temp_que.next;}
    						first_pointer = last_clone;	
    						last_clone = last_clone.next;
    					}
    				return (new QueueImp<T>(first_pointer,finalQueue));       
    			}
    			
    		}catch (CloneNotSupportedException e) {
    			e.printStackTrace();
    		}
    	}
    	return null;       
    }
    
    @Override
    public T head() {
        return (T) first.data;
    }
    
    @Override
    public boolean isEmpty() {
    	if (first == null && last == null){ return true; }
    	else{ return false;}	   		
    	}

    public void printContents(){
    	Node<T> temp = new Node();
    	temp = last;
    	String content = "";
    	while(temp != null){
    		content = content  + temp.data;
    		temp = temp.next;
    	}   	
    	

    	if (content == ""){
    		System.out.println("Empty");
    	}
    	else{
    		for (int i= content.length()-1; i>=0 ; i--){
    			System.out.println(content.charAt(i));
    		}
    	} 
	
    }
    

}
    


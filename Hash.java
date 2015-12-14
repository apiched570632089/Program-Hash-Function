///////////////////////////////////////////////////////////////////////////////
//////////////////////////Program Hash Function////////////////////////////////
/////////////////////////////apiched audomphon/////////////////////////////////
/////////////////////////////////570632089/////////////////////////////////////
import java.io.IOException;

class Link {
  private int data;
  public Link next;

  public Link(int d) {
    data = d;
  }

  public int getKey() {
    return data;
  }

  public void displayLink() {
    System.out.print(data + " ");
  }
}

class SortedList {
  private Link first;
  public SortedList() {
    first = null;
  }

  public void insert(Link theLink){
    int key = theLink.getKey();
    Link previous = null; 
    Link current = first;
    while (current != null && key > current.getKey()) { 
      previous = current;
      current = current.next; 
    }
    if (previous == null) 
      first = theLink; 
    else
      previous.next = theLink; 
    theLink.next = current; 
  }

  public void delete(int key){ 
    Link previous = null; 
    Link current = first;

    while (current != null && key != current.getKey()) { 
      previous = current;
      current = current.next; 
    }
    if (previous == null) 
      first = first.next;       
    else
      previous.next = current.next; 
  }

  public Link find(int key) {
    Link current = first; 
    while (current != null && current.getKey() <= key) { 
      if (current.getKey() == key) 
        return current;  
      current = current.next;
    }
    return null;
  }

  public void displayList() {
    System.out.print(": ");
    Link current = first;
    while (current != null){
      current.displayLink(); 
      current = current.next;
    }
    System.out.println("");
  }
}

public class Hash {
  private SortedList[] hashArray; 

  private int arraySize;

  public Hash(int size) {
    arraySize = size;
    hashArray = new SortedList[arraySize];
    for (int i = 0; i < arraySize; i++)
      hashArray[i] = new SortedList(); 
  }

  public void displayTable() {
    for (int j = 0; j < arraySize; j++) {
      System.out.print(j + ""); 
      hashArray[j].displayList(); 
    }
  }

  public int hashFunc(int key) {
    return key % arraySize;
  }

  public void insert(Link theLink) {
    int key = theLink.getKey();
    int hashVal = hashFunc(key); 
    hashArray[hashVal].insert(theLink); 
  }

  public void delete(int key) {
    int hashVal = hashFunc(key);
    hashArray[hashVal].delete(key); 
  }

  public Link find(int key) {
    int hashVal = hashFunc(key);
    Link theLink = hashArray[hashVal].find(key);
    return theLink;
  }

  public static void main(String[] args) throws IOException {
    int aKey;
    Link dataItem;
    int size, initSize, keysPerCell = 20;
    size = 50;
    initSize = 100;
    Hash hashTable = new Hash(size);
    /////////////////data input random 0-1000///////////////////////////////
    for (int i = 0; i < initSize; i++){
      aKey = (int) (java.lang.Math.random() * keysPerCell * size);
      dataItem = new Link(aKey);
      hashTable.insert(dataItem);
    }
    ////////////////////////////////////////////////////////////////////////
    hashTable.displayTable();
    aKey = 100;
    dataItem = new Link(aKey);
    hashTable.insert(dataItem);
    aKey = 100;
    hashTable.delete(aKey);

    aKey = 50;
    dataItem = hashTable.find(aKey);
    if (dataItem != null)
      System.out.println("Found " + aKey);
    else
      System.out.println("Could not find " + aKey);
  }

}

           
         
    
    
    
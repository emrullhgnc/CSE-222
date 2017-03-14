package myStringBuilder;

import java.util.Iterator;
import java.util.*;

/**
 * Created by egc on 3/11/2017.
 */

public class SingleLinkedList<E> implements Iterable{
    /**
     * Node un kendisi
     */
    private Node<E> head =null;
    /**
     * Silinen Node ları tutar.
     */
    private ArrayList<Node> deletedNodes = new ArrayList<Node>();
    /**
     * Node ların sayısı
     */
    private int size;

    public Node<E> getHead() {
        return head;
    }

    /**
     * inner class
     * @param <E> Node class type Enum
     */
    private static class Node<E>{
        /**
         * tutulan data
         */
        private E data;
        /**
         * Bir sonraki Node u tutar
         */
        private Node<E> next;

        /**
         * Constractor
         * @param dataItem
         */
        private Node(E dataItem){
            data =dataItem;
            next=null;
        }

        /**
         *
         * Constractor
         * @param dataItem eklenilecek data
         * @param nodeRef sonraki Node u tutar
         */
        private Node(E dataItem,Node<E> nodeRef){
            data=dataItem;
            next=nodeRef;
        }

        public E getData() {
            return data;
        }
    }
    // Inner class example
    private class MyIterator implements  Iterator<E> {
        /**
         * Bu method head in gosterdigi node u check eder.
         * iterator class ından override yapilmistir.
         * @return boolean type
         */
        @Override
        public boolean hasNext() {
            if(head.next==null)
                return false;
            else
                return true;
        }

        /**
         * Bu method head den sonraki node un data sina ulasir.
         * iterator class ından override yapilmistir.
         * @return head den sonraki node un data sını return eder
         */
        @Override
        public E next() {
            if(this.hasNext()) {
                Node<E> temp=head;
                head=head.next;
                return temp.data;
            }
            throw new NoSuchElementException();

        }

        /**
         * ımplement edilmedi
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /**
     *
     * Bu method iterator olarak node lara ulasmada kullanilir.
     * @return iterator type
     */
    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    /**
     *
     * Bu method node silme islemi yapar.
     * @param node parametreden sonraki node u sil
     * @return  silinen node u return eder.
     */
    private E removeAfter(Node<E> node){
        Node<E> temp = node.next;

        if(temp != null){
            node.next=temp.next;
            deletedNodes.add(temp.next);
            size--;
            return temp.data;
        }else{
            return null;
        }

    }

    /**
     *
     * Bu method silinen node ları return eder.
     * @return ArrayList type
     */
    public ArrayList<Node> getDeletedNodes() {
        return deletedNodes;
    }

    /**
     *
     * Bu method ilk node u siler
     * @return silinen Node un data sını return eder.
     */
    public E removeFirst(){
        Node<E> temp = head;
        if(head != null){
            head = head.next;
        }
        if(temp != null){
            deletedNodes.add(temp);
            size--;
            return temp.data;
        }else {
            return null;
        }

    }

    /**
     *
     * Bu method silinen Node ları string hale getirir.
     * @return String
     */
    public String deletedToString (){
        String result="";

        for(int i=0;i<deletedNodes.size();++i){
            result += deletedNodes.get(i).data;
            result += " ->";
        }
        return result;

    }


    /**
     *
     * Bu method toplam Node sayısını return eder.
     * @return toplam Node sayısı
     */
    public int getSize(){
        return size;
    }

    /**
     * Bu method Node eklemede kullanılır.
     * Eger silinen Node varsa o Node kullanılarak ekleme yapılır.
     * @param item eklenilecek obje
     */
    public void addFirst(E item){

        if(deletedNodes.size()==0)
            head=new Node(item,head);
        else{
            int lastIndex =deletedNodes.size()-1;

            deletedNodes.get(lastIndex).data=item; //set nodes data fields
            deletedNodes.get(lastIndex).next=head;
            head=deletedNodes.get(lastIndex);
            deletedNodes.remove(lastIndex);
        }

        size++;
    }

    /**
     *
     * Bu method istenilen index teki Node u return eder.
     * @param index
     * @return  aranan Node
     */
    private Node<E> getNode(int index){
        Node<E> node =head;
        for(int i=0;i<index && node != null ;++i)
            node = node.next;
        return node;
    }

    /**
     *
     * Bu method aranan index teki obje ye ulasır.
     * @param index aranan objenın konumu
     * @return Object
     */
    public E get(int index){

        if(index <0 || index >= size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;

    }

    /**
     * Tester class
     * @return String
     */
    public String reverseToString(){
        return reverseToString(head);
    }

    /**
     * Bu method String i recursive olarak tersten yazdırır.
     * @param node her seferde bi sonraki node verilir
     * @return String
     */
    private String reverseToString(Node<E> node){
        if(node ==null){
           return "";
        }
        return reverseToString(node.next)+" ->"+node.getData();
    }

    /**
     *
     * Bu method Node ları string hale getirir.
     * @return String
     */
    @Override
    public String toString(){
        Node<E> nodeRef=head;
        StringBuilder result =new StringBuilder();

        while(nodeRef != null){
            result.append(nodeRef.data);
            if(nodeRef.next != null)
                result.append(" ->");
            nodeRef=nodeRef.next;
        }
        return result.toString();

    }
}

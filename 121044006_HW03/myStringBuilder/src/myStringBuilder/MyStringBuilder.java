package myStringBuilder;

import java.util.Iterator;


/**
 * Created by egc on 3/10/2017.
 */
public class MyStringBuilder<E> {
    /**
     * Single linked list te data lar tutulur.
     */
    private SingleLinkedList sll=new SingleLinkedList();

    /**
     *
     * Bu method obje ekler
     * @param obj yeni obje ekle
     */
    public void append(E obj){

        sll.addFirst(obj);
    }

    /**
     *
     * Bu method index kullanarak toString olusturur.
     * @return  String
     */
    @Override
    public String toString(){

        String result="";
        for(int i=0;i<sll.getSize();++i){
            result+=sll.get(i);
            if(i != sll.getSize()-1)
                result += " ->";
        }

        //System.out.println("result 1 "+result);
        return result;
    }

    /**
     *
     * Bu method iterator u kullanarak
     *  Node ları String halde gosterir.
     * @return  String
     */
    public String toStringWithIterator(){
        Iterator it=sll.iterator();
        String result = "";

        while(it.hasNext())
        {
            result +=it.next();
            result += " ->";
        }
        result +=sll.get(0);
       // System.out.println("result 2 "+result);
        return result;
    }

    /**
     *
     * Bu method Single LinkedList in toString methodunu kullanarak
     *  String return eder.
     * @return String
     */
    public String toStringWithLinkedList(){
      //  System.out.println("result 3 "+sll.toString());

        return sll.toString();
    }

}

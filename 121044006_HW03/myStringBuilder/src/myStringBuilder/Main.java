package myStringBuilder;

import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * Created by egc on 3/11/2017.
 */
public class Main {




    public static void main(String args[]) throws IOException{
        /*{
            FileWriter out3 = null;

            String val;

            try {

                out3 = new FileWriter("numbers.txt");


                for (int i = 1; i < 10001; ++i) {
                    out3.append(String.valueOf(i));
                    out3.append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                if (out3 != null) {
                    out3.close();
                }
            }
        }*/
        {
            MyStringBuilder myStringBuilder = new MyStringBuilder();

            FileReader in = null;
            FileWriter out1 = null;
            FileWriter out2 = null;
            FileWriter out3 = null;

            String val;

            try {
                in = new FileReader("numbers.txt");
                out1 = new FileWriter("result1.txt");
                out2 = new FileWriter("result2.txt");
                out3 = new FileWriter("result3.txt");

                BufferedReader br = new BufferedReader(in);

                while ((val = br.readLine()) != null) {
                    myStringBuilder.append(val);
                   // System.out.println(val);
                }
               // System.out.println("Test Of toStringWithLinkedList" );
                out3.append(myStringBuilder.toStringWithLinkedList());
                //System.out.println(myStringBuilder.toStringWithLinkedList());
                out1.append(myStringBuilder.toString());
               // System.out.println(myStringBuilder.toString() );
                out2.append(myStringBuilder.toStringWithIterator());
                //System.out.println("added  " );*/

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (in != null) {
                    in.close();
                }
                if (out1 != null) {
                    out1.close();
                }
                if (out2 != null) {
                    out2.close();
                }
                if (out3 != null) {
                    out3.close();
                }

            }
        }
        //Test Part Two
        {
            System.out.println("**************** PART-2 ***********************");
            System.out.println("*                                             *");
            SingleLinkedList sll =new SingleLinkedList();

            FileReader in = null;

            String val;

            try {

                in = new FileReader("numbers.txt");

                BufferedReader br = new BufferedReader(in);
                int num=1;
                while ((val = br.readLine()) != null) {
                    sll.addFirst(val);
                    if( num==100 )
                        break;
                    num++;

                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                if (in != null) {
                    in.close();
                }
            }

            System.out.println("All Nodes In SingleLinkedList  ");
            System.out.println(sll.toString());
            System.out.println("\n");
            System.out.println("Test Of Reverse String Method  ");
            System.out.println(sll.reverseToString());
            System.out.println("*                                             *");
            System.out.println("***********************************************");
        }
        //Test Part Four
        {
            System.out.println("**************** PART-4 ***********************");
            System.out.println("*                                             *");
            SingleLinkedList sll =new SingleLinkedList();
            FileReader in = null;
            String val;

            try {

                in = new FileReader("numbers.txt");

                BufferedReader br = new BufferedReader(in);
                int num=1;
                while ((val = br.readLine()) != null) {
                    sll.addFirst(val);
                    if( num==100 )
                        break;
                    num++;
                }

                for(int i=0;i<50;++i)
                    sll.removeFirst();
                System.out.println("Deleted First Fifty Nodes " );

                System.out.println(sll.deletedToString());
                System.out.println("\n");
                for(int i=100;i<=200;++i)
                    sll.addFirst(String.valueOf(i));

                System.out.println("New Nodes Added  Using Deleted Nodes From Delete Operation");
                //System.out.println("\n");
                System.out.println(sll.toString());
                System.out.println("*                                             *");
                System.out.println("***********************************************");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

                if (in != null) {
                    in.close();
                }
            }

        }






    }

}

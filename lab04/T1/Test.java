/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab03;

/**
 *
 * @author tigo
 */
import java.util.Arrays;
import java.util.stream.*;
public class Test {
    private static int[] em_size = {4,3};
    private static int[] tur_size = {8,9};
    private static int[][] empresariais = {{1,2,3,6},{4,5,6,6},{7,8,9,6}};
    private static int[][] turistas = {{1,2,3,6,8,4,4},{1,2,3,6,8,4,4},{1,2,3,6,8,4,4},{1,2,3,6,8,4,4},{1,2,3,6,8,4,4},{1,2,3,6,8,4,4},{1,2,3,6,8,4,4},{1,2,3,6,8,4,4},{1,2,3,6,8,4,4}};
    
       public static String getEmpresariais(){
        StringBuilder sb = new StringBuilder();
        int pointer = 0;
        String abc = " ABCDEFGHIJKLMNOPRSTUVXWYZ";
        for(int[] i : empresariais){
           sb.append(String.valueOf(abc.charAt(pointer))+" ");
            for(int j : i){
                sb.append(String.valueOf(j)+" ");
            }
            sb.append("\n");
            pointer++;
        }
        for(int i=0;i<Math.abs(em_size[1]-tur_size[1]);i++){
            char[] temp = new char[em_size[0]*2];
            Arrays.fill(temp,' ');
            sb.append(String.valueOf(abc.charAt(pointer))+" ");
            sb.append(new String(temp)+"\n");
            pointer++;
        }
        return sb.toString();
    }
    
    
    public static String getTuristas(){
        StringBuilder sb = new StringBuilder();
        
        for(int[] i : turistas){
            
            for(int j : i){
                sb.append(String.valueOf(j)+" ");
            }
            sb.append("\n");
         
        }
        return sb.toString();
    }
    
    
    public static void main(String args[]){
        String[] emp_arr = getEmpresariais().split("\n");
        String[] tur_arr = getTuristas().split("\n");
        
        StringBuilder sb = new StringBuilder();
        
        System.out.println(String.valueOf(emp_arr.length));
        System.out.println(String.valueOf(tur_arr.length));
        
        for(int i =0;i<Math.max(emp_arr.length, tur_arr.length);i++){
            sb.append(emp_arr[i]+tur_arr[i]+"\n");
        }
        System.out.println(sb.toString());
       
        
    }
}

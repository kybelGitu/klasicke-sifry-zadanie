package help_tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

public class Text {

   public static File pickFromFileChooser() {
       JFileChooser fc = new JFileChooser();
       fc.setCurrentDirectory(new File("."));
       fc.setDialogTitle("Select the file to open... ");
       fc.setMultiSelectionEnabled(false);
       fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

       int returnVal = fc.showOpenDialog(null);

       if (returnVal == JFileChooser.APPROVE_OPTION) {
           File f = fc.getSelectedFile();
           return f;
       }
       return null;
   }

   public static String readText(File file) {
       StringBuilder sb = new StringBuilder();
       if (file.exists()) {
           BufferedReader br = null;
           try {
               br = new BufferedReader(new FileReader(file));
               String line;
               while ((line = br.readLine()) != null) {
                   sb.append(line).append("\n");
               }
           } catch (Exception ex) {
               sb = null;
               Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
           } finally {
               try {
                   br.close();
               } catch (IOException ex) {
                   Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
               }
           }

       }
       return sb.toString();
   }

   public static boolean writeText(File file, String content) {
       if (file.exists()) {
           BufferedWriter bw = null;
           try {
               bw = new BufferedWriter(new FileWriter(file));
               bw.write(content);
               bw.flush();
               return true;
           } catch (IOException ex) {
               Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
           } finally {
               try {
                   bw.close();
               } catch (IOException ex) {
                   Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
       }
       return false;
   }

   public static void saveToFile(Object o, String path) {
       try {
           FileOutputStream fos = new FileOutputStream(path);
           ObjectOutputStream oos = new ObjectOutputStream(fos);
           oos.writeObject(o);
           oos.close();
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException ex) {
           Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
       }
   }

   public static Object readFromFile(String path) {
       try {
           FileInputStream fis = new FileInputStream(path);
           ObjectInputStream ois = new ObjectInputStream(fis);
           Object o = ois.readObject();
           return o;
       } catch (FileNotFoundException ex) {
           Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
       } catch (IOException | ClassNotFoundException ex) {
           Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
       }
       return null;
   }
   public static List recursion(int n){
       
       List <String> newList = new ArrayList();
       List <String> reminder = new ArrayList(); 
       String current;
       for(char act = 'a';act <= 'z'; act++){
           //current = "";
           current =Character.toString(act);
           if(n == 1){
               newList.add(current);
               continue;
           }
           else if(act == 'a')
            reminder = recursion(n-1);
  

           for(String s : reminder){
               //current += s;
               newList.add(current + s);
           }
       }
       return newList;
   }
   public static void printObjects(Object input[], String label){
       System.out.println(label + " :");
       for(Object i : input)
            System.out.println(i.toString() + ", ");
    }
    public static void printList(List<Object> input, String label){
       System.out.println(label + " :");
      for(Object i : input){
         Object act[] = (Object[]) i;
          System.out.println(Arrays.toString(act) + ", ");
      }
    }
    public static String convertToTSA(String in){
        in = in.toLowerCase();
         Normalizer.normalize(in, Normalizer.Form.NFD);
         in = in.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
          in = in.replaceAll("[^a-z ]", "");
          in =  in.replaceAll("\\s+","");
          return in;
    }
   
}
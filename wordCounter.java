import java.io.*;
import java.util.*;

public class wordCounter {
    public static int takeIntegerInput(BufferedReader br, String s) {
        int n = 0;
        while (true) {
            try {
                System.out.print(s);
                n = Integer.parseInt(br.readLine());
                break;
            } catch (Exception e) {
                System.out.println("Enter numbers only.");
            }
        }
        return n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = takeIntegerInput(br, "Input type(Enter 1:File 2:String):");
        ArrayList<String> array = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        while (!(t == 1 || t == 2)) {
            System.out.println("Enter 1 or 2 only.");
            t = takeIntegerInput(br, "Input type(Enter 1:File 2:String):");
        }
        if (t == 1) {
            System.out.print("Enter File Path:");
            String s;
            FileReader fr;
            while (true) {
                try {
                    s = br.readLine();
                    fr = new FileReader(s);
                    break;

                } catch (Exception e) {
                    System.out.print("Wrong File Name. Enter Correct File name:");
                }
            }
            BufferedReader b = new BufferedReader(fr);
            s = b.readLine();
            while (s != null) {
                StringTokenizer st = new StringTokenizer(s);
                while (st.hasMoreTokens()) {
                    s = st.nextToken();
                    array.add(s);
                    map.put(s, map.getOrDefault(s, 0) + 1);
                }
                s = b.readLine();
            }
            b.close();
        } else {
            System.out.print("Enter String:");
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            while (st.hasMoreTokens()) {
                s = st.nextToken();
                array.add(s);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        System.out.println("String analysis Completed");
        while (true) {
            int n = takeIntegerInput(br,
                    "\nEnter 0:Exit \n1:Count of Words \n2:Count of unique Words \n3.Frequency of specific word \n4:print Every Word and its Frequency\nEnter your option:");
            if (n == 0)
                break;
            else if (n == 1)
                System.out.println("Total number of words:" + array.size());
            else if (n == 2)
                System.out.println("Total number of unique words:" + map.size());
            else if (n == 3) {
                System.out.print("Enter Word:");
                String s = br.readLine();
                if (map.containsKey(s))
                    System.out.println("Frequency of \'" + s + "\' :" + map.get(s));
                else
                    System.out.println("Word \'" + s + "\' not present.Frequency:0");
            } else if (n == 4) {
                System.out.println();
                for (String a : map.keySet()) {
                    System.out.println(a + ":" + map.get(a));
                }
            } else
                System.out.println("Wrong option.Select from given options only");
        }
    }
}

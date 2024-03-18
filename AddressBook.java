import java.io.*;
import java.util.*;

public class AddressBook 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedReader b=new BufferedReader(new FileReader("phoneBook.txt"));
        String line;
        HashMap<String, Contact> array = new HashMap<>();
        while((line=b.readLine())!=null)
        {
            StringTokenizer st=new StringTokenizer(line);
            String name=st.nextToken();
            array.put(name,new Contact(name, st.nextToken(), st.nextToken()));
        }
        b.close();
        int n = 5;
        while (n != 0) 
        {
            System.out.println("Enter 0:Exit 1:Add a Contact 2:Remove a contact 3:Search a contact 4:Display All Contacts 5:Update Contact");
            System.out.print("Enter your option:");
            n=Integer.parseInt(br.readLine());
            switch(n)
            {
                case 1:
                {
                    System.out.print("Enter Name:");
                    String s=br.readLine();
                    if(array.containsKey(s))
                    {
                        System.out.println("Contact Already Existed");
                    }
                    else
                    {
                        System.out.print("Enter phoneNo:");
                        String ph=br.readLine();
                        System.out.print("Enter Email:");
                        String em=br.readLine();
                        array.put(s,new Contact(s, ph, em));
                    }
                    break;
                }
                case 2:
                {
                    System.out.print("Enter Name:");
                    String s=br.readLine();
                    if(array.containsKey(s))
                    array.remove(s);
                    else
                    System.out.println("Contact Not Found");
                    break;
                }
                case 3:
                {
                    System.out.print("Enter Name:");
                    String s=br.readLine();
                    if(array.containsKey(s))
                    {
                        System.out.println(array.get(s));
                    }
                    else
                    {
                        System.out.println("Contact Not Found");
                    }
                    break;
                }
                case 4:
                {
                    System.out.println();
                    for(Contact i:array.values())
                    {
                        System.out.println(i);
                    }
                    System.out.println();
                    break;
                }
                case 5:
                {
                    System.out.print("Enter Name:");
                    String s=br.readLine();
                    System.out.print("Enter phoneNo:");
                    String ph=br.readLine();
                    System.out.print("Enter Email:");
                    String em=br.readLine();
                    array.put(s,new Contact(s, ph, em));
                    break;
                }
                case 0:
                    break;
                default:
                    System.out.println("Enter Correct Option Only");

            }
        }
        System.out.println("Thank you for using Our Address Book");
        BufferedWriter bw=new BufferedWriter(new FileWriter("phoneBook.txt"));
        for(Contact i:array.values())
        {
            bw.write(i.getData());
        }
        bw.close();
    }

}

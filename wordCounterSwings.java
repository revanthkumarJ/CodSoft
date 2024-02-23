import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class wordCounterSwings {

    static ArrayList<String> array;
    static HashMap<String, Integer> map;

    public static void addFileData(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader b = new BufferedReader(fr);
        String s = b.readLine();
        while (s != null) {
            addStringData(s);
            s = b.readLine();
        }
        b.close();
    }

    public static void addStringData(String s)
    {
        StringTokenizer st = new StringTokenizer(s);
            while (st.hasMoreTokens()) {
                s = st.nextToken();
                array.add(s);
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
    }

    
    public static void main(String[] args) throws IOException{
        JFrame frame = new JFrame();
        frame.setTitle("Random Number Generator");
        frame.setSize(1400, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container con = frame.getContentPane();
        con.setLayout(null);

        JLabel title = new JLabel("CodSoft Task-2 : Word Counter");
        title.setForeground(Color.RED);
        title.setFont(new Font("Ink Free", Font.CENTER_BASELINE, 30));
        title.setBounds(350, 30, 900, 60);
        con.add(title);

        JLabel credits = new JLabel("Created by:J.Revanth Kumar");
        credits.setBounds(1000, 400, 400, 40);
        con.add(credits);

        JLabel lan = new JLabel("Used Language:JAVA");
        lan.setBounds(1000, 440, 400, 40);
        con.add(lan);

        JLabel type = new JLabel("Type Of Input:");
        type.setBounds(100, 140, 100, 30);
        con.add(type);

        String option[] = new String[] { "File", "String" };
        JComboBox<String> M = new JComboBox<>(option);
        M.setBounds(200, 140, 70, 30);
        con.add(M);

        JLabel input = new JLabel("Give Input:");
        input.setBounds(100, 180, 100, 30);
        con.add(input);

        JTextField S = new JTextField();
        S.setBounds(200, 180, 200, 30);
        con.add(S);

        JButton submit = new JButton("Submit");
        submit.setLocation(150, 220);
        submit.setSize(90, 30);
        submit.setBackground(Color.YELLOW);
        con.add(submit);

        JLabel error= new JLabel("");
        error.setBounds(100, 260, 200, 30);
        con.add(error);
        

        JLabel NWords = new JLabel("Total Number Of Words:");
        NWords.setBounds(700, 140, 300, 30);
        con.add(NWords);

        JLabel NWordsA = new JLabel("0");
        NWordsA.setBounds(900, 140, 100, 30);
        con.add(NWordsA);

        JLabel UWords = new JLabel("Total Number Of Unique Words:");
        UWords.setBounds(700, 180, 300, 30);
        con.add(UWords);

        JLabel UWordsA = new JLabel("0");
        UWordsA.setBounds(950, 180, 100, 30);
        con.add(UWordsA);

        JLabel F = new JLabel("Search a word Frequency:");
        F.setBounds(700, 220, 200, 30);
        con.add(F);

        JTextField FW = new JTextField();
        FW.setBounds(900, 220, 200, 30);
        con.add(FW);

        JButton search = new JButton("Search");
        search.setLocation(800, 260);
        search.setSize(90, 30);
        search.setBackground(Color.GREEN);
        con.add(search);

        JLabel Freq = new JLabel("Frequency of Given Word:");
        Freq.setBounds(700, 290, 200, 30);
        con.add(Freq);

        JLabel FreqOut = new JLabel("0");
        FreqOut.setBounds(900, 290, 200, 30);
        con.add(FreqOut);

        submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                error.setText("");
                array = new ArrayList<>();
                map = new HashMap<>();
                String f=S.getText();
                if(M.getItemAt(M.getSelectedIndex()).equals("File"))
                {
                    try{
                        addFileData(f);
                    }
                    catch(Exception exx){
                        error.setText("Incorrect File Name");
                    }
                    
                }
                else
                    addStringData(f);
                NWordsA.setText(array.size()+"");
                UWordsA.setText(map.size()+"");

            }
        });

        search.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                
                String s=FW.getText();
                if(map.containsKey(s))
                FreqOut.setText(map.get(s)+"");
                else
                FreqOut.setText("0");
            }
        });

        frame.setVisible(true);
    }
}
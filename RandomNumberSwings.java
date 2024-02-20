import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class RandomNumberSwings {
    static int Total = 10;
    static int num;
    public static void main(String[] args) {
        Random r = new Random();
        num = r.nextInt(500);

        JFrame frame = new JFrame();
        frame.setTitle("Random Number Generator");
        frame.setSize(1400, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container con = frame.getContentPane();
        con.setLayout(null);

        JLabel title = new JLabel("CodSoft Task-1 : Number Guessing");
        title.setForeground(Color.RED);
        title.setFont(new Font("Ink Free", Font.CENTER_BASELINE, 30));
        title.setBounds(350, 30, 900, 60);
        con.add(title);

        JLabel credits = new JLabel("Created by:J.Revanth Kumar");
        credits.setBounds(900, 440, 400, 30);
        con.add(credits);
        credits.setFont(new Font("Ink Free", Font.ITALIC, 20));
        JLabel lan = new JLabel("Used Language:JAVA");
        lan.setBounds(900, 480, 400, 30);
        con.add(lan);
        lan.setFont(new Font("Ink Free", Font.ITALIC, 20));

        JLabel head = new JLabel("Guess a Number Between 1 and 500");
        head.setForeground(Color.BLUE);
        head.setFont(new Font("Ink Free", Font.CENTER_BASELINE, 20));
        head.setBounds(400, 90, 500, 40);
        con.add(head);

        JLabel id = new JLabel("Enter Your Guess:");
        id.setForeground(Color.DARK_GRAY);
        id.setFont(new Font("Ink Free", Font.BOLD, 17));
        id.setBounds(450, 150, 180, 30);
        con.add(id);

        JTextField idIn = new JTextField();
        idIn.setBounds(620, 150, 200, 30);
        con.add(idIn);
        idIn.setBackground(Color.cyan);
        idIn.setFont(new Font("Ink Free", Font.ITALIC, 15));

        JLabel guess = new JLabel("Guesses Left:");
        guess.setFont(new Font("Ink Free", Font.BOLD, 18));
        guess.setBounds(450, 200, 150, 30);
        con.add(guess);

        JLabel guessOut = new JLabel("10");
        guessOut.setFont(new Font("Ink Free", Font.BOLD, 30));
        guessOut.setBounds(490, 240, 150, 40);
        con.add(guessOut);

        JLabel guessStatus = new JLabel("Guess Status:");
        guessStatus.setFont(new Font("Ink Free", Font.BOLD, 18));
        guessStatus.setBounds(650, 200, 150, 30);
        con.add(guessStatus);

        JLabel guessStatusOut = new JLabel("");
        guessStatusOut.setFont(new Font("Ink Free", Font.BOLD, 30));
        guessStatusOut.setBounds(670, 240, 180, 40);
        con.add(guessStatusOut);

        JButton submit = new JButton("Submit");
        submit.setLocation(560, 320);
        submit.setSize(100, 30);
        submit.setBackground(Color.green);
        con.add(submit);

        JButton reset = new JButton("Replay");
        reset.setLocation(560, 360);
        reset.setSize(100, 30);
        reset.setBackground(Color.yellow);
        con.add(reset);

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guessStatusOut.setText("");
                idIn.setText("");
                guessOut.setText("10");
            }
        });

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Total == 0) {
                    guessStatus.setText("Correct Number:");
                    guessStatusOut.setText(num+"");
                    Total=10;
                    num=r.nextInt(500);
                } else {
                    guessStatus.setText("Guess status:");
                    int n = Integer.parseInt(idIn.getText());
                    if (n > num)
                        guessStatusOut.setText("High");
                    else if (n < num)
                        guessStatusOut.setText("Low");
                    else
                        guessStatusOut.setText("Correct");
                    Total--;
                }
                guessOut.setText(Total + "");

            }
        });

        frame.setVisible(true);
    }

}

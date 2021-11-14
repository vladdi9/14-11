package org.itstep;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BrowserHistory extends JFrame {
    private final String[] url = {" google.com "," youtube.com "," github.com "};
    private ArrayDeque<String> history = new ArrayDeque<>();

    public  BrowserHistory(){
        setTitle("Browser history");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        DefaultListModel<String> model = new DefaultListModel<>();
        JList<String> list = new JList<String>(model);
        for (int i = 0; i < url.length; i++){
            JButton jButton = new JButton();
            jButton.setBounds(10,20+i*30,200,25);
            jButton.setText(url[i]);

            String s = url[i];
            jButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (history.size()>=5)
                        history.pollLast();
                    history.addFirst(s);
                    model.clear();
                    Object[]items=history.toArray();
                    String[] sItems= Arrays.copyOf(items, items.length, String[].class);
                    model.addAll(Arrays.asList(sItems));
                    validate();
                }
            });
            add(jButton);
        }
        list.setBounds(300,20,200,300);
        add(list);
        setLayout(null);
        repaint();
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory();
    }
}
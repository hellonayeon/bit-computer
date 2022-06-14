package view;

import net.WriteClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/* 아이디를 입력받기 위한 폼 */
public class IdFrame extends JFrame implements ActionListener {

    public static TextField tf = new TextField(8);

    JButton btn = new JButton("등록");

    ClientFrame cf;

    WriteClass wc;

    public IdFrame(ClientFrame cf, WriteClass wc) {

        this.cf = cf; // IdFrame 은 ClientFrame 안에서 생성
        this.wc = wc;

        setTitle("ID 입력");
        setLayout(null);

        JLabel label = new JLabel("ID: ");
        label.setBounds(50, 60, 30, 30);
        add(label);

        tf.setBounds(80, 60, 100, 30);
        add(tf);

        btn.setBounds(80, 100, 100, 30);
        btn.addActionListener(this);
        add(btn);

        setBounds(300, 300, 250, 200);
        setBackground(Color.green);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // ID 전송
        wc.sendMessage();

        // 첫 번째 전송
        cf.isFirst = false;

        // 두 번째 전송
        // ClientFrame 을 시각화
        cf.setVisible(true);

        // 현재 창 close
        this.dispose();


    }
}

package com.company;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;

public class Graph  extends JFrame {
    private  JLabel label1=new JLabel("Введите путь к файлу");
    private JTextField FileAddress =new JTextField("",20);
    private  JLabel label2=new JLabel("Введите маску((.*)- от 0 знаков, (.?)- 1 знак):");
    private JTextField MaskText =new JTextField("",20);
    private JButton task15but= new JButton("Задание 15");
    private JButton task14but= new JButton("Задание 14");
    private JTextArea Answer15Area = new JTextArea(10, 30);
    private JTextArea Answer14Area = new JTextArea(10, 40);
    public void graphics() {
        JFrame frame = new JFrame("Лабораторная номер 12");
        frame.setSize(300,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        frame.setVisible(true);
        Var15 var15 = new Var15();


        task14but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Var15 var15 = new Var15();
                File file = new File(FileAddress.getText());

                String text14Answer = var15.findDeepestItem(file);

                //Создаем новый контейнер JFrame
                JFrame jfrm = new JFrame("Ответ");
                //Устанавливаем диспетчер компоновки
                jfrm.getContentPane().setLayout(new FlowLayout());
                //Устанавливаем размер окна
                jfrm.setSize(500, 250);
                //Устанавливаем завершение программы при закрытии окна
                jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                //Создаем новую таблицу на основе двумерного массива данных и заголовков
                //jTable1.setModel(new javax.swing.table.DefaultTableModel(c,headers));*/

                //panel.add(jTable1);

                //Создаем панель прокрутки и включаем в ее состав нашу таблицу
                JScrollPane jscrlp = new JScrollPane(Answer14Area);
                Answer14Area.append(text14Answer);


                //Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней
                jfrm.getContentPane().add(jscrlp);

                //Отображаем контейнер
                jfrm.setVisible(true);

            }
        });
        task15but.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                Var15 var15 = new Var15();
                File file = new File(FileAddress.getText());
                String mask = MaskText.getText();

                ArrayList<String> text15Answer = null;
                try {
                    text15Answer = var15.findFilterItem(file, mask);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                //Создаем новый контейнер JFrame
                JFrame jfrm = new JFrame("Ответ");
                //Устанавливаем диспетчер компоновки
                jfrm.getContentPane().setLayout(new FlowLayout());
                //Устанавливаем размер окна
                jfrm.setSize(500, 250);
                //Устанавливаем завершение программы при закрытии окна
                jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                //Создаем новую таблицу на основе двумерного массива данных и заголовков
                //jTable1.setModel(new javax.swing.table.DefaultTableModel(c,headers));*/

                //panel.add(jTable1);

                //Создаем панель прокрутки и включаем в ее состав нашу таблицу
                JScrollPane jscrlp = new JScrollPane(Answer14Area);
                for (int i = 1; i < text15Answer.size(); i++) {
                    Answer14Area.append(text15Answer.get(i)+"\n");

                }



                //Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней
                jfrm.getContentPane().add(jscrlp);

                //Отображаем контейнер
                jfrm.setVisible(true);

            }
        });



        panel.add(label1);
        panel.add(FileAddress);
        panel.add(label2);
        panel.add(MaskText);
        panel.add(task15but);
        panel.add(task14but);
        frame.add(panel);
    }

}

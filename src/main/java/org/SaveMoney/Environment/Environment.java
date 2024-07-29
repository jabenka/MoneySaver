package org.SaveMoney.Environment;

import org.SaveMoney.Config;
import org.SaveMoney.Model.Model;

import javax.swing.*;
import java.awt.*;

public class Environment extends JPanel {


    JFrame frame;
    SpringLayout layout;
    Container cp;
    Model model;
    JTextField addField;
    JLabel displayAmount;
    JTextField addGoalField;
    JLabel displayGoal;
    Config config;
    public Environment(JFrame frame) {
        frame.setName("MoneySave");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.frame = frame;
        layout = new SpringLayout();

        config=new Config();
        model=config.Load();

        cp = frame.getContentPane();
        cp.setLayout(layout);

        setFrame();

        frame.setSize(new Dimension(800, 600));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    public void setFrame(){
        JLabel amount= new JLabel("Остаток:");
        JLabel goal=new JLabel("Отложено:");
        displayAmount=new JLabel(String.valueOf(Model.getAmount()));
        displayGoal=new JLabel(String.valueOf(Model.getGoal()));
        int spacing=10;


        JButton add=new JButton("Добавить сумму");
        addField=new JTextField(11);
        add.addActionListener(i->{
            long CurrentAmount=Long.parseLong(addField.getText());
            long PrevAmount=Model.getAmount();
            Model.setAmount(PrevAmount+CurrentAmount);
            displayAmount.setText(String.valueOf(Model.getAmount()));
        });
        JButton addGoal=new JButton("Добавить накопления");
        addGoalField=new JTextField(11);
        addGoal.addActionListener(e-> {
                Long CurrAmount=Long.parseLong(addGoalField.getText());
                Long PrevAmount=Model.getGoal();
                Model.setGoal(PrevAmount+CurrAmount);
                displayGoal.setText(String.valueOf(Model.getGoal()));
        });


        JButton decrease=new JButton("Убавить сумму");
        decrease.addActionListener(e->{
            Long CurrentAmount=Long.parseLong(addField.getText());
            Long PrevAmount=Model.getAmount();
            Model.setAmount(PrevAmount-CurrentAmount);
            displayAmount.setText(String.valueOf(Model.getAmount()));
        });


        JButton save=new JButton("Сохранить");
        save.addActionListener(e->{
            config.Save(model);
        });

        layout.putConstraint(SpringLayout.WEST,amount,spacing,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.NORTH,amount,spacing,SpringLayout.NORTH,frame);

        layout.putConstraint(SpringLayout.WEST,add,spacing,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH,add,spacing+40,SpringLayout.SOUTH,frame);

        layout.putConstraint(SpringLayout.WEST,addField,spacing,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH,addField,spacing+70,SpringLayout.SOUTH,frame);

        layout.putConstraint(SpringLayout.WEST,displayAmount,spacing+55,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.NORTH,displayAmount,spacing,SpringLayout.NORTH,frame);

        layout.putConstraint(SpringLayout.EAST,goal,spacing+550,SpringLayout.EAST,frame);
        layout.putConstraint(SpringLayout.NORTH,goal,spacing,SpringLayout.NORTH,frame);

        layout.putConstraint(SpringLayout.EAST,addGoal,spacing+550,SpringLayout.EAST,frame);
        layout.putConstraint(SpringLayout.NORTH,addGoal,spacing+50,SpringLayout.NORTH,frame);

        layout.putConstraint(SpringLayout.EAST,addGoalField,spacing+550,SpringLayout.EAST,frame);
        layout.putConstraint(SpringLayout.SOUTH,addGoalField,spacing+60,SpringLayout.SOUTH,frame);

        layout.putConstraint(SpringLayout.EAST,displayGoal,spacing+595,SpringLayout.EAST,frame);
        layout.putConstraint(SpringLayout.NORTH,displayGoal,spacing,SpringLayout.NORTH,frame);

        layout.putConstraint(SpringLayout.WEST,decrease,spacing,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.SOUTH,decrease,spacing+110,SpringLayout.SOUTH,frame);

        layout.putConstraint(SpringLayout.WEST,save,spacing+290,SpringLayout.WEST,frame);
        layout.putConstraint(SpringLayout.NORTH,save,spacing+500,SpringLayout.NORTH,frame);


        cp.add(goal);
        cp.add(addField);
        cp.add(add);
        cp.add(displayAmount);
        cp.add(amount);
        cp.add(addGoal);
        cp.add(addGoalField);
        cp.add(displayGoal);
        cp.add(decrease);
        cp.add(save);
    }



}

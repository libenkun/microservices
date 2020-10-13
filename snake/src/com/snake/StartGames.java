package com.snake;

import javax.swing.*;

/**
 * @author lbk
 * @date 2020/9/28 16:43
 **/
public class StartGames {
    public static void main(String[] args) {
        //1,绘制静态窗口，JFrame
        JFrame frame = new JFrame("贪吃蛇小游戏");
        //设置界面大小
        frame.setBounds(10,10,900,720);
        frame.setResizable(false);//窗口大小不可以改变
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭事件，游戏可以关闭

        //2面板 JPanel 可以加入到JFrame上
        frame.add(new GamePanel());

        frame.setVisible(true);//让窗口能够展现出来

    }
}

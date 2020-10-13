package com.snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * @author lbk
 * @date 2020/9/28 16:57
 * alt+Insert 查找父类的方法
 **/
public class GamePanel extends JPanel implements KeyListener, ActionListener {

    int lenth;//蛇的长度
    int[] snakeX = new int[600];//蛇的坐标x
    int[] snakeY = new int[500];//坐标y
    String fx;//r:右

    boolean isStart = false;//游戏是否开始
    Timer timer = new Timer(100, this);//定时间

    //1定义一个食物
    int foodx;
    int foody;
    Random random = new Random();

    //构造器
    public GamePanel() {
        init();
        //获取键盘监听事件
        this.setFocusable(true);
        this.addKeyListener(this);
        timer.start();//让时间动起来
    }

    //初始化
    public void init() {
        lenth = 3;
        snakeX[0] = 100;
        snakeY[0] = 100;//头部坐标
        snakeX[1] = 75;
        snakeY[1] = 100;//第一个身体的坐标
        snakeX[2] = 50;
        snakeY[2] = 100;//第2个身体的坐标
        fx = "R";
        foodx = 25 + 75 * random.nextInt(34);
        foody = 75 + 25 * random.nextInt(24);
    }


    //画板：画界面
    //Graphics :画笔
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);//清屏
        this.setBackground(Color.WHITE);//设置背景的颜色
        //绘制头部的广告栏
        Data.headr.paintIcon(this, g, 25, 11);
        //绘制游戏区域
        g.fillRect(25, 75, 850, 600);
        if (fx.equals("R")) {
            //画一条静态小蛇
            Data.right.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (fx.equals("L")) {
            Data.left.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (fx.equals("U")) {
            Data.up.paintIcon(this, g, snakeX[0], snakeY[0]);
        } else if (fx.equals("D")) {
            Data.down.paintIcon(this, g, snakeX[0], snakeY[0]);
        }

        for (int i = 1; i < lenth; i++) {
            Data.body.paintIcon(this, g, snakeX[i], snakeY[i]);//身体长度通过lenth来控制
        }

        //画食物
        Data.food.paintIcon(this, g, foodx, foody);
        //游戏是否开始
        if (isStart == false) {
            //画一个文字，String
            g.setColor(Color.WHITE);//设置画笔的颜色
            g.setFont(new Font("微软雅黑", Font.BOLD, 40));//设置字体
            g.drawString("按下空格开始游戏", 300, 300);
        }

    }


    //接收键盘的输入：监听
    @Override
    public void keyPressed(KeyEvent e) {
        //键盘按下，未释放
        //接收键盘上的键
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_SPACE) {//如果按下空格键
            isStart = !isStart;
            repaint();//刷新界面
        }
        //键盘控制走向
        if (keyCode == KeyEvent.VK_LEFT) {
            fx = "L";
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            fx = "R";
        } else if (keyCode == KeyEvent.VK_UP) {
            fx = "U";
        } else if (keyCode == KeyEvent.VK_DOWN) {
            fx = "D";
        }
    }

    //接收键盘的输入：监听
    @Override
    public void keyReleased(KeyEvent e) {
        //释放某个键
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //键盘按下，弹起
    }

    //定时器，监听时间，帧：执行定时
    @Override
    public void actionPerformed(ActionEvent e) {
        //如果游戏处于开始状态
        if (isStart) {
            //右移
            for (int i = lenth - 1; i > 0; i--) {//除了脑袋，身体都向前移动
                snakeX[i] = snakeX[i - 1];
                snakeY[i] = snakeY[i - 1];
            }
            //通过控制方向让头部移动
            if (fx.equals("R")) {
                snakeX[0] = snakeX[0] + 25;//头部移动
                //边界判断
                if (snakeX[0] > 850) {
                    snakeX[0] = 25;
                }
            } else if (fx.equals("L")) {
                snakeX[0] = snakeX[0] - 25;//头部移动
                //边界判断
                if (snakeX[0] < 25) {
                    snakeX[0] = 850;
                }
            } else if (fx.equals("U")) {
                snakeY[0] = snakeY[0] - 25;//头部移动
                //边界判断
                if (snakeY[0] < 75) {
                    snakeY[0] = 650;
                }
            } else if (fx.equals("D")) {
                snakeY[0] = snakeY[0] + 25;//头部移动
                //边界判断
                if (snakeY[0] > 650) {
                    snakeY[0] = 75;
                }
            }
            //如果小蛇的头和食物的坐标重合了
            if (snakeX[0] == foodx && snakeY[0] == foody) {
                //长度+1
                lenth++;
                //重新生成食物
                foodx = 25 + 75 * random.nextInt(34);
                foody = 75 + 25 * random.nextInt(24);
            }

            //刷新界面
            repaint();
        }
        timer.start();//让时间动起来
    }


}

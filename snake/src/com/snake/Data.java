package com.snake;


import javax.swing.*;
import java.net.URL;

/**
 * @author lbk
 * @date 2020/9/28 17:11
 * 存放外部数据
 **/
public class Data {

    //头部图片 URL:定位图片的地址，ImageIcon:图片
    public static URL headreURL = Data.class.getResource("/status/header.png");
    public static ImageIcon headr = new ImageIcon(headreURL);

    //toub
    public static URL upURL = Data.class.getResource("/status/up.png");
    public static URL downUrl = Data.class.getResource("/status/down.png");
    public static URL leftUrl = Data.class.getResource("/status/left.png");
    public static URL rightUrl = Data.class.getResource("/status/right.png");

    public static ImageIcon up = new ImageIcon(upURL);
    public static ImageIcon down = new ImageIcon(downUrl);
    public static ImageIcon left = new ImageIcon(leftUrl);
    public static ImageIcon right = new ImageIcon(rightUrl);

    //身体
    public static URL bodyUrl = Data.class.getResource("/status/body.png");
    public static ImageIcon body = new ImageIcon(bodyUrl);
    //食物
    public static URL foodUrl = Data.class.getResource("/status/food.png");
    public static ImageIcon food  = new ImageIcon(foodUrl);

}

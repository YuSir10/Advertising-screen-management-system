package com.asms.res;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author chensiyu04 
 * @address www.blogjava.net/chensiyu04
 */
public class PictrueLable extends JPanel {

	 private static final long serialVersionUID = 1L;  
	    private Image image;  
	    private int imgWidth;  
	    private int imgHeight;  
	  
	    public int getImgWidth() {  
	        return imgWidth;  
	    }  
	  
	    public void setImgWidth(int imgWidth) {  
	        this.imgWidth = imgWidth;  
	    }  
	  
	    public int getImgHeight() {  
	        return imgHeight;  
	    }  
	  
	    public void setImgHeight(int imgHeight) {  
	        this.imgHeight = imgHeight;  
	    }  
	  
	    public PictrueLable() {  
	    }  
	  
	    public void setImagePath(String imgPath) {  
	        // �÷������Ƽ�ʹ�ã��÷����������أ�ͼ�񲢲����ص��ڴ棬����ͼ��Ŀ��͸�ʱ�᷵��-1��  
	        // image = Toolkit.getDefaultToolkit().getImage(imgPath);  
	        try {  
	            // �÷����Ὣͼ����ص��ڴ棬�Ӷ��õ�ͼ�����ϸ��Ϣ��  
	            image = ImageIO.read(new FileInputStream(imgPath));  
	        } catch (FileNotFoundException e) {  
	            e.printStackTrace();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	        setImgWidth(image.getWidth(this));  
	        setImgHeight(image.getHeight(this));  
	    }  
	  
	    @Override  
	    public void paintComponent(Graphics g1) {  
	        int x = 0;  
	        int y = 0;  
	        Graphics g = (Graphics) g1;  
	        if ( == image) {  
	            return;  
	        }  
	  
	        g.drawImage(image, x, y, image.getWidth(this), image.getHeight(this),  
	                this);  
	        g = ;  
	    }  
    

   
}
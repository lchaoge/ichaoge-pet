package com.ichaoge.pet.common.service;

import com.ichaoge.pet.common.dao.VideoInfoDao;
import com.ichaoge.pet.common.entity.VideoInfo;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;


/**
 * Created by chaoge on 2018/9/29.
 */
public class VideoInfoService extends VideoInfoDao {


    public VideoInfoService(String ffmpegApp){
        super(ffmpegApp);
    }

//    public static void main(String[] args){
//        VideoInfoService videoInfoService = new VideoInfoService("C:\\Users\\Administrator\\Desktop\\ffmpeg-20180928-179ed2d-win64-static\\bin\\ffmpeg.exe");
//        try
//        {
//            videoInfoService.getFirstThumb("C:\\Users\\Administrator\\Desktop\\maoka\\1.mp4", "C:\\Users\\Administrator\\Desktop\\maoka\\222.png",800, 600);
//            System.out.println("over");
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//    }

    /***
     *
     * 得到第一秒（也是第一帧）图片
     */
    public void getFirstThumb(String videoFilename, String thumbFilename, int width,int height) throws IOException, InterruptedException{
        super.getThumb(videoFilename, thumbFilename, width, height, 0, 0, 2);
    }

    /**
     * 得到最后一秒（也是最后一帧）图片
     */
    public void getLastThumb(String videoFilename, String thumbFilename, int width,int height) throws IOException, InterruptedException{
        VideoInfo videoInfo = new VideoInfo(ffmpegApp);
        videoInfo.getInfo(videoFilename);
        super.getThumb(videoFilename, thumbFilename, width, height,
                videoInfo.getHours(), videoInfo.getMinutes(),
                videoInfo.getSeconds() - 0.2f);
    }


    /**
     * 获取指定视频的帧并保存为图片至指定目录
     * @param videofile  源视频文件路径
     * @param framefile  截取帧的图片存放路径
     * @throws Exception
     */
    public static void getFirstImage(String videofile, String framefile)
            throws Exception {
        long start = System.currentTimeMillis();
        File targetFile = new File(framefile);
        FFmpegFrameGrabber ff = new FFmpegFrameGrabber(videofile);
        ff.start();
        int lenght = ff.getLengthInFrames();
        int i = 0;
        Frame f = null;
        while (i < lenght) {
            // 过滤前5帧，避免出现全黑的图片，依自己情况而定
            f = ff.grabFrame();
            if ((i > 5) && (f.image != null)) {
                break;
            }
            i++;
        }
        IplImage img = f.image;
        int owidth = img.width();
        int oheight = img.height();
        // 对截取的帧进行等比例缩放
        int width = 800;
        int height = (int) (((double) width / owidth) * oheight);
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        bi.getGraphics().drawImage(f.image.getBufferedImage().getScaledInstance(width, height, Image.SCALE_SMOOTH),
                0, 0, null);
        ImageIO.write(bi, "jpg", targetFile);
        //ff.flush();
        ff.stop();
        System.out.println(System.currentTimeMillis() - start);
    }

//    public static void main(String[] args) {
//        try {
//            VideoInfoService.getFirstImage("http://pet.ichaoge.com:3000/static/uploads/video/video-1538212520111.mp4", "C:/Users/Administrator/Desktop/maoka/test4.jpg");
//            System.out.println("over");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }





}

import org.bytedeco.javacv.CanvasFrame;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;

import javax.swing.*;

public class Test {

    public static void main(String[] args) throws Exception {
        new Test().vfxgrab();
    }

    /**
     * 使用vfxcap方式抓取windows下的摄像头画面
     * 根据ffmpeg官方文档，支持video_size和framerate两个参数，但是测试发现video_size设置后直接异常报错，framerate设置无效
     * @author eguid
     */
    public void vfxgrab() throws Exception {

        //不管设置成什么都可以打开摄像头
        //比如设置成空字符串
//		FFmpegFrameGrabber grabber = new FFmpegFrameGrabber("");
        //或者随便设置点其他字符串都可以
        FFmpegFrameGrabber grabber = new FFmpegFrameGrabber("desktop");
		/*参数支持video_size
		Set the video frame size.
		framerate
		Set the grabbing frame rate. Default value is ntsc, corresponding to a frame rate of 30000/1001.
		*/
        grabber.setFormat("gdigrab");// 基于gdigrab的输入格式
        //可以设置，但是没有效果
//		grabber.setFrameRate(50);
//		grabber.setOption("framerate", "50");
        //不能设置这些参数，设置就会导致异常
//		grabber.setImageWidth(800);
//		grabber.setImageHeight(600);
//		grabber.setOption("video_size", "400x300");// 正确设置帧率方法，直接设置60帧每秒的高帧率
//
        grabber.start();

        CanvasFrame canvas = new CanvasFrame("摄像头预览");// 新建一个窗口
        canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        canvas.setAlwaysOnTop(true);
        Frame frame = null;

        long timeDump = System.currentTimeMillis();// 记录一下时间，用来简单计算一下平均帧率
        long lastTimeDump;
        // 抓取屏幕画面
        for (int i = 0; (frame = grabber.grab()) != null; i++) {
            // 显示画面
            canvas.showImage(frame);

            lastTimeDump = System.currentTimeMillis();
            if (lastTimeDump - timeDump > 5000) {// 录屏10秒，超过10秒退出并计算平均帧率
                long inteval = ((lastTimeDump - timeDump) / 1000);
                System.out.println("总耗时：" + inteval + "秒，总帧数：" + i + ",平均帧率：" + i / inteval);
                break;
            }
        }

        canvas.dispose();
        grabber.close();
    }
}

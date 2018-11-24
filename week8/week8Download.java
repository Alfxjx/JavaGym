import java.net.URL;
import java.io.*;
 
public class week8Download extends Thread{
    String file;
    URL url;
    public week8Download(String file, URL url){
        this.file = file;
        this.url = url;
    }
    public void run(){
        // InputStream input = null;
        // OutputStream output = null;
        try(InputStream input = url.openStream();
            OutputStream output = new FileOutputStream(file))
        {
            byte[] data = new byte[1024];
            int length;
            while((length=input.read(data))!=-1){
                output.write(data,0,length);
            }
        }catch(IOException e1){
                e1.printStackTrace();
            }   
    }


    public static void main(String[] args)
        throws Exception
    {
        //目标
        final URL[] urls = {
            new URL("https://www.pku.edu.cn"),
            new URL("https://www.baidu.com"),
            new URL("https://www.sina.com.cn"),
            new URL("https://www.dstang.com")
        };
        final String[] files = {
            "pku.htm", 
            "baidu.htm",
            "sina.htm", 
            "study.htm",
        };
        //新建4个线程，使用对应的Downloader方法
        Thread task1 = new Thread(new week8Download(files[0], urls[0]));
        task1.start();
        Thread task2 = new Thread(new week8Download(files[1], urls[1]));
        task2.start();
        Thread task3 = new Thread(new week8Download(files[2], urls[2]));
        task3.start();
        Thread task4 = new Thread(new week8Download(files[3], urls[3]));
        task4.start();
    }    
}
import java.io.File;
import java.io.IOException;

/**
 * @Description:
 * @Author: xuzh1
 * @Date: 2018-11-14 14:48
 **/
public class Main {
    public static void main(String[] args) throws IOException {

        String path = "E:\\JAVA\\123.txt";		//要遍历的路径

        if(!new File(path).exists()){
            new File(path).mkdirs();
        }

//
//        File file = new File(path);		//获取其file对象
//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        File[] fs = file.listFiles();	//遍历path下的文件和目录，放在File数组中
//        for(File f:fs) {                    //遍历File[]数组
//            if (!f.isDirectory()) {        //若非目录(即文件)，则打印
//                System.out.println(f.getName());
//            }
//        }

        if(new File(path).exists()){
            new File(path).delete();
        }

        new File(path).createNewFile();


    }


}

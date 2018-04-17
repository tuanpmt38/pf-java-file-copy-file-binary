import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyFileBinary {
    public static void main(String[] args) {
        // file nguồn
        File sourceFile = new File("file1.txt");
        //file đích
        File destFile = new File("file3.txt");
        // kiểm tra file đích có hay chưa, chưa thì tạo file mới
        if (!destFile.exists()) {
            try {
                destFile.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destFile);
            byte[] arrbyte = new byte[1024];
            int lenght;
            while ((lenght = fis.read(arrbyte)) > 0) {
                fos.write(arrbyte, 0, lenght);
            }
//            while (fis.read(arrbyte) != -1) {
//                fos.write(arrbyte);
//            }
            fis.close();
            fos.close();
            System.out.println("Copy done !");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

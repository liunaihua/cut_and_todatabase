import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ReadFile {
    private static Logger logger=Logger.getLogger(ReadFile.class);
    public static int read(String readFilePath,String writeFilePath) throws IOException {
        File readFile=new File(readFilePath);
        File writeFile=null;
        long total=0l;
        Long each_container_nums=0l;
        ResourceBundle bundle=ResourceBundle.getBundle("pro");
        int total_container= Integer.parseInt(bundle.getString("total_container"));
        List<String> strings=new ArrayList<>();

            strings = FileUtils.readLines(readFile, "utf-8");
            total=strings.size();
            logger.info("total count of numbers is:"+total);
            each_container_nums=total/total_container;
            logger.info("each container nums is:"+each_container_nums);
            int container=1;
            writeFile=new File(writeFilePath+String.valueOf(container));
            for(int i=0;i<total;i++){
                if(i>each_container_nums*container){
                    if(container!=total_container){
                        container++;
                    }
                    writeFile=new File(writeFilePath+String.valueOf(container));
                    FileUtils.writeStringToFile(writeFile,strings.get(i)+"\n","utf-8",true);
                }else {
                    FileUtils.writeStringToFile(writeFile,strings.get(i)+"\n","utf-8",true);
                }


            }

        return total_container;
    }
}

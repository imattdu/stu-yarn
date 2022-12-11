package com.matt.yarn;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;

import java.util.Arrays;

/**
 * @author matt
 * @date 2022-12-12 1:28
 */
public class WordCountDriver {

    private static Tool tool;
    public static void main(String[] args) throws Exception {
        // 1. 创建配置文件
        Configuration conf = new Configuration();
        // 2. 判断是否有 tool 接口
        switch (args[0]){
            case "wordcount":
                tool = new WordCount();
                break;
            default:
                throw new RuntimeException(" No such tool: "+
                        args[0] );
        }
        // 3. 用 Tool 执行程序
        // Arrays.copyOfRange 将老数组的元素放到新数组里面
        int run = ToolRunner.run(conf, tool,
                Arrays.copyOfRange(args, 1, args.length));
        System.exit(run);
    }

}

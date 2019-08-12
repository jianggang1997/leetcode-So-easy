package com.learn.arithemtic.demo;


import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;

/**
 * @author jianggang
 * @date 2019/6/17 10:44:52
 * @description
 */
public class AutoCompilerJava {
    public static void main(String[] args) throws IOException {
        String javaCode =
                "public class Hello{" +
                        "public static void main(String[] args){" +
                        "System.out.println(\"HelloWorld\");" +
                    "}" +
                "}";
        String filePath = "Users/jianggang/Hello.java";
        File javaFile = new File(filePath);
        if(!javaFile.exists()){
            javaFile.getParentFile().mkdirs();
            javaFile.createNewFile();
        }
        OutputStream os = new FileOutputStream(javaFile);
        os.write(javaCode.getBytes(),0,javaCode.length());
        os.flush();
        os.close();
        compilerJavaCode(filePath);
    }

    public static void compilerJavaCode(String filePath) throws IOException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null,null,null,filePath);
        if(result == 0){
            System.out.println("编译成功!");
            Runtime rt = Runtime.getRuntime();
            Process pro = rt.exec("java -cp Users/jianggang Hello");
            InputStream in = pro.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String terminal = "";
            while ((terminal = reader.readLine()) != null){
                System.out.println(terminal);
            }
        }else {
            System.out.println("编译失败");
        }
    }
}

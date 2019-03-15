package com.learn.arithemtic.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jianggang
 * @Date 2019/3/14 15:54:26
 * @Description
 * 文本左右对齐-----> 运行通过
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 *
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 *
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 */
public class FullJustify {

    public static void main(String[] args) {
        String[] strs = {"What","must","be","acknowledgment","shall","be"};
        List<String> res = fullJustify(strs,16);
        for(String str : res){
            System.out.println("\""+str+"\"");
        }
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        //记录上次成功分词的位置
        int flag = 0;
        for(int i = 0,len = words.length ; i < len ; i++){
            //最多放置 单词字符总长度+（单词数-1）< 最大长度
            if(sb.length()+words[i].length()>maxWidth-(i-flag)){
                int block = 0;
                int blockL = 0;
                if(i-flag != 1){
                    block = (maxWidth - sb.length())/(i-flag-1);
                    blockL = (maxWidth - sb.length())%(i-flag-1);
                }else{
                    block = maxWidth -sb.length();
                }
                StringBuffer temp = new StringBuffer();
                //在单词中间填充空格
                for(int a = flag ; a < i ; a++){
                    temp.append(words[a]);
                    if(a != (i-1)){
                        if(a < flag+blockL){
                            for(int t = 0;t < block+1;t++){
                                temp.append(" ");
                            }
                        }else{
                            for(int t = 0;t < block;t++){
                                temp.append(" ");
                            }
                        }
                    }else if(i-flag==1){
                        for(int t = 0;t < (maxWidth-sb.length());t++){
                            temp.append(" ");
                        }
                    }
                }
                res.add(temp.toString());
                flag = i;
                sb.setLength(0);
            }
            if(i != len-1){
                sb.append(words[i]);
            }else{
                StringBuffer temp = new StringBuffer();
                for(int a = flag ; a <= i ; a++){
                    temp.append(words[a]);
                    if(a != (i)){
                        temp.append(" ");
                    }
                }
                System.out.println();
                for(int a=0,x=maxWidth-temp.length();a<x;a++){
                    temp.append(" ");
                }
                res.add(temp.toString());
            }
        }
        return res;
    }
}

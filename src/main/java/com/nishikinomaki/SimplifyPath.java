package com.nishikinomaki;

import java.util.Iterator;
import java.util.Stack;


/**
 * Created by nishikinomaki on 16/3/14.
 *
 * Given an absolute path for a file (Unix-style), simplify it.

    For example,
    path = "/home/", => "/home"
    path = "/a/./b/../../c/", => "/c"
    @see {https://leetcode.com/problems/simplify-path/}

    解题思路:
    [参考]http://blog.csdn.net/makuiyu/article/details/44497901

    这道题的要求是简化一个Unix风格下的文件的绝对路径。

    字符串处理，由于".."是返回上级目录（如果是根目录则不处理），因此可以考虑用栈记录路径名，以便于处理。需要注意几个细节：

    1.重复连续出现的'/'，只按1个处理，即跳过重复连续出现的'/'；
    2.如果路径名是"."，则不处理；
    3.如果路径名是".."，则需要弹栈，如果栈为空，则不做处理；
    4.如果路径名为其他字符串，入栈。

    最后，再逐个取出栈中元素（即已保存的路径名），用'/'分隔并连接起来，不过要注意顺序呦。

    时间复杂度：O(n)
    空间复杂度：O(n)

 */
public class SimplifyPath {

    private static final char SPIRIT = '/';
    private static final String PARENT_DIR = "..";
    private static final String DOT = ".";

    public String simplifyPath(String path) {
        if(path == null){
            return null;
        }
        Stack<String> stack = new Stack<>();
        char[] pathCharArray = path.toCharArray();
        for (int i = 0; i < pathCharArray.length ;) {
            while ( i < pathCharArray.length && SPIRIT == pathCharArray[i]){
                //如果是"/"则跳过
                ++ i;
            }
            StringBuilder dirname = new StringBuilder();
            while ( i < pathCharArray.length && SPIRIT != pathCharArray[i]){
                dirname.append(pathCharArray[i++]);
            }
            if(PARENT_DIR.equals(dirname.toString())){
                if(!stack.isEmpty()) {
                    stack.pop(); // "..则出栈"
                }
            }
            else if(!DOT.equals(dirname.toString()) && !"".equals(dirname.toString())){
                stack.push(dirname.toString());
            }
        }
        if(stack.isEmpty()){
            return "/";
        }
        StringBuilder realPath = new StringBuilder();
        for(Iterator<String> i = stack.iterator(); i.hasNext(); ){
            realPath.append(SPIRIT).append(i.next());
        }
        return realPath.toString();
    }

    public static void main(String[] args) {
        String path = "/home/product/server_java/";
        //String path = "/";
//        String path = "/home/";
//        String path = "/a/./b/../../c/";
        SimplifyPath simplifyPath = new SimplifyPath();
        System.out.println(simplifyPath.simplifyPath(path));

    }
}

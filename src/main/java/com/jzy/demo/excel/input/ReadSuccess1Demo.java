package com.jzy.demo.excel.input;

import com.jzy.office.exception.ExcelColumnNotFoundException;
import com.jzy.office.exception.ExcelSheetNameInvalidException;
import com.jzy.office.exception.ExcelTooManyRowsException;
import com.jzy.office.exception.InvalidFileTypeException;

import java.io.IOException;
import java.util.List;

/**
 * @ClassName ReadSuccess1Demo
 * @Author JinZhiyun
 * @Description 成功读取学生信息的示例1
 * @Date 2020/4/1 21:48
 * @Version 1.0
 **/
public class ReadSuccess1Demo {
    public static void main(String[] args) throws IOException, InvalidFileTypeException {
        //改成你实际的文件路径
        String filePath = "E:\\Engineering\\java\\idea\\easy-office-process\\example\\test1.xlsx";
        //通过文件绝对路径构造excel对象
        Test1InputExcel excel = new Test1InputExcel(filePath);

        try {
            //校验并读取数据
            excel.testAndReadData();
        } catch (ExcelTooManyRowsException e) {
            //相应逻辑
            System.out.println("这个表格太多行了");
            e.printStackTrace();
        } catch (ExcelColumnNotFoundException e) {
            //相应逻辑
            System.out.println("有列没有找到，检查列名是否符合要求");
            e.printStackTrace();
        } catch (ExcelSheetNameInvalidException e) {
            //相应逻辑
            System.out.println("有sheet没有找到，检查sheet名是否符合要求");
            e.printStackTrace();
        }
        //获得读取到的数据
        List<Student> students = excel.getStudents();
        System.out.println("读取到的学生信息:");
        students.forEach(System.out::println);
    }
}

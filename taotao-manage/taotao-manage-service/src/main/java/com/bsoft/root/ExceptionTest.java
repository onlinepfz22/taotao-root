package com.bsoft.root;

import java.net.URL;

/**
 * @Auther: YSFY
 * @Date: 2018/6/22 10:17
 * @Pacage_name: com.bsoft.root
 * @Project_Name: taotao-root
 * @Description:
 */
public class ExceptionTest {

    public static void main(String[] args) {
        URL urlOfClass = App.class.getClassLoader().getResource("org/slf4j/spi/LocationAwareLogger.log");
        System.out.println(urlOfClass);


    }
}

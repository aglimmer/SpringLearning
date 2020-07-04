package com.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.TestDao;
import com.serv.TestService;

public class QueryTest {

	public QueryTest() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		 BeanFactory context=new ClassPathXmlApplicationContext("spring-mybatis.xml"); 
		 TestService testService = context.getBean(TestService.class);
		 Map<String,Object> mp = new HashMap<String,Object>();
		 mp.put("sex", "男");
		 mp.put("height", 150);
		 
		 String p = testService.queryService(mp);
		 System.out.println("第一种：通过service层调用查询（json字符串）：");
		 System.out.println(p);
		 
		 TestDao testDao = context.getBean(TestDao.class);
		 List<Map<String,Object>> arr = testDao.queryInfo(mp);
		 System.out.println("\n第二种：通过dao层调用查询：");
		 arr.forEach((m)->{
			 m.forEach((k,v)->{
				 System.out.print(v+"\t");
			 });
			 System.out.println();
		 });
		 
		 
	}

}

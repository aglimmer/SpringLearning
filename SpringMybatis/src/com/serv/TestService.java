package com.serv;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.TestDao;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


/**
 * @author wonzeng
 * 2020年7月3日
 * Service层使用规则总结：
 * 		1. 用于协助Controller层处理业务逻辑
 * 		2. 其存在不是必须的，处理较简单时可以直接合并Controller层
 * 		3. 如果使用了Service层，Service类上必须要注解 @Service ，类似的也可用  @Component @Repository 等
 * 		4. 必须在配置文件 (spring-mybatis.xml)中做如下配置，才能使注解被扫描到：
 *			<context:component-scan base-package="com.service"></context:component-scan>
 *
 */

@Service
public class TestService {

	
	/**
	 *  该注解同样可以直接配置到 Controller层
	 *   直接在Controller层通过注解对象testDao调用Dao层方法
	 */
	@Autowired
	TestDao testDao;
	
	
	public String queryService(Map<String,Object> mp) {
		// TODO Auto-generated constructor stub
		List<Map<String,Object>> ob = testDao.queryInfo(mp);
		//转换日期格式，也可用：new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create(); 
		 Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
		 return gson.toJson(ob);
	}
	

}

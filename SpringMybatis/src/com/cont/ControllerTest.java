package com.cont;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.serv.TestService;

/**
 * @author wonzeng
 * 2020年7月3日
 * Controller层：
 * 		1.必须配置spring-mvc.xml文件
 * 		2.尤其是以下扫描路径必须正确配置
 * 	<context:component-scan base-package="com.cont" />
 *	<bean
 *		class="org.springframework.web.servlet.view.InternalResourceViewResolver">
 *		<property name="prefix" value="/" />
 *		<property name="suffix" value=".html" />
 *	</bean>
 *  
 */
@Controller
public class ControllerTest {

	@Autowired
	TestService testService;
//	@Autowired
//	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	
	public ControllerTest() {
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * @param mp
	 * @ResponseBody 注解通常使用在控制层 controller的方法上
	 * 		1. 其作用是将方法的返回值以特定的格式写入到response的body区域， 进而将数据返回给客户端
	 * 		2. 当方法上面没有写ResponseBody,底层会将方法的返回值封装为ModelAndView对象
	 * 		3. 一种是可直接调用 response.getWriter()将String送到前端，另一种还可使用return返回String
	 * 		4. 若返回String，默认按iso8859-1编码，页面可能出现乱码
	 * 		  此时可以将 @RequestMapping("/queryinfo.do") 修改为：
	 * 		@RequestMapping(value="/queryinfo.do",produces="text/html;charset=utf-8")
	 */
	@ResponseBody
	@RequestMapping(value="/queryinfo.do",produces="text/html;charset=utf-8")
	public String queryTest(@RequestParam Map<String,Object> mp) {
		mp.forEach((k,v)->{
			System.out.println("ControllerTest.queryTest():"+k+"\t"+v);
		});
		String res = testService.queryService(mp);
		System.out.println("json:"+res);
//		返回类型为void，则可以直接使用如下：
//		try {
//			response.getWriter().print(res);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return res;
	}
}

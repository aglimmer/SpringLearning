package com.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
/**
 * Dao层：
 * 		1.确保 mybatis-spring包正确导入到环境依赖中
 * 		2.必须要在配置文件中配置dao层的扫描路径 (spring-mybatis.xml):
*			<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
*				<!-- 扫描包路径，如果需要扫描多个包，中间使用半角逗号隔开 -->
*				<property name="basePackage" value="com.dao" />
*			</bean>
*		3.这里使用 Map作为参数，则 Map 的key必须与 注解上的查询语句 "#{ }" 中的名字一致，个数一致
**/
public interface TestDao {
	@Select("select * from tb_test where sex=#{sex} and height>#{height} limit 0,10")
	public List<Map<String,Object>> queryInfo(Map<String,Object> mp);
}

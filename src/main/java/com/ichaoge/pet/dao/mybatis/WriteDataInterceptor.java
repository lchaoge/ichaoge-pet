package com.ichaoge.pet.dao.mybatis;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;

import java.util.Properties;

/**
 * @description MyBatis写数据拦截器
 * @author  zengyang
 * @date  2012-12-19
 * 
 */
@Intercepts({@Signature(type= Executor.class,method = "update",
args = {MappedStatement.class, Object.class})})
public class WriteDataInterceptor implements Interceptor {
	
	private static CacheManager memcachedManager;
	
	public CacheManager getMemcachedManager() {
		if(memcachedManager == null) {
			memcachedManager = (CacheManager) ApplicationContextUtils.getService("memcachedManager");
		}
		return memcachedManager;
	}
	 
	public Object intercept(Invocation invocation) throws Throwable {
		Object[] args = invocation.getArgs();
		MappedStatement mappedStatement = (MappedStatement) args[0];
		Object paramObj = args[1];
		if(paramObj == null)
			return invocation.proceed();
		if(mappedStatement.getSqlCommandType()== SqlCommandType.UPDATE||
				mappedStatement.getSqlCommandType()== SqlCommandType.DELETE) {
			return deleteCache(invocation, paramObj);
		}
		return invocation.proceed();
	}
	 
	private Object deleteCache(Invocation invocation,Object paramObj) throws Throwable {
		Object value =  invocation.proceed();
		return value;
	}


	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	public void setProperties(Properties properties) {
		
	}
}

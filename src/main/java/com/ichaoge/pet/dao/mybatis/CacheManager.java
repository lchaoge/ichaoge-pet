package com.ichaoge.pet.dao.mybatis;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @description 缓存管理接口
 * @author  zengyang
 * 
 */
public interface CacheManager {
	/**
	 * 得到缓存记录
	 * @author zengyang
	 * @param key
	 * @return
	 */
	public Serializable get(String key);
	/**
	 * 写入一条记录到缓存中
	 * @param key
	 * @param result
	 * @return
	 * @author  zengyang
	 */
	public boolean put(String key, Serializable result);
	/**
	 * 写入一条记录到缓存中
	 * @author zengyang
	 * @param key	缓存key
	 * @param result	缓存内容
	 * @param timeToIdleSeconds	过期时间(单位秒)
	 */
	public boolean put(String key, Serializable result, int timeToIdleSeconds);
	/**
	 * 写入一条记录到缓存中
	 * @author zengyang
	 * @param key		缓存key
	 * @param result	缓存内容
	 * @param idleDate	过期日期
	 */
	public boolean put(String key, Serializable result, Date idleDate);
	/**
	 * 删除一条缓存
	 * @author zengyang
	 * @param key
	 */
	public void remove(String key);
	/**
	 * 得到缓存数量
	 * @author zengyang
	 * @return
	 */
	public int getSize();
	/**
	 * 清空缓存
	 * @author zengyang
	 */
	public void clear();
	
	public boolean exists(String key);
}

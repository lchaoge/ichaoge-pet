package com.ichaoge.pet.utils;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * 实现描述：通用工具类
 * 
 * @author simon
 * @version v1.0.0
 * @see
 * @since 2014年1月28日 下午2:12:15
 */
public abstract class LangUtils {

    public static int nvl(Integer i, int defaults) {
        return i == null ? defaults : i;
    }

    public static long nvl(Long l, long defaults) {
        return l == null ? defaults : l;
    }

    public static boolean nvl(Boolean b, boolean defaults) {
        return b == null ? defaults : b;
    }

    public static boolean nvl(String bool, boolean defaults) {
        return bool == null ? defaults : Boolean.parseBoolean(bool);
    }

    public static String nvl(String string, String defaults) {
        return string == null ? defaults : string;
    }

    /**
     * <pre>
     *     功能类似 Guava 的 Lists.transform，
     *     不同点：Guava 是生成的 TransformingRandomAccessList，使用到List中的元素时才会生成一个新的对象，这个对象不在原 List 中存在。
     *     本方法是预生成对象，使用 ArrayList 替代 TransformingRandomAccessList。
     * </pre>
     *
     * @param fromList
     * @param function
     * @param <F>
     * @param <T>
     * @return
     */
    public static <F, T> List<T> transform(List<F> fromList, Function<? super F, ? extends T> function) {
        List<T> result = Lists.newArrayList();
        if (fromList == null) {
            return result;
        }

        for (F input : fromList) {
            result.add(function.apply(input));
        }
        return result;
    }

    public static <T> List<T> filter(List<T> fromList, Predicate<? super T> predicate) {
        List<T> result = Lists.newArrayList();
        for (T input : fromList) {
            if (predicate.apply(input)) {
                result.add(input);
            }
        }
        return result;
    }

    public static List<Long> longList(List<String> stringList) {
        List<Long> result = Lists.newArrayList();
        for (String string : stringList) {
            result.add(Long.valueOf(string));
        }
        return result;
    }

    public static class Ref<T> {
        private Object obj;

        private Ref() {
        }

        @SuppressWarnings("unchecked")
        public T get() {
            return (T) this.obj;
        }

        public void set(Object obj) {
            this.obj = obj;
        }

        public static <T> Ref<T> of() {
            return new Ref<>();
        }

        public static <T> Ref<T> of(T obj) {
            Ref<T> ref = new Ref<>();
            ref.set(obj);
            return ref;
        }
    }

}

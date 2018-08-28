package com.ichaoge.pet.common;

import java.util.Random;
import java.util.UUID;

/**
 * 随机生成字符串
 * 
 * @author red
 *
 */
public class GenerateRandom {
	/**
	 * 
	 * @param numberFlag
	 *            //是否数字
	 * @param length
	 *            //长度
	 * @return //String
	 */
	public static String createRandom(boolean numberFlag, int length) {
		String retStr = "";
		String strTable = numberFlag ? "1234567890"
				: "1234567890abcdefghijkmnpqrstuvwxyz";
		int len = strTable.length();
		boolean bDone = true;
		do {
			retStr = "";
			int count = 0;
			for (int i = 0; i < length; i++) {
				double dblR = Math.random() * len;
				int intR = (int) Math.floor(dblR);
				char c = strTable.charAt(intR);
				if (('0' <= c) && (c <= '9')) {
					count++;
				}
				retStr += strTable.charAt(intR);
			}
			if (count >= 2) {
				bDone = false;
			}
		} while (bDone);

		return retStr;
	}

	public static String getUuid() {
		// 生成32位uuid
		UUID uuidObj = UUID.randomUUID();
		String uuid = uuidObj.toString().replaceAll("-", "");

		return uuid;
	}

	/**
	 * 生成传入数字范围内的随机整数
	 * 
	 * @param maxNum
	 *            最大范围数字,例如maxNum=100,则取1...100随机整数
	 * @return 随机数
	 */
	public static int getRandomInt(int maxNum) {
		Random random = new Random(System.currentTimeMillis());
		int iRandom = random.nextInt(maxNum) + 1;
		return iRandom;
	}

	/**
	 * 随机指定范围内N个不重复的数 在初始化的无重复待选数组中随机产生一个数放入结果中，
	 * 将待选数组被随机到的数，用待选数组(len-1)下标对应的数替换 然后从len-2里随机产生下一个随机数，如此类推
	 * 
	 * @param max
	 *            指定范围最大值
	 * @param min
	 *            指定范围最小值
	 * @param n
	 *            随机数个数
	 * @return int[] 随机数结果集
	 */
	public static int[] randomArray(int min, int max, int n) {
		int len = max - min + 1;

		if (max < min || n > len) {
			return null;
		}

		// 初始化给定范围的待选数组
		int[] source = new int[len];
		for (int i = min; i < min + len; i++) {
			source[i - min] = i;
		}

		int[] result = new int[n];
		Random rd = new Random();
		int index = 0;
		for (int i = 0; i < result.length; i++) {
			// 待选数组0到(len-2)随机一个下标
			index = Math.abs(rd.nextInt() % len--);
			// 将随机到的数放入结果集
			result[i] = source[index];
			// 将待选数组中被随机到的数，用待选数组(len-1)下标对应的数替换
			source[index] = source[len];
		}
		return result;
	}
}

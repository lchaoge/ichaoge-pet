package com.ichaoge.pet.common.converter;

import com.ichaoge.pet.common.constant.EncodingConstant;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * MVC框架字符串传送的编码格式重载，默认使用UTF-8
 * 解决中文乱码问题
 *
 * User: chaoge
 * Date: 15-2-27
 * Time: 上午9:51
 */
public class UTF8StringHttpMessageConverter extends AbstractHttpMessageConverter<String> {

	public static final Charset DEFAULT_CHARSET = Charset.forName(EncodingConstant.UTF_8);

	private final List<Charset> availableCharsetList;

	public UTF8StringHttpMessageConverter() {
		this(DEFAULT_CHARSET);
	}

	public UTF8StringHttpMessageConverter(Charset defaultCharset) {
		super(new MediaType("text", "plain", defaultCharset), MediaType.ALL);
		this.availableCharsetList = new ArrayList<Charset>(Charset.availableCharsets().values());
	}

	@Override
	protected boolean supports(Class<?> aClass) {
		return String.class.equals(aClass);
	}

	@Override
	protected String readInternal(Class<? extends String> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
		MediaType contentType = httpInputMessage.getHeaders().getContentType();
		Charset charset = contentType.getCharSet() != null ? contentType.getCharSet() : DEFAULT_CHARSET;
		return FileCopyUtils.copyToString(new InputStreamReader(httpInputMessage.getBody(), charset));
	}

	@Override
	protected void writeInternal(String s, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {
		MediaType contentType = httpOutputMessage.getHeaders().getContentType();
		Charset charset = contentType.getCharSet() != null ? contentType
				.getCharSet() : DEFAULT_CHARSET;
		FileCopyUtils.copy(s, new OutputStreamWriter(httpOutputMessage.getBody(), charset));
	}

	@Override
	protected Long getContentLength(String s, MediaType contentType) {
		if (contentType != null && contentType.getCharSet() != null) {
			Charset charset = contentType.getCharSet();
			try {
				return (long) s.getBytes(charset.name()).length;
			} catch (UnsupportedEncodingException ex) {
				throw new InternalError(ex.getMessage());
			}
		} else {
			return null;
		}
	}

	public List<Charset> getAvailableCharsetList() {
		return availableCharsetList;
	}

}

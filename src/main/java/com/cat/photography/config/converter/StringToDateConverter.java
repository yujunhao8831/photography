package com.cat.photography.config.converter;

import com.cat.photography.common.DateFormatStyle;
import com.cat.photography.common.SimpleDateFormatPro;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * 这里只能对普通参数进行转换
 *
 * 对 {@link org.springframework.web.bind.annotation.RequestBody} 接收的参数无效
 *
 * @author : 披荆斩棘
 * @date : 17/7/17
 */
public class StringToDateConverter implements Converter< String, Date > {

    @Override
    public Date convert ( String source ) {
        return new SimpleDateFormatPro(DateFormatStyle.getDateFormatStyles() ).parse(source );
    }
}

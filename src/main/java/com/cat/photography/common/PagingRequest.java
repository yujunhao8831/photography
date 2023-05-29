package com.cat.photography.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 分页信息接收实体
 *
 * @author : 披荆斩棘
 * @date : 2017/7/13
 */
@Getter
@Setter
@ToString
@Accessors( chain = true )
public class PagingRequest implements Serializable {

    private int pageNumber;
    private int pageSize;


    public PagingRequest() {
        this( 1 , 10 );
    }

    public PagingRequest(int pageNumber , int pageSize ) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }


}

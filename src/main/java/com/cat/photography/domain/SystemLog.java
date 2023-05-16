package com.cat.photography.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 系统日志表
 * </p>
 *
 * 
 * @since 2023-05-15
 */
@Data
@TableName("system_log")
public class SystemLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 后台管理用户ID
     */
    private Long userId;

    /**
     * 后台管理用户真实姓名
     */
    private String userRealName;

    /**
     * 操作日志(也用于可以存储异常栈信息,或者运行的sql) json
     */
    private String actionLog;

    /**
     * 操作ip地址
     */
    private String actionIpAddress;

    /**
     * 操作描述
     */
    private String actionDescription;

    /**
     * 动作开始时间
     */
    private LocalDateTime actionStartTime;

    /**
     * 动作结束时间
     */
    private LocalDateTime actionEndTime;

    /**
     * 总执行时间(微秒)
     */
    private Long actionTotalTime;

    /**
     * 操作类
     */
    private String actionClass;

    /**
     * 操作方法
     */
    private String actionMethod;

    /**
     * 方法参数
     */
    private String actionArgs;

    /**
     * 是否异常
     */
    private Boolean isException;

    /**
     * 异常是否警报
     */
    private Boolean isExceptionWarn;

    /**
     * 通知类型(SMS:短信,MAIL:邮箱)
     */
    private String noticeType;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

}

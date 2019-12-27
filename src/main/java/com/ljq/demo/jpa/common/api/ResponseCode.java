package com.ljq.demo.jpa.common.api;

import lombok.Getter;
import lombok.ToString;

/**
 * @Description: 接口返回码枚举类
 * @Author: junqiang.lu
 * @Date: 2019/3/26
 */
@Getter
@ToString
public enum  ResponseCode {

    /**
     * 成功
     */
    SUCCESS(200, "成功"),
    /**
     * 失败
     */
    FAIL(-1, "失败"),

    /**
     * 参数与公共模块
     */
    PARAM_ERROR(1001, "参数(格式)错误"),
    PARAM_NOT_NULL(1002, "参数不能为空"),
    OBJECT_NOT_EXIST(1003, "查询对象不存在"),
    OBJECT_IS_DELETE(1004, "对象已经删除"),
    METHOD_NOT_VALID(1005, "请求方式错误"),
    API_DEPRECATED(1006, "接口已遗弃"),
    FILE_UPLOAD_ERROR(1007, "上传文件失败"),
    FILE_UPLOAD_SIZE(1008, "上传文件太大"),
    FILE_NULL_ERROR(1009, "上传文件不能为空"),
    PARAM_MISSING_ERROR(1010, "缺少请求参数"),
    UPDATE_FAIL(1011, "更新失败，请重新操作"),
    REQUEST_TIME_OUT(1012,"请求超时"),
    FILE_FORMAT_ERROR(1013,"文件格式错误"),
    NOT_DATA(1014,"未查询到数据"),
    REQUEST_METHOD_ERROR(1015, "请求方式错误"),
    MEDIA_TYPE_NOT_SUPPORT_ERROR(1016, "参数(文件)格式不支持"),
    PARAM_BIND_ERROR(1017, "参数格式错误,数据绑定失败"),
    NOT_FOUND_ERROR(1018, "请求资源(接口)不存在"),
    MISS_REQUEST_PART_ERROR(1019, "缺少请求体(未上传文件)"),
    MISS_REQUEST_PARAM_ERROR(1020, "缺少请求参数"),

    /**
     * 课程
     */
    COURSE_NOT_EXIST(2001, "课程不存在"),
    COURSE_DEADLINE_END_TIME_EARLIER_NOW(2002, "课程截止时间不能早于当前时间"),
    COURSE_START_TIME_EARLIER_NOW(2003, "课程开始时间不能早于当前时间"),
    COURSE_END_TIME_EARLIER_START_TIME(2004, "课程结束时间不能早于课程开始时间"),
    COURSE_PRICE_ERROR(2005, "课程价格设置不合理"),
    COURSE_COVER_FILE_NOT_EXIST(2006, "课程封面文件不存在"),
    COURSE_INTRODUCTION_FILE_NOT_EXIST(2007, "课程简介图片文件不存在"),
    COURSE_VIDEO__FILE_NOT_EXIST(2008, "课程视频资源文件不存在"),
    COURSE_NOT_SUPPORT_LESSON(2009, "当前课程不支持课次"),
    COURSE_VIDEO_USER_NO_PERMISSION(2010, "用户没有查看该视频的权限"),
    COURSE_START_TIME_UPDATE_24H_ERROR(2011, "只有在课程开始 24 小时之前可修改课程信息"),
    COURSE_START_TIME_MUST_BEFORE_24H(2012, "课程开始时间必须距离当前至少 24 小时"),
    COURSE_DEADLINE_TIME_EARLIER_COURSE_END_TIME(2013, "课程期限截至时间不能早于课程结束时间"),
    COURSE_EXPIRED_ERROR(2014, "课程已经过期,不可修改"),
    COURSE_LIVE_REPEAT_CREATE(2016, "当前课程直播课已经创建,请勿重复创建"),
    COURSE_LIVE_NO_INFO(2017, "未查询到课程直播信息"),
    COURSE_DEADLINE_START_TIME_EARLIER_COURSE_START_TIME(2018, "课程开始时间不得早于课程期限开始时间"),
    COURSE_DEADLINE_END_TIME_EARLIER_DEADLINE_START_TIME(2019, "课程期限截止时间不能早于开始时间"),
    COURSE_CAN_NOT_DELETE_USER_BUY(2020, "课程无法删除,已经有用户购买"),

    COURSE_TYPE_EXIST(2101, "课程类别名称已经存在"),
    COURSE_TYPE_USED(2102, "课程类别已经被使用,不可删除"),
    COURSE_TYPE_NOT_EXIST(2103, "课程类别不存在"),
    COURSE_TYPE_OVER_SIZE(2104, "课程类别的数量已经达到最大值"),

    COURSE_BACKGROUND_NOT_EXIST(2201, "课程背景不存在"),
    COURSE_BACKGROUND_USED(2202, "课程背景已经被使用,不可删除"),

    COURSE_TAG_EXIST(2301, "课程标签已经存在"),
    COURSE_TAG_NOT_EXIST(2302, "课程标签不存在"),
    COURSE_TAG_USED(2303, "课程标签已经被使用,不可删除"),

    COURSE_LESSON_VIDEO_FILE_NOT_EXIST(2401, "课程课次视频文件不存在"),
    COURSE_LESSON_OVER_SIZE(2402, "当前课程课次数量已经达到最大值"),
    COURSE_LESSON_NOT_EXIST(2403, "课次信息不存在"),

    COURSE_USER_RECORD_NOT_EXIST(2501, "当前用户的学习记录不存在"),
    COURSE_RECORD_NOT_EXIST(2502, "课程学习记录不存在"),

    COURSE_STATISTICS_USER_TYPE_ERROR(2601, "用户类型选择错误"),

    COURSE_SOURCE_ERROR_NOT_RECORD(2701, "课程来源错误,当前课程非录播课"),
    COURSE_SOURCE_ERROR_NOT_LIVE(2702, "课程来源错误,当前课程非直播课"),

    COURSE_SHELF_UP_ERROR_LIVE_COURSE_STARTED(2801, "课程上架失败,直播课程已经开始"),
    COURSE_SHELF_DOWN_ERROR_LIVE_COURSE_NOT_END(2802, "课程下架失败,直播未结束"),

    /**
     * 管理员
     */
    ADMIN_PASSWORD_ERROR(3001, "密码错误"),
    ADMIN_PHONE_REPEAT_ERROR(3002,"手机号已经注册"),
    ADMIN_ACCOUNT_NOT_EXIST(3003, "管理员账号存在"),
    ADMIN_NOT_EXIST(3004, "管理员不存在"),
    OLD_NEW_PWD_DIFFERENT(3005,"新密码和旧密码不同"),
    OLD_PWD_ERROR(3006,"原密码错误"),

    /**
     * 订单
     */
    ORDER_CANCEL_ERROR(4001, "订单取消失败,可能原因:1 订单不存在;2 订单非本人所属;3 仅未支付订单可取消"),
    ORDER_STATUS_NOT_PAY_ERROR(4002, "订单已支付或已取消"),
    ORDER_PAY_WX_OPENID_NULL(4003,"微信用户识别码为空"),
    ORDER_PAY_TYPE_ERROR(4004,"订单支付方式错误"),
    ORDER_SUBMIT_FAIL(4005,"订单提交失败,请稍后重试"),
    ORDER_NOT_CANCEL(4006, "订单未取消"),
    ORDER_OWNER_NOT_MATCH(4007, "用户身份不匹配"),
    ORDER_NOT_FREE(4008, "该订单非免费订单"),
    ORDER_AMOUNT_ERROR(4009, "订单金额有误"),
    ORDER_GOODS_REPEAT_BUY(4010, "已经购买,请勿重复下单"),
    ORDER_OVER_FREE_LIMIT(4011, "已经超过免单优惠限制,请付费购买"),
    ORDER_NOT_EXIST(4012, "订单不存在"),
    ORDER_USER_NOT_SUBSCRIBE_COURSE(4013, "用户未订阅该课程"),
    ORDER_NO_CREATE(4014, "当前课程无需创建订单"),
    ORDER_USER_NOT_BUY_COURSE(4015, "用户未购买该课程"),
    ORDER_USER_CAN_NOT_CANCEL_SUBSCRIBE_COURSE(4016, "当前课程无法取消订阅"),
    ORDER_DELETE_ERROR(4016, "订单删除失败,可能原因: 1订单不存在或已删除; 2订单非本人所属; 3订单未取消"),
    ORDER_PAID(4017, "订单已支付"),
    ORDER_POSTED(4018, "订单已发货"),
    ORDER_CANCELED(4019, "订单已取消"),
    ORDER_RETURNED(4020, "订单已退货"),

    /**
     * 优惠券
     */
    COUPON_DISCOUNT_NULL_ERROR(5001, "折扣券不能为空"),
    COUPON_CASH_NULL_ERROR(5002, "代金券不能为空"),
    COUPON_DISCOUNT_VALUE_ERROR(5003, "折扣券折扣力度设置不合理"),
    COUPON_CASH_VALUE_ERROR(5004, "代金券优惠金额设置不合理"),
    COUPON_GOODS_NULL_ERROR(5005, "参与优惠的课程不能为空"),
    COUPON_PUBLISHED(5006, "优惠券已发布,禁止修改"),
    COUPON_NO_COMPLIANT_COURSE(5007, "没有符合优惠规则的课程"),
    COUPON_INFO_ERROR(5008, "优惠券信息错误"),
    COUPON_GOODS_INFO_ERROR(5009, "参与优惠的课程信息有误"),
    COUPON_CONTAIN_PUBLISHED_GOODS(5010, "该优惠券中包含已经参与优惠的课程"),

    /**
     * 用户信息
     */
    USER_TOKEN_NULL_ERROR(6001, "用户身份令牌为空"),
    USER_TOKEN_EXPIRED_ERROR(6002, "登录失效,请重新登录"),
    USER_PASSWORD_ERROR(3001, "密码错误"),
    USER_BAN(6003,"账号已停用"),
    USER_PHONE_NON_EXIST(6004,"手机号不存在"),
    USER_INFO_FIND_FAIL(6005,"用户信息查询失败"),
    CODE_FREQUENTLY(6006,"短信发送频繁,请稍后..."),
    CODE_ERROR(6007,"验证码错误"),
    USER_NOT_EXIST(6008,"用户不存在"),
    USER_ALREADY_EXIST(6009,"手机号已存在"),
    //会员，校区地址不可修改
    YES_INVITE(6010,"校区地址不可修改"),
    NOT_INVITE(6011,"非会员"),
    INVITATION_ALREADY_USE(6012,"邀请码无效"),
    USER_REGISTER_FAIL(6013,"注册失败，请重试"),
    USER_TEACHER_NOT_EXIST(6014, "教师不存在"),
    USER_NOT_STUDENT(6015, "当前用户非学生用户"),
    USER_NOT_TEACHER(6016, "当前用户非教师用户"),
    TITLE_ALREADY_EXIST(6017, "该标签已存在"),
    LOGIN_ENTRANCE(6018,"登录或注册入口异常"),
    TITLE_USER(6019,"教师职称正在被使用，不可删除"),
    LOGIN_EXCEED_ONE(6020,"该学生已登录过系统，不可删除"),
    INVITE_ERROR(6021,"用户角色invite字段，值错误"),
    NOT_SHOP_USER(6023,"该账号不是商城用户"),

    /**
     * 文件
     */
    FILE_NOT_EXIST(7001, "文件不存在"),
    FILE_USED_ON_COURSE_BACKGROUND(7002, "文件已经在课程背景中使用"),

    /**
     * banner
     */
    BANNER_OVER_MAX_NUM_SAME_TYPE(8001, "超过了同一模块(类型) Banner 图的数量上限"),

    /**
     * 消息
     */
    MESSAGE_REGISTRATION_ID_NULL_ERROR(8001, "APP消息推送设备识别码为空"),
    MESSAGE_APP_PUSH_ERROR(8002, "APP 消息推送失败"),

    /**
     * 岗位
     */
    JOB_TYPE_USER(9001,"该岗位分类已被使用，不可删除"),
    JOB_USER(9002,"该岗位已被使用，不可删除"),
    ORGANIZED_USE(9003,"该机构下存在子类目和用户，不可删除"),

    /**
     * 商城-商品
     */
    SHOP_GOODS_NOT_EXIST(10001, "商品不存在"),
    GOODS_TIME_IS_NULL(10002,"秒杀时间未填写"),
    GOODS_TIME_SIZE(10003,"秒杀开始时间大于结束时间"),
    SHOP_GOODS_SHELF_DOWN(10004, "商品已下架"),

    /**
     * 商城-购物车
     */
    SHOP_CART_NOT_EXIST(11001, "没有查询到购物车信息"),

    /**
     * 商城-收藏夹
     */
    SHOP_FAVORITE_NOT_EXIST(12001, "没有查询到用户收藏信息"),

    /**
     * 商品分类
     */
    GOODS_TYPE_PARENT(13001,"模块最多可添加8个"),
    GOODS_TYPE_NOT_DELETE(13002,"模块下有子模块或商品，不可删除"),
    /**
     * 收货地址
     */
    ADDRESS_MAX(14001,"收货地址最多可添加10个"),
    ADDRESS_NOT_EXIST(14002, "收货地址不存在"),

    /**
     * 用户发票
     */
    INVOICE_NOT_EXIST(15001, "发票信息不存在"),


    /**
     * 未知异常
     */
    UNKNOWN_ERROR(-1000,"系统异常");


    /**
     * 返回码
     */
    private int code;

    /**
     * 返回信息
     */
    private String msg;

    ResponseCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}

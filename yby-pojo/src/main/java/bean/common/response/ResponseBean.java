package bean.common.response;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 响应实体类
 * @author guocy
 * */
@Data
@ToString
public final class ResponseBean<T> implements Serializable {

    private static final long serialVersionUID = 2578404513884660164L;

    /**
     * 响应状态码
     * */
    private Short status;

    /**
     * 响应对象
     * */
    private T obj;

    /**
     * 响应信息
     * */
    private String msg;

    /**
     * 响应实体构造函数 - 无参构造函数默认为请求失败
     * */
    public ResponseBean(){
        this.status = ResponseStatusEnum.FAILED.getCode();
        this.obj = null;
        this.msg = ResponseStatusEnum.FAILED.getPhraseCN();
    }

    /**
     * 响应实体构造函数 - 响应状态以传入响应状态枚举值为准
     * @param status 响应状态枚举类
     *        {@link ResponseStatusEnum}
     * */
    public ResponseBean(ResponseStatusEnum status){
        this.status = status.getCode();
        this.obj = null;
        this.msg = status.getPhraseCN();
    }

    /**
     * 响应实体构造函数 - 传入响应对象及响应信息预定为成功
     * @param obj 响应对象
     * @param msg 响应信息
     * */
    public ResponseBean(T obj, String msg){
        this.status = ResponseStatusEnum.SUCCESS.getCode();
        this.obj = obj == null ? null : (T) obj;
        this.msg = msg == null ? ResponseStatusEnum.SUCCESS.getPhraseCN() : msg;
    }

    /**
     * 响应实体构造函数 - 全参数构造函数以传入响应状态枚举为准
     * @param status 响应状态枚举类
     * @param obj 响应对象
     * @param msg 响应信息
     * */
    public ResponseBean(ResponseStatusEnum status, T obj, String msg){
        this.status = status.getCode();
        this.obj = obj;
        this.msg = msg == null ? status.getPhraseCN() : msg;
    }

    /**
     * 变更响应状态
     * @param status 响应状态枚举类
     * */
    public ResponseBean<T> changeStatus(ResponseStatusEnum status){
        this.status = status.getCode();
        return this;
    }

    /**
     * 更新响应状态为请求成功
     * */
    public ResponseBean<T> success(){
        this.status = ResponseStatusEnum.SUCCESS.getCode();
        this.msg = ResponseStatusEnum.SUCCESS.getPhraseCN();
        return this;
    }

    /**
     * 更新响应状态为请求失败
     * */
    public ResponseBean<T> failed(){
        this.status = ResponseStatusEnum.FAILED.getCode();
        this.msg = ResponseStatusEnum.FAILED.getPhraseCN();
        return this;
    }

    /**
     * 更新响应状态为未登录
     * */
    public ResponseBean<T> unlogged(){
        this.status = ResponseStatusEnum.UNAUTHORIZED.getCode();
        return this;
    }

}

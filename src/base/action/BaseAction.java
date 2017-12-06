package base.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//Action类继承BaseAction后可以使用加强的方法,精简代码
public class BaseAction extends ActionSupport {
    //增强ActionContext对象的put方法
    public void put(String key, Object value) {
        //先获取到ActionContext对象
        ActionContext.getContext().put(key, value);
    }

    //增强ValueStack的push方法
    public void push(Object value) {
        ActionContext.getContext().getValueStack().push(value);
    }
}

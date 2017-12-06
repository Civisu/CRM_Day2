package linkman.action;

import base.action.BaseAction;
import com.opensymphony.xwork2.ModelDriven;
import customer.domain.Customer;
import customer.service.CustomerService;
import linkman.domain.Linkman;
import linkman.service.LinkmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

//联系人模块
@Controller(value = "linkmanAction")
@Scope(value = "prototype")
public class LinkmanAction extends BaseAction implements ModelDriven<Linkman> {

    //创建Linkman对象,用于封装数据,	getModel的 get去掉，把M变成小写，model就是LinkmanAction的属性
    private Linkman linkman = new Linkman();

    @Override
    public Linkman getModel() {
        return linkman;
    }

    //注入LinkmanService对象
    @Autowired
    private LinkmanService linkmanService;

    //注入CustomerService对象
    @Autowired
    private CustomerService customerService;

    //跳转到新增联系人方法
    public String initAdd() throws Exception {

        //查询所有客户
        List<Customer> customerList = customerService.findAll();

        //放入ContextMap中
        super.put("customerList", customerList);

        return "initAdd";
    }
}

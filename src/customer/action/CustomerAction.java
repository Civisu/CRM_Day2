package customer.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import customer.domain.Customer;
import customer.service.CustomerService;
import dict.domain.Dict;
import dict.service.DictService;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.List;

//客户模块
@Controller(value = "customerAction")
@Scope(value = "prototype")
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    private Customer model = new Customer();

    @Override
    public Customer getModel() {
        return model;
    }

    //@Resource(name = "customerService")
    @Autowired
    private CustomerService customerService;

    //注入字典的业务层
    @Autowired
    private DictService dictService;

    //删除客户
    public String delete() throws Exception {
        customerService.delete(model);
        return SUCCESS;
    }

    //修改客户
    public String update() throws Exception {
        customerService.update(model);
        return SUCCESS;
    }

    //跳转到修改客户页面
    public String initUpdate() throws Exception {

        //根据id查询客户信息
        Customer customer = customerService.findById(model.getCustId());
        //把数据放入值栈
        ActionContext.getContext().getValueStack().push(customer);
        // 压栈值栈中，或者压入map
        // ValueStack vs = ActionContext.getContext().getValueStack();
        // 把c对象压入到栈顶，获取到c对象的属性的值：value="[0].top.属性"	简写的方式：value="属性"
        // vs.push(c);

        //创建离线条件对象		QBC:query by Criteria
        DetachedCriteria criteria1 = DetachedCriteria.forClass(Dict.class);
        //设置查询的条件 SELECT * FROM base_dict WHERE dict_type_code = '002';
        criteria1.add(Restrictions.eq("dictTypeCode", "002"));
        //查询客户来源的数据
        List<Dict> sourceList = dictService.findByWhere(criteria1);

        //查询行业数据
        DetachedCriteria criteria2 = DetachedCriteria.forClass(Dict.class);
        //设置查询条件
        criteria2.add(Restrictions.eq("dictTypeCode", "001"));
        //查询客户行业的数据
        List<Dict> industryList = dictService.findByWhere(criteria2);

        //查询级别数据
        DetachedCriteria criteria3 = DetachedCriteria.forClass(Dict.class);
        //设置查询条件
        criteria3.add(Restrictions.eq("dictTypeCode", "006"));
        //查询级别数据
        List<Dict> levelList = dictService.findByWhere(criteria3);

        //将集合存入值栈或者ContextMap中,转发到JSP页面
        ActionContext.getContext().put("sourceList", sourceList);
        ActionContext.getContext().put("industryList", industryList);
        ActionContext.getContext().put("levelList", levelList);


        return "initUpdate";
    }

    //跳转到新增客户页面
    public String initAdd() throws Exception {
        /**
         * Criteria c = session.createCriteria(Class)
         * c.add(Restrictions.eq gt ge lt )
         * c.list()
         */
        //创建离线条件对象		QBC:query by Criteria
        DetachedCriteria criteria1 = DetachedCriteria.forClass(Dict.class);
        //设置查询的条件 SELECT * FROM base_dict WHERE dict_type_code = '002';
        criteria1.add(Restrictions.eq("dictTypeCode", "002"));
        //查询客户来源的数据
        List<Dict> sourceList = dictService.findByWhere(criteria1);

        //查询行业数据
        DetachedCriteria criteria2 = DetachedCriteria.forClass(Dict.class);
        //设置查询条件
        criteria2.add(Restrictions.eq("dictTypeCode", "001"));
        //查询客户行业的数据
        List<Dict> industryList = dictService.findByWhere(criteria2);

        //查询级别数据
        DetachedCriteria criteria3 = DetachedCriteria.forClass(Dict.class);
        //设置查询条件
        criteria3.add(Restrictions.eq("dictTypeCode", "006"));
        //查询级别数据
        List<Dict> levelList = dictService.findByWhere(criteria3);

        //将集合存入值栈或者ContextMap中,转发到JSP页面
        ActionContext.getContext().put("sourceList", sourceList);
        ActionContext.getContext().put("industryList", industryList);
        ActionContext.getContext().put("levelList", levelList);

        return "initAdd";
    }

    //增加客户
    public String save() throws Exception {
        //调用业务层,保存客户
        customerService.save(model);

        return SUCCESS;
    }

    //查询所有用户
    public String findAll() throws Exception {
        //调用业务层查询所有客户
        List<Customer> list = customerService.findAll();
        System.out.println(list.size());
        //将集合保存到ContextMap中
        ActionContext.getContext().put("list", list);
        return "findAll";
    }

}

package customer.domain;

import dict.domain.Dict;
import linkman.domain.Linkman;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//客户表
@Entity
@Table(name = "cst_customer")
public class Customer {
    /**
     * CREATE TABLE `cst_customer` (
     * `cust_id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '客户编号(主键)',
     * `cust_name` varchar(32) NOT NULL COMMENT '客户名称(公司名称)',
     * `cust_source` varchar(32) DEFAULT NULL COMMENT '客户信息来源',
     * `cust_industry` varchar(32) DEFAULT NULL COMMENT '客户所属行业',
     * `cust_level` varchar(32) DEFAULT NULL COMMENT '客户级别',
     * `cust_address` varchar(128) DEFAULT NULL COMMENT '客户联系地址',
     * `cust_phone` varchar(64) DEFAULT NULL COMMENT '客户联系电话',
     * PRIMARY KEY (`cust_id`)
     * ) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;
     */

    @Id
    @Column(name = "cust_id")
    @GenericGenerator(name = "myNative", strategy = "native")
    @GeneratedValue(generator = "myNative")
    private Long custId;
    @Column(name = "cust_name")
    private String custName;

    /* 已经是外键
    private String custSource;
    private String custIndustry;
    private String custLevel;
    */

    @Column(name = "cust_address")
    private String custAddress;
    @Column(name = "cust_phone")
    private String custPhone;

    //客户来源private String custSource;
    @ManyToOne(targetEntity = Dict.class)
    @JoinColumn(name = "cust_source", referencedColumnName = "dict_id")
    private Dict source;

    //客户行业
    @ManyToOne(targetEntity = Dict.class)
    @JoinColumn(name = "cust_industry", referencedColumnName = "dict_id")
    private Dict industry;

    //客户级别
    @ManyToOne(targetEntity = Dict.class)
    @JoinColumn(name = "cust_level", referencedColumnName = "dict_id")
    private Dict level;

    //配置级联操作
    @OneToMany(targetEntity = Linkman.class, mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Linkman> linkmens = new HashSet<Linkman>();

    public Set<Linkman> getLinkmens() {
        return linkmens;
    }

    public void setLinkmens(Set<Linkman> linkmens) {
        this.linkmens = linkmens;
    }

    public Dict getSource() {
        return source;
    }

    public void setSource(Dict source) {
        this.source = source;
    }

    public Dict getIndustry() {
        return industry;
    }

    public void setIndustry(Dict industry) {
        this.industry = industry;
    }

    public Dict getLevel() {
        return level;
    }

    public void setLevel(Dict level) {
        this.level = level;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String address) {
        this.custAddress = address;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String phone) {
        this.custPhone = phone;
    }
}

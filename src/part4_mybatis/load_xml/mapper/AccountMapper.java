package part4_mybatis.load_xml.mapper;

import part4_mybatis.load_xml.Account;

import java.util.List;

//使用namespace绑定接口

public interface AccountMapper {
    List<Account> selectAllAccount();
}

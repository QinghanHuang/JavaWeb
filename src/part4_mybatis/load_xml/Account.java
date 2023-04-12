package part4_mybatis.load_xml;

import lombok.Data;
import org.apache.ibatis.type.Alias;

@Data
@Alias("clementAccount")
public class Account {
    private String account;
    private String password;
}

package part2_db.db_object;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    String id;
    String firstName;
    String lastName;
    String address;
    String phone;


}

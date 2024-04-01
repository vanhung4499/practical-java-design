package com.hnv99.design;

import com.hnv99.design.user.User;
import com.hnv99.design.user.impl.Student;
import com.hnv99.design.user.impl.Teacher;
import com.hnv99.design.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class DataView {

    List<User> userList = new ArrayList<User>();

    public DataView() {
        userList.add(new Student("fly", "Lớp nâng cao", "1A"));
        userList.add(new Student("windy", "Lớp nâng cao", "1A"));
        userList.add(new Student("Đại mao", "Lớp thông thường", "2C"));
        userList.add(new Student("Shing", "Lớp thông thường", "3D"));
        userList.add(new Teacher("BK", "Giáo viên siêu cấp", "1A"));
        userList.add(new Teacher("NanaGoddess", "Giáo viên siêu cấp", "1A"));
        userList.add(new Teacher("Dangdang", "Giáo viên thông thường", "2C"));
        userList.add(new Teacher("Zedong", "Giáo viên thực tập", "3D"));
    }

    // Hiển thị
    public void show(Visitor visitor) {
        for (User user : userList) {
            user.accept(visitor);
        }
    }

}

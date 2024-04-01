package com.hnv99.design.visitor;

import com.hnv99.design.user.impl.Student;
import com.hnv99.design.user.impl.Teacher;

public interface Visitor {

    // Truy cập thông tin học sinh
    void visit(Student student);

    // Truy cập thông tin giáo viên
    void visit(Teacher teacher);

}

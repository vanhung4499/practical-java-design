package com.hnv99.design.visitor.impl;

import com.hnv99.design.user.impl.Student;
import com.hnv99.design.user.impl.Teacher;
import com.hnv99.design.visitor.Visitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Parent implements Visitor {

    private Logger logger = LoggerFactory.getLogger(Parent.class);

    public void visit(Student student) {
        logger.info("Thông tin học sinh Tên: {} Lớp: {} Xếp hạng: {}", student.name, student.clazz, student.ranking());
    }

    public void visit(Teacher teacher) {
        logger.info("Thông tin giáo viên Tên: {} Lớp: {} Cấp bậc: {}", teacher.name, teacher.clazz, teacher.identity);
    }

}
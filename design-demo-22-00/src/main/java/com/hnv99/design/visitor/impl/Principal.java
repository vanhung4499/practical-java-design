package com.hnv99.design.visitor.impl;

import com.hnv99.design.user.impl.Student;
import com.hnv99.design.user.impl.Teacher;
import com.hnv99.design.visitor.Visitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Principal implements Visitor {

    private Logger logger = LoggerFactory.getLogger(Principal.class);

    public void visit(Student student) {
        logger.info("Thông tin học sinh Tên: {} Lớp: {}", student.name, student.clazz);
    }

    public void visit(Teacher teacher) {
        logger.info("Thông tin giáo viên Tên: {} Lớp: {} Tỷ lệ chuyển cấp: {}", teacher.name, teacher.clazz, teacher.entranceRatio());
    }

}

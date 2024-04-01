package com.hnv99.design;

import com.hnv99.design.group.Employee;
import com.hnv99.design.group.GroupStructure;
import com.hnv99.design.group.Link;
import com.hnv99.design.lang.Iterator;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ApiTest {
    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void testIterator() {
        // Điền dữ liệu
        GroupStructure groupStructure = new GroupStructure("1", "Xưởng sản xuất");

        // Thông tin nhân viên
        groupStructure.add(new Employee("2", "Hoa hoa", "Bộ phận cấp 2"));
        groupStructure.add(new Employee("3", "Đậu bao", "Bộ phận cấp 2"));
        groupStructure.add(new Employee("4", "Bèo bèo", "Bộ phận cấp 3"));
        groupStructure.add(new Employee("5", "Đại thiêu", "Bộ phận cấp 3"));
        groupStructure.add(new Employee("6", "Hổ cao", "Bộ phận cấp 4"));
        groupStructure.add(new Employee("7", "Linh chi", "Bộ phận cấp 4"));
        groupStructure.add(new Employee("8", "Thu dã", "Bộ phận cấp 4"));

        // Mối quan hệ nút 1->(1,2) 2->(4,5)
        groupStructure.addLink("1", new Link("1", "2"));
        groupStructure.addLink("1", new Link("1", "3"));
        groupStructure.addLink("2", new Link("2", "4"));
        groupStructure.addLink("2", new Link("2", "5"));
        groupStructure.addLink("5", new Link("5", "6"));
        groupStructure.addLink("5", new Link("5", "7"));
        groupStructure.addLink("5", new Link("5", "8"));

        Iterator<Employee> iterator = groupStructure.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            logger.info("{}，ID nhân viên：{} Tên：{}", employee.getDesc(), employee.getUId(), employee.getName());
        }
    }
}

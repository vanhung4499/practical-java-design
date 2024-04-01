package com.hnv99.design.group;

import com.hnv99.design.lang.Collection;
import com.hnv99.design.lang.Iterator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GroupStructure implements Collection<Employee, Link> {

    private String groupId;                                                 // ID của tổ chức, cũng là ID của một chuỗi tổ chức
    private String groupName;                                               // Tên của tổ chức
    private Map<String, Employee> employeeMap = new ConcurrentHashMap<>();  // Danh sách nhân viên
    private Map<String, List<Link>> linkMap = new ConcurrentHashMap<>();  // Mối quan hệ cấu trúc tổ chức; id->list
    private Map<String, String> invertedMap = new ConcurrentHashMap<>();       // Mối quan hệ nghịch đảo

    public GroupStructure(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    public boolean add(Employee employee) {
        return null != employeeMap.put(employee.getUId(), employee);
    }

    public boolean remove(Employee o) {
        return null != employeeMap.remove(o.getUId());
    }

    public boolean addLink(String key, Link link) {
        invertedMap.put(link.getToId(), link.getFromId());
        if (linkMap.containsKey(key)) {
            return linkMap.get(key).add(link);
        } else {
            List<Link> links = new LinkedList<>();
            links.add(link);
            linkMap.put(key, links);
            return true;
        }
    }

    public boolean removeLink(String key) {
        return null != linkMap.remove(key);
    }

    public Iterator<Employee> iterator() {

        return new Iterator<Employee>() {

            HashMap<String, Integer> keyMap = new HashMap<>();

            int totalIdx = 0;
            private String fromId = groupId;  // ID của nhân viên, From
            private String toId = groupId;   // ID của nhân viên, To

            public boolean hasNext() {
                return totalIdx < employeeMap.size();
            }

            public Employee next() {
                List<Link> links = linkMap.get(toId);
                int cursorIdx = getCursorIdx(toId);

                // Quét các nút cùng cấp
                if (null == links) {
                    cursorIdx = getCursorIdx(fromId);
                    links = linkMap.get(fromId);
                }

                // Quét các nút cấp trên
                while (cursorIdx > links.size() - 1) {
                    fromId = invertedMap.get(fromId);
                    cursorIdx = getCursorIdx(fromId);
                    links = linkMap.get(fromId);
                }

                // Lấy nút
                Link link = links.get(cursorIdx);
                toId = link.getToId();
                fromId = link.getFromId();
                totalIdx++;

                // Trả về kết quả
                return employeeMap.get(link.getToId());
            }

            // Xác định tiến độ duyệt theo chiều ngang cho mỗi cấp
            public int getCursorIdx(String key) {
                int idx = 0;
                if (keyMap.containsKey(key)) {
                    idx = keyMap.get(key);
                    keyMap.put(key, ++idx);
                } else {
                    keyMap.put(key, idx);
                }
                return idx;
            }
        };
    }

}

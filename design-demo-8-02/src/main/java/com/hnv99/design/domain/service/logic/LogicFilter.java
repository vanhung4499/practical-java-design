package com.hnv99.design.domain.service.logic;

import com.hnv99.design.domain.model.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

public interface LogicFilter {

    /**
     * Bộ lọc logic
     *
     * @param matterValue          Giá trị quyết định
     * @param treeNodeLineInfoList Danh sách nút quyết định
     * @return Id của nút tiếp theo
     */
    Long filter(String matterValue, List<TreeNodeLink> treeNodeLineInfoList);

    /**
     * Lấy giá trị quyết định
     *
     * @param treeId           ID của cây quy tắc
     * @param userId           ID của người dùng
     * @param decisionMatter   Thông tin quyết định
     * @return Giá trị quyết định
     */
    String matterValue(Long treeId, String userId, Map<String, String> decisionMatter);

}

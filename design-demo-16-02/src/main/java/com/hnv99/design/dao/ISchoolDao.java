package com.hnv99.design.dao;

import com.hnv99.design.po.School;

public interface ISchoolDao {

    School querySchoolInfoById(Long treeId);

}
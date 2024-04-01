package com.hnv99.design;

public enum Status {

    /** 1. Đã tạo và chỉnh sửa */
    Editing,

    /** 2. Chờ duyệt */
    Check,

    /** 3. Đã được duyệt (Công việc được chuyển sang trạng thái hoạt động) */
    Pass,

    /** 4. Từ chối duyệt (Có thể rút lại và chuyển về trạng thái chỉnh sửa) */
    Refuse,

    /** 5. Đang hoạt động */
    Doing,

    /** 6. Đã đóng */
    Close,

    /** 7. Đã mở (Công việc được chuyển sang trạng thái hoạt động) */
    Open,

}


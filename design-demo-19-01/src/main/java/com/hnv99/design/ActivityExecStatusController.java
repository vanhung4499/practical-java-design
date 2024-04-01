package com.hnv99.design;

public class ActivityExecStatusController {

    /**
     * Thay đổi trạng thái hoạt động
     * 1. Chỉnh sửa -> Kiểm tra, Đóng
     * 2. Đã duyệt -> Từ chối, Đóng, Đang thực hiện
     * 3. Từ chối -> Rút lại, Đóng
     * 4. Đang thực hiện -> Đóng
     * 5. Đã đóng -> Mở
     * 6. Đang mở -> Đóng
     *
     * @param activityId   ID hoạt động
     * @param beforeStatus Trạng thái trước khi thay đổi
     * @param afterStatus  Trạng thái sau khi thay đổi
     * @return Kết quả
     */
    public Result execStatus(String activityId, Enum<Status> beforeStatus, Enum<Status> afterStatus) {

        // 1. Chỉnh sửa -> Kiểm tra, Đóng
        if (Status.Editing.equals(beforeStatus)) {
            if (Status.Check.equals(afterStatus) || Status.Close.equals(afterStatus)) {
                ActivityService.execStatus(activityId, beforeStatus, afterStatus);
                return new Result("0000", "Thay đổi trạng thái thành công");
            } else {
                return new Result("0001", "Từ chối thay đổi trạng thái");
            }
        }

        // 2. Đã duyệt -> Từ chối, Đóng, Đang thực hiện
        if (Status.Pass.equals(beforeStatus)) {
            if (Status.Refuse.equals(afterStatus) || Status.Doing.equals(afterStatus) || Status.Close.equals(afterStatus)) {
                ActivityService.execStatus(activityId, beforeStatus, afterStatus);
                return new Result("0000", "Thay đổi trạng thái thành công");
            } else {
                return new Result("0001", "Từ chối thay đổi trạng thái");
            }
        }

        // 3. Từ chối -> Rút lại, Đóng
        if (Status.Refuse.equals(beforeStatus)) {
            if (Status.Editing.equals(afterStatus) || Status.Close.equals(afterStatus)) {
                ActivityService.execStatus(activityId, beforeStatus, afterStatus);
                return new Result("0000", "Thay đổi trạng thái thành công");
            } else {
                return new Result("0001", "Từ chối thay đổi trạng thái");
            }
        }

        // 4. Đang thực hiện -> Đóng
        if (Status.Doing.equals(beforeStatus)) {
            if (Status.Close.equals(afterStatus)) {
                ActivityService.execStatus(activityId, beforeStatus, afterStatus);
                return new Result("0000", "Thay đổi trạng thái thành công");
            } else {
                return new Result("0001", "Từ chối thay đổi trạng thái");
            }
        }

        // 5. Đã đóng -> Mở
        if (Status.Close.equals(beforeStatus)) {
            if (Status.Open.equals(afterStatus)) {
                ActivityService.execStatus(activityId, beforeStatus, afterStatus);
                return new Result("0000", "Thay đổi trạng thái thành công");
            } else {
                return new Result("0001", "Từ chối thay đổi trạng thái");
            }
        }

        // 6. Đang mở -> Đóng
        if (Status.Open.equals(beforeStatus)) {
            if (Status.Close.equals(afterStatus)) {
                ActivityService.execStatus(activityId, beforeStatus, afterStatus);
                return new Result("0000", "Thay đổi trạng thái thành công");
            } else {
                return new Result("0001", "Từ chối thay đổi trạng thái");
            }
        }

        return new Result("0001", "Không thể xử lý thay đổi trạng thái hoạt động");

    }

}


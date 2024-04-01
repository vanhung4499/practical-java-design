package com.hnv99.design;

public abstract class State {

    /**
     * Kiểm tra hoạt động
     *
     * @param activityId    ID hoạt động
     * @param currentStatus Trạng thái hiện tại
     * @return Kết quả thực hiện
     */
    public abstract Result arraignment(String activityId, Enum<Status> currentStatus);

    /**
     * Duyệt
     *
     * @param activityId    ID hoạt động
     * @param currentStatus Trạng thái hiện tại
     * @return Kết quả thực hiện
     */
    public abstract Result checkPass(String activityId, Enum<Status> currentStatus);

    /**
     * Từ chối
     *
     * @param activityId    ID hoạt động
     * @param currentStatus Trạng thái hiện tại
     * @return Kết quả thực hiện
     */
    public abstract Result checkRefuse(String activityId, Enum<Status> currentStatus);

    /**
     * Thu hồi
     *
     * @param activityId    ID hoạt động
     * @param currentStatus Trạng thái hiện tại
     * @return Kết quả thực hiện
     */
    public abstract Result checkRevoke(String activityId, Enum<Status> currentStatus);

    /**
     * Đóng
     *
     * @param activityId    ID hoạt động
     * @param currentStatus Trạng thái hiện tại
     * @return Kết quả thực hiện
     */
    public abstract Result close(String activityId, Enum<Status> currentStatus);

    /**
     * Mở
     *
     * @param activityId    ID hoạt động
     * @param currentStatus Trạng thái hiện tại
     * @return Kết quả thực hiện
     */
    public abstract Result open(String activityId, Enum<Status> currentStatus);

    /**
     * Thực hiện
     *
     * @param activityId    ID hoạt động
     * @param currentStatus Trạng thái hiện tại
     * @return Kết quả thực hiện
     */
    public abstract Result doing(String activityId, Enum<Status> currentStatus);

}
package com.hnv99.design;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Dịch vụ quảng cáo cơ bản của cửa hàng trực tuyến
 * 1. Tạo biển quảng cáo hàng hóa tốt nhất
 * 2. Biển quảng cáo chứa mã mời quảng cáo
 */
public abstract class NetMall {

    protected Logger logger = LoggerFactory.getLogger(NetMall.class);

    String uId;   // ID người dùng
    String uPwd;  // Mật khẩu người dùng

    public NetMall(String uId, String uPwd) {
        this.uId = uId;
        this.uPwd = uPwd;
    }

    /**
     * Tạo biển quảng cáo hàng hóa
     *
     * @param skuUrl Địa chỉ hàng hóa (JD, Taobao, Dangdang)
     * @return Thông tin hình ảnh base64 của biển quảng cáo
     */
    public String generateGoodsPoster(String skuUrl) {
        if (!login(uId, uPwd)) return null;             // 1. Xác thực đăng nhập
        Map<String, String> reptile = reptile(skuUrl);  // 2. Thực hiện thu thập thông tin sản phẩm
        return createBase64(reptile);                   // 3. Tạo biển quảng cáo
    }

    // Mô phỏng đăng nhập
    protected abstract Boolean login(String uId, String uPwd);

    // Mô phỏng thu thập thông tin sản phẩm (giá ưu đãi sau khi đăng nhập)
    protected abstract Map<String, String> reptile(String skuUrl);

    // Tạo thông tin biển quảng cáo sản phẩm
    protected abstract String createBase64(Map<String, String> goodsInfo);

}


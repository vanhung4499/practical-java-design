package com.hnv99.design;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpClient {

    public static String doGet(String httpurl) {
        HttpURLConnection connection = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;// Chuỗi kết quả trả về
        try {
            // Tạo đối tượng kết nối url từ xa
            URL url = new URL(httpurl);
            // Mở kết nối thông qua đối tượng kết nối url từ xa, chuyển đổi sang lớp HttpURLConnection
            connection = (HttpURLConnection) url.openConnection();
            // Thiết lập phương thức kết nối: GET
            connection.setRequestMethod("GET");
            // Thiết lập thời gian chờ kết nối tới máy chủ chính: 15000 miligiây
            connection.setConnectTimeout(15000);
            // Thiết lập thời gian đọc dữ liệu trả về từ xa: 60000 miligiây
            connection.setReadTimeout(60000);
            // Gửi yêu cầu
            connection.connect();
            // Thông qua kết nối, nhận dữ liệu đầu vào
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                // Đóng gói dữ liệu đầu vào is, và chỉ định bộ mã ký tự
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                // Lưu trữ dữ liệu
                StringBuilder sbf = new StringBuilder();
                String temp = null;
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Đóng tài nguyên
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            assert connection != null;
            connection.disconnect();// Đóng kết nối từ xa
        }

        return result;
    }

}


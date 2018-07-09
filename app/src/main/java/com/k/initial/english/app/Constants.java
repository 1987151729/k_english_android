package com.k.initial.english.app;

/**
 * Created by Android Studio.
 * User: Kila
 * E-Mail Address: initialk1943@gmail.com
 * Date: 25/06/2018
 * Time: 08:48
 */
public final class Constants {

    // app配置
    public static final class Configs {
        public static final int DEVICE = 2; // 设备类型（1=安卓，2=苹果）
        public static final String VERSION = "1.0.0"; // 客户端版本
        public static final String CHANNEL = "guanwang"; // 客户端渠道
        // 接口配置
        // 正式用
        private static final String API_IP = "106.14.132.45";
        // 测试用
        //    private static final String API_IP = "192.168.1.114";

        private static final String API_PORT = "80";
        private static final String API_VERSION = "v2";
        public static final String API_SITE = "http://" + API_IP + ":" + API_PORT + "/app/k_english/apis/" + API_VERSION + "/api/";
        public static final String API_KEY = "Px";
        public static final String API_RSA_PUCLIC_KEY = "";
    }

    // 本地数据存储键值对
    public static final class SharedPreferencesKeys {
        public static final String INSTANCE = "INSTANCE"; // SharedPreferences数据
        public static final String RONG_TOKEN = "RONG_TOKEN"; // UserDefaults数据-融云token
        public static final String USER_ID = "USER_ID"; // UserDefaults数据-用户id
        //        public static final String USER_NAME = "USER_NAME"; // UserDefaults数据-用户昵称
//        public static final String USER_AVATAR = "USER_AVATAR"; // UserDefaults数据-用户头像
//        public static final String USER_SEX = "USER_SEX"; // UserDefaults数据-用户头像
//        public static final String USER_INFO = "USER_INFO"; // UserDefaults数据-用户信息
        public static final String USER_PASSWORDSTATE = "USER_PASSWORDSTATE"; // UserDefaults数据-密码状态
        public static final String USER_TOKEN = "USER_TOKEN"; // UserDefaults数据-token
        public static final String LOGIN_USERNAME = "LOGIN_USERNAME"; // UserDefaults数据-登录账号（可能是"邮箱"或"用户名"）
        //        public static final String IS_USER_INFO_EDIT = "IS_USER_INFO_EDIT"; // UserDefaults数据-用户信息是否有过修改
//        public static final String IS_LOVE_LETTER_INFO_EDIT = "IS_LOVE_LETTER_INFO_EDIT"; // UserDefaults数据-书信信息是否有过修改
        public static final String IGNORED_VERSIONS = "IGNORED_VERSIONS"; // UserDefaults数据-已忽略的app版本（集合，以逗号分隔）
    }

    // 枚举
    public static final class Enum {

        // 性别枚举
        public static final class Sex {
            public static final int MALE = 1; // 男
            public static final int FEMALE = 2; // 女
        }

        // 文件使用途径枚举
        public static final class FileUseWay {
            // 图片
            public static final class Image {
                public static final int AVATAR = 0; // 用户头像
                public static final int ALBUM = 1; // 相册
                public static final int BLOG = 2; // 说说
                public static final int BLOG_COMMENT = 3; // 说说评论
            }
        }

        // 消息内容类型枚举
        public static final class ChatContentType {
            public static final int TEXT = 0;
            public static final int IMAGE = 1;
            public static final int AUDIO = 2;
        }

        // EventBus事件枚举
        public static final class Eventbus {
            public static final int BLOG_PUBLISH = 0; // 说说发布成功
            public static final int USER_INFO_EDIT = 1; // 编辑个人信息成功
        }
    }

    // 其他
}

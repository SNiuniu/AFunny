package com.sniuniu.afunny;

import java.util.List;

public class DataList {

    /**
     * code : 200
     * msg : 成功!
     * data : [{"type":"video","text":"有才的网友：每当这个BGM一响，那剧情肯定就会有反转！","username":"唐唐频道","uid":"17800244","header":"http://wimg.spriteapp.cn/profile/large/2016/05/10/573192938ef8d_mini.jpg","comment":140,"top_commentsVoiceuri":null,"top_commentsContent":"为什么不能播放","top_commentsHeader":"http://wimg.spriteapp.cn/profile/large/2018/04/19/5ad889f403b01_mini.jpg","top_commentsName":"原谅集团住姐夫大使馆","passtime":"2018-04-28 12:07:02","soureid":27640078,"up":1314,"down":174,"forward":50,"image":null,"gif":null,"thumbnail":"http://wimg.spriteapp.cn/picture/2018/0419/5ad84b5eb7493_wpd.jpg","video":"http://wvideo.spriteapp.cn/video/2018/0419/5ad84b5eb7493_wpd.mp4"}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * type : video
         * text : 有才的网友：每当这个BGM一响，那剧情肯定就会有反转！
         * username : 唐唐频道
         * uid : 17800244
         * header : http://wimg.spriteapp.cn/profile/large/2016/05/10/573192938ef8d_mini.jpg
         * comment : 140
         * top_commentsVoiceuri : null
         * top_commentsContent : 为什么不能播放
         * top_commentsHeader : http://wimg.spriteapp.cn/profile/large/2018/04/19/5ad889f403b01_mini.jpg
         * top_commentsName : 原谅集团住姐夫大使馆
         * passtime : 2018-04-28 12:07:02
         * soureid : 27640078
         * up : 1314
         * down : 174
         * forward : 50
         * image : null
         * gif : null
         * thumbnail : http://wimg.spriteapp.cn/picture/2018/0419/5ad84b5eb7493_wpd.jpg
         * video : http://wvideo.spriteapp.cn/video/2018/0419/5ad84b5eb7493_wpd.mp4
         */

        private String type;
        private String text;
        private String username;
        private String uid;
        private String header;
        private int comment;
        private Object top_commentsVoiceuri;
        private String top_commentsContent;
        private String top_commentsHeader;
        private String top_commentsName;
        private String passtime;
        private int soureid;
        private int up;
        private int down;
        private int forward;
        private Object image;
        private Object gif;
        private String thumbnail;
        private String video;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public int getComment() {
            return comment;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }

        public Object getTop_commentsVoiceuri() {
            return top_commentsVoiceuri;
        }

        public void setTop_commentsVoiceuri(Object top_commentsVoiceuri) {
            this.top_commentsVoiceuri = top_commentsVoiceuri;
        }

        public String getTop_commentsContent() {
            return top_commentsContent;
        }

        public void setTop_commentsContent(String top_commentsContent) {
            this.top_commentsContent = top_commentsContent;
        }

        public String getTop_commentsHeader() {
            return top_commentsHeader;
        }

        public void setTop_commentsHeader(String top_commentsHeader) {
            this.top_commentsHeader = top_commentsHeader;
        }

        public String getTop_commentsName() {
            return top_commentsName;
        }

        public void setTop_commentsName(String top_commentsName) {
            this.top_commentsName = top_commentsName;
        }

        public String getPasstime() {
            return passtime;
        }

        public void setPasstime(String passtime) {
            this.passtime = passtime;
        }

        public int getSoureid() {
            return soureid;
        }

        public void setSoureid(int soureid) {
            this.soureid = soureid;
        }

        public int getUp() {
            return up;
        }

        public void setUp(int up) {
            this.up = up;
        }

        public int getDown() {
            return down;
        }

        public void setDown(int down) {
            this.down = down;
        }

        public int getForward() {
            return forward;
        }

        public void setForward(int forward) {
            this.forward = forward;
        }

        public Object getImage() {
            return image;
        }

        public void setImage(Object image) {
            this.image = image;
        }

        public Object getGif() {
            return gif;
        }

        public void setGif(Object gif) {
            this.gif = gif;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }
    }
}

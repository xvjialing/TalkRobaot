package com.lytech.xjl.talkrobaot.bean;

/**
 * Created by xjl on 17-10-31.
 */

public class Message {

    /**
     * status : 0
     * msg : ok
     * result : {"type":"聊天","content":"你好，我是小i机器人，很高兴认识你。","relquestion":""}
     */

    private int status;
    private String msg;
    private ResultBean result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * type : 聊天
         * content : 你好，我是小i机器人，很高兴认识你。
         * relquestion :
         */

        private String type;
        private String content;
        private String relquestion;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getRelquestion() {
            return relquestion;
        }

        public void setRelquestion(String relquestion) {
            this.relquestion = relquestion;
        }
    }
}

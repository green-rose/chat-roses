package com.gfa.chat.models;

public class MsgRequestDTO {
        Integer channelId;
        String channelSecret;
        String content;

        public MsgRequestDTO(Integer channelId, String channelSecret, String content) {
                this.channelId = channelId;
                this.content = content;
        }

        public MsgRequestDTO() {
        }

        public Integer getChanelId() {
                return channelId;
        }

        public void setChanelId(Integer chanelId) {
                this.channelId = chanelId;
        }

        public String getChannelSecret() {
                return channelSecret;
        }

        public void setChannelSecret(String channelSecret) {
                this.channelSecret = channelSecret;
        }

        public String getContent() {
                return content;
        }

        public void setContent(String content) {
                this.content = content;
        }
}
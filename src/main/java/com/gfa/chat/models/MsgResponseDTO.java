package com.gfa.chat.models;

import java.time.Instant;

public class MsgResponseDTO {

        Author author;
        String content;
        Instant created;

        public MsgResponseDTO(Author author, String content, Instant created) {
                this.author = author;
                this.content = content;
                this.created = created;
        }

        public MsgResponseDTO() {
        }

        public Author getAuthor() {
                return author;
        }

        public void setAuthor(Author author) {
                this.author = author;
        }

        public String getContent() {
                return content;
        }

        public void setContent(String content) {
                this.content = content;
        }

        public Instant getCreated() {
                return created;
        }

        public void setCreated(Instant created) {
                this.created = created;
        }
}
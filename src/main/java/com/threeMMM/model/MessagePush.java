package com.threeMMM.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhaoyazhi on 2016/9/12.
 */
@Entity
@Table(name="t_message_push" )
public class MessagePush {

    private Integer id;
    private Integer message_status; //1-待推送服务事项，2-待扩展 *
    private String title;
    private String message;
    private String type; //001-微信推送，010-短信推送，100-邮件推送，其他可扩展
    private Integer type_sub; //此项当type为001（微信推送时有效），1-普通服务消息，2-模板消息
    private String send_to;//发送人，微信推送时-openid，短信推送时-mobile，邮件推送时-email;同一类型下，可多人，多人之间使用英文逗号分隔；
    private Integer come_from; // 来源方，1-前台，2-后台，0-其它
    private Date create_time;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMessage_status() {
        return message_status;
    }

    public void setMessage_status(Integer message_status) {
        this.message_status = message_status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getType_sub() {
        return type_sub;
    }

    public void setType_sub(Integer type_sub) {
        this.type_sub = type_sub;
    }

    public String getSend_to() {
        return send_to;
    }

    public void setSend_to(String send_to) {
        this.send_to = send_to;
    }

    public Integer getCome_from() {
        return come_from;
    }

    public void setCome_from(Integer come_from) {
        this.come_from = come_from;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}

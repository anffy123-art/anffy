package com.px.partybuild.controller;

import com.github.pagehelper.PageInfo;
import com.px.partybuild.controller.jsonmodel.RequsetData;
import com.px.partybuild.model.CfMessage;
import com.px.partybuild.service.MessageService;
import com.px.partybuild.service.MhService;

import com.px.partybuild.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @Autowired
    private StringUtils stringUtils;

    @ResponseBody
    @GetMapping("/getNewMessage")
    public RequsetData<List<CfMessage>> getNewMessage(@RequestParam("userId") String userId, @RequestParam(required = false) String title, @RequestParam(required = false) String day, @RequestParam(required = false) Integer state) {

        RequsetData<List<CfMessage>> result = new RequsetData<>();
        List<CfMessage> list = messageService.selectMessageList(userId, "", day, state);
        result.setItem(list.size() >= 5 ? list.subList(0, 5) : list);
        return result;
    }

    @ResponseBody
    @GetMapping("/getMessageList")
    public RequsetData<PageInfo<HashMap<String, Object>>> getMessageList(@RequestParam("userId") String userId, @RequestParam("state") int state, @RequestParam("pageindex") int pageIndex, @RequestParam("pagesize") int pageSize, @RequestParam(required = false) String title) {

        RequsetData<PageInfo<HashMap<String, Object>>> result = new RequsetData<>();
        PageInfo<HashMap<String, Object>> list = messageService.selectMessageList(userId, title, state, pageIndex, pageSize);
        result.setItem(list);
        return result;
    }

    @ResponseBody
    @GetMapping("/testSendMessage")
    public RequsetData<String> testSendMessage() {
        CfMessage messasge = new CfMessage();
        messasge.setMessageid(UUID.randomUUID().toString());
        messasge.setFromuser("02559ea163e5411ca761a74e1558d5d9");
        messasge.setTouser("02559ea163e5411ca761a74e1558d5d9");
        messasge.setMsgtitle("测试发送消息");
        messasge.setUrl("mainindex");
        messageService.sendMessage(messasge);
        RequsetData<String> result = new RequsetData<>();
        result.setMsg("发送成功");
        return result;
    }

    @ResponseBody
    @RequestMapping("/clearMessageByBusinessId")
    public RequsetData<String> ClearMessageByBusinessId(@RequestParam("businessId") String businessId, @RequestParam("userId") String userId, @RequestParam("messageType") Integer messageType) {
        RequsetData<String> res = new RequsetData<>();
        int count = 0;
        /*CfMessage message = messageService.getMessageByBusinessId(businessId, userId, messageType);
        if (message != null && !stringUtils.IsNullOrEmpty(message.getMessageid()) && message.getState() == 1) {
            count = messageService.clearMessage(message.getMessageid());
        }*/
        count = messageService.clearMessageByBusinessId(businessId, userId, messageType);
        if (count > 0) {
            res.setSuccess(true);
            res.setMsg("清除成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("清除失败！");
        }
        return res;
    }

    @ResponseBody
    @RequestMapping("/clearMessageById")
    public RequsetData<String> ClearMessageById(@RequestParam("messageId") String messageId) {
        RequsetData<String> res = new RequsetData<>();
        int count = messageService.clearMessage(messageId);
        if (count > 0) {
            res.setSuccess(true);
            res.setMsg("清除成功！");
        } else {
            res.setSuccess(false);
            res.setMsg("清除失败！");
        }
        return res;
    }
}

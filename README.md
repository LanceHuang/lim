# lim
IM即时通讯系统

## 介绍
lim是一款即时通讯系统，提出了不同的聊天设计方案

## 系统架构
参考资料：http://www.52im.net/thread-1230-1-1.html  

参考图片：
![](http://www.52im.net/data/attachment/forum/201904/30/125435sjtx5taw9atxw5wh.jpg)

- 客户端：lim-client，负责发送和接收消息
- 用户中心：lim-rest，负责注册登录、为客户端分配消息服务器
- 消息服务器：lim-server，无状态，与客户端保持长连接，负责将客户端消息放入消息队列
- 消息队列：kafka实现，负责削峰填谷
- 消息处理：lim-message，无状态，负责异步消费消息队列中的消息，将消息写入消息存储库和消息同步库
- 消息存储库和索引：influxdb实现，负责持久化会话消息
- 消息同步库：influxdb实现，负责写扩散同步

## QuickStart
todo

## TODO
* [ ] 私聊
* [ ] 工会聊天
* [ ] 自定义组聊
* [ ] 世界聊天

# 图片验证码 - 前后端分离，图片验证码实现方案。

- 客户端与服务端基于 Oauth2 进行通信，其中使用到 token 作为用户的数据令牌。

- 服务端使用 Redis 作为集中式缓存，键值：{token, captcha_code}

- 服务端提供两个接口

```
生成图片验证码
【GET】http://localhost:8080/v0.1/captcha?token=797fd0f3016b4184a0682348546b2ac0
```

```
验证图片验证码（一般情况下，这个接口会合并到登录接口中）
【GET】http://localhost:8080/v0.1/captcha/valid?token=797fd0f3016b4184a0682348546b2ac0&captchaCode=XUYD
```

- 客户端可以使用 ajax 请求或者使用 img 标签。
这里，为了简单起见，就使用 img 标签。地址：{project}/src/main/resources/page

- 接口测试，可以使用 postman
这里，附带 postman 脚本。地址：{project}/src/main/resources/postman

